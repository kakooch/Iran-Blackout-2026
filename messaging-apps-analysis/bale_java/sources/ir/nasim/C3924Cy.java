package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Cy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3924Cy extends AbstractC17902nl0 {
    private UB a;
    private List b;
    private boolean c;
    private List d;
    private Boolean e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (UB) c19084pl0.z(1, new UB());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C15065ix());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.b(3);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(6); i2++) {
            arrayList2.add(new C25247zz());
        }
        this.d = c19084pl0.p(6, arrayList2);
        this.e = Boolean.valueOf(c19084pl0.u(7));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        UB ub = this.a;
        if (ub != null) {
            c19675ql0.i(1, ub);
        }
        c19675ql0.m(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.m(6, this.d);
        Boolean bool = this.e;
        if (bool != null) {
            c19675ql0.a(7, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct GroupUpdateContainer{}";
    }
}
