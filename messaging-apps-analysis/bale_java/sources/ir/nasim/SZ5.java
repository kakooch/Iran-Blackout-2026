package ir.nasim;

/* loaded from: classes4.dex */
public class SZ5 extends AbstractC10365bX5 {
    private C7462Rv b;

    public static SZ5 s(byte[] bArr) {
        return (SZ5) AbstractC16720ll0.b(new SZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C7462Rv) c19084pl0.z(1, new C7462Rv());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C7462Rv c7462Rv = this.b;
        if (c7462Rv != null) {
            c19675ql0.i(1, c7462Rv);
        }
    }

    public String toString() {
        return "response LoadGroupAvatars{}";
    }
}
