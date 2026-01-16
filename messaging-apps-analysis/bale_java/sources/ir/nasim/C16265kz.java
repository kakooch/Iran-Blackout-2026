package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16265kz extends AbstractC24063xz {
    private String a;
    private int b;
    private boolean c;
    private C6035Lx d;
    private long e;

    public C16265kz(String str, int i, boolean z, C6035Lx c6035Lx, long j) {
        this.a = str;
        this.b = i;
        this.c = z;
        this.d = c6035Lx;
        this.e = j;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.b(3);
        this.d = (C6035Lx) c19084pl0.z(4, new C6035Lx());
        this.e = c19084pl0.i(5);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 26;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        c19675ql0.a(3, this.c);
        C6035Lx c6035Lx = this.d;
        if (c6035Lx != null) {
            c19675ql0.i(4, c6035Lx);
        }
        c19675ql0.g(5, this.e);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct LiveMessage{}";
    }

    public long u() {
        return this.e;
    }

    public C6035Lx w() {
        return this.d;
    }

    public int y() {
        return this.b;
    }

    public boolean z() {
        return this.c;
    }

    public C16265kz() {
    }
}
