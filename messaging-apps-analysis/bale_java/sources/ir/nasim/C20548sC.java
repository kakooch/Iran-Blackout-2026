package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.sC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20548sC extends VB {
    private int a;

    public C20548sC(int i) {
        this.a = i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.VB
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ServiceExUserInvited{}";
    }

    public int u() {
        return this.a;
    }

    public C20548sC() {
    }
}
