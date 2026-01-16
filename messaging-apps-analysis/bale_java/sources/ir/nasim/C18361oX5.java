package ir.nasim;

/* renamed from: ir.nasim.oX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18361oX5 extends AbstractC10365bX5 {
    private boolean b;

    public static C18361oX5 s(byte[] bArr) {
        return (C18361oX5) AbstractC16720ll0.b(new C18361oX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.b(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.b);
    }

    public String toString() {
        return "response CanSeeMessages{}";
    }
}
