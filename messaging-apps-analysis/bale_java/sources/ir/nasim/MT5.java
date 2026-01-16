package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class MT5 extends TP5 {
    private long a;
    private int b;
    private List c;
    private EnumC9196Yx d;
    private boolean e;
    private EnumC5550Jv f;

    public static MT5 r(byte[] bArr) {
        return (MT5) AbstractC16720ll0.b(new MT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = new ArrayList();
        Iterator it = c19084pl0.n(3).iterator();
        while (it.hasNext()) {
            this.c.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC9196Yx.p(iH);
        }
        this.e = c19084pl0.b(5);
        int iH2 = c19084pl0.h(6, 0);
        if (iH2 != 0) {
            this.f = EnumC5550Jv.p(iH2);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 104;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.f(3, ((EnumC15220jD) it.next()).j());
        }
        EnumC9196Yx enumC9196Yx = this.d;
        if (enumC9196Yx != null) {
            c19675ql0.f(4, enumC9196Yx.j());
        }
        c19675ql0.a(5, this.e);
        EnumC5550Jv enumC5550Jv = this.f;
        if (enumC5550Jv != null) {
            c19675ql0.f(6, enumC5550Jv.j());
        }
    }

    public String toString() {
        return "rpc LoadDialogs{}";
    }
}
