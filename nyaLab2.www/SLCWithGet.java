public class SLCWithGet <E extends Comparable<? super E>> extends LinkedCollection<E> implements CollectionWithGet<E>{
    @Override
    public boolean add(E element){
        if(element == null){
            throw new NullPointerException();
        }
        if(head == null || element.compareTo(head.element) < 0){
            head = new Entry(element, head);
            return true;
        }
        Entry dummy = head;
        while((dummy.next != null) && element.compareTo(dummy.next.element) > 0){
            dummy = dummy.next;
        }
        dummy.next = new Entry(element, dummy.next);
        return true;
    }
    @Override
    public E get(E e) {
        Entry dummy = head;
        while(dummy != null) {
            int res = e.compareTo(dummy.element);
            if (res == 0){
                return dummy.element;
            }
            else if(res < 1){
                return null;
            }
            dummy = dummy.next;
        }
        return null;
    }
}
