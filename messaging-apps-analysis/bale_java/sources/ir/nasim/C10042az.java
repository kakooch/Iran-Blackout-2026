package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.az, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10042az extends AbstractC17902nl0 {
    private String a;

    public C10042az(String str) {
        this.a = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
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
        return "struct KeyboardButtonPollType{}";
    }

    public C10042az() {
    }
}
