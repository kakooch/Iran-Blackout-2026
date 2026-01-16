package ir.nasim;

/* renamed from: ir.nasim.vV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22592vV5 extends TP5 {
    private boolean a;
    private long b;
    private EnumC22865vx c;
    private String d;

    public static C22592vV5 r(byte[] bArr) {
        return (C22592vV5) AbstractC16720ll0.b(new C22592vV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
        this.b = c19084pl0.i(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC22865vx.p(iH);
        }
        this.d = c19084pl0.A(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 29;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
        c19675ql0.g(2, this.b);
        EnumC22865vx enumC22865vx = this.c;
        if (enumC22865vx != null) {
            c19675ql0.f(3, enumC22865vx.j());
        }
        String str = this.d;
        if (str != null) {
            c19675ql0.o(4, str);
        }
    }

    public String toString() {
        return "rpc SetOnline{}";
    }
}
