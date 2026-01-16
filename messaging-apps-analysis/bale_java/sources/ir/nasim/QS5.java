package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QS5 extends TP5 {
    private List a;
    private List b;

    public QS5(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public static QS5 r(byte[] bArr) {
        return (QS5) AbstractC16720ll0.b(new QS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C18766pD());
        }
        this.a = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new C25238zy());
        }
        this.b = c19084pl0.p(2, arrayList2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 2628;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "rpc GetReferencedEntitites{}";
    }

    public QS5() {
    }
}
