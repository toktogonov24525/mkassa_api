package com.Mkassa_API.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomDate {

    public static LocalDate generateRandomDate() {
        int year = 2023;
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 31);
        return LocalDate.of(year, month, day);
    }

    public static String getRandomDate(String startDateStr, String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();

        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            long startMillis = startDate.getTime();
            long endMillis = endDate.getTime();
            long randomMillis = startMillis + (long) (random.nextDouble() * (endMillis - startMillis));
            Date randomDate = new Date(randomMillis);

            return dateFormat.format(randomDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int getRandomBranchId(int[] branchIds) {
        Random random = new Random();
        int randomIndex = random.nextInt(branchIds.length);
        return branchIds[randomIndex];
    }
    public static void performRandomPutRequest(int[] branchIds) {
        int selectedBranchId = getRandomBranchId(branchIds);
        putRequest(selectedBranchId);


    }

    public static void putRequest(int branchId) {
        System.out.println("Sending PUT request to branch ID: " + branchId);
    }

}
