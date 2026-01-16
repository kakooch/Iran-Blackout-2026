package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.wC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23011wC extends AbstractC24063xz {
    private String a;
    private VB b;

    public C23011wC(String str, VB vb) {
        this.a = str;
        this.b = vb;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        if (c19084pl0.v(3) != null) {
            this.b = VB.r(c19084pl0.d(3));
        }
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        VB vb = this.b;
        if (vb != null) {
            c19675ql0.b(3, vb.q());
        }
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ServiceMessage{}";
    }

    public VB u() {
        return this.b;
    }

    public String w() {
        return this.a;
    }

    public C23011wC() {
    }
}
