package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.ox, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18611ox extends AbstractC17902nl0 {
    private String a;
    private AbstractC19202px b;

    public C18611ox(String str, AbstractC19202px abstractC19202px) {
        this.a = str;
        this.b = abstractC19202px;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        if (c19084pl0.v(2) != null) {
            this.b = AbstractC19202px.r(c19084pl0.d(2));
        }
    }

    public String q() {
        return this.a;
    }

    public AbstractC19202px r() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        AbstractC19202px abstractC19202px = this.b;
        if (abstractC19202px != null) {
            c19675ql0.b(2, abstractC19202px.q());
        }
    }

    public String toString() {
        return "struct CustomAction{}";
    }

    public C18611ox() {
    }
}
