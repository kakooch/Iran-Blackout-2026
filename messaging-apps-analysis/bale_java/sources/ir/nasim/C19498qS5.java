package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.qS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19498qS5 extends TP5 {
    private C22993wA a;
    private C12056dy b;
    private String c;

    public static C19498qS5 r(byte[] bArr) {
        return (C19498qS5) AbstractC16720ll0.b(new C19498qS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = (C12056dy) c19084pl0.z(2, new C12056dy());
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        C12056dy c12056dy = this.b;
        if (c12056dy != null) {
            c19675ql0.i(2, c12056dy);
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc GetNasimFilePublicUrl{}";
    }
}
