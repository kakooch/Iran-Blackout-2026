package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.pB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18748pB extends AbstractC17902nl0 {
    private C4392Ey a;
    private List b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C19930rB());
        }
        this.b = c19084pl0.p(2, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "struct Reaction{}";
    }
}
