package com.patika.messaging.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AdvertDetailsGenerator {

    public static final ArrayList<String> titleList1 = new ArrayList<>(Arrays.asList("Satilik","Kiralik","temiz","ihtiyactan"));
    public static final ArrayList<String> titleList2 = new ArrayList<>(Arrays.asList("Ev","Araba","Arsa","Daire","Motosiklet"));
    public static final ArrayList<String> detailList = new ArrayList<>(Arrays.asList("Asansörlü","kombili","temiz"));

    public static String generateTitle(){
        Random random = new Random();
        int titleIdx1 = random.nextInt(titleList1.size());
        int titleIdx2 = random.nextInt(titleList2.size());


        return titleList1.get(titleIdx1) + " " + titleList2.get(titleIdx2);
    }

    public static String generateDetail(){
        Random random = new Random();
        int detailIdx = random.nextInt(detailList.size());

        return detailList.get(detailIdx);
    }

}
