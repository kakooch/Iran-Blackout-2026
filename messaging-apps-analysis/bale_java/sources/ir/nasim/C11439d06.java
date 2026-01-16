package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.d06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11439d06 extends AbstractC10365bX5 {
    private List b;
    private List c;
    private OC d;
    private List e;

    public static C11439d06 s(byte[] bArr) {
        return (C11439d06) AbstractC16720ll0.b(new C11439d06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new IA());
        }
        this.b = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new GA());
        }
        this.c = c19084pl0.p(2, arrayList2);
        this.d = (OC) c19084pl0.z(3, new OC());
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(4); i3++) {
            arrayList3.add(new HA());
        }
        this.e = c19084pl0.p(4, arrayList3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(2, this.c);
        OC oc = this.d;
        if (oc != null) {
            c19675ql0.i(3, oc);
        }
        c19675ql0.m(4, this.e);
    }

    public String toString() {
        return "response LoadTransactions{}";
    }
}
