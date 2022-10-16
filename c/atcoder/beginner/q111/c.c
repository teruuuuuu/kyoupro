#include <stdio.h>
#include <stdlib.h>

struct key_value {
  int key;
  int value;
};
struct tree_map {
    struct key_value *center;
    struct tree_map *left;
    struct tree_map *right;
};
struct kv_tupple {
    struct key_value *left;
    struct key_value *right;
};
struct tree_map *add_map(int key, struct tree_map *pointer);
void show_tree_map(struct tree_map *pointer);
struct key_value *make_kv(int key);
struct tree_map *make_node(int key);

struct kv_tupple *make_kv_tupple();
void find_top2(struct kv_tupple *tupple, struct tree_map *pointer);
int need_num(int sum, struct key_value *pointer);

struct tree_map
*add_map(int key, struct tree_map *pointer)
{
  if(NULL == pointer) {
    pointer = make_node(key);
  } else {
    if(pointer->center->key == key){
      pointer->center->value++;
    }else if(pointer->center->key < key){
      pointer->right = add_map(key, pointer->right);
    } else {
      pointer->left = add_map(key, pointer->left);
    }
  }
  return pointer;
}

void
show_tree_map(struct tree_map *pointer)
{
  if(NULL != pointer->left ){
    show_tree_map(pointer->left);
  }
  printf("key=%d  value=%d\n", pointer->center->key, pointer->center->value);
  if(NULL != pointer->right ){
    show_tree_map(pointer->right);
  }
}

struct key_value
*make_kv(int key)
{
  struct key_value *pointer = malloc(sizeof(struct key_value));
  pointer->key = key;
  pointer->value = 1;
  return pointer;
}

struct tree_map
*make_node(int key)
{
  struct tree_map *pointer = malloc(sizeof(struct tree_map));
  pointer->center = make_kv(key);
  pointer->left = NULL;
  pointer->right = NULL;
  return pointer;
}

struct kv_tupple
*make_kv_tupple()
{
  struct kv_tupple *pointer = malloc(sizeof(struct kv_tupple));
  pointer->left = NULL;
  pointer->right = NULL;
  return pointer;
}

void
find_top2(struct kv_tupple *tupple, struct tree_map *pointer)
{
  if(NULL != pointer->left ){
    find_top2(tupple, pointer->left);
  }
  if(NULL == tupple->left || tupple->left->value < pointer->center->value) {
    tupple->right = tupple->left;
    tupple->left = pointer->center;
  } else if(NULL == tupple->right || tupple->right->value < pointer->center->value) {
    tupple->right = pointer->center;
  }
  if(NULL != pointer->right ){
    find_top2(tupple, pointer->right);
  }
}

int
need_num(int sum, struct key_value *pointer)
{
 if(NULL == pointer){
   return sum;
 } else {
   return sum - pointer->value;
 }
}

int
main(void)
{
  int N, v;
  scanf("%d", &N);
  struct tree_map *map1=NULL;
  struct tree_map *map2=NULL;
  int sum1=N/2+N%2;
  int sum2=N/2;
  struct kv_tupple *tupple1 = make_kv_tupple();
  struct kv_tupple *tupple2 = make_kv_tupple();

  for(int i = 0; i < N; i++) {
    scanf("%d", &v);
    if(i%2==0) {
      map1 = add_map(v, map1);
    } else {
      map2 = add_map(v, map2);
    }
  }
  find_top2(tupple1, map1);
  find_top2(tupple2, map2);

  if(tupple1->left->key != tupple2->left->key) {
    printf("%d\n", need_num(sum1, tupple1->left) + need_num(sum2, tupple2->left));
  } else {
    int ans1 = need_num(sum1, tupple1->left) + need_num(sum2, tupple2->right);
    int ans2 = need_num(sum1, tupple1->right) + need_num(sum2, tupple2->left);
    if(ans1<ans2) {
      printf("%d\n", ans1);
    } else {
      printf("%d\n", ans2);
    }
  }
  return 0;
}
