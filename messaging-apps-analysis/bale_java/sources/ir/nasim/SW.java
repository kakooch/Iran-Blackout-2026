package ir.nasim;

/* loaded from: classes5.dex */
public class SW extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    private EnumC17422mw1 a;
    private long b;

    public SW() {
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return this.a.p();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = EnumC17422mw1.j(c19084pl0.g(1));
        this.b = c19084pl0.i(2);
    }

    public long q() {
        return this.b;
    }

    public EnumC17422mw1 r() {
        return this.a;
    }

    public SW s(long j) {
        return new SW(this.a, Long.valueOf(j));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a.p());
        c19675ql0.g(2, this.b);
    }

    public SW(EnumC17422mw1 enumC17422mw1, Long l) {
        this.b = l.longValue();
        this.a = enumC17422mw1;
    }
}
