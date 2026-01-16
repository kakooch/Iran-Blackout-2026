package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.vu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22841vu3 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(BJ3 bj3, AbstractC13165fm abstractC13165fm) {
        BJ3 bj3J1 = bj3.j1();
        if (!(bj3J1 != null)) {
            M73.b("Child of " + bj3 + " cannot be null when calculating alignment line");
        }
        if (bj3.q1().t().containsKey(abstractC13165fm)) {
            Integer num = (Integer) bj3.q1().t().get(abstractC13165fm);
            return num != null ? num.intValue() : RecyclerView.UNDEFINED_DURATION;
        }
        int iJ = bj3J1.J(abstractC13165fm);
        if (iJ == Integer.MIN_VALUE) {
            return RecyclerView.UNDEFINED_DURATION;
        }
        bj3J1.X1(true);
        bj3.W1(true);
        bj3.U1();
        bj3J1.X1(false);
        bj3.W1(false);
        return iJ + (abstractC13165fm instanceof HY2 ? C22045ua3.l(bj3J1.F1()) : C22045ua3.k(bj3J1.F1()));
    }
}
