package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class FV5 extends TP5 {
    private long a;
    private int b;
    private String c;
    private byte[] d;
    private String e;
    private String f;
    private List g;
    private AbstractC17566nB h;
    private EnumC6251Mv i;
    private List j;

    public static FV5 r(byte[] bArr) {
        return (FV5) AbstractC16720ll0.b(new FV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.d(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.A(6);
        this.g = c19084pl0.q(7);
        if (c19084pl0.v(8) != null) {
            this.h = AbstractC17566nB.r(c19084pl0.d(8));
        }
        int iH = c19084pl0.h(9, 0);
        if (iH != 0) {
            this.i = EnumC6251Mv.p(iH);
        }
        this.j = new ArrayList();
        Iterator it = c19084pl0.n(10).iterator();
        while (it.hasNext()) {
            this.j.add(EC.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        byte[] bArr = this.d;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(4, bArr);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        String str3 = this.f;
        if (str3 != null) {
            c19675ql0.o(6, str3);
        }
        c19675ql0.n(7, this.g);
        AbstractC17566nB abstractC17566nB = this.h;
        if (abstractC17566nB != null) {
            c19675ql0.b(8, abstractC17566nB.q());
        }
        EnumC6251Mv enumC6251Mv = this.i;
        if (enumC6251Mv != null) {
            c19675ql0.f(9, enumC6251Mv.j());
        }
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            c19675ql0.f(10, ((EC) it.next()).j());
        }
    }

    public String toString() {
        return "rpc StartPhoneAuth{}";
    }
}
