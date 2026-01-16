package ir.nasim;

import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.Dz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4167Dz extends AbstractC17902nl0 {
    private List a;
    private String b;
    private Long c;
    private C19811qz d;

    public C4167Dz(List list, String str, Long l, C19811qz c19811qz) {
        this.a = list;
        this.b = str;
        this.c = l;
        this.d = c19811qz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.n(1);
        this.b = c19084pl0.r(2);
        this.c = Long.valueOf(c19084pl0.y(3));
        this.d = (C19811qz) c19084pl0.z(4, new C19811qz());
    }

    public Long q() {
        return this.c;
    }

    public String r() {
        return this.b;
    }

    public List s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.k(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        Long l = this.c;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
        C19811qz c19811qz = this.d;
        if (c19811qz != null) {
            c19675ql0.i(4, c19811qz);
        }
    }

    public String toString() {
        return "struct MessageReaction{}";
    }

    public C4167Dz() {
    }
}
