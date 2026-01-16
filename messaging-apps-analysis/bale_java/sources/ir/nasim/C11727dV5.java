package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.dV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11727dV5 extends TP5 {
    private HB a;
    private List b;

    public static C11727dV5 r(byte[] bArr) {
        return (C11727dV5) AbstractC16720ll0.b(new C11727dV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0.v(1) != null) {
            this.a = HB.r(c19084pl0.d(1));
        }
        this.b = new ArrayList();
        Iterator it = c19084pl0.n(2).iterator();
        while (it.hasNext()) {
            this.b.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 217;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        HB hb = this.a;
        if (hb != null) {
            c19675ql0.b(1, hb.q());
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.f(2, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc SearchMessages{}";
    }
}
