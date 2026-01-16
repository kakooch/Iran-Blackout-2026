package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class JT5 extends TP5 {
    private byte[] a;
    private int b;
    private List c;

    public static JT5 r(byte[] bArr) {
        return (JT5) AbstractC16720ll0.b(new JT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.v(1);
        this.b = c19084pl0.g(2);
        this.c = new ArrayList();
        Iterator it = c19084pl0.n(3).iterator();
        while (it.hasNext()) {
            this.c.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_ARCHIVED_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        byte[] bArr = this.a;
        if (bArr != null) {
            c19675ql0.b(1, bArr);
        }
        c19675ql0.f(2, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.f(3, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc LoadArchived{}";
    }
}
