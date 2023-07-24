package com.starbucks;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
	static Menu menu = new Menu();

	public static void main(String[] args) {
		menu.setDrinks(getDrinksFromFile());
		menu.listMenu();
		menu.writeUserOptionsToFile();
	}


	private static ArrayList<Drink> getDrinksFromFile() {
		Path path = Path.of("files/drinks.csv");
		ArrayList<Drink> drinks = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		try (BufferedReader reader = Files.newBufferedReader(path)) {

			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith("#")) {
					String[] elements = line.split(";");
					int id = Integer.parseInt(elements[0]);
					String name = elements[1];
					double price = Double.parseDouble(elements[2]);
					boolean lactoseFree = Boolean.parseBoolean(elements[3]);
					LocalDate from = LocalDate.parse(elements[4], formatter);
					LocalDate to = LocalDate.parse(elements[5], formatter);
					Drink d = new Drink(id, name, price, lactoseFree, from, to);
					drinks.add(d);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}catch(DateTimeParseException e ) {
			System.out.println("Date not valid");
		}
		catch (Exception e) {
			System.out.println("Unknown error!");
		}
		return drinks;
	}
}
