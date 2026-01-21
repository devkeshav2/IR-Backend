package Linked;

import java.util.LinkedList;

public class CreateLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 1);

        System.out.println(list.get(0));
    }
}
