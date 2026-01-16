package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Lw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6026Lw extends AbstractC17902nl0 {
    private String a;
    private C5793Kw b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C5793Kw) c19084pl0.z(2, new C5793Kw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C5793Kw c5793Kw = this.b;
        if (c5793Kw != null) {
            c19675ql0.i(2, c5793Kw);
        }
    }

    public String toString() {
        return "struct CardInfo{}";
    }
}
