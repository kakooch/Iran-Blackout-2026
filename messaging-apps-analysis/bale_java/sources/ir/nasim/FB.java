package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FB extends AbstractC17902nl0 {
    private List a;
    private List b;
    private int c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C12047dx());
        }
        this.a = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new C12047dx());
        }
        this.b = c19084pl0.p(2, arrayList2);
        this.c = c19084pl0.g(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
        c19675ql0.m(2, this.b);
        c19675ql0.f(3, this.c);
    }

    public String toString() {
        return "struct ScoreBoard{}";
    }
}
