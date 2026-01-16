package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Xu, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8894Xu extends AbstractC19230q0 {
    private int a;
    private String b;
    private long c;
    private long d;
    private long e;
    private List f;
    private String g;
    private Boolean h;

    public C8894Xu() {
        this.b = "";
        this.f = new ArrayList();
        this.h = Boolean.TRUE;
    }

    public final long C() {
        return this.d;
    }

    public final long D() {
        return this.e;
    }

    public final Boolean E() {
        return this.h;
    }

    public final void F(Boolean bool) {
        this.h = bool;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.o(6);
        this.g = c19084pl0.r(7);
        this.h = Boolean.valueOf(c19084pl0.b(8));
    }

    public final List s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.f(1, this.a);
        c19675ql0.o(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        c19675ql0.g(5, this.e);
        List list = this.f;
        if (list != null) {
            c19675ql0.l(6, list);
        }
        String str = this.g;
        if (str == null) {
            str = "";
        }
        c19675ql0.o(7, str);
        Boolean bool = this.h;
        if (bool != null) {
            c19675ql0.a(8, bool.booleanValue());
        }
    }

    public final int u() {
        return this.a;
    }

    public final String w() {
        return this.b;
    }

    public final String y() {
        return this.g;
    }

    public final long z() {
        return this.c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C8894Xu(int i, List list, String str, long j, long j2, long j3, String str2, Boolean bool) {
        this();
        AbstractC13042fc3.i(str, "countryNumber");
        this.b = str;
        this.g = str2;
        this.e = j3;
        this.d = j2;
        this.c = j;
        this.f = list;
        this.a = i;
        this.h = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C8894Xu(byte[] bArr) {
        this();
        AbstractC13042fc3.i(bArr, "data");
        load(bArr);
    }
}
