package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.aQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9708aQ5 extends TP5 {
    private List a;

    public static C9708aQ5 r(byte[] bArr) {
        return (C9708aQ5) AbstractC16720ll0.b(new C9708aQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C22269ux());
        }
        this.a = c19084pl0.p(1, arrayList);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ADD_DESTINATION_CARDS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }

    public String toString() {
        return "rpc AddDestinationCards{}";
    }
}
