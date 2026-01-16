package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0115l {
    private static final C0115l c = new C0115l();
    private final boolean a;
    private final long b;

    private C0115l() {
        this.a = false;
        this.b = 0L;
    }

    private C0115l(long j) {
        this.a = true;
        this.b = j;
    }

    public static C0115l a() {
        return c;
    }

    public static C0115l d(long j) {
        return new C0115l(j);
    }

    public long b() {
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
        if (!(obj instanceof C0115l)) {
            return false;
        }
        C0115l c0115l = (C0115l) obj;
        boolean z = this.a;
        if (z && c0115l.a) {
            if (this.b == c0115l.b) {
                return true;
            }
        } else if (z == c0115l.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.a) {
            return 0;
        }
        long j = this.b;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return this.a ? String.format("OptionalLong[%s]", Long.valueOf(this.b)) : "OptionalLong.empty";
    }
}
