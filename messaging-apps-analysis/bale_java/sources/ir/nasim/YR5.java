package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class YR5 extends TP5 {
    private List a;
    private List b;

    public static YR5 r(byte[] bArr) {
        return (YR5) AbstractC16720ll0.b(new YR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C25238zy());
        }
        this.a = c19084pl0.p(1, arrayList);
        this.b = new ArrayList();
        Iterator it = c19084pl0.n(2).iterator();
        while (it.hasNext()) {
            this.b.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.f(2, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc GetGroupState{}";
    }
}
