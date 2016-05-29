package heap_prioqueue;

/**
 *                   root at 0    root at 1
 * Left child        ix*2 + 1     ix*2
 * Right child       ix*2 + 2     ix*2 + 1
 * Parent            (ix-1)/2     ix/2
 */
public class Heap {

    int[] storage;
    int last;

    public Heap() {
        storage = new int[10];
        last = 1;
    }

    //can work in place - just pop item as last item in array after heapify
    void sort() {
        while(last>1) {
            print();
            System.out.println("         popped   "  +pop());
        }
    }

    public void heapifyUp(int nodeIdx) {
        if(nodeIdx <= 1) {
            //at root
            return;
        }
        int currVal = storage[nodeIdx];
        int parentVal = storage[nodeIdx/2];
        if(parentVal < currVal) {
            storage[nodeIdx/2] = currVal;
            storage[nodeIdx] = parentVal;
            heapifyUp(nodeIdx/2);
        }
    }

    public void add(Integer newValue) {
        storage[last] = newValue;
        heapifyUp(last);
        last++;
    }

    public int pop() {
        int max = storage[1];
        storage[1] = storage[--last];
        heapifyDown(storage[1], 1);

        return max;
    }

    private void heapifyDown(int value, int start) {

        final int leftIndex = 2*start;
        final int rightIndex = 2*start+1;
        if(rightIndex>= last || leftIndex >=last ) return;

        int rightValue = storage[rightIndex];
        int leftValue = storage[leftIndex];

        //!! take grater
        int swapIndex;
        if(leftValue > rightValue) {
            swapIndex = leftIndex;
        } else {
            swapIndex = rightIndex;
        }

        if(leftValue > value) {
            int tmp = storage[swapIndex];
            storage[swapIndex] = value;
            storage[start] = tmp;

            heapifyDown(value, swapIndex);
        }
    }

    public void print() {
        int levels = (int)Math.floor(Math.sqrt(last-1))+1;

        System.out.println("Heap levels: " + levels);

       // for(int level=1; level <= levels; level ++) {

         //   int indents = ((levels*levels)/(2*(level)));
//            for(int ind = 0; ind < indents; ind++ ) {
//                System.out.print("\t");
//            }

            for (int i = 1; i< last; i++) {
                    System.out.print(storage[i] + "\t");
            }

            System.out.println();
        //}
    }

    public static void main(String[] args) {
        Heap heap  = new Heap();
        heap.add(5);

        heap.add(7);
        heap.add(8);

        heap.add(9);


        heap.add(10);

        heap.add(2);
        heap.add(3);

        heap.add(1);


        heap.print();

        //heap.print();

      // System.out.println("max=" + heap.pop());

        heap.print();


        heap.sort();
      //  heap.print();

    }
}