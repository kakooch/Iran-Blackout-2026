package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class BT5 extends TP5 {
    private C25238zy a;
    private long b;
    private C18766pD c;
    private List d;
    private Integer e;

    public static BT5 r(byte[] bArr) {
        return (BT5) AbstractC16720ll0.b(new BT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.i(4);
        this.c = (C18766pD) c19084pl0.z(3, new C18766pD());
        this.d = new ArrayList();
        Iterator it = c19084pl0.n(5).iterator();
        while (it.hasNext()) {
            this.d.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        this.e = Integer.valueOf(c19084pl0.x(6));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 69;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.g(4, this.b);
        C18766pD c18766pD = this.c;
        if (c18766pD != null) {
            c19675ql0.i(3, c18766pD);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            c19675ql0.f(5, ((EnumC15220jD) it.next()).j());
        }
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(6, num.intValue());
        }
    }

    public String toString() {
        return "rpc InviteUser{}";
    }
}
