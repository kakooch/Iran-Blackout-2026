package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.eQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12325eQ5 extends TP5 {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;

    public static C12325eQ5 r(byte[] bArr) {
        return (C12325eQ5) AbstractC16720ll0.b(new C12325eQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ADD_RECIPIENT_FIELD_NUMBER;
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
        c19675ql0.a(4, this.d);
        String str4 = this.e;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str4);
        String str5 = this.f;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str5);
        String str6 = this.g;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str6);
        String str7 = this.h;
        if (str7 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str7);
    }

    public String toString() {
        return "rpc AddRecipient{}";
    }
}
