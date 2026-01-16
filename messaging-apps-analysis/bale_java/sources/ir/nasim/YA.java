package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class YA extends AbstractC17902nl0 {
    private int a;
    private String b;

    public YA(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.r(2);
    }

    public String q() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "struct PollOption{}";
    }

    public YA() {
    }
}
