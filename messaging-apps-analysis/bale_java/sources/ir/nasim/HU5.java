package ir.nasim;

/* loaded from: classes4.dex */
public class HU5 extends TP5 {
    private Long a;

    public static HU5 r(byte[] bArr) {
        return (HU5) AbstractC16720ll0.b(new HU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Long.valueOf(c19084pl0.y(1));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 91;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Long l = this.a;
        if (l != null) {
            c19675ql0.g(1, l.longValue());
        }
    }

    public String toString() {
        return "rpc RemoveAvatar{}";
    }
}
