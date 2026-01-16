package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;

/* renamed from: ir.nasim.oU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18334oU5 extends TP5 {
    private List a;
    private String b;

    public static C18334oU5 r(byte[] bArr) {
        return (C18334oU5) AbstractC16720ll0.b(new C18334oU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.q(1);
        this.b = c19084pl0.A(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.n(1, this.a);
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
    }

    public String toString() {
        return "rpc NotifyAboutDeviceInfo{}";
    }
}
