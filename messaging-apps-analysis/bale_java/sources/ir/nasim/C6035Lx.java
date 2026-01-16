package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Lx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6035Lx extends AbstractC24063xz {
    private long a;
    private long b;
    private int c;
    private String d;
    private String e;
    private C11413cy f;
    private AbstractC4383Ex g;
    private ZC h;
    private String i;
    private String j;
    private Integer k;
    private Long l;
    private C5118Hz m;

    public C6035Lx(long j, long j2, int i, String str, String str2, C11413cy c11413cy, AbstractC4383Ex abstractC4383Ex, ZC zc, String str3, String str4, Integer num, Long l, C5118Hz c5118Hz) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = str;
        this.e = str2;
        this.f = c11413cy;
        this.g = abstractC4383Ex;
        this.h = zc;
        this.i = str3;
        this.j = str4;
        this.k = num;
        this.l = l;
        this.m = c5118Hz;
    }

    public C11413cy C() {
        return this.f;
    }

    public long getAccessHash() {
        return this.b;
    }

    public long getFileId() {
        return this.a;
    }

    public int getFileSize() {
        return this.c;
    }

    public Integer getFileStorageVersion() {
        return this.k;
    }

    public String getName() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = (C11413cy) c19084pl0.z(6, new C11413cy());
        if (c19084pl0.v(8) != null) {
            this.g = AbstractC4383Ex.r(c19084pl0.d(8));
        }
        this.h = (ZC) c19084pl0.z(9, new ZC());
        this.i = c19084pl0.A(10);
        this.j = c19084pl0.A(11);
        this.k = Integer.valueOf(c19084pl0.x(12));
        this.l = Long.valueOf(c19084pl0.y(13));
        this.m = (C5118Hz) c19084pl0.z(14, new C5118Hz());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.f(3, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        C11413cy c11413cy = this.f;
        if (c11413cy != null) {
            c19675ql0.i(6, c11413cy);
        }
        AbstractC4383Ex abstractC4383Ex = this.g;
        if (abstractC4383Ex != null) {
            c19675ql0.b(8, abstractC4383Ex.q());
        }
        ZC zc = this.h;
        if (zc != null) {
            c19675ql0.i(9, zc);
        }
        String str3 = this.i;
        if (str3 != null) {
            c19675ql0.o(10, str3);
        }
        String str4 = this.j;
        if (str4 != null) {
            c19675ql0.o(11, str4);
        }
        Integer num = this.k;
        if (num != null) {
            c19675ql0.f(12, num.intValue());
        }
        Long l = this.l;
        if (l != null) {
            c19675ql0.g(13, l.longValue());
        }
        C5118Hz c5118Hz = this.m;
        if (c5118Hz != null) {
            c19675ql0.i(14, c5118Hz);
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
        return "struct DocumentMessage{}";
    }

    public ZC u() {
        return this.h;
    }

    public AbstractC4383Ex w() {
        return this.g;
    }

    public C5118Hz y() {
        return this.m;
    }

    public String z() {
        return this.e;
    }

    public C6035Lx() {
    }
}
