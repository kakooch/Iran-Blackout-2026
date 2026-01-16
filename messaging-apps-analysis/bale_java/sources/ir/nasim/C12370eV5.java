package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.eV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12370eV5 extends TP5 {
    private byte[] a;
    private List b;
    private HB c;

    public static C12370eV5 r(byte[] bArr) {
        return (C12370eV5) AbstractC16720ll0.b(new C12370eV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.v(1);
        this.b = new ArrayList();
        Iterator it = c19084pl0.n(2).iterator();
        while (it.hasNext()) {
            this.b.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        if (c19084pl0.v(3) != null) {
            this.c = HB.r(c19084pl0.d(3));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 222;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        byte[] bArr = this.a;
        if (bArr != null) {
            c19675ql0.b(1, bArr);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.f(2, ((EnumC15220jD) it.next()).j());
        }
        HB hb = this.c;
        if (hb != null) {
            c19675ql0.b(3, hb.q());
        }
    }

    public String toString() {
        return "rpc SearchMessagesMore{}";
    }
}
