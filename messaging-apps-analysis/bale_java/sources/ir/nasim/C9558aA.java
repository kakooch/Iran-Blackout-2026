package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.aA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9558aA extends AbstractC17902nl0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private List e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new C9448Zz());
        }
        this.e = c19084pl0.p(5, arrayList);
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
        String str3 = this.c;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
        String str4 = this.d;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str4);
        c19675ql0.m(5, this.e);
    }

    public String toString() {
        return "struct OpenGraphObject{}";
    }
}
