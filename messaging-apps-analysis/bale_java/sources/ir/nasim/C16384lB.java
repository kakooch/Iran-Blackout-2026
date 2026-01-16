package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.lB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16384lB extends AbstractC24063xz {
    private AbstractC24063xz a;
    private String b;
    private long c;
    private String d;
    private EnumC7264Qz e;
    private C7498Rz f;
    private C19811qz g;
    private String h;

    public C16384lB(AbstractC24063xz abstractC24063xz, String str, long j, String str2, EnumC7264Qz enumC7264Qz, C7498Rz c7498Rz, C19811qz c19811qz, String str3) {
        this.a = abstractC24063xz;
        this.b = str;
        this.c = j;
        this.d = str2;
        this.e = enumC7264Qz;
        this.f = c7498Rz;
        this.g = c19811qz;
        this.h = str3;
    }

    public String C() {
        return this.d;
    }

    public EnumC7264Qz D() {
        return this.e;
    }

    public String E() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = AbstractC24063xz.r(c19084pl0.d(1));
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.A(4);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.e = EnumC7264Qz.p(iH);
        }
        this.f = (C7498Rz) c19084pl0.z(6, new C7498Rz());
        this.g = (C19811qz) c19084pl0.z(7, new C19811qz());
        this.h = c19084pl0.A(8);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 15;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC24063xz abstractC24063xz = this.a;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(1, abstractC24063xz.q());
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.g(3, this.c);
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
        EnumC7264Qz enumC7264Qz = this.e;
        if (enumC7264Qz != null) {
            c19675ql0.f(5, enumC7264Qz.j());
        }
        C7498Rz c7498Rz = this.f;
        if (c7498Rz != null) {
            c19675ql0.i(6, c7498Rz);
        }
        C19811qz c19811qz = this.g;
        if (c19811qz != null) {
            c19675ql0.i(7, c19811qz);
        }
        String str3 = this.h;
        if (str3 != null) {
            c19675ql0.o(8, str3);
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
        return "struct PurchaseMessage{}";
    }

    public String u() {
        return this.b;
    }

    public C19811qz w() {
        return this.g;
    }

    public long y() {
        return this.c;
    }

    public AbstractC24063xz z() {
        return this.a;
    }

    public C16384lB() {
    }
}
