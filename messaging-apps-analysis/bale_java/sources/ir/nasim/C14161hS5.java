package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.hS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14161hS5 extends TP5 {
    private C8421Vx a;
    private List b;

    public static C14161hS5 r(byte[] bArr) {
        return (C14161hS5) AbstractC16720ll0.b(new C14161hS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C8421Vx) c19084pl0.z(1, new C8421Vx());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C3460Az());
        }
        this.b = c19084pl0.p(2, arrayList);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C8421Vx c8421Vx = this.a;
        if (c8421Vx != null) {
            c19675ql0.i(1, c8421Vx);
        }
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "rpc GetMessagesRepliesInfo{}";
    }
}
