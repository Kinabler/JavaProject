/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l_stack;

/**
 *
 * @author phamt
 */
public class Node {

    Object info;
    Node next;

    Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

    Node(Object info) {
        this(info, null);
    }
}
