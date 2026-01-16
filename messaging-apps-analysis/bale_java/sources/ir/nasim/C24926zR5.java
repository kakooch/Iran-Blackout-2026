package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.zR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24926zR5 extends TP5 {
    private String a;
    private C6026Lw b;
    private OC c;

    public static C24926zR5 r(byte[] bArr) {
        return (C24926zR5) AbstractC16720ll0.b(new C24926zR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C6026Lw) c19084pl0.z(2, new C6026Lw());
        this.c = (OC) c19084pl0.z(3, new OC());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CARD_INFO_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C6026Lw c6026Lw = this.b;
        if (c6026Lw != null) {
            c19675ql0.i(2, c6026Lw);
        }
        OC oc = this.c;
        if (oc != null) {
            c19675ql0.i(3, oc);
        }
    }

    public String toString() {
        return "rpc GetCardInfo{}";
    }
}
