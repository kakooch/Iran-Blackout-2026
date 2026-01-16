package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.jR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15352jR5 extends TP5 {
    private EnumC24781zC a;

    public static C15352jR5 r(byte[] bArr) {
        return (C15352jR5) AbstractC16720ll0.b(new C15352jR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC24781zC.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.EDIT_SEX_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC24781zC enumC24781zC = this.a;
        if (enumC24781zC != null) {
            c19675ql0.f(1, enumC24781zC.j());
        }
    }

    public String toString() {
        return "rpc EditSex{}";
    }
}
