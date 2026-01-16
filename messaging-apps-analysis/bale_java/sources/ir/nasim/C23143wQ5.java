package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.wQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23143wQ5 extends TP5 {
    private String a;
    private EnumC24635yx b;
    private long c;
    private String d;

    public static C23143wQ5 r(byte[] bArr) {
        return (C23143wQ5) AbstractC16720ll0.b(new C23143wQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC24635yx.p(iH);
        }
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.A(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        EnumC24635yx enumC24635yx = this.b;
        if (enumC24635yx != null) {
            c19675ql0.f(2, enumC24635yx.j());
        }
        c19675ql0.g(3, this.c);
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
    }

    public String toString() {
        return "rpc ChangeStatusDialogAdOrder{}";
    }
}
