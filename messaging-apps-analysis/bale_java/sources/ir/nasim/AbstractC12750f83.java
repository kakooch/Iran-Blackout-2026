package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.f83, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12750f83 {
    protected InterfaceC20714sU3 a;
    protected TA4 b;
    protected String c;
    protected int d;

    protected void a(C6652Ok0 c6652Ok0) {
        this.a.k(c6652Ok0);
    }

    protected C6652Ok0 b() {
        return this.a.q();
    }

    protected PH1 c() {
        return this.a.m();
    }

    protected String d(Pattern pattern) {
        this.a.setIndex(this.d);
        String strC = this.a.c(pattern);
        this.d = this.a.n();
        return strC;
    }

    protected abstract TA4 e();

    public TA4 f(InterfaceC20714sU3 interfaceC20714sU3) {
        this.a = interfaceC20714sU3;
        this.b = interfaceC20714sU3.g();
        this.c = interfaceC20714sU3.h();
        this.d = interfaceC20714sU3.n();
        TA4 ta4E = e();
        interfaceC20714sU3.setIndex(this.d);
        return ta4E;
    }

    protected String g() {
        this.a.setIndex(this.d);
        String strE = this.a.e();
        this.d = this.a.n();
        return strE;
    }

    protected int h() {
        this.a.setIndex(this.d);
        int iL = this.a.l();
        this.d = this.a.n();
        return iL;
    }

    protected String i() {
        this.a.setIndex(this.d);
        String strB = this.a.b();
        this.d = this.a.n();
        return strB;
    }

    protected char j() {
        this.a.setIndex(this.d);
        return this.a.peek();
    }

    protected void k(PH1 ph1) {
        this.a.setIndex(this.d);
        this.a.f(ph1);
        this.d = this.a.n();
    }

    protected void l() {
        this.a.o();
    }

    public abstract char m();

    protected void n() {
        this.a.setIndex(this.d);
        this.a.d();
        this.d = this.a.n();
    }

    protected C5693Kk7 o(String str) {
        return this.a.j(str);
    }

    protected C5693Kk7 p(String str, int i, int i2) {
        return this.a.p(str, i, i2);
    }
}
