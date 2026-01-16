package org.rbmain.PhoneFormat;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class CallingCodeInfo {
    public String callingCode;
    public ArrayList<String> intlPrefixes;
    public ArrayList<RuleSet> ruleSets;
    public ArrayList<String> trunkPrefixes;

    public CallingCodeInfo() {
        new ArrayList();
        this.callingCode = BuildConfig.FLAVOR;
        this.trunkPrefixes = new ArrayList<>();
        this.intlPrefixes = new ArrayList<>();
        this.ruleSets = new ArrayList<>();
    }

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

    String format(String str) {
        String strSubstring;
        String str2;
        String str3 = null;
        if (str.startsWith(this.callingCode)) {
            str2 = this.callingCode;
            strSubstring = str.substring(str2.length());
        } else {
            String strMatchingTrunkCode = matchingTrunkCode(str);
            if (strMatchingTrunkCode != null) {
                strSubstring = str.substring(strMatchingTrunkCode.length());
                str3 = strMatchingTrunkCode;
                str2 = null;
            } else {
                strSubstring = str;
                str2 = null;
            }
        }
        if (this.callingCode.equals("98") && strSubstring.startsWith("0")) {
            strSubstring = strSubstring.replaceFirst("^0+(?!$)", BuildConfig.FLAVOR);
        }
        Iterator<RuleSet> it = this.ruleSets.iterator();
        while (it.hasNext()) {
            String str4 = it.next().format(strSubstring, str2, str3, true);
            if (str4 != null) {
                return str4;
            }
        }
        Iterator<RuleSet> it2 = this.ruleSets.iterator();
        while (it2.hasNext()) {
            String str5 = it2.next().format(strSubstring, str2, str3, false);
            if (str5 != null) {
                return str5;
            }
        }
        return (str2 == null || strSubstring.length() == 0) ? str : String.format("%s %s", str2, strSubstring);
    }
}
