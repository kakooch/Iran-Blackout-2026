package ir.nasim;

/* renamed from: ir.nasim.hT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14170hT5 extends TP5 {
    private int a;

    public C14170hT5(int i) {
        this.a = i;
    }

    public static C14170hT5 r(byte[] bArr) {
        return (C14170hT5) AbstractC16720ll0.b(new C14170hT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 137;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "rpc GetUserContext{}";
    }

    public C14170hT5() {
    }
}
