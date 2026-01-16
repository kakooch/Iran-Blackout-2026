package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11541dB extends AbstractC24063xz {
    private long a;
    private String b;
    private AbstractC24063xz c;
    private AbstractC24063xz d;
    private String e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        if (c19084pl0.v(3) != null) {
            this.c = AbstractC24063xz.r(c19084pl0.d(3));
        }
        if (c19084pl0.v(4) != null) {
            this.d = AbstractC24063xz.r(c19084pl0.d(4));
        }
        this.e = c19084pl0.A(5);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 62980;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        AbstractC24063xz abstractC24063xz = this.c;
        if (abstractC24063xz != null) {
            c19675ql0.b(3, abstractC24063xz.q());
        }
        AbstractC24063xz abstractC24063xz2 = this.d;
        if (abstractC24063xz2 != null) {
            c19675ql0.b(4, abstractC24063xz2.q());
        }
        String str2 = this.e;
        if (str2 != null) {
            c19675ql0.o(5, str2);
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
        return "struct PremiumMessage{}";
    }
}
