package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11559dD extends AbstractC17902nl0 {
    private String a;
    private String b;
    private Boolean c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = Boolean.valueOf(c19084pl0.u(3));
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
        Boolean bool = this.c;
        if (bool != null) {
            c19675ql0.a(3, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct TextModernField{}";
    }
}
