package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Tx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7953Tx extends AbstractC17902nl0 {
    private EnumC6251Mv a;
    private String b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC6251Mv.p(iH);
        }
        this.b = c19084pl0.r(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        EnumC6251Mv enumC6251Mv = this.a;
        if (enumC6251Mv != null) {
            c19675ql0.f(1, enumC6251Mv.j());
        }
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "struct ExInfoAddress{}";
    }
}
