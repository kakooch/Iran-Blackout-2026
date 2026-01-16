package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.aU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9744aU5 extends TP5 {
    private long a;
    private Long b;
    private Long c;
    private MA d;
    private List e;
    private int f;
    private OC g;
    private EnumC15083iz h;
    private OA i;

    public static C9744aU5 r(byte[] bArr) {
        return (C9744aU5) AbstractC16720ll0.b(new C9744aU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = Long.valueOf(c19084pl0.y(2));
        this.c = Long.valueOf(c19084pl0.y(3));
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = MA.p(iH);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new LA());
        }
        this.e = c19084pl0.p(5, arrayList);
        this.f = c19084pl0.g(6);
        this.g = (OC) c19084pl0.z(7, new OC());
        int iH2 = c19084pl0.h(8, 0);
        if (iH2 != 0) {
            this.h = EnumC15083iz.p(iH2);
        }
        int iH3 = c19084pl0.h(9, 0);
        if (iH3 != 0) {
            this.i = OA.p(iH3);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_TRANSACTIONS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
        Long l2 = this.c;
        if (l2 != null) {
            c19675ql0.g(3, l2.longValue());
        }
        MA ma = this.d;
        if (ma != null) {
            c19675ql0.f(4, ma.j());
        }
        c19675ql0.m(5, this.e);
        c19675ql0.f(6, this.f);
        OC oc = this.g;
        if (oc != null) {
            c19675ql0.i(7, oc);
        }
        EnumC15083iz enumC15083iz = this.h;
        if (enumC15083iz != null) {
            c19675ql0.f(8, enumC15083iz.j());
        }
        OA oa = this.i;
        if (oa != null) {
            c19675ql0.f(9, oa.j());
        }
    }

    public String toString() {
        return "rpc LoadTransactions{}";
    }
}
