package com.example.project1;

public class LinkedList<Object extends Comparable<Object>> {
    Node front;

    public void addFirst(Object d) {
        Node newNode = new Node(d);
        if (front == null) front = newNode;
        else {
            newNode.next = front;
            front = newNode;
        }
    }

    public void addLast(Object d) {
        Node newNode = new Node(d);
        Node curr = front;
        if (front == null) front = newNode;
        else {
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
    }


    public void addSort(Object data) { //method for add sorted to linked list
        Node newNode = new Node(data);
        Node curr = front;
        Node prev = null;
        for (; (curr != null) && curr.data.compareTo(data) < 0; prev = curr, curr = curr.next)
            ;

        if (front == null) // case0 add to empty link list
            addFirst(data);
        else if (prev == null) { // case1 add to empty first element
            addFirst(data);
        } else if (curr == null) { // case2: add the last
            addLast(data);
        } else { // case3: insert between two node (curr and prev )
            newNode.next = curr;
            prev.next = newNode;
        }

    }

    public Tawjihi Ser(LinkedList<Tawjihi> lin, long seat) {//method for search in linked list
        Node<Tawjihi> ser = lin.front;
        while (ser != null) {
            if (ser.data.getSeatNumber() == seat) {
                return ser.data;
            } else
                ser = ser.next;
        }
        return null;
    }

    public boolean delete(Object x) {//delete a node from linke list
        if (front == null)
            return false;
        if (front.data.equals(x)) {
            front = front.next;
            return true;
        }
        Node<Object> previous = front;
        Node<Object> current = front.next;
        while (current != null) {
            if (current.data.equals(x)) {

                previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public boolean deleteStudent(LinkedList<Tawjihi> lin, long Seat) { //search a node and send it to methode delete
        Node<Tawjihi> delete = lin.front;
        while (delete != null) {
            if (delete.data.getSeatNumber() == Seat) {
                return delete((Object) delete.data);
            } else
                delete = delete.next;
        }
        return false;
    }

    @Override
    public String toString() {//print
        Node curr = front;
        String s = "";
        while (curr != null) {
            s += curr.data;
            curr = curr.next;
        }
        return s;
    }

    public int getSize() {//return the size for list
        Node curr = front;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    public double getMean() {//get the avg for list
        Node<Tawjihi> curr = front;
        double mean;
        double sum = 0;
        while (curr != null) {
            sum += curr.data.getAvg();
            curr = curr.next;
        }
        mean = sum / getSize();
        return mean;
    }

    public LinkedList topTen() {//print top 10 student
        LinkedList top = new LinkedList();
        Node<Tawjihi> curr = front;
        int cunt = 1;
        double topavg = curr.data.getAvg();
        while (cunt < 10) {
            top.addSort(curr.data);
            if (curr.data.getAvg() < topavg) {
                cunt++;
                topavg = curr.data.getAvg();
            }
            curr = curr.next;
        }
        return top;
    }

    public int numberAboveGrade(double grade) {//return the number of student above a grade
        Node<Tawjihi> curr = front;
        int adove = 0;
        while (curr != null) {
            if (curr.data.getAvg() >= grade)
                adove++;
            curr = curr.next;
        }
        return adove;
    }

    public double perAboveGrade(double grade) {//return the per of student above a grade
        return numberAboveGrade(grade) / (double) getSize();
    }

    public double mode() {//retuen the mode of list
        double mode = 0;
        Node<Tawjihi> curr = front.next;
        Node<Tawjihi> prev = front;
        int max = 0;
        while (curr != null) {
            int counter = 1;
            while (curr.data.getAvg() == prev.data.getAvg()) {
                counter++;
                prev = curr;
                curr = curr.next;
            }
            if (counter > max) {
                mode = curr.data.getAvg();
                max = counter;
            }
            prev = curr;
            curr = curr.next;
        }
        return mode;
    }

}

