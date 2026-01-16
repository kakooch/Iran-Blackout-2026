package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.nZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17788nZ5 extends AbstractC10365bX5 {
    private List b;
    private EA c;

    public static C17788nZ5 s(byte[] bArr) {
        return (C17788nZ5) AbstractC16720ll0.b(new C17788nZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new NA());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = (EA) c19084pl0.z(2, new EA());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        EA ea = this.c;
        if (ea != null) {
            c19675ql0.i(2, ea);
        }
    }

    public String toString() {
        return "response GetUserAccounts{}";
    }
}
