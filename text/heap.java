
public class Heap {
  
  ArrayList<Integer> storage;
  int last;
  
  public Heap() {
    storage = new ArrayList<>();
    last = 0;
  }
  
  public void heapify(int nodeIdx) {
    if(nodeIdx < 0) {
     return;
    }
    int currVal = storage.get(nodeIdx);
    int parentVal = storage.get(nodeIdx/2);
    if(parentVal < currVal) {
      storage.set(nodeIdx/2, currVal);
      storage.set(nodeIdx, parentVal);
      heapify(nodeIdx/2))
    }
  }
  
  public void add(Integer newValue) {
    storage.set(last, newValue);
    heapify(last);
    last++;
  }
  
  public void get() {
  }
}


2 * 0             10    (0)
2 * 1 -1       6  (1)   7  (2)  2 * 1
2 * 2        5  (3)  4 (4)   6 (5) 2 (6)


2*(n-1) -1