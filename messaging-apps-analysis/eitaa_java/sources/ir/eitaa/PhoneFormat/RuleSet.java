package ir.eitaa.PhoneFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class RuleSet {
    public static Pattern pattern = Pattern.compile("[0-9]+");
    public boolean hasRuleWithIntlPrefix;
    public boolean hasRuleWithTrunkPrefix;
    public int matchLen;
    public ArrayList<PhoneRule> rules = new ArrayList<>();

    String format(String str, String intlPrefix, String trunkPrefix, boolean prefixRequired) {
        int length = str.length();
        int i = this.matchLen;
        if (length >= i) {
            Matcher matcher = pattern.matcher(str.substring(0, i));
            int i2 = matcher.find() ? Integer.parseInt(matcher.group(0)) : 0;
            Iterator<PhoneRule> it = this.rules.iterator();
            while (it.hasNext()) {
                PhoneRule next = it.next();
                if (i2 >= next.minVal && i2 <= next.maxVal && str.length() <= next.maxLen) {
                    if (prefixRequired) {
                        int i3 = next.flag12;
                        if (((i3 & 3) == 0 && trunkPrefix == null && intlPrefix == null) || ((trunkPrefix != null && (i3 & 1) != 0) || (intlPrefix != null && (i3 & 2) != 0))) {
                            return next.format(str, intlPrefix, trunkPrefix);
                        }
                    } else if ((trunkPrefix == null && intlPrefix == null) || ((trunkPrefix != null && (next.flag12 & 1) != 0) || (intlPrefix != null && (next.flag12 & 2) != 0))) {
                        return next.format(str, intlPrefix, trunkPrefix);
                    }
                }
            }
            if (!prefixRequired) {
                if (intlPrefix != null) {
                    Iterator<PhoneRule> it2 = this.rules.iterator();
                    while (it2.hasNext()) {
                        PhoneRule next2 = it2.next();
                        if (i2 >= next2.minVal && i2 <= next2.maxVal && str.length() <= next2.maxLen && (trunkPrefix == null || (next2.flag12 & 1) != 0)) {
                            return next2.format(str, intlPrefix, trunkPrefix);
                        }
                    }
                } else if (trunkPrefix != null) {
                    Iterator<PhoneRule> it3 = this.rules.iterator();
                    while (it3.hasNext()) {
                        PhoneRule next3 = it3.next();
                        if (i2 >= next3.minVal && i2 <= next3.maxVal && str.length() <= next3.maxLen && (intlPrefix == null || (next3.flag12 & 2) != 0)) {
                            return next3.format(str, intlPrefix, trunkPrefix);
                        }
                    }
                }
            }
        }
        return null;
    }
}
