package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Ow, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6759Ow extends AbstractC14591iA {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC14591iA
    public int s() {
        return 168;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        c19675ql0.f(3, this.c);
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str3);
        String str4 = this.e;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str4);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ChargeOrderMessage{}";
    }

    public int u() {
        return this.c;
    }

    public String w() {
        return this.e;
    }

    public String y() {
        return this.b;
    }

    public String z() {
        return this.a;
    }
}
