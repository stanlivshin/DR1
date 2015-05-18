package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.Sentence;

public class SentenceTest {

	@Test
	public void testSentence() {
		String text = "This contains 12 words and punctuations.";
		Sentence sentence = new Sentence();
		sentence.processString(text);
		assertEquals(12, sentence.getSentenceItemArray().size());
		
		text = "";
		Sentence sentence2 = new Sentence();
		sentence2.processString(text);
		assertEquals(0, sentence2.getSentenceItemArray().size());
		
		text = "~!@#$%^&*()+=-";
		Sentence sentence3 = new Sentence();
		sentence3.processString(text);
		assertEquals(14, sentence3.getSentenceItemArray().size());
	}
}
