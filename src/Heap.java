
import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MinHeap miniheap = new MinHeap() ;
        char in ;
        int insert ;
        do {
            in=scan.next().charAt(0) ;
            switch (in) {
                case 'E'  :
                case 'e' :
                    System.out.println(miniheap.isEmpty());
                    break;
                case 'T'  :
                case 't'  :
                    System.out.println(miniheap.getMinimum());
                    break;
                case 'I' :
                case 'i' :
                    insert = scan.nextInt() ; miniheap.insert(insert);
                    break;
                case 'R' :
                case 'r' :
                    miniheap.removeMin();
                    break;
                case 's' :
                case 'S' :
                    System.out.println(miniheap.getSize());
                    break;
                case 'p' :
                case 'P' :
                    miniheap.print();
                    break;
            }

        }while (in !='$') ;
    }
}
class MinHeap {
    int Size = 0;
    int[] heap ;
    public int getSize() {
        return Size;
    }
    MinHeap(){
        heap = new int[5] ;
    }
    private int parent(int i) {
        return ((i-1)/2) ;
    }
    private int left(int i) {
        return (2*i+1) ;
    }
    private int right(int i) {
        return (2*i+2) ;
    }
    private void toOrgonize () {
        int  i=Size-1 ;
        int temp ;
        boolean ifGoOrNot=true ; ;
        while (i>0 && ifGoOrNot==true) {
            if (heap[i]<heap[parent(i)]  ) {
                temp = heap[i] ;
                heap[i] = heap[parent(i)] ;
                heap[parent(i)] = temp ;
                i = parent(i) ;
            }
            else ifGoOrNot=false;
        }
    }
    public boolean isEmpty () {
        if (Size==0) return true ;
        else return false;
    }
    public int getMinimum() {
        if (Size>0)
        return heap[0] ;
        else {
            System.out.println("empty");
            return 0 ;
        }
    }
    public void insert(int value) {
        Size++ ;
        if (Size > heap.length) heap= Arrays.copyOf(heap,heap.length+3) ;
        heap[Size-1] = value ;
        toOrgonize();
    }
    public void print() {
        for (int i=0 ; i<Size ; i++) {
            System.out.println(heap[i]);
        }
    }
    public void removeMin() {
        if (isEmpty()) return;
        else {
            heap[0]=heap[Size-1] ;
            Size-- ;
            rmMinOrgonize(0) ;
        }
    }
    private void rmMinOrgonize(int index) {
        int leftChiled = left(index) ;
        int rightChiled = right(index) ;
        int min ;
        int tmp ;
        if (rightChiled>=Size) {
            if(leftChiled>=Size) return;
            else min=leftChiled ;
        } else {
            if (heap[leftChiled] <= heap[rightChiled]) {
                min=leftChiled;
            }
            else min=rightChiled;
        }
        if (heap[index]>heap[min])  {
            tmp= heap[index] ;
            heap[index] = heap[min] ;
            heap[min] = tmp ;
            rmMinOrgonize(min);
        }
    }
}
