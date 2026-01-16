package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class QC extends AbstractC17902nl0 {
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    public QC(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.b(2);
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.b(5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.a(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.a(4, this.d);
        c19675ql0.a(5, this.e);
    }

    public String toString() {
        return "struct SwitchInlineQueryChosenChat{}";
    }

    public QC() {
    }
}
