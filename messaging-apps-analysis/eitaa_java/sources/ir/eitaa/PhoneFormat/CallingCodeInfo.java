package ir.eitaa.PhoneFormat;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CallingCodeInfo {
    public ArrayList<String> countries = new ArrayList<>();
    public String callingCode = "";
    public ArrayList<String> trunkPrefixes = new ArrayList<>();
    public ArrayList<String> intlPrefixes = new ArrayList<>();
    public ArrayList<RuleSet> ruleSets = new ArrayList<>();

    String matchingAccessCode(String str) {
        Iterator<String> it = this.intlPrefixes.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (str.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    String matchingTrunkCode(String str) {
        Iterator<String> it = this.trunkPrefixes.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (str.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    String format(String orig) {
        String strSubstring;
        String str;
        String str2 = null;
        if (orig.startsWith(this.callingCode)) {
            str = this.callingCode;
            strSubstring = orig.substring(str.length());
        } else {
            String strMatchingTrunkCode = matchingTrunkCode(orig);
            if (strMatchingTrunkCode != null) {
                strSubstring = orig.substring(strMatchingTrunkCode.length());
                str2 = strMatchingTrunkCode;
                str = null;
            } else {
                strSubstring = orig;
                str = null;
            }
        }
        Iterator<RuleSet> it = this.ruleSets.iterator();
        while (it.hasNext()) {
            String str3 = it.next().format(strSubstring, str, str2, true);
            if (str3 != null) {
                return str3;
            }
        }
        Iterator<RuleSet> it2 = this.ruleSets.iterator();
        while (it2.hasNext()) {
            String str4 = it2.next().format(strSubstring, str, str2, false);
            if (str4 != null) {
                return str4;
            }
        }
        return (str == null || strSubstring.length() == 0) ? orig : String.format("%s %s", str, strSubstring);
    }
}
