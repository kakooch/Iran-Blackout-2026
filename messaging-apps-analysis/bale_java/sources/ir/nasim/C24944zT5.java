package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.zT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24944zT5 extends TP5 {
    private long a;
    private String b;
    private String c;
    private long d;
    private String e;

    public static C24944zT5 r(byte[] bArr) {
        return (C24944zT5) AbstractC16720ll0.b(new C24944zT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.r(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.INIT_SEFTE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        c19675ql0.g(4, this.d);
        String str3 = this.e;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str3);
    }

    public String toString() {
        return "rpc InitSefte{}";
    }
}
