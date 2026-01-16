package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;

/* renamed from: ir.nasim.pT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18916pT5 extends TP5 {
    private List a;

    public static C18916pT5 r(byte[] bArr) {
        return (C18916pT5) AbstractC16720ll0.b(new C18916pT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.n(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_USERS_PRESENCE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.k(1, this.a);
    }

    public String toString() {
        return "rpc GetUsersPresence{}";
    }
}
