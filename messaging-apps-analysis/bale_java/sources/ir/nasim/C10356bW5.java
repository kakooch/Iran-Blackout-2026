package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.bW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10356bW5 extends TP5 {
    private C17557nA a;
    private long b;
    private AbstractC24063xz c;

    public C10356bW5(C17557nA c17557nA, long j, AbstractC24063xz abstractC24063xz) {
        this.a = c17557nA;
        this.b = j;
        this.c = abstractC24063xz;
    }

    public static C10356bW5 r(byte[] bArr) {
        return (C10356bW5) AbstractC16720ll0.b(new C10356bW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        this.b = c19084pl0.i(2);
        if (c19084pl0.v(3) != null) {
            this.c = AbstractC24063xz.r(c19084pl0.d(3));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.UPDATE_MESSAGE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.g(2, this.b);
        AbstractC24063xz abstractC24063xz = this.c;
        if (abstractC24063xz != null) {
            c19675ql0.b(3, abstractC24063xz.q());
        }
    }

    public String toString() {
        return "rpc UpdateMessage{}";
    }

    public C10356bW5() {
    }
}
