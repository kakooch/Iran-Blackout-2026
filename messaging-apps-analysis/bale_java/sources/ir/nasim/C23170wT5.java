package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.wT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23170wT5 extends TP5 {
    private C18766pD a;
    private String b;

    public static C23170wT5 r(byte[] bArr) {
        return (C23170wT5) AbstractC16720ll0.b(new C23170wT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C18766pD) c19084pl0.z(1, new C18766pD());
        this.b = c19084pl0.r(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GRANT_BANKI_ACCESS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C18766pD c18766pD = this.a;
        if (c18766pD != null) {
            c19675ql0.i(1, c18766pD);
        }
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "rpc GrantBankiAccess{}";
    }
}
