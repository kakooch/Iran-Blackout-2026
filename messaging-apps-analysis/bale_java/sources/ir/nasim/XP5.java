package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class XP5 extends TP5 {
    private String a;
    private Boolean b;

    public static XP5 r(byte[] bArr) {
        return (XP5) AbstractC16720ll0.b(new XP5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = Boolean.valueOf(c19084pl0.u(2));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ACTIVATE_WALLET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        Boolean bool = this.b;
        if (bool != null) {
            c19675ql0.a(2, bool.booleanValue());
        }
    }

    public String toString() {
        return "rpc ActivateWallet{}";
    }
}
