package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15784kA extends AbstractC24063xz {
    private AbstractC14591iA a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = AbstractC14591iA.r(c19084pl0.d(1));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 167;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC14591iA abstractC14591iA = this.a;
        if (abstractC14591iA == null) {
            throw new IOException();
        }
        c19675ql0.b(1, abstractC14591iA.q());
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct OrderMessage{}";
    }

    public AbstractC14591iA u() {
        return this.a;
    }
}
