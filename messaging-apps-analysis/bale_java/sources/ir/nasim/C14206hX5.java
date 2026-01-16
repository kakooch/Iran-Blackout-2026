package ir.nasim;

/* renamed from: ir.nasim.hX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14206hX5 extends AbstractC10365bX5 {
    private boolean b;

    public static C14206hX5 s(byte[] bArr) {
        return (C14206hX5) AbstractC16720ll0.b(new C14206hX5(), bArr);
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
        return "response Bool{}";
    }
}
