package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12038dw extends AbstractC24063xz {
    private AbstractC10632bw a;

    public C12038dw(AbstractC10632bw abstractC10632bw) {
        this.a = abstractC10632bw;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = AbstractC10632bw.r(c19084pl0.d(1));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 10;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC10632bw abstractC10632bw = this.a;
        if (abstractC10632bw == null) {
            throw new IOException();
        }
        c19675ql0.b(1, abstractC10632bw.q());
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct BankMessage{}";
    }

    public AbstractC10632bw u() {
        return this.a;
    }

    public C12038dw() {
    }
}
