package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.zq7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C25169zq7 implements Serializable {
    private static C25169zq7[] b = new C25169zq7[2];
    public static final C25169zq7 c = new C25169zq7(0);
    public static final C25169zq7 d = new C25169zq7(1);
    private int a;

    private C25169zq7(int i) {
        this.a = i;
        b[i] = this;
    }

    public String toString() {
        int i = this.a;
        return i != 0 ? i != 1 ? "Error while printing Timeout" : "Transaction Timeout" : "Retransmission Timeout";
    }
}
