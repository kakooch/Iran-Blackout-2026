package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.pV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18934pV5 extends TP5 {
    private String a;
    private C19811qz b;
    private long c;

    public static C18934pV5 r(byte[] bArr) {
        return (C18934pV5) AbstractC16720ll0.b(new C18934pV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C19811qz) c19084pl0.z(2, new C19811qz());
        this.c = c19084pl0.i(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEND_SERAJ_EVENT_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C19811qz c19811qz = this.b;
        if (c19811qz != null) {
            c19675ql0.i(2, c19811qz);
        }
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "rpc SendSerajEvent{}";
    }
}
