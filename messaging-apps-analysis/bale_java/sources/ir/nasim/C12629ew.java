package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.ew, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12629ew extends AbstractC10632bw {
    private C10015aw a;
    private C10015aw b;
    private long c;
    private long d;
    private long e;
    private String f;
    private long g;
    private Integer h;

    public C12629ew(C10015aw c10015aw, C10015aw c10015aw2, long j, long j2, long j3, String str, long j4, Integer num) {
        this.a = c10015aw;
        this.b = c10015aw2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = j4;
        this.h = num;
    }

    public long C() {
        return this.c;
    }

    public C10015aw D() {
        return this.a;
    }

    public long E() {
        return this.e;
    }

    public long F() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C10015aw) c19084pl0.k(1, new C10015aw());
        this.b = (C10015aw) c19084pl0.k(2, new C10015aw());
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.A(6);
        this.g = c19084pl0.i(7);
        this.h = Integer.valueOf(c19084pl0.x(8));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC10632bw
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C10015aw c10015aw = this.a;
        if (c10015aw == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c10015aw);
        C10015aw c10015aw2 = this.b;
        if (c10015aw2 == null) {
            throw new IOException();
        }
        c19675ql0.i(2, c10015aw2);
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        c19675ql0.g(5, this.e);
        String str = this.f;
        if (str != null) {
            c19675ql0.o(6, str);
        }
        c19675ql0.g(7, this.g);
        Integer num = this.h;
        if (num != null) {
            c19675ql0.f(8, num.intValue());
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
        return "struct BankMoneyTransfer{}";
    }

    public Integer u() {
        return this.h;
    }

    public String w() {
        return this.f;
    }

    public C10015aw y() {
        return this.b;
    }

    public long z() {
        return this.g;
    }

    public C12629ew() {
    }
}
