package ir.nasim;

import java.io.Serializable;

/* loaded from: classes8.dex */
public final class XV4 implements Serializable {
    private final Object a;
    private final Object b;

    public XV4(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public static /* synthetic */ XV4 d(XV4 xv4, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = xv4.a;
        }
        if ((i & 2) != 0) {
            obj2 = xv4.b;
        }
        return xv4.c(obj, obj2);
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final XV4 c(Object obj, Object obj2) {
        return new XV4(obj, obj2);
    }

    public final Object e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XV4)) {
            return false;
        }
        XV4 xv4 = (XV4) obj;
        return AbstractC13042fc3.d(this.a, xv4.a) && AbstractC13042fc3.d(this.b, xv4.b);
    }

    public final Object f() {
        return this.b;
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ')';
    }
}
