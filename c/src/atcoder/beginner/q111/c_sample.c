#include <stdio.h>
#include <stdlib.h>

#define LIMIT 100001

int main(void)
{
    int vi, vj;
    int n;
    int i;
    char c;
    int *ctr_vi, *ctr_vj;
    int MAX_vi, MAX_vj;
    int MAX_vi2, MAX_vj2;
    int index_MAX_vi, index_MAX_vj;

    MAX_vi = MAX_vj = 0;
    MAX_vi2 = MAX_vj2 = 0;

    scanf("%d", &n);
    ctr_vi = (int*)malloc(sizeof(int)*LIMIT);
    ctr_vj = (int*)malloc(sizeof(int)*LIMIT);

    for(i=1; i<LIMIT; i++)
        ctr_vi[i] = ctr_vj[i] = 0;

    for(i=1; i<=n/2; i++)
    {
        scanf("%d%c", &vi, &c);
        scanf("%d%c", &vj, &c);

        ctr_vi[vi]++;
        ctr_vj[vj]++;
    }


    for(i=1; i<LIMIT; i++)
    {
        if(ctr_vi[i] >= MAX_vi)
        {
            MAX_vi2 = MAX_vi;
            MAX_vi = ctr_vi[i];
            index_MAX_vi = i;
        }
        else if(ctr_vi[i] > MAX_vi2)
        {
            MAX_vi2 = ctr_vi[i];
        }

        if(ctr_vj[i] >= MAX_vj)
        {
            MAX_vj2 = MAX_vj;
            MAX_vj = ctr_vj[i];
            index_MAX_vj = i;
        }
        else if(ctr_vj[i] > MAX_vj2)
        {
            MAX_vj2 = ctr_vj[i];
        }
    }

    if(index_MAX_vi != index_MAX_vj)
        printf("%d\n", n-MAX_vi-MAX_vj);
    else
    {
        if(MAX_vi > MAX_vj)
        {
            printf("%d\n", n-MAX_vi-MAX_vj2);
        }
        else if(MAX_vi < MAX_vj)
        {
            printf("%d\n", n-MAX_vj-MAX_vi2);
        }
        else
        {
            if(MAX_vi2 > MAX_vj2)
                printf("%d\n", n-MAX_vj-MAX_vi2);
            else
                printf("%d\n", n-MAX_vi-MAX_vj2);
        }
    }

    free(ctr_vi);
    free(ctr_vj);
    return 0;
}
