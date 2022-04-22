class Solution {
    
    private static int count = 0;
    public int reversePairs(int[] A) {
        count = 0;
        mergeSort(A, 0, A.length-1);
        return count;
    }
   
    private static void mergeSort(int[] A, int s, int e) {
        if(s == e) return;

        int m = (s+e)/2;
        mergeSort(A, s, m);
        mergeSort(A, m+1, e);
        merge(A, s, m , e);
    }

    private static void merge(int[] A, int s, int m, int e) {
        int[] temp = new int[e-s+1];
        int p1=s, p2=m+1, p3=0;

        while(p1 <= m && p2 <= e) {
            if(A[p1] <= 2L*A[p2]) {
                temp[p3] = A[p1]; p3++; p1++;
            } else {
                temp[p3] = A[p2]; p3++; p2++;
                count += m-p1+1;
            }
        }
        while(p1 <= m) {
            temp[p3] = A[p1];
            p3++; p1++;
        }
        while(p2 <= e) {
            temp[p3] = A[p2];
            p3++; p2++;
        }

        Arrays.sort(temp); //since we are merging and the array need to be sorted thats why
        for(int i=0; i<=e-s; i++) {
            //System.out.println(temp[i]);
            A[i+s] = temp[i];
        }
    }
}