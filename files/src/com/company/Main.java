package com.company;
import  filesWork.fileRead;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	System.out.println("Введите имя файла, или путь к нему");
	Scanner scanner = new Scanner(System.in);
	String fileName = scanner.nextLine();
	scanner.close();
		
	fileRead file  = new fileRead(fileName);
	int[] quantity = file.QuantitySymb();
	file.OutputFile(quantity);
    }
}
