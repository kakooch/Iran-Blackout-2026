package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class DX5 extends AbstractC10365bX5 {
    private List b;
    private List c;

    public static DX5 s(byte[] bArr) {
        return (DX5) AbstractC16720ll0.b(new DX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C18766pD());
        }
        this.b = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new C22883vz());
        }
        this.c = c19084pl0.p(2, arrayList2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(2, this.c);
    }

    public String toString() {
        return "response FetchGroupAdmins{}";
    }
}
