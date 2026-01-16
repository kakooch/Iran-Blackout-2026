package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.cQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10918cQ5 extends TP5 {
    private C12056dy a;
    private byte[] b;
    private OC c;

    public static C10918cQ5 r(byte[] bArr) {
        return (C10918cQ5) AbstractC16720ll0.b(new C10918cQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C12056dy) c19084pl0.z(1, new C12056dy());
        this.b = c19084pl0.d(2);
        this.c = (OC) c19084pl0.z(3, new OC());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ADD_GIF_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C12056dy c12056dy = this.a;
        if (c12056dy != null) {
            c19675ql0.i(1, c12056dy);
        }
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        OC oc = this.c;
        if (oc != null) {
            c19675ql0.i(3, oc);
        }
    }

    public String toString() {
        return "rpc AddGif{}";
    }
}
