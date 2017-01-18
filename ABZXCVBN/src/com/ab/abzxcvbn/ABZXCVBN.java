package com.ab.abzxcvbn;

import java.util.ArrayList;

import com.nulabinc.zxcvbn.AttackTimes;
import com.nulabinc.zxcvbn.Feedback;
import com.nulabinc.zxcvbn.Matching;
import com.nulabinc.zxcvbn.Scoring;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.TimeEstimates;
import com.nulabinc.zxcvbn.matchers.Match;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DesignerName;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.collections.List;

@DesignerName("Build 20170117")                                    
@Version(1.00F)                                
@Author("Alain Bailleul")      
@ShortName("ABZXCVBN")    
public class ABZXCVBN {
	public void Initialize() {
		
	}

    public ABZStrength measure(String password) {
        return measure(password, null);
    }

    public ABZStrength measure(String password, List sanitizedInputs) {
        if (password.equals("")) {
            BA.LogError("Password is empty.");
            return null;
        }
        java.util.List<String> lowerSanitizedInputs = new ArrayList<>();
        if (sanitizedInputs != null) {
        	for (int i=0;i<sanitizedInputs.getSize();i++) {
        		String s = (String) sanitizedInputs.Get(i);
        		lowerSanitizedInputs.add(s.toLowerCase());
        	}            
        }
        long start = time();
        Matching matching = new Matching(lowerSanitizedInputs);
        java.util.List<Match> matches = matching.omnimatch(password);
        Strength strength = Scoring.mostGuessableMatchSequence(password, matches);
        strength.setCalcTime(time() - start);
        AttackTimes attackTimes = TimeEstimates.estimateAttackTimes(strength.getGuesses());
        strength.setCrackTimeSeconds(attackTimes.getCrackTimeSeconds());
        strength.setCrackTimesDisplay(attackTimes.getCrackTimesDisplay());
        strength.setScore(attackTimes.getScore());
        strength.setFeedback(Feedback.getFeedback(strength.getScore(), strength.getSequence()));
        ABZStrength ret = new ABZStrength();
        ret.inner = strength;
        return ret;
    }

    private long time() {
        return System.nanoTime();
    }
}
