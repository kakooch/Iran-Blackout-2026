package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.nX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17770nX5 extends AbstractC10365bX5 {
    private C4857Gw b;
    private List c;
    private int d;
    private DC e;
    private C19784qw f;

    public static C17770nX5 s(byte[] bArr) {
        return (C17770nX5) AbstractC16720ll0.b(new C17770nX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C4857Gw) c19084pl0.z(1, new C4857Gw());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C17557nA());
        }
        this.c = c19084pl0.p(2, arrayList);
        this.d = c19084pl0.g(3);
        this.e = (DC) c19084pl0.z(4, new DC());
        this.f = (C19784qw) c19084pl0.z(5, new C19784qw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4857Gw c4857Gw = this.b;
        if (c4857Gw != null) {
            c19675ql0.i(1, c4857Gw);
        }
        c19675ql0.m(2, this.c);
        c19675ql0.f(3, this.d);
        DC dc = this.e;
        if (dc != null) {
            c19675ql0.i(4, dc);
        }
        C19784qw c19784qw = this.f;
        if (c19784qw != null) {
            c19675ql0.i(5, c19784qw);
        }
    }

    public String toString() {
        return "response Call{}";
    }
}
