package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.kQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15934kQ5 extends TP5 {
    private List a;

    public static C15934kQ5 r(byte[] bArr) {
        return (C15934kQ5) AbstractC16720ll0.b(new C15934kQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C4392Ey());
        }
        this.a = c19084pl0.p(1, arrayList);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }

    public String toString() {
        return "rpc BindMoneyRequestDetailsList{}";
    }
}
