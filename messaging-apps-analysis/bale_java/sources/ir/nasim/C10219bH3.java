package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.bH3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10219bH3 extends AbstractC19230q0 {
    private boolean a;
    private long b;
    private String c;
    private List d;
    private EnumC9567aB e;
    private C16885m18 f;

    public C10219bH3() {
        this.c = "";
        this.d = new ArrayList();
    }

    public final boolean C() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.b(2);
        this.b = c19084pl0.i(3);
        this.c = c19084pl0.r(4);
        this.d = c19084pl0.q(5);
        this.e = EnumC9567aB.p(c19084pl0.g(6));
        this.f = (C16885m18) c19084pl0.k(7, new C16885m18());
    }

    public final List s() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.a(2, this.a);
        c19675ql0.g(3, this.b);
        c19675ql0.o(4, this.c);
        c19675ql0.n(5, this.d);
        EnumC9567aB enumC9567aB = this.e;
        if (enumC9567aB == null) {
            enumC9567aB = EnumC9567aB.SINGLECHOICE;
        }
        c19675ql0.f(6, enumC9567aB.j());
        C16885m18 c16885m18 = this.f;
        if (c16885m18 != null) {
            c19675ql0.i(7, c16885m18);
        }
    }

    public final long u() {
        return this.b;
    }

    public final String w() {
        return this.c;
    }

    public final EnumC9567aB y() {
        return this.e;
    }

    public final C16885m18 z() {
        return this.f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C10219bH3(byte[] bArr) {
        this();
        AbstractC13042fc3.i(bArr, "data");
        load(bArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C10219bH3(boolean z, long j, String str, List list, EnumC9567aB enumC9567aB, C16885m18 c16885m18) {
        this();
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(list, "answers");
        this.a = z;
        this.b = j;
        this.c = str;
        this.d = list;
        this.e = enumC9567aB;
        this.f = c16885m18;
    }
}
