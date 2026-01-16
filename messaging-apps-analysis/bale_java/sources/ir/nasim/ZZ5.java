package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ZZ5 extends AbstractC10365bX5 {
    private List b;
    private OC c;

    public static ZZ5 s(byte[] bArr) {
        return (ZZ5) AbstractC16720ll0.b(new ZZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new GC());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = (OC) c19084pl0.z(2, new OC());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        OC oc = this.c;
        if (oc != null) {
            c19675ql0.i(2, oc);
        }
    }

    public String toString() {
        return "response LoadOwnStickers{}";
    }
}
