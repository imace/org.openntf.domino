/*
 *******************************************************************************
 * Copyright (C) 2012, International Business Machines Corporation and         *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */
package com.ibm.icu.text;

import java.text.CharacterIterator;
import java.util.Stack;

/**
 * The LanguageBreakEngine interface is to be used to implement any language-specific logic for break iteration.
 */
interface LanguageBreakEngine {
	/**
	 * @param c
	 *            A Unicode codepoint value
	 * @param breakType
	 *            The kind of break iterator that is wanting to make use of this engine - character, word, line, sentence
	 * @return true if the engine can handle this character, false otherwise
	 */
	public boolean handles(int c, int breakType);

	/**
	 * Implements the actual breaking logic.
	 * 
	 * @param text
	 *            The text to break over
	 * @param startPos
	 *            The index of the beginning of our range
	 * @param endPos
	 *            The index of the possible end of our range. It is possible, however, that our range ends earlier
	 * @param reverse
	 *            true iff we are iterating backwards (in a call to previous(), for example)
	 * @param breakType
	 *            The kind of break iterator that is wanting to make use of this engine - character, word, line, sentence
	 * @param foundBreaks
	 *            A Stack that the breaks found will be added to
	 * @return the number of words found
	 */
	public int findBreaks(CharacterIterator text, int startPos, int endPos, boolean reverse, int breakType, Stack<Integer> foundBreaks);
}
