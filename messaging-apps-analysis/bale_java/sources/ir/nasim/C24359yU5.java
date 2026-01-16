package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.yU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24359yU5 extends TP5 {
    private int a;
    private C25238zy b;
    private long c;
    private long d;

    public static C24359yU5 r(byte[] bArr) {
        return (C24359yU5) AbstractC16720ll0.b(new C24359yU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = (C25238zy) c19084pl0.z(2, new C25238zy());
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PIN_MESSAGE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        C25238zy c25238zy = this.b;
        if (c25238zy != null) {
            c19675ql0.i(2, c25238zy);
        }
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
    }

    public String toString() {
        return "rpc PinMessage{}";
    }
}
