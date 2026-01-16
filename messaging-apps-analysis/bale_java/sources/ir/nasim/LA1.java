package ir.nasim;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public final class LA1 {
    private Integer a;

    public final Integer a(KeyEvent keyEvent) {
        int iC = AbstractC23371wo3.c(keyEvent);
        if ((Integer.MIN_VALUE & iC) != 0) {
            this.a = Integer.valueOf(iC & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.a;
        if (num == null) {
            return Integer.valueOf(iC);
        }
        this.a = null;
        Integer numValueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), iC));
        Integer num2 = numValueOf.intValue() != 0 ? numValueOf : null;
        return num2 == null ? Integer.valueOf(iC) : num2;
    }
}
