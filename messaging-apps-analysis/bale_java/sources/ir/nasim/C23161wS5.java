package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.wS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23161wS5 extends TP5 {
    private C22993wA a;
    private long b;
    private long c;
    private Integer d;
    private String e;

    public static C23161wS5 r(byte[] bArr) {
        return (C23161wS5) AbstractC16720ll0.b(new C23161wS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = Integer.valueOf(c19084pl0.x(4));
        this.e = c19084pl0.r(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_OTP_TOKEN_V2_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        Integer num = this.d;
        if (num != null) {
            c19675ql0.f(4, num.intValue());
        }
        String str = this.e;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str);
    }

    public String toString() {
        return "rpc GetOTPTokenV2{}";
    }
}
