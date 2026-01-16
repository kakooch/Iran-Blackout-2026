package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.aT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9735aT5 extends TP5 {
    private List a;

    public static C9735aT5 r(byte[] bArr) {
        return (C9735aT5) AbstractC16720ll0.b(new C9735aT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = new ArrayList();
        Iterator it = c19084pl0.n(1).iterator();
        while (it.hasNext()) {
            this.a.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 9;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.f(1, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc GetState{}";
    }
}
