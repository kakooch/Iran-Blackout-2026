package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.fB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12793fB extends AbstractC24063xz {
    private AbstractC24063xz a;

    public C12793fB(AbstractC24063xz abstractC24063xz) {
        this.a = abstractC24063xz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = AbstractC24063xz.r(c19084pl0.d(1));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 27;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC24063xz abstractC24063xz = this.a;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(1, abstractC24063xz.q());
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ProtectedMessage{}";
    }

    public AbstractC24063xz u() {
        return this.a;
    }

    public C12793fB() {
    }
}
