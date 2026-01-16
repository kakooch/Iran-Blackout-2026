package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.mV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17161mV5 extends TP5 {
    private C16966mA a;
    private List b;
    private C3933Cz c;
    private long d;

    public C17161mV5(C16966mA c16966mA, List list, C3933Cz c3933Cz, long j) {
        this.a = c16966mA;
        this.b = list;
        this.c = c3933Cz;
        this.d = j;
    }

    public static C17161mV5 r(byte[] bArr) {
        return (C17161mV5) AbstractC16720ll0.b(new C17161mV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C16966mA) c19084pl0.z(1, new C16966mA());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new CC());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = (C3933Cz) c19084pl0.z(3, new C3933Cz());
        this.d = c19084pl0.i(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C16966mA c16966mA = this.a;
        if (c16966mA != null) {
            c19675ql0.i(1, c16966mA);
        }
        c19675ql0.m(2, this.b);
        C3933Cz c3933Cz = this.c;
        if (c3933Cz != null) {
            c19675ql0.i(3, c3933Cz);
        }
        c19675ql0.g(4, this.d);
    }

    public String toString() {
        return "rpc SendMultiMediaMessage{}";
    }

    public C17161mV5() {
    }
}
