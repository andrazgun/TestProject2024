package org.siit.course;

import java.util.*;

public class Course06 {


//HashMap method to iterate and print all K/V pairs
    public static void printHashMap(HashMap<Character, Integer> hm) {
        for (Character c : hm.keySet()) {
            System.out.println(c + " : " + hm.get(c));
        }
        System.out.println(hm);
    }

//method to sum array elements positioned on even indexes
    private static int addEvenPositions(int[] arr1) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i+=2) {
            sum += arr1[i];
        }
        return sum;
    }
//      ArrayList method
    public static ArrayList<String> convertArrayToList(String[] arg) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, arg);
        return list;
    }
//          Hashset method
    public static HashSet<String> getUniqueWords(String phrase) {
        HashSet<String> uniqueWords = new HashSet<>();
        String[] words = phrase.split(" "); //split the phrase into words based on spaces
        Collections.addAll(uniqueWords, words);
        return uniqueWords;
    }

//    Number of character duplication in a text - HashMap method
    public static HashMap<Character, Integer> getAllCharsCount(String phrase) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (Character c: phrase.toLowerCase().toCharArray()) { //breaks phrase in an array with characters from phrase
            if (charMap.containsKey(c)) { //checks if character is present in HashMap
                charMap.replace(c, charMap.get(c) +1); // increment the value of the hashmap with 1
            }
            else { // character is not present in HashMap
                charMap.put(c, 1);
            }

        }
        return charMap;
    }


    public static void runCourseCode06() {


//        int type Array, collection of int variables
        int[] arrayInt = {1, 5, 9};

//        String type Array, collection of String variables
        String[] arrayString = {"Alex", "are", "mere"};

//        int type Person, collection of objects'
        Person[] arrayPerson = {
                new Person(),
                new Person(22,
                        'f',
                        "Dan",
                        181,
                        90,
                        true,
                        1946)
                };

//        empty array of 5 persons, index 0 - 4
        Person[] arr2 = new Person[5];
        arr2[3] = new Person(); // person at index 2 will have value, the rest will be null
        System.out.println(arr2[0]); // null
        System.out.println(arr2[3]); // org.siit.course.Person@5594a1b5
//        Array index is out of bounds
//        arr2[5] = new Person();

        for (String s : arrayString) {
            System.out.println(s);
        }
        System.out.println(addEvenPositions(arrayInt)); // 10

        ArrayList arr3 = new ArrayList(); // raw arraylist --> without parameter type
        List arr4 = new ArrayList(); // raw list --> without parameter type
        ArrayList<String> names1 = new ArrayList<>(); // String type arraylist
        names1.add("Ana");
        names1.add("Bubu");
        names1.add("Cezar");
        System.out.println(names1.size()); // 3
        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Ion");
        ArrayList<String> names3 = new ArrayList<>();
        names3.addAll(names1);
        names3.addAll(names2);
        ArrayList<String> names4 = (ArrayList<String>) names3.clone(); // clones names3 but create a unique arrayList
        if (names3.contains("Alex")) { //if element is present
            System.out.println("Alex is part of the team");
        }
        else {
            System.out.println("Alex is not part of the team");
        }

        if (names3.equals(names4)) { //use this to compare 2 lists element by element
            System.out.println("Collections are the same");
        }
        else {
            System.out.println("Collections are different");
        }

        ArrayList<String> names5 = names4;
        System.out.println(names3.indexOf("Ana")); //return index of element
        System.out.println(names3.get(0)); //return value of element at index x
        System.out.println("--------------------");
        System.out.println(names4.lastIndexOf("Ion"));
        names3.set(0, "Danut"); //update a value on a specific index/position
        System.out.println(names3.indexOf("Danut"));
        System.out.println("--------------------");
        String[] arr5 = new String[names5.size()]; //convert ArrayList to Array
        arr5 = names4.toArray(arr5);
        System.out.println(arr5);
        System.out.println("--------------------");
        for (String s : arr5) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        ArrayList<String> newList = convertArrayToList(arr5);//convert Array to ArrayList



        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Triangle(4, 5, 7)); //add different element to ArrayList
        shapeList.add((new Circle(5))); //add different element to ArrayList

        for (Shape s : shapeList) {
            s.draw();
        }
//        ArrayList iterator old version not recommended
        Iterator it = shapeList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
//        shapeList.remove(0); // remove element from ArrayList

//        ArrayList iterator with enhanced loop, recommended
        for (Shape shape : shapeList) {
            System.out.println(shape); // print all ArrayList elements in new line
        }
        System.out.println("-----------HashSets---------");
//        HashSets
        HashSet<String> myHashSet = new HashSet<>();
        myHashSet.add("Vali");
        myHashSet.add("Fane");
        myHashSet.add("Tibi");
        myHashSet.add("Vali"); //error duplicate element, won't be added to HashSet
        myHashSet.remove("Fane"); //remove element
        for (String s : myHashSet) {
            System.out.println(s);
        }

        String phrase = "Sets are not ordered, so you cannot access an element from it using index as you\n" +
                "do with lists";

        for (String word : getUniqueWords(phrase)) {
            System.out.println(word);
        }
        System.out.println("-------HashMaps-------------");
//      HashMaps
        HashMap<Integer, String> namesIndex = new HashMap<>();
        namesIndex.put(10, "Ana");
        namesIndex.put(5, "Gina");

        for (Integer key : namesIndex.keySet()) {
            System.out.println(key + " : " + namesIndex.get(key));
        }

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("doi", "cinci"); // add element with K/V
        hashMap1.put("trei", "patru"); // add element with K/V
        hashMap1.put("dude", "mere"); // add element with K/V
        hashMap1.remove("trei"); //remove element by key

        for (String key : hashMap1.keySet()) {
            System.out.println(key + " : " + hashMap1.get(key));
        }

        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        hashMap2 = getAllCharsCount("ana are mere");
        printHashMap(hashMap2);

        System.out.println("-----Queues---------------");
//        Queues
        Queue<Integer> q = new LinkedList<>();
        q.add(56);
        q.add(101);
        q.add(69);
        q.add(23);
        System.out.println(q);
        int qh = q.poll();//Retrieves, but does not remove, the head of this queue
        System.out.println(qh);
        System.out.println(q);


        System.out.println("----ENUM---------------");

        ArrayList<String> browsers = new ArrayList<>(){
            {
                add("Firefox");
                add("Chrome");
                add("Edge");
            }
        };
        ; // Firefox
        System.out.println(browsers.get(0)); // get Firefox from ArrayList
        System.out.println(Browsers.FIREFOX); // get FIREFOX from Enum
        if (browsers.get(0).compareToIgnoreCase(Browsers.FIREFOX.toString()) == 0) { //compare arraylist with enum
            System.out.println("Browsers are the same: " + Browsers.FIREFOX);
        }



    }
}
