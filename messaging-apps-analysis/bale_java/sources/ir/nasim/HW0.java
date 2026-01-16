package ir.nasim;

/* loaded from: classes.dex */
public abstract class HW0 {
    public static final int a(int i) {
        return Character.charCount(i);
    }

    public static final int b(CharSequence charSequence, int i) {
        return Character.codePointAt(charSequence, i);
    }

    public static final int c(CharSequence charSequence, int i) {
        return Character.codePointBefore(charSequence, i);
    }
}
