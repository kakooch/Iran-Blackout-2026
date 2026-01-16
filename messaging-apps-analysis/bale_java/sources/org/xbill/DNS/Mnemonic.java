package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/* loaded from: classes8.dex */
class Mnemonic {
    static final int CASE_LOWER = 3;
    static final int CASE_SENSITIVE = 1;
    static final int CASE_UPPER = 2;
    private final String description;
    private boolean numericok;
    private String prefix;
    private final int wordcase;
    private final HashMap<String, Integer> strings = new HashMap<>();
    private final HashMap<Integer, String> values = new HashMap<>();
    private int max = Integer.MAX_VALUE;

    public Mnemonic(String str, int i) {
        this.description = str;
        this.wordcase = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$remove$0(int i, Map.Entry entry) {
        return ((Integer) entry.getValue()).intValue() == i;
    }

    private int parseNumeric(String str) throws NumberFormatException {
        try {
            int i = Integer.parseInt(str);
            if (i < 0) {
                return -1;
            }
            if (i <= this.max) {
                return i;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String sanitize(String str) {
        int i = this.wordcase;
        return i == 2 ? str.toUpperCase() : i == 3 ? str.toLowerCase() : str;
    }

    public void add(int i, String str) {
        check(i);
        String strSanitize = sanitize(str);
        this.strings.put(strSanitize, Integer.valueOf(i));
        this.values.put(Integer.valueOf(i), strSanitize);
    }

    public void addAlias(int i, String str) {
        check(i);
        this.strings.put(sanitize(str), Integer.valueOf(i));
    }

    public void addAll(Mnemonic mnemonic) {
        if (this.wordcase == mnemonic.wordcase) {
            this.strings.putAll(mnemonic.strings);
            this.values.putAll(mnemonic.values);
        } else {
            throw new IllegalArgumentException(mnemonic.description + ": wordcases do not match");
        }
    }

    public void check(int i) {
        if (i < 0 || i > this.max) {
            throw new IllegalArgumentException(this.description + Separators.SP + i + " is out of range");
        }
    }

    public String getText(int i) {
        check(i);
        String str = this.values.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i);
        if (this.prefix == null) {
            return string;
        }
        return this.prefix + string;
    }

    public int getValue(String str) {
        int numeric;
        String strSanitize = sanitize(str);
        Integer num = this.strings.get(strSanitize);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.prefix;
        if (str2 != null && strSanitize.startsWith(str2) && (numeric = parseNumeric(strSanitize.substring(this.prefix.length()))) >= 0) {
            return numeric;
        }
        if (this.numericok) {
            return parseNumeric(strSanitize);
        }
        return -1;
    }

    public void remove(final int i) {
        this.values.remove(Integer.valueOf(i));
        this.strings.entrySet().removeIf(new Predicate() { // from class: org.xbill.DNS.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Mnemonic.lambda$remove$0(i, (Map.Entry) obj);
            }
        });
    }

    public void removeAlias(String str) {
        this.strings.remove(sanitize(str));
    }

    public void setMaximum(int i) {
        this.max = i;
    }

    public void setNumericAllowed(boolean z) {
        this.numericok = z;
    }

    public void setPrefix(String str) {
        this.prefix = sanitize(str);
    }
}
