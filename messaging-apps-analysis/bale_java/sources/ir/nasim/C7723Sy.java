package ir.nasim;

/* renamed from: ir.nasim.Sy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7723Sy extends AbstractC17902nl0 {
    private String a;
    private C7489Ry b;

    public C7723Sy(String str, C7489Ry c7489Ry) {
        this.a = str;
        this.b = c7489Ry;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        this.b = (C7489Ry) c19084pl0.z(2, new C7489Ry());
    }

    public C7489Ry q() {
        return this.b;
    }

    public String r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        C7489Ry c7489Ry = this.b;
        if (c7489Ry != null) {
            c19675ql0.i(2, c7489Ry);
        }
    }

    public String toString() {
        return "struct IntroMessage{}";
    }

    public C7723Sy() {
    }
}
