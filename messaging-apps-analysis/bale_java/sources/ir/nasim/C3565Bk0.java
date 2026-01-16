package ir.nasim;

import android.graphics.Rect;

/* renamed from: ir.nasim.Bk0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3565Bk0 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public C3565Bk0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int a() {
        return this.d - this.b;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c - this.a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C3565Bk0.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        C3565Bk0 c3565Bk0 = (C3565Bk0) obj;
        return this.a == c3565Bk0.a && this.b == c3565Bk0.b && this.c == c3565Bk0.c && this.d == c3565Bk0.d;
    }

    public final Rect f() {
        return new Rect(this.a, this.b, this.c, this.d);
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return ((Object) C3565Bk0.class.getSimpleName()) + " { [" + this.a + ',' + this.b + ',' + this.c + ',' + this.d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3565Bk0(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        AbstractC13042fc3.i(rect, "rect");
    }
}
