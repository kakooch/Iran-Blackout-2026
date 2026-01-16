package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class AC extends AbstractC19202px {
    private String a;

    public AC(String str) {
        this.a = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
    }

    @Override // ir.nasim.AbstractC19202px
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
    }

    public String toString() {
        return "struct ShowSnackBarAction{}";
    }

    public String u() {
        return this.a;
    }

    public AC() {
    }
}
