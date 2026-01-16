package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class FA extends AbstractC17902nl0 {
    private String a;
    private LA b;
    private String c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (LA) c19084pl0.z(2, new LA());
        this.c = c19084pl0.r(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        LA la = this.b;
        if (la != null) {
            c19675ql0.i(2, la);
        }
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
    }

    public String toString() {
        return "struct PfmSplitUnit{}";
    }
}
