package com.mobiauto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<String> fizzBuzz() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                numbers.add("FizzBuzz");
            } else if (i % 3 == 0) {
                numbers.add("Fizz");
            } else if (i % 5 == 0) {
                numbers.add("Buzz");
            } else {
                numbers.add(String.valueOf(i));
            }
        }
        return numbers;
    }

    public static int countPointsAngryBirds(String[] result) {
        int points = 0;
        for (String s : result) {
            points += s.chars()
                    .filter(ch -> ch == '*')
                    .count();
        }
        return points;
    }

    public static int countCreepyMoments(String[] moments) {
        int counter = 0;
        for (String moment : moments) {
            String[] hoursAndMinutes = moment.split(":");
            String hours = hoursAndMinutes[0];
            String minutes = hoursAndMinutes[1];

            String firstHourDigit = hours.substring(0, 1);
            String secondHourDigit = hours.substring(1);

            String firstMinuteDigit = minutes.substring(0, 1);
            String secondMinuteDigit = minutes.substring(1);
            if (isAAAA(firstHourDigit, secondHourDigit, firstMinuteDigit, secondMinuteDigit)
                    || isAABB(firstHourDigit, secondHourDigit, firstMinuteDigit, secondMinuteDigit)
                    || isABAB(firstHourDigit, secondHourDigit, firstMinuteDigit, secondMinuteDigit)
                    || isABBA(firstHourDigit, secondHourDigit, firstMinuteDigit, secondMinuteDigit)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isAABB(String firstHourDigit, String secondHourDigit, String firstMinuteDigit, String secondMinuteDigit) {
        return firstHourDigit.equals(secondHourDigit) && firstMinuteDigit.equals(secondMinuteDigit);
    }

    private static boolean isABBA(String firstHourDigit, String secondHourDigit, String firstMinuteDigit, String secondMinuteDigit) {
        return firstHourDigit.equals(secondMinuteDigit) && secondHourDigit.equals(firstMinuteDigit);
    }

    private static boolean isABAB(String firstHourDigit, String secondHourDigit, String firstMinuteDigit, String secondMinuteDigit) {
        return firstHourDigit.equals(firstMinuteDigit) && secondHourDigit.equals(secondMinuteDigit);
    }

    private static boolean isAAAA(String firstHourDigit, String secondHourDigit, String firstMinuteDigit, String secondMinuteDigit) {
        return firstHourDigit.equals(secondHourDigit) &&
                firstMinuteDigit.equals(firstHourDigit) &&
                secondMinuteDigit.equals(secondHourDigit);
    }

    public static int getLeagueChampionPoints(int[] wins, int[] ties) {
        int numberOfTeams = wins.length;
        int[] points = new int[numberOfTeams];

        for (int i = 0; i < numberOfTeams; i++) {
            points[i] = wins[i] * 3 + ties[i];
        }

        return Arrays.stream(points).max().getAsInt();
    }
}
