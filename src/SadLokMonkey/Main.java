package SadLokMonkey;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main {

	//public static String FORMAT = "The ADJ NOUN ADV VERB the NOUN whilst it VERB its NOUN.";
	public static String FORMAT = "I really like adj noun.";
	
	
	public static void main (String[] args) {
		List<String> nouns, verbs, adjectives, adverbs;
		PrintWriter out = null;
		Random RNG = new Random();
		RNG.setSeed(System.currentTimeMillis());

		try {
			nouns = Files.readAllLines(Paths.get("src/SadLokMonkey/nouns.txt"), Charset.defaultCharset());
			verbs = Files.readAllLines(Paths.get("src/SadLokMonkey/verbs.txt"), Charset.defaultCharset());
			adjectives = Files.readAllLines(Paths.get("src/SadLokMonkey/adjectives.txt"), Charset.defaultCharset());
			adverbs = Files.readAllLines(Paths.get("src/SadLokMonkey/adverbs.txt"), Charset.defaultCharset());
			//out = new PrintWriter("src/SadLokMonkey/hereyago.txt");
			String result;
			for (int i = 0; i < 15; i++) {
				result = FORMAT;
				
				while (result.contains("noun")) {
					result = result.replaceFirst("noun", nouns.get(RNG.nextInt(nouns.size())));
				}
				while (result.contains("NOUN")) {
					result = result.replaceFirst("NOUN", nouns.get(RNG.nextInt(nouns.size())).toUpperCase());
				}
				while (result.contains("verb")) {
					result = result.replaceFirst("verb", verbs.get(RNG.nextInt(verbs.size())));
				}
				while (result.contains("VERB")) {
					result = result.replaceFirst("VERB", verbs.get(RNG.nextInt(verbs.size())).toUpperCase());
				}
				while (result.contains("adj")) {
					result = result.replaceFirst("adj", adjectives.get(RNG.nextInt(adjectives.size())));
				}
				while (result.contains("ADJ")) {
					result = result.replaceFirst("ADJ", adjectives.get(RNG.nextInt(adjectives.size())).toUpperCase());
				}
				while (result.contains("adv")) {
					result = result.replaceFirst("adv", adverbs.get(RNG.nextInt(adverbs.size())));
				}
				while (result.contains("ADV")) {
					result = result.replaceFirst("ADV", adverbs.get(RNG.nextInt(adverbs.size())).toUpperCase());
				}
				System.out.println(result+"\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (out != null) out.close();
		}
	}
}