package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.dW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11736dW5 extends TP5 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static C11736dW5 r(byte[] bArr) {
        return (C11736dW5) AbstractC16720ll0.b(new C11736dW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.A(2);
        this.c = c19084pl0.A(3);
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.r(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.UPGRADE_KIFPOOL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            c19675ql0.o(3, str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            c19675ql0.o(4, str4);
        }
        String str5 = this.e;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str5);
    }

    public String toString() {
        return "rpc UpgradeKifpool{}";
    }
}
