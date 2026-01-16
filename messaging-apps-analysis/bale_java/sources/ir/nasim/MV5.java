package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MV5 extends TP5 {
    private List a;

    public static MV5 r(byte[] bArr) {
        return (MV5) AbstractC16720ll0.b(new MV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C18766pD());
        }
        this.a = c19084pl0.p(1, arrayList);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 32;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }

    public String toString() {
        return "rpc SubscribeToOnline{}";
    }
}
