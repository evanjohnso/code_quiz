package com.company;

import com.company.SinglyLinkedList.Node;

public class Main {
    public static void main(String[] args) {
        String a = "8274019656219028659301288111182982891661022947253820";
        String c = "7396983492654280852359244735289764547811192735453222";

        SinglyLinkedList list = new SinglyLinkedList(new Node("1"));
        list.push(new Node("2"));
        list.push(new Node("3"));
        list.push(new Node("4"));
        System.out.println(list.head.value + " " + list.tail.value);
        list.reverse();
        System.out.println(list.head.value + " " + list.tail.value);

        AddLargeInts.addLargeInts("1234", "12345678");
        AddLargeInts.addLargeInts("12345678", "1234");
        AddLargeInts.addLargeInts(a, c);
    }

}
