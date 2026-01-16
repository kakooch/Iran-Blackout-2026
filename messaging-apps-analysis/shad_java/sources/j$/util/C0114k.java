package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0114k {
    private static final C0114k c = new C0114k();
    private final boolean a;
    private final int b;

    private C0114k() {
        this.a = false;
        this.b = 0;
    }

    private C0114k(int i) {
        this.a = true;
        this.b = i;
    }

    public static C0114k a() {
        return c;
    }

    public static C0114k d(int i) {
        return new C0114k(i);
    }

    public int b() {
        if (this.a) {
            return this.b;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0114k)) {
            return false;
        }
        C0114k c0114k = (C0114k) obj;
        boolean z = this.a;
        if (z && c0114k.a) {
            if (this.b == c0114k.b) {
                return true;
            }
        } else if (z == c0114k.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.a) {
            return this.b;
        }
        return 0;
    }

    public String toString() {
        return this.a ? String.format("OptionalInt[%s]", Integer.valueOf(this.b)) : "OptionalInt.empty";
    }
}
