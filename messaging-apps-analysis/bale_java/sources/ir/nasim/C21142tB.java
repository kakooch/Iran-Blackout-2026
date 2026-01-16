package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.tB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21142tB extends AbstractC10632bw {
    private C19811qz a;
    private C19811qz b;

    public C21142tB(C19811qz c19811qz, C19811qz c19811qz2) {
        this.a = c19811qz;
        this.b = c19811qz2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C19811qz) c19084pl0.k(1, new C19811qz());
        this.b = (C19811qz) c19084pl0.k(2, new C19811qz());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC10632bw
    public int s() {
        return 6;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C19811qz c19811qz = this.a;
        if (c19811qz == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c19811qz);
        C19811qz c19811qz2 = this.b;
        if (c19811qz2 == null) {
            throw new IOException();
        }
        c19675ql0.i(2, c19811qz2);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ReceiptMessage{}";
    }

    public C19811qz u() {
        return this.a;
    }

    public C19811qz w() {
        return this.b;
    }

    public C21142tB() {
    }
}
