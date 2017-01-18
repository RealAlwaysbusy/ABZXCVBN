package com.ab.abzxcvbn;

import com.nulabinc.zxcvbn.Strength;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;

@Author("Alain Bailleul")      
@ShortName("ABZStrength") 
public class ABZStrength {
	protected Strength inner=null;;
    
    
    public String getPassword() {
        return inner.getPassword();
    }
    
    public double getGuesses() {
        return inner.getGuesses();
    }

    public double getGuessesLog10() {
        return inner.getGuessesLog10();
    }

    public ABCrackTimeSeconds getCrackTimeSeconds() {
        return new ABCrackTimeSeconds(inner.getCrackTimeSeconds());
    }

    public ABCrackTimesDisplay getCrackTimesDisplay() {
        return new ABCrackTimesDisplay(inner.getCrackTimesDisplay());
    }

    public int getScore() {
        return inner.getScore();
    }

    public ABFeedback getFeedback() {
        return new ABFeedback(inner.getFeedback());
    }

    /*
    public List getSequence() {
    	List sequence = new List();
    	sequence.Initialize();
    	for (int i=0;i<inner.getSequence().size();i++) {
    		Match m = inner.getSequence().get(i);
    		sequence.Add(new ABMatch(m));
    	}
        return sequence;
    }
    */

    public long getCalcTime() {
        return inner.getCalcTime();
    }
    
    public String ToString() {
    	StringBuilder s = new StringBuilder();
    	s.append("Password: " + getPassword() + "\n");
    	s.append("Score: " + getScore() + "\n");
    	s.append("Guesses: " + getGuesses() + "\n");
    	s.append("GuessesLog10: " + getGuessesLog10() + "\n");
    	s.append("CrackTimeSeconds:\n");
    	s.append(getCrackTimeSeconds().ToString());
    	s.append("CrackTimesDisplay:\n");
    	s.append(getCrackTimesDisplay().ToString());
    	s.append("Feedback:\n");
    	s.append(getFeedback().ToString());
    	s.append("------------------------------------------------------------\n");
    	return s.toString();
    }
}
