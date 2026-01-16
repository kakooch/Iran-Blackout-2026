package ir.nasim;

/* renamed from: ir.nasim.oY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18370oY5 extends AbstractC10365bX5 {
    private DA b;

    public static C18370oY5 s(byte[] bArr) {
        return (C18370oY5) AbstractC16720ll0.b(new C18370oY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (DA) c19084pl0.z(1, new DA());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        DA da = this.b;
        if (da != null) {
            c19675ql0.i(1, da);
        }
    }

    public String toString() {
        return "response GetMemberPermissions{}";
    }
}
