package ir.nasim;

import java.text.BreakIterator;

/* loaded from: classes.dex */
public abstract class JY6 {
    public static final int a(String str, int i) {
        androidx.emoji2.text.e eVarC = c();
        Integer num = null;
        if (eVarC != null) {
            Integer numValueOf = Integer.valueOf(eVarC.d(str, i));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i);
    }

    public static final int b(String str, int i) {
        androidx.emoji2.text.e eVarC = c();
        Integer num = null;
        if (eVarC != null) {
            Integer numValueOf = Integer.valueOf(eVarC.f(str, Math.max(0, i - 1)));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    private static final androidx.emoji2.text.e c() {
        if (!androidx.emoji2.text.e.k()) {
            return null;
        }
        androidx.emoji2.text.e eVarC = androidx.emoji2.text.e.c();
        if (eVarC.g() == 1) {
            return eVarC;
        }
        return null;
    }
}
