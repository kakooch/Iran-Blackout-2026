package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ET5 extends TP5 {
    private C22993wA a;
    private List b;

    public static ET5 r(byte[] bArr) {
        return (ET5) AbstractC16720ll0.b(new ET5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = new ArrayList();
        Iterator it = c19084pl0.n(2).iterator();
        while (it.hasNext()) {
            this.b.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.JOIN_PUBLIC_GROUP_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.f(2, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc JoinPublicGroup{}";
    }
}
