package ir.nasim;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes2.dex */
public final class L93 {
    public static final L93 e = new L93(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static class a {
        static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    private L93(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static L93 a(L93 l93, L93 l932) {
        return b(Math.max(l93.a, l932.a), Math.max(l93.b, l932.b), Math.max(l93.c, l932.c), Math.max(l93.d, l932.d));
    }

    public static L93 b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new L93(i, i2, i3, i4);
    }

    public static L93 c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static L93 d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || L93.class != obj.getClass()) {
            return false;
        }
        L93 l93 = (L93) obj;
        return this.d == l93.d && this.a == l93.a && this.c == l93.c && this.b == l93.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
