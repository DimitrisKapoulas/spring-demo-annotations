package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String filename = "/home/mitsos/Desktop/spring-demo-annotations/src/com/luv2code/springdemo/Fortunes.txt";
    private List<String> theFortunes;
    // create a random number generator
    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println(">> Inside the default constructor");
    }

    @PostConstruct
    private void loadFortunesFile() {
        File theFile = new File(filename);
        System.out.println(theFile.exists());
        theFortunes = new ArrayList<String>();

        // read fortunes from file
        try (BufferedReader br = new BufferedReader(
                new FileReader(theFile))) {

            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(theFortunes.size());

        String tempFortune = theFortunes.get(index);

        return tempFortune;
    }
}
