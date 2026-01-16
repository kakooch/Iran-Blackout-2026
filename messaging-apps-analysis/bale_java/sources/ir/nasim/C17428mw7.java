package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.mw7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17428mw7 implements Serializable {
    private final Object a;
    private final Object b;
    private final Object c;

    public C17428mw7(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public static /* synthetic */ C17428mw7 e(C17428mw7 c17428mw7, Object obj, Object obj2, Object obj3, int i, Object obj4) {
        if ((i & 1) != 0) {
            obj = c17428mw7.a;
        }
        if ((i & 2) != 0) {
            obj2 = c17428mw7.b;
        }
        if ((i & 4) != 0) {
            obj3 = c17428mw7.c;
        }
        return c17428mw7.d(obj, obj2, obj3);
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final Object c() {
        return this.c;
    }

    public final C17428mw7 d(Object obj, Object obj2, Object obj3) {
        return new C17428mw7(obj, obj2, obj3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17428mw7)) {
            return false;
        }
        C17428mw7 c17428mw7 = (C17428mw7) obj;
        return AbstractC13042fc3.d(this.a, c17428mw7.a) && AbstractC13042fc3.d(this.b, c17428mw7.b) && AbstractC13042fc3.d(this.c, c17428mw7.c);
    }

    public final Object f() {
        return this.a;
    }

    public final Object g() {
        return this.b;
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final Object j() {
        return this.c;
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ", " + this.c + ')';
    }
}
