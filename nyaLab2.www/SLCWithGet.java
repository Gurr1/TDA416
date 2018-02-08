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
        while(element.compareTo(dummy.next.element) > 0){
            dummy = dummy.next;
        }
        dummy.next = new Entry(element, dummy.next);
        return true;
    }

    @Override
    public E get(E e) {
        Entry dummy = head;
        while(dummy != null) {
            if (e.compareTo(dummy.element) == 0){
                return dummy.element;
            }
            dummy = dummy.next;
        }
        return null;
    }
}
