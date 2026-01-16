package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.xP1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23720xP1 implements Serializable {
    private static int b = 4;
    private static C23720xP1[] c = new C23720xP1[4];
    public static final C23720xP1 d = new C23720xP1(0);
    public static final C23720xP1 e = new C23720xP1(1);
    public static final C23720xP1 f = new C23720xP1(2);
    public static final C23720xP1 g = new C23720xP1(3);
    private int a;

    private C23720xP1(int i) {
        this.a = i;
        c[i] = this;
    }

    public static C23720xP1 a(int i) {
        if (i < 0 || i >= b) {
            throw new IllegalArgumentException("Invalid dialogState value");
        }
        return c[i];
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C23720xP1) && ((C23720xP1) obj).a == this.a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        int i = this.a;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Error while printing Dialog State" : "Terminated Dialog" : "Completed Dialog" : "Confirmed Dialog" : "Early Dialog";
    }
}
