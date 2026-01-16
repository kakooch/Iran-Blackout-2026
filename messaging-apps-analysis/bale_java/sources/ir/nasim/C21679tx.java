package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.tx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21679tx extends AbstractC10632bw {
    private AbstractC24063xz a;
    private EnumC21816uB b;
    private C19811qz c;
    private Long d;
    private String e;

    public C21679tx(AbstractC24063xz abstractC24063xz, EnumC21816uB enumC21816uB, C19811qz c19811qz, Long l, String str) {
        this.a = abstractC24063xz;
        this.b = enumC21816uB;
        this.c = c19811qz;
        this.d = l;
        this.e = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0.v(1) != null) {
            this.a = AbstractC24063xz.r(c19084pl0.d(1));
        }
        this.b = EnumC21816uB.p(c19084pl0.g(2));
        this.c = (C19811qz) c19084pl0.k(3, new C19811qz());
        this.d = Long.valueOf(c19084pl0.y(4));
        this.e = c19084pl0.A(5);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC10632bw
    public int s() {
        return 5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC24063xz abstractC24063xz = this.a;
        if (abstractC24063xz != null) {
            c19675ql0.b(1, abstractC24063xz.q());
        }
        EnumC21816uB enumC21816uB = this.b;
        if (enumC21816uB == null) {
            throw new IOException();
        }
        c19675ql0.f(2, enumC21816uB.j());
        C19811qz c19811qz = this.c;
        if (c19811qz == null) {
            throw new IOException();
        }
        c19675ql0.i(3, c19811qz);
        Long l = this.d;
        if (l != null) {
            c19675ql0.g(4, l.longValue());
        }
        String str = this.e;
        if (str != null) {
            c19675ql0.o(5, str);
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
        return "struct DeprecatedReceiptMessage{}";
    }

    public EnumC21816uB u() {
        return this.b;
    }

    public C19811qz w() {
        return this.c;
    }

    public C21679tx() {
    }
}
