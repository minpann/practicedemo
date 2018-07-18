package com.mp.sort;

public class SortTest {
    /*************打印结果**************/
    public void print(int a[])
    {
        int i;
        for(i = 0;i < a.length; i++)
        {
            if(i < a.length -1)
                System.out.print(a[i] + ",");
            else
                System.out.println(a[i]);
        }

    }

    /****************直接插入排序**************/
    public void directinsert_sort(int a[], int len)
    {
        int i,j;
        int temp;
        for (i=1; i<len; i++)
        {
            temp = a[i];
            for (j=i-1; j>=0; j--)
            {
                if (temp < a[j])  //如果插入的值小于某个值，则退出循环
                    break;

                a[j+1] = a[j];

            }
            a[j+1] = temp;
        }
    }

    /*****************选择排序***************/
    public void selectSort(int a[], int len){
        int k,temp;
        for(int i = 0;i < len - 1;i ++){
            k = i;
            for(int j = i + 1;j <len;j ++){
                if(a[k] > a[j])
                {
                    k = j;
                }
            }

            if(k != i){
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    /*****************希尔排序***************/
    public void shellSort(int a[],int len){
        int d = len;
        while(d > 1){
            d=(d+1)/2;
            for(int i =0;i < len -d;i ++){
                if(a[i + d] < a[i]){
                    int tmp = a[i + d];
                    a[i + d] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }

    /*****************冒泡排序******************/
    public void bubbleSort(int[] a)
    {
        boolean flag = true;
        for (int i = 0; i < a.length; i++) {
            flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] < a[j+1])
                {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag)
            {
                break;
            }
        }
    }

    /*****************快速排序******************/
    public void quickSort(int[] a, int left, int right)
    {
        if(left < right)
        {
            int low = left;
            int high = right;
            int key = a[left];
            while(low < high){
                while(low < high && key <= a[high])
                {
                    high --;
                }
                a[low] = a[high];

                while(low < high && key >= a[low]){
                    low ++;
                }
                a[high] = a[low];

            }
            a[low] = key;
            quickSort(a,left,low-1);
            quickSort(a,low+1,right);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,2,7,9,12,0,9};
        SortTest ss = new SortTest();
        //ss.shellSort(arr, arr.length);
//        ss.quickSort(arr, 0, arr.length - 1);
//		ss.directinsert_sort(arr, arr.length);
//		ss.selectSort(arr, arr.length);
		ss.bubbleSort(arr);

        ss.print(arr);

    }
}
