package com.starbucks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
	private ArrayList<Drink> drinks;
	private ArrayList<Product> products = new ArrayList<>();

	public ArrayList<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(ArrayList<Drink> drinks) {
		this.drinks = drinks;
	}

	public void listMenu() {
		LocalDate now = LocalDate.now();
		System.out.println(
				"************************************************* Menu ************************************************* \n");
		System.out.print(String.format("%s", "ID"));
		System.out.print(String.format("%20s", "Product Name"));
		System.out.print(String.format("%20s", "Price"));
		System.out.print(String.format("%20s", "Lactose Free"));
		System.out.print(String.format("%20s", "Available From"));
		System.out.print(String.format("%20s", "Available To"));
		System.out.print(String.format("%20s", "Is Available"));
		System.out.println();
		this.drinks.forEach(drink -> {
			System.out.printf("%2o", drink.getId());
			System.out.printf("%20s", drink.getTitle());
			System.out.printf("%20f", drink.getPrice());
			System.out.printf("%20s", drink.isLactoseFree());
			System.out.printf("%20s", drink.getFrom().toString());
			System.out.printf("%20s", drink.getTo().toString());
			if (now.isAfter(drink.getFrom()) && now.isBefore(drink.getTo())) {
				System.out.printf("%20s \n", "true");
			} else {
				System.out.printf("%20s \n", "false");
			}
		});
		Scanner sc = new Scanner(System.in);
		String userInput = "0";
		while (Integer.parseInt(userInput) != -1) {
			System.out.println("\nPlease Enter the ID of one of your favorite items : ");
			userInput = sc.nextLine();
			addPrefferedItem(Integer.parseInt(userInput));
			System.out.println("Do you want to enter another item? Press any button if yes and -1 if no : ");
			userInput = sc.nextLine();
		}
		sc.close();
		System.out.println("Thank you !");
	}

	public void writeUserOptionsToFile() {
		File outputFile = new File("Files/prefferedOptions.csv");
		try (PrintWriter pw = new PrintWriter(outputFile)) {
			List<String[]> productsStrings = new ArrayList<>();
			for (int i = 0; i < products.size(); i++) {
				productsStrings.add(new String[] { String.valueOf(products.get(i).getId()), products.get(i).getTitle(),
						String.valueOf(products.get(i).getPrice()) });
			}
			productsStrings.stream().map(productString -> convertToCSV(productString)).forEach(pw::println);

		} catch (FileNotFoundException e) {
			System.out.println("Output file not found");
		}
	}

	private String convertToCSV(String[] userProducts) {
		return Stream.of(userProducts).collect(Collectors.joining(","));
	}

	private void addPrefferedItem(int id) {
		this.drinks.forEach(drink -> {
			if (drink.getId() == id) {
				this.products.add((Product) drink);
			}
		});
	}

}
