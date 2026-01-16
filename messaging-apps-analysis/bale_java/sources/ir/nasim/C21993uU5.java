package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.uU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21993uU5 extends TP5 {
    private String a;
    private C4392Ey b;
    private Long c;
    private String d;

    public static C21993uU5 r(byte[] bArr) {
        return (C21993uU5) AbstractC16720ll0.b(new C21993uU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C4392Ey) c19084pl0.z(2, new C4392Ey());
        this.c = Long.valueOf(c19084pl0.y(3));
        this.d = c19084pl0.A(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C4392Ey c4392Ey = this.b;
        if (c4392Ey != null) {
            c19675ql0.i(2, c4392Ey);
        }
        Long l = this.c;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
    }

    public String toString() {
        return "rpc PayMoneyRequestByWallet{}";
    }
}
