#include <stdio.h>
#include <stdlib.h>

#define INITIAL_POOL_SIZE 100

typedef enum { RED, BLACK } Color;

typedef struct Node {
    int data;
    int count;
    Color color;
    struct Node *left, *right, *parent;
} Node;

typedef struct {
    Node *nodes;
    int size;
    int capacity;
} NodePool;

NodePool pool;

void initializePool() {
    pool.nodes = (Node *)malloc(INITIAL_POOL_SIZE * sizeof(Node));
    pool.size = 0;
    pool.capacity = INITIAL_POOL_SIZE;
    for (int i = 0; i < pool.capacity; i++) {
        pool.nodes[i].left = pool.nodes[i].right = pool.nodes[i].parent = NULL;
    }
}

void expandPool() {
    pool.capacity += INITIAL_POOL_SIZE;
    pool.nodes = (Node *)realloc(pool.nodes, pool.capacity * sizeof(Node));
    for (int i = pool.size; i < pool.capacity; i++) {
        pool.nodes[i].left = pool.nodes[i].right = pool.nodes[i].parent = NULL;
    }
}

Node *allocateNode(int data) {
    if (pool.size >= pool.capacity) {
        expandPool();
    }
    Node *node = &pool.nodes[pool.size++];
    node->data = data;
    node->count = 1;
    node->color = RED;
    return node;
}

Node *createNode(int data) {
    return allocateNode(data);
}

void rotateLeft(Node **root, Node *x) {
    Node *y = x->right;
    x->right = y->left;
    if (y->left != NULL) {
        y->left->parent = x;
    }
    y->parent = x->parent;
    if (x->parent == NULL) {
        *root = y;
    } else if (x == x->parent->left) {
        x->parent->left = y;
    } else {
        x->parent->right = y;
    }
    y->left = x;
    x->parent = y;
}

void rotateRight(Node **root, Node *y) {
    Node *x = y->left;
    y->left = x->right;
    if (x->right != NULL) {
        x->right->parent = y;
    }
    x->parent = y->parent;
    if (y->parent == NULL) {
        *root = x;
    } else if (y == y->parent->left) {
        y->parent->left = x;
    } else {
        y->parent->right = x;
    }
    x->right = y;
    y->parent = x;
}

void fixViolation(Node **root, Node *z) {
    while (z != *root && z->parent->color == RED) {
        if (z->parent == z->parent->parent->left) {
            Node *y = z->parent->parent->right;
            if (y != NULL && y->color == RED) {
                z->parent->color = BLACK;
                y->color = BLACK;
                z->parent->parent->color = RED;
                z = z->parent->parent;
            } else {
                if (z == z->parent->right) {
                    z = z->parent;
                    rotateLeft(root, z);
                }
                z->parent->color = BLACK;
                z->parent->parent->color = RED;
                rotateRight(root, z->parent->parent);
            }
        } else {
            Node *y = z->parent->parent->left;
            if (y != NULL && y->color == RED) {
                z->parent->color = BLACK;
                y->color = BLACK;
                z->parent->parent->color = RED;
                z = z->parent->parent;
            } else {
                if (z == z->parent->left) {
                    z = z->parent;
                    rotateRight(root, z);
                }
                z->parent->color = BLACK;
                z->parent->parent->color = RED;
                rotateLeft(root, z->parent->parent);
            }
        }
    }
    (*root)->color = BLACK;
}

void insert(Node **root, int data) {
    Node *z = createNode(data);
    Node *y = NULL;
    Node *x = *root;

    while (x != NULL) {
        y = x;
        if (z->data < x->data) {
            x = x->left;
        } else {
            x = x->right;
        }
    }

    z->parent = y;
    if (y == NULL) {
        *root = z;
    } else if (z->data < y->data) {
        y->left = z;
    } else {
        y->right = z;
    }

    fixViolation(root, z);
}

void inorder(Node *node) {
    if (node == NULL) return;
    inorder(node->left);
    printf("%d (count: %d) ", node->data, node->count);
    inorder(node->right);
}

Node *search(Node *root, int data) {
    if (root == NULL || root->data == data) {
        return root;
    }

    if (data < root->data) {
        return search(root->left, data);
    } else {
        return search(root->right, data);
    }
}

void insertOrIncrement(Node **root, int data) {
    Node *node = search(*root, data);
    if (node != NULL) {
        node->count++;
    } else {
        insert(root, data);
    }
}

void collectNodes(Node *root, Node **array, int *index) {
    if (root == NULL) return;
    collectNodes(root->left, array, index);
    array[(*index)++] = root;
    collectNodes(root->right, array, index);
}

int compareNodes(const void *a, const void *b) {
    Node *nodeA = *(Node **)a;
    Node *nodeB = *(Node **)b;
    return nodeB->count - nodeA->count;
}

// Node** sortNodesByCount(Node *root) {
//     if (root == NULL) return NULL;

//     Node **array = (Node **)malloc(pool.size * sizeof(Node *));
//     int index = 0;
//     collectNodes(root, array, &index);

//     qsort(array, index, sizeof(Node *), compareNodes);

//     printf("Nodes sorted by count (descending):\n");
//     for (int i = 0; i < index; i++) {
//         printf("%d (count: %d)\n", array[i]->data, array[i]->count);
//     }

//     return array;
// }

Node** sortNodesByCount(Node *root, int *size) {
    if (root == NULL) return NULL;

    Node **array = (Node **)malloc(pool.size * sizeof(Node *));
    int index = 0;
    collectNodes(root, array, &index);

    qsort(array, index, sizeof(Node *), compareNodes);

    *size = index;
    return array;
}

int maxCountSum(Node **array1, int index1, Node **array2, int index2) {
    if (index1 < 0 && index2 < 0) return 0;
    else if (index1 < 0) return array2[index2]->count;
    else if (index2 < 0) return array1[index1]->count;

    if (array1[index1]->data != array2[index2]->data) {
        return array1[index1]->count + array2[index2]->count;
    } else {
        int sum1 = maxCountSum(array1, index1 - 1, array2, index2);
        int sum2 = maxCountSum(array1, index1, array2, index2 - 1);
        return sum1 > sum2 ? sum1 : sum2;
    }
}

int main() {
    initializePool();


    int n;
    int input;
    scanf("%d", &n);
    Node *numbers1 = NULL;
    Node *numbers2 = NULL;
    for (int i = 0; i < n; i++) {
        scanf("%d", &input);
        if (i % 2 == 0) {
            insertOrIncrement(&numbers1, input);
        } else {
            insertOrIncrement(&numbers2, input);
        }
    }

    // inorder(numbers1);
    // printf("\n");
    // inorder(numbers2);
    // printf("\n");

    int size1, size2;
    Node **sorted1 = sortNodesByCount(numbers1, &size1);
    Node **sorted2 = sortNodesByCount(numbers2, &size2);

    int maxSum = maxCountSum(sorted1, size1-1, sorted2, size2-1);
    // printf("Max count sum: %d\n", maxSum);
    printf("%d\n", n - maxSum);

    // メモリの解放
    free(sorted1);
    free(sorted2);
    free(pool.nodes);

    return 0;
}
