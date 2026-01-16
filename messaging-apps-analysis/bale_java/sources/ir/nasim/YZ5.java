package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class YZ5 extends AbstractC10365bX5 {
    private List b;
    private byte[] c;

    public static YZ5 s(byte[] bArr) {
        return (YZ5) AbstractC16720ll0.b(new YZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C22883vz());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = c19084pl0.v(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        byte[] bArr = this.c;
        if (bArr != null) {
            c19675ql0.b(2, bArr);
        }
    }

    public String toString() {
        return "response LoadMembers{}";
    }
}
