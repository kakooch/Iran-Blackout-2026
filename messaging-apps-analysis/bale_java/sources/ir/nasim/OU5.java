package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class OU5 extends TP5 {
    private C25238zy a;
    private long b;
    private List c;
    private Long d;

    public static OU5 r(byte[] bArr) {
        return (OU5) AbstractC16720ll0.b(new OU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.i(4);
        this.c = new ArrayList();
        Iterator it = c19084pl0.n(5).iterator();
        while (it.hasNext()) {
            this.c.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        this.d = Long.valueOf(c19084pl0.y(6));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 101;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.g(4, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.f(5, ((EnumC15220jD) it.next()).j());
        }
        Long l = this.d;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
    }

    public String toString() {
        return "rpc RemoveGroupAvatar{}";
    }
}
