package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.dU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11718dU5 extends TP5 {
    private C25238zy a;
    private C18766pD b;
    private String c;

    public static C11718dU5 r(byte[] bArr) {
        return (C11718dU5) AbstractC16720ll0.b(new C11718dU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = (C18766pD) c19084pl0.z(2, new C18766pD());
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.MAKE_USER_ADMIN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        C18766pD c18766pD = this.b;
        if (c18766pD != null) {
            c19675ql0.i(2, c18766pD);
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc MakeUserAdmin{}";
    }
}
