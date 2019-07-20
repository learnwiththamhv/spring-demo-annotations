package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private ArrayList<String> data = new ArrayList<String>();
	private final String fileName = "C:\\Users\\hvtha\\eclipse-workspace\\spring-demo-annotations\\src\\fortuneFile.txt";
	private Random rand = new Random();

	public FileFortuneService() {

	}

	@PostConstruct
	public void initDataFromFile() {
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">> FileFortuneService: inside initDataFromFile() method");
	}

	private void readFile() throws IOException {
		File theFile = new File(fileName);
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
		}
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return data.get(rand.nextInt(data.size()));
	}

}
