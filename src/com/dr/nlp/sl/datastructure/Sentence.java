package com.dr.nlp.sl.datastructure;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.datastructure.helper.XMLTagable;

/**
 * NLP Data Structure - Sentence
 * 
 * Sentence data structure is created by Paragraph
 * and responsible for splitting input string into
 * SentenceItem(s) items and storing them into
 * array list by using non-word regular expression:
 * "\W"
 * 
 * SentenceItem are subclassed into Word(s) and
 * Punctuation(s)
 * 
 * This class also implements XMLTagable interface for
 * XML output
 * 
 * @see SentenceItem
 * @see Paragraph
 * @see Word
 * @see Punctuation
 * @see XMLTagable
 * @author Stan Livshin
 */
public class Sentence implements XMLTagable {
	
	private final String NON_WORD_REGEX = "\\W"; //match any non-word character
	private ArrayList<SentenceItem> sentenceItemArray;
	
	/**
	 * Default constructor
	 */
	public Sentence() {
		this.sentenceItemArray = new ArrayList<>();
	}
	
	/**
	 * Processing string input splitting it into Word(s)
	 * and/or Punctuation(s) using non-word regular
	 * expression
	 * @param string - Input String
	 */
	public void processString(String string) {
		int beginIndex = 0;
		Matcher matcher = Pattern.compile(NON_WORD_REGEX).matcher(string);
		while (matcher.find()) { //in between non-word chars Word(s) can be found
			if (beginIndex != matcher.start()) {
				if (Config.DEBUG)
					System.out.println(Sentence.class + " processString() Word: " + string.substring(beginIndex, matcher.start()));
				sentenceItemArray.add(new Word(string.substring(beginIndex, matcher.start())));
				beginIndex = matcher.end();
			} else
				beginIndex++;
			
			//process the matched non-word, ie Punctuation
			if (Config.DEBUG)
				System.out.println(Sentence.class + " processString() Punctuation: " + matcher.group());
			sentenceItemArray.add(new Punctuation(matcher.group()));
		}
	}
	
	/**
	 * @return SentenceItem array list holding Word(s) and Punctuation(s)
	 */
	public ArrayList<SentenceItem> getSentenceItemArray() {
		return sentenceItemArray;
	}

	/**
	 * Used for XML Output tag
	 * @return "Sentence" string
	 */
	@Override
	public String getXMLTagName() {
		return "Sentence";
	}
}
