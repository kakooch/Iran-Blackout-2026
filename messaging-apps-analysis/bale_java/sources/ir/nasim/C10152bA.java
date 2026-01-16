package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.bA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10152bA extends AbstractC19202px {
    private String a;
    private EnumC4140Dw b;

    public C10152bA(String str, EnumC4140Dw enumC4140Dw) {
        this.a = str;
        this.b = enumC4140Dw;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC4140Dw.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC19202px
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        EnumC4140Dw enumC4140Dw = this.b;
        if (enumC4140Dw != null) {
            c19675ql0.f(2, enumC4140Dw.j());
        }
    }

    public String toString() {
        return "struct OpenUrlAction{}";
    }

    public EnumC4140Dw u() {
        return this.b;
    }

    public String w() {
        return this.a;
    }

    public C10152bA() {
    }
}
