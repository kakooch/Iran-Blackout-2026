package ir.nasim;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.tM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21247tM5 implements QU3 {
    private final C21921uM5 a = new C21921uM5(100);

    private C21247tM5() {
    }

    public static QU3 b() {
        return new C21247tM5();
    }

    private static boolean c(CharSequence charSequence, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        if (matcher.matches()) {
            return true;
        }
        return z;
    }

    @Override // ir.nasim.QU3
    public boolean a(CharSequence charSequence, C10138b85 c10138b85, boolean z) {
        String strA = c10138b85.a();
        if (strA.length() == 0) {
            return false;
        }
        return c(charSequence, this.a.a(strA), z);
    }
}
