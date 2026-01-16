package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Fx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4617Fx extends AbstractC4383Ex {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private byte[] f;

    public C4617Fx(int i, String str, String str2, String str3, String str4, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = bArr;
    }

    public String C() {
        return this.d;
    }

    public String D() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.v(6);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC4383Ex
    public int s() {
        return 5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
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
        byte[] bArr = this.f;
        if (bArr != null) {
            c19675ql0.b(6, bArr);
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
        return "struct DocumentExAudio{}";
    }

    public String u() {
        return this.b;
    }

    public String w() {
        return this.c;
    }

    public byte[] y() {
        return this.f;
    }

    public int z() {
        return this.a;
    }

    public C4617Fx() {
    }
}
