package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.fV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12979fV5 extends TP5 {
    private List a;
    private List b;

    public static C12979fV5 r(byte[] bArr) {
        return (C12979fV5) AbstractC16720ll0.b(new C12979fV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = new ArrayList();
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            this.a.add(HB.r((byte[]) it.next()));
        }
        this.b = new ArrayList();
        Iterator it2 = c19084pl0.n(2).iterator();
        while (it2.hasNext()) {
            this.b.add(EnumC15220jD.p(((Integer) it2.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.b(1, ((HB) it.next()).q());
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            c19675ql0.f(2, ((EnumC15220jD) it2.next()).j());
        }
    }

    public String toString() {
        return "rpc SearchPeer{}";
    }
}
