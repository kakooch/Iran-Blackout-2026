package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class XA extends AbstractC24063xz {
    private String a;
    private List b;
    private boolean c;
    private EnumC9567aB d;
    private ZA e;
    private long f;

    public XA(String str, List list, boolean z, EnumC9567aB enumC9567aB, ZA za, long j) {
        this.a = str;
        this.b = list;
        this.c = z;
        this.d = enumC9567aB;
        this.e = za;
        this.f = j;
    }

    public EnumC9567aB C() {
        return this.d;
    }

    public boolean D() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new YA());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.b(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC9567aB.p(iH);
        }
        this.e = (ZA) c19084pl0.z(5, new ZA());
        this.f = c19084pl0.i(6);
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 96;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.m(2, this.b);
        c19675ql0.a(3, this.c);
        EnumC9567aB enumC9567aB = this.d;
        if (enumC9567aB != null) {
            c19675ql0.f(4, enumC9567aB.j());
        }
        ZA za = this.e;
        if (za != null) {
            c19675ql0.i(5, za);
        }
        c19675ql0.g(6, this.f);
    }

    public String toString() {
        return "struct PollMessage{}";
    }

    public List u() {
        return this.b;
    }

    public long w() {
        return this.f;
    }

    public String y() {
        return this.a;
    }

    public ZA z() {
        return this.e;
    }

    public XA() {
    }
}
