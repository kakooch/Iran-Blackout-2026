package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class OS5 extends TP5 {
    private int a;
    private List b;

    public static OS5 r(byte[] bArr) {
        return (OS5) AbstractC16720ll0.b(new OS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = new ArrayList();
        Iterator it = c19084pl0.n(2).iterator();
        while (it.hasNext()) {
            this.b.add(EnumC16375lA.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_RECENT_ORDERS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.f(2, ((EnumC16375lA) it.next()).j());
        }
    }

    public String toString() {
        return "rpc GetRecentOrders{}";
    }
}
