package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.jx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15656jx extends AbstractC17902nl0 {
    private String a;

    public C15656jx(String str) {
        this.a = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
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
    }

    public String toString() {
        return "struct CopyTextButton{}";
    }

    public C15656jx() {
    }
}
