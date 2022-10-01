class MyPointer {
    private Pointer head;
    private Pointer tail;
    private int size;

    public MyPointer() {
        this.size = 0;
    }

    private class Pointer {
        private int value;
        private Pointer next;

        public Pointer(int value) {
            this.value = value;
        }

        public Pointer(int value, Pointer next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtFirst(int value) {
        Pointer pointer = new Pointer(value);
        pointer.next = head;
        head = pointer;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertAtLast(int value) {
        if (tail == null) {
            insertAtFirst(value);
            return;
        }
        Pointer pointer = new Pointer(value);
        tail.next = pointer;
        tail = pointer;
        size++;
    }

    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            insertAtFirst(value);
            return;
        }
        if (index == size) {
            insertAtLast(value);
            return;
        }
        Pointer temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Pointer pointer = new Pointer(value, temp.next);
        temp.next = pointer;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1)
            return deleteFirst();

        Pointer secondLast = getValue(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int deleteAtIndex(int index) {
        if (index == 0)
            return deleteFirst();
        if (index == size - 1)
            return deleteLast();
        Pointer previous = getValue(index - 1);
        int value = previous.next.value;

        return value;
    }

    public Pointer findElement(int value) {
        Pointer pointer = head;
        while (pointer != null) {
            if (pointer.value == value)
                return pointer;
            pointer = pointer.next;
        }
        return pointer;
    }

    public Pointer getValue(int index) {
        Pointer pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public void displayPointerList() {
        Pointer temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyPointer myList = new MyPointer();

        myList.insertAtFirst(4);
        myList.insertAtFirst(5);
        myList.insertAtFirst(6);
        myList.insertAtFirst(3);
        myList.insertAtFirst(14);
        myList.insertAtFirst(49);
        myList.insertAtIndex(20, 4);
        myList.displayPointerList();
    }
}