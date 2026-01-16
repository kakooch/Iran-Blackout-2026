package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class YT5 extends TP5 {
    private C17557nA a;
    private List b;
    private boolean c;

    public static YT5 r(byte[] bArr) {
        return (YT5) AbstractC16720ll0.b(new YT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C3460Az());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.b(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_REACTIONS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.m(2, this.b);
        c19675ql0.a(3, this.c);
    }

    public String toString() {
        return "rpc LoadReactions{}";
    }
}
