package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.cW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10972cW5 extends TP5 {
    private String a;
    private int b;
    private C25238zy c;

    public static C10972cW5 r(byte[] bArr) {
        return (C10972cW5) AbstractC16720ll0.b(new C10972cW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = (C25238zy) c19084pl0.z(3, new C25238zy());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.UPDATE_VIEW_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        C25238zy c25238zy = this.c;
        if (c25238zy != null) {
            c19675ql0.i(3, c25238zy);
        }
    }

    public String toString() {
        return "rpc UpdateView{}";
    }
}
