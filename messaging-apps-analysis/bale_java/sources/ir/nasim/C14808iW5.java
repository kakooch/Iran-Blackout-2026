package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.iW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14808iW5 extends TP5 {
    private String a;
    private String b;
    private String c;

    public static C14808iW5 r(byte[] bArr) {
        return (C14808iW5) AbstractC16720ll0.b(new C14808iW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.VERIFY_CASH_OUT_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        String str3 = this.c;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
    }

    public String toString() {
        return "rpc VerifyCashOut{}";
    }
}
