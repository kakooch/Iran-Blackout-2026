package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class EB extends AbstractC17902nl0 {
    private long a;
    private String b;
    private EnumC18602ow c;
    private C17420mw d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC18602ow.p(iH);
        }
        this.d = (C17420mw) c19084pl0.z(4, new C17420mw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        EnumC18602ow enumC18602ow = this.c;
        if (enumC18602ow != null) {
            c19675ql0.f(3, enumC18602ow.j());
        }
        C17420mw c17420mw = this.d;
        if (c17420mw != null) {
            c19675ql0.i(4, c17420mw);
        }
    }

    public String toString() {
        return "struct SavedBill{}";
    }
}
