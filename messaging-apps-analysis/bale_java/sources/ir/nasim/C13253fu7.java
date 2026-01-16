package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.fu7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13253fu7 implements Serializable {
    private static int b = 6;
    private static C13253fu7[] c = new C13253fu7[6];
    public static final C13253fu7 d = new C13253fu7(0);
    public static final C13253fu7 e = new C13253fu7(1);
    public static final C13253fu7 f = new C13253fu7(2);
    public static final C13253fu7 g = new C13253fu7(3);
    public static final C13253fu7 h = new C13253fu7(4);
    public static final C13253fu7 i = new C13253fu7(5);
    private int a;

    private C13253fu7(int i2) {
        this.a = i2;
        c[i2] = this;
    }

    public static C13253fu7 a(int i2) {
        if (i2 < 0 || i2 >= b) {
            throw new IllegalArgumentException("Invalid transactionState value");
        }
        return c[i2];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C13253fu7) && ((C13253fu7) obj).a == this.a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        int i2 = this.a;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "Error while printing Transaction State" : "Terminated Transaction" : "Confirmed Transaction" : "Completed Transaction" : "Proceeding Transaction" : "Trying Transaction" : "Calling Transaction";
    }
}
