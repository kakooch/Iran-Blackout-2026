package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.gW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13606gW5 extends TP5 {
    private String a;
    private String b;
    private Boolean c;
    private List d;

    public static C13606gW5 r(byte[] bArr) {
        return (C13606gW5) AbstractC16720ll0.b(new C13606gW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = Boolean.valueOf(c19084pl0.u(3));
        this.d = c19084pl0.q(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER;
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
        Boolean bool = this.c;
        if (bool != null) {
            c19675ql0.a(3, bool.booleanValue());
        }
        c19675ql0.n(4, this.d);
    }

    public String toString() {
        return "rpc ValidateCode{}";
    }
}
