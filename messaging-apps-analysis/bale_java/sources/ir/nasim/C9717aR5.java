package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.aR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9717aR5 extends TP5 {
    private C25238zy a;
    private long b;
    private String c;
    private List d;

    public static C9717aR5 r(byte[] bArr) {
        return (C9717aR5) AbstractC16720ll0.b(new C9717aR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.A(3);
        this.d = new ArrayList();
        Iterator it = c19084pl0.n(5).iterator();
        while (it.hasNext()) {
            this.d.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 213;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            c19675ql0.f(5, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc EditGroupAbout{}";
    }
}
