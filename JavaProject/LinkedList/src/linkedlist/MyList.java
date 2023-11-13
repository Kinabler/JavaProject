/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author phamt
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    int size() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    //Line 12 - 43
    int getIndex(int info) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info == info) {
                break;
            }
            indexRes++;
            p = p.next;
        }
        return indexRes;
    }

    void traverse() {
        Node node = head;
        while (node != null) {
            System.out.println(node.info + " ");
            node = node.next;
        }
        System.out.println("");
    }

    boolean exist(int value) {
        Node node = head;
        while (node != null) {
            if (node.info == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    void addLast(int info) {
        if (head == null) {
            head = tail = new Node(info);
        } else {
            Node node = new Node(info);
            tail.next = node;
            tail = node;
        }
    }

    void addFirst(int info) {
        if (isEmpty()) {
            head = tail = new Node(info);
        } else {
            Node node = new Node(info);
            node.next = head;
            head = node;
        }
    }

    void addPosition(int pos, Node x) {
        //Pos must != 0 and != size()
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        Node node = new Node(x, p.next);
        p.next = node;
    }

    void delFirst() {
        head = head.next;
    }

    //Line 106 - 149
    void delLast() {
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        tail = node;
    }

    void delNodeHaveValueX(int x) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            i++;
            p = p.next;
        }
        delPosition(i);
    }

    void delPosition(int pos) {
        //Pos must != 0 and != size() - 1
        Node p = head;
        while (pos -- > 1) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    int get(int pos) {
        Node p = head;
        while (pos-- > 0) {
            p = p.next;
        }
        return p.info;
    }

    void sort() {
        if (isEmpty()) {
            return;
        }
        Node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info > pj.info) {
                    int temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    void sortFirstKElements(int k) {
        for (int i = 0; i < k; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info > pj.next.info) {
                    int temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }

    void sortLastKElements(int k) {
        int count = size() - k;
        Node pi = head, pj;
        while (count-- > 0) {
            pi = pi.next;
        }

        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info > pj.info) {
                    int temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    void revrese() {
        Node prev = null, current = head, next;
        boolean updateTail = false;
        while (current != null) {
            next = current.next;
            current.next = prev;
            if (!updateTail) {
                tail = current;
                updateTail = true;
            }
            prev = current;
            current = next;
        }

        head = prev;
    }

    void reverseFirstKElements(int k) {
        Node temp = head, connect;
        while (k-- > 1) {
            temp = temp.next;
        }
        connect = temp.next;
        temp.next = null;

        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = connect;
    }

    void reverseLastKElements(int k) {
        int count = size() - k;
        Node connect = head;
        while (count-- > 1) {
            connect = connect.next;
        }

        Node prev = null, current = connect.next, next;
        connect.next = tail;
        tail = current;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

}
