package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.qz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19811qz extends AbstractC17566nB {
    private List a;

    public C19811qz(List list) {
        this.a = list;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C20420rz());
        }
        this.a = c19084pl0.p(1, arrayList);
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 6;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }

    public String toString() {
        return "struct MapValue{}";
    }

    public List u() {
        return this.a;
    }

    public C19811qz() {
    }
}
