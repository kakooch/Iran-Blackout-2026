package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class UC extends AbstractC17902nl0 {
    private String a;
    private String b;
    private int c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        c19675ql0.f(3, this.c);
    }

    public String toString() {
        return "struct TemplateMessageButton{}";
    }
}
