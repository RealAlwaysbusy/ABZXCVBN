package com.ab.abzxcvbn;

import com.nulabinc.zxcvbn.AttackTimes.CrackTimeSeconds;

import anywheresoftware.b4a.BA.Hide;

public class ABCrackTimeSeconds {
	protected CrackTimeSeconds inner;
	
	@Hide
	public ABCrackTimeSeconds() {
		
	}
	
	@Hide
	public ABCrackTimeSeconds(CrackTimeSeconds secs) {
		inner=secs;
	}
	
	public double getOnlineThrottling100perHour() {
        return inner.getOnlineThrottling100perHour();
    }
    
    public double getOnlineNoThrottling10perSecond() {
        return inner.getOnlineNoThrottling10perSecond();
    }

    public double getOfflineSlowHashing1e4perSecond() {
        return inner.getOfflineSlowHashing1e4perSecond();
    }

    public double getOfflineFastHashing1e10PerSecond() {
        return inner.getOfflineFastHashing1e10PerSecond();
    }
    
    public String ToString() {
   	 StringBuilder s = new StringBuilder();
   	 s.append("    OnlineThrottling100perHour: " + getOnlineThrottling100perHour() + "\n");
   	 s.append("    OnlineNoThrottling10perSecond: " + getOnlineNoThrottling10perSecond() + "\n");
   	 s.append("    OfflineSlowHashing1e4perSecond: " + getOfflineSlowHashing1e4perSecond() + "\n");
   	 s.append("    OfflineFastHashing1e10PerSecond: " + getOfflineFastHashing1e10PerSecond() + "\n");
   	 return s.toString();
    }
}
