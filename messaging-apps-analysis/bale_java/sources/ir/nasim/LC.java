package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class LC extends AbstractC17902nl0 {
    private String a;
    private C16966mA b;

    public LC(String str, C16966mA c16966mA) {
        this.a = str;
        this.b = c16966mA;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C16966mA) c19084pl0.z(2, new C16966mA());
    }

    public String q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C16966mA c16966mA = this.b;
        if (c16966mA != null) {
            c19675ql0.i(2, c16966mA);
        }
    }

    public String toString() {
        return "struct StoryReference{}";
    }

    public LC() {
    }
}
