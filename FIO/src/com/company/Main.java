package com.company;
import java.text.ParseException;
import java.util.Scanner;
import Information.*;


public class Main {

    public static void main(String[] args) throws ParseException {
	 System.out.println("Введите ФИО и дату рождения:");
	 Scanner scanner = new Scanner(System.in);
	 String inf = scanner.nextLine();
	 scanner.close();
	 InformationAboutUser informationAboutUser = new InformationAboutUser(inf);
	 System.out.println(informationAboutUser.Surname + " " + informationAboutUser.Initials + ' '+
			 informationAboutUser.sex + ' ' + informationAboutUser.age);
    }
}
