package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class VT5 extends TP5 {
    private C25238zy a;
    private int b;
    private byte[] c;
    private C16856lz d;

    public static VT5 r(byte[] bArr) {
        return (VT5) AbstractC16720ll0.b(new VT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.v(3);
        this.d = (C16856lz) c19084pl0.z(4, new C16856lz());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.f(2, this.b);
        byte[] bArr = this.c;
        if (bArr != null) {
            c19675ql0.b(3, bArr);
        }
        C16856lz c16856lz = this.d;
        if (c16856lz != null) {
            c19675ql0.i(4, c16856lz);
        }
    }

    public String toString() {
        return "rpc LoadMembers{}";
    }
}
