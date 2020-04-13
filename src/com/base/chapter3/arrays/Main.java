package com.base.chapter3.arrays;

public class Main {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard(5);

        scoreboard.add(new GameEntry(500, "Enkos"));
        scoreboard.add(new GameEntry(300, "Marji"));
        scoreboard.add(new GameEntry(20, "Marcom"));
        scoreboard.add(new GameEntry(30, "Pippo"));
        scoreboard.add(new GameEntry(400, "Joseph"));
        scoreboard.add(new GameEntry(230, "Pluto"));


        System.out.println(scoreboard.toString());

        char[] chars = new char[5];

        chars[0] = 'B';
        chars[1] = 'C';
        chars[2] = 'D';
        chars[3] = 'A';
        chars[4] = 'E';

        insertionSort(chars);
    }

    public static void insertionSort(char[] data) {
        int length = data.length;

        for (int i = 1; i < length; i++) {
            char current = data[i];

            int j = i;

            while (j > 0 && data[j - 1] > current) {
                data[j] = data[j - 1];
                j--;
            }

            data[j] = current;
        }
    }
}
