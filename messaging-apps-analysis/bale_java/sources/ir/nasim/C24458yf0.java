package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.yf0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C24458yf0 {
    private final int a;
    private final CharSequence b;

    C24458yf0(int i, CharSequence charSequence) {
        this.a = i;
        this.b = charSequence;
    }

    private static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    private boolean d(CharSequence charSequence) {
        String strA = a(this.b);
        String strA2 = a(charSequence);
        return (strA == null && strA2 == null) || (strA != null && strA.equals(strA2));
    }

    int b() {
        return this.a;
    }

    CharSequence c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C24458yf0)) {
            return false;
        }
        C24458yf0 c24458yf0 = (C24458yf0) obj;
        return this.a == c24458yf0.a && d(c24458yf0.b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), a(this.b)});
    }
}
