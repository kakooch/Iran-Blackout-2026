package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.uZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22039uZ6 extends AbstractC21382tZ6 {
    public static String A1(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(0, AbstractC23053wG5.i(i, str.length()));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static String B1(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        if (i >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - AbstractC23053wG5.i(i, length));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static final Collection C1(CharSequence charSequence, Collection collection) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        for (int i = 0; i < charSequence.length(); i++) {
            collection.add(Character.valueOf(charSequence.charAt(i)));
        }
        return collection;
    }

    public static List D1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? E1(charSequence) : AbstractC9766aX0.e(Character.valueOf(charSequence.charAt(0))) : AbstractC10360bX0.m();
    }

    public static final List E1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return (List) C1(charSequence, new ArrayList(charSequence.length()));
    }

    public static String q1(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(AbstractC23053wG5.i(i, str.length()));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static String r1(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        if (i >= 0) {
            return A1(str, AbstractC23053wG5.e(str.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char s1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character t1(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (i < 0 || i >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static char u1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(AbstractC20762sZ6.f0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character v1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static char w1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static Character x1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static String y1(String str, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(c24411ya3, "indices");
        return c24411ya3.isEmpty() ? "" : AbstractC20762sZ6.V0(str, c24411ya3);
    }

    public static CharSequence z1(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (i >= 0) {
            return charSequence.subSequence(0, AbstractC23053wG5.i(i, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
