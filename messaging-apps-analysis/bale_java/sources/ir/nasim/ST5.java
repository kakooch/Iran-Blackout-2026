package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ST5 extends TP5 {
    private C17557nA a;
    private long b;
    private EnumC15083iz c;
    private int d;
    private List e;

    public ST5(C17557nA c17557nA, long j, EnumC15083iz enumC15083iz, int i, List list) {
        this.a = c17557nA;
        this.b = j;
        this.c = enumC15083iz;
        this.d = i;
        this.e = list;
    }

    public static ST5 r(byte[] bArr) {
        return (ST5) AbstractC16720ll0.b(new ST5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
        this.b = c19084pl0.i(3);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.c = EnumC15083iz.p(iH);
        }
        this.d = c19084pl0.g(4);
        this.e = new ArrayList();
        Iterator it = c19084pl0.n(6).iterator();
        while (it.hasNext()) {
            this.e.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
        c19675ql0.g(3, this.b);
        EnumC15083iz enumC15083iz = this.c;
        if (enumC15083iz != null) {
            c19675ql0.f(5, enumC15083iz.j());
        }
        c19675ql0.f(4, this.d);
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            c19675ql0.f(6, ((EnumC15220jD) it.next()).j());
        }
    }

    public String toString() {
        return "rpc LoadHistory{}";
    }

    public ST5() {
    }
}
