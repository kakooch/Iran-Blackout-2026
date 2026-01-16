package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ZX5 extends AbstractC10365bX5 {
    private List b;

    public static ZX5 s(byte[] bArr) {
        return (ZX5) AbstractC16720ll0.b(new ZX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C24045xx());
        }
        this.b = c19084pl0.p(2, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "response GetDialogAdOrderDetails{}";
    }
}
