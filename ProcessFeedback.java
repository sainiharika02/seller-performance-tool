package com.model;

public class ProcessFeedback {
	String[] positives = {"good","awesome","nice","best","great", "fast"};
	String[] negatives = {"bad","worst","ugly","waste","poor", "slow"};
	
	public boolean isPositive(String word) {
		for(int index =0; index < positives.length ; index++){
			if(word.equals(positives[index])) {
				return true; 
			}
		}
		return false;
	}
	
	public boolean isNegative(String word) {
		for(int index =0; index < negatives.length ; index++){
			if(word.equals(negatives[index])) {
				return true; 
			}
		}
		return false;
	}
	
	public String categorize(String feedback) {
		int positive = 0,negative = 0, neutral = 0;
		String[] word = feedback.split(" ");
		for (int i = 0; i < word.length; i ++) {
			if (isPositive(word[i])){
				positive++;
			} else if (isNegative(word[i])) {
				negative ++;
			} else {
				neutral ++;
			}
		}
		if (positive < negative) {
			return "negative";
		} else {
			return "positive";
		}
	}
}
