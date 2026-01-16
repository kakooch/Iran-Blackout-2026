package ir.nasim;

import java.util.List;

/* loaded from: classes4.dex */
public class RX5 extends AbstractC10365bX5 {
    private List b;
    private boolean c;

    public static RX5 s(byte[] bArr) {
        return (RX5) AbstractC16720ll0.b(new RX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.o(1);
        this.c = c19084pl0.b(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.l(1, this.b);
        c19675ql0.a(2, this.c);
    }

    public String toString() {
        return "response GetChargeAmounts{}";
    }
}
