package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.My, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6278My extends AbstractC17902nl0 {
    private EnumC6538Ny a;
    private List b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC6538Ny.p(iH);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C6044Ly());
        }
        this.b = c19084pl0.p(2, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC6538Ny enumC6538Ny = this.a;
        if (enumC6538Ny != null) {
            c19675ql0.f(1, enumC6538Ny.j());
        }
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "struct InternetBundleList{}";
    }
}
