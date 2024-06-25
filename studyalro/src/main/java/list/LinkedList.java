package list;

import java.util.Comparator;

public class LinkedList<E> {
    class Node<E>{
        private E data; //데이터
        private Node<E> next; //뒤쪽 포인터

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; //머리 포인터
    private Node<E> crnt; //선택 포인터

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                //검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null; //검색 실패
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj); //리스트가 비었다면 머리에 삽입
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head; //스캔 중인 노드
                Node<E> pre = head; //스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    //노드 p를 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    //선택한 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }
    //모든 노드 삭제
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        crnt = null;
    }
    //선택 노드를 하나 뒤쪽으로 진행
    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    //선택한 노드를 출력
    public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }
    //모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
