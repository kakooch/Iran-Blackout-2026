package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.uD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21834uD extends AbstractC17902nl0 {
    private String a;
    private List b;
    private String c;
    private Boolean d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C7696Sv());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.A(3);
        this.d = Boolean.valueOf(c19084pl0.u(4));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.m(2, this.b);
        String str2 = this.c;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
        Boolean bool = this.d;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct Wallet{}";
    }
}
