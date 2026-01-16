package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class DS5 extends TP5 {
    private C22993wA a;
    private long b;
    private long c;
    private int d;
    private String e;

    public static DS5 r(byte[] bArr) {
        return (DS5) AbstractC16720ll0.b(new DS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.A(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.f(4, this.d);
        String str = this.e;
        if (str != null) {
            c19675ql0.o(5, str);
        }
    }

    public String toString() {
        return "rpc GetPayMoneyRequestToken{}";
    }
}
