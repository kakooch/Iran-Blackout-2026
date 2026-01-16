package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.dX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11745dX5 extends AbstractC10365bX5 {
    private List b;

    public static C11745dX5 s(byte[] bArr) {
        return (C11745dX5) AbstractC16720ll0.b(new C11745dX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.q(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.n(1, this.b);
    }

    public String toString() {
        return "response AddDestinationCards{}";
    }
}
