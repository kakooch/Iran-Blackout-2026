package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10963cV5 extends TP5 {
    private HB a;
    private Long b;
    private List c;
    private EnumC15083iz d;

    public static C10963cV5 r(byte[] bArr) {
        return (C10963cV5) AbstractC16720ll0.b(new C10963cV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0.v(1) != null) {
            this.a = HB.r(c19084pl0.d(1));
        }
        this.b = Long.valueOf(c19084pl0.y(2));
        this.c = new ArrayList();
        Iterator it = c19084pl0.n(3).iterator();
        while (it.hasNext()) {
            this.c.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC15083iz.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEARCH_MEDIA_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        HB hb = this.a;
        if (hb != null) {
            c19675ql0.b(1, hb.q());
        }
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.f(3, ((EnumC15220jD) it.next()).j());
        }
        EnumC15083iz enumC15083iz = this.d;
        if (enumC15083iz != null) {
            c19675ql0.f(4, enumC15083iz.j());
        }
    }

    public String toString() {
        return "rpc SearchMedia{}";
    }
}
