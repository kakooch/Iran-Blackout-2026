package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.mS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17134mS5 extends TP5 {
    private EnumC18029ny a;
    private boolean b;
    private List c;

    public static C17134mS5 r(byte[] bArr) {
        return (C17134mS5) AbstractC16720ll0.b(new C17134mS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18029ny.p(iH);
        }
        this.b = c19084pl0.b(2);
        this.c = new ArrayList();
        Iterator it = c19084pl0.l(3).iterator();
        while (it.hasNext()) {
            this.c.add(AbstractC18620oy.r((byte[]) it.next()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_MY_GROUPS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC18029ny enumC18029ny = this.a;
        if (enumC18029ny != null) {
            c19675ql0.f(1, enumC18029ny.j());
        }
        c19675ql0.a(2, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.b(3, ((AbstractC18620oy) it.next()).q());
        }
    }

    public String toString() {
        return "rpc GetMyGroups{}";
    }
}
