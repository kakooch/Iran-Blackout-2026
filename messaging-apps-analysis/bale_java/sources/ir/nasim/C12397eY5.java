package ir.nasim;

/* renamed from: ir.nasim.eY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12397eY5 extends AbstractC10365bX5 {
    private int b;

    public static C12397eY5 s(byte[] bArr) {
        return (C12397eY5) AbstractC16720ll0.b(new C12397eY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.b);
    }

    public String toString() {
        return "response GetGroupMembersCount{}";
    }
}
