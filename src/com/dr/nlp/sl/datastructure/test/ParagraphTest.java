package com.dr.nlp.sl.datastructure.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dr.nlp.sl.datastructure.Paragraph;

public class ParagraphTest {
	
	@Test
	public void testParagraph() {
		String text = "";
		Paragraph paragraph = new Paragraph();
		paragraph.processString(text);
		assertEquals(0, paragraph.getSentenceArray().size());
		
		text = "Testing.  Testing2. And now a quote: \"Quoting?\" Testing3.";
		Paragraph paragraph2 = new Paragraph();
		paragraph2.processString(text);
		assertEquals(4, paragraph2.getSentenceArray().size());
		
		text = "Testing. Testing! Testing, testing? 'Single quote', said test! Now double quote, \"HOORAY!\" End of test!";
		Paragraph paragraph3 = new Paragraph();
		paragraph3.processString(text);
		assertEquals(6, paragraph3.getSentenceArray().size());
	}
}
