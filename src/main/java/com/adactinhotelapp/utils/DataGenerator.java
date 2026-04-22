package com.adactinhotelapp.utils;

import com.github.javafaker.Faker;

public class DataGenerator {

	private static final Faker faker = new Faker();

	public static String getRandomName() {
		return faker.name().fullName();
	}

	public static String getRandomEmail() {
		// Generates something like: john.doe_123@example.com
		return faker.internet().emailAddress();
	}

	public static String getRandomFirstName() {
		return faker.name().firstName();
	}

	public static String getRandomLastName() {
		return faker.name().lastName();
	}

	public static String getRandomCompanyName() {
		return faker.company().name();
	}

	public static String getRandomAddress() {
		return faker.address().streetAddress();
	}

	public static String getRandomCardNumber() {
		return faker.finance().creditCard();
	}

	public static String getRandomExpiryMonth() {
		return String.format("%02d", faker.number().numberBetween(1, 12));
	}

	public static String getRandomExpiryYear() {
		return String.valueOf(faker.number().numberBetween(2027, 2037));
	}

	public static String getRandomCVV() {
		return faker.number().digits(3);
	}

	// Generates a single realistic sentence
	public static String getRandomSentence() {
		return faker.lorem().sentence();
	}

	// Generates a paragraph (ideal for "Comments" or "Feedback" boxes)
	public static String getRandomComment() {
		return faker.lorem().paragraph();
	}

	// Generates a specific number of words
	public static String getRandomWords(int count) {
		return faker.lorem().fixedString(count);
	}

	public static String getRandomCountry() {
		return faker.address().country();
	}

	public static String getRandomState() {
		return faker.address().state();
	}

	public static String getRandomCity() {
		return faker.address().city();
	}

	public static String getRandomZipCode() {
		return faker.address().zipCode();
	}

	public static String getRandomMobileNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String getRandomPassword() {
		return faker.internet().password();
	}

}