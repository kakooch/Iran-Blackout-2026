package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class DQ5 extends TP5 {
    private long a;
    private String b;
    private List c;
    private EnumC3690By d;
    private List e;
    private String f;
    private BB g;

    public static DQ5 r(byte[] bArr) {
        return (DQ5) AbstractC16720ll0.b(new DQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new C18766pD());
        }
        this.c = c19084pl0.p(3, arrayList);
        int iH = c19084pl0.h(6, 0);
        if (iH != 0) {
            this.d = EnumC3690By.p(iH);
        }
        this.e = new ArrayList();
        Iterator it = c19084pl0.n(7).iterator();
        while (it.hasNext()) {
            this.e.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        this.f = c19084pl0.A(8);
        int iH2 = c19084pl0.h(9, 0);
        if (iH2 != 0) {
            this.g = BB.p(iH2);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.m(3, this.c);
        EnumC3690By enumC3690By = this.d;
        if (enumC3690By != null) {
            c19675ql0.f(6, enumC3690By.j());
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            c19675ql0.f(7, ((EnumC15220jD) it.next()).j());
        }
        String str2 = this.f;
        if (str2 != null) {
            c19675ql0.o(8, str2);
        }
        BB bb = this.g;
        if (bb != null) {
            c19675ql0.f(9, bb.j());
        }
    }

    public String toString() {
        return "rpc CreateGroup{}";
    }
}
