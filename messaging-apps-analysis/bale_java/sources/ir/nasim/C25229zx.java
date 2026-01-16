package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C25229zx extends AbstractC17902nl0 {
    private String a;
    private String b;
    private List c;

    public C25229zx(String str, String str2, List list) {
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    public String getKey() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new C3681Bx());
        }
        this.c = c19084pl0.p(3, arrayList);
    }

    public List q() {
        return this.c;
    }

    public String r() {
        return this.a;
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
        c19675ql0.m(3, this.c);
    }

    public String toString() {
        return "struct DialogGroup{}";
    }

    public C25229zx() {
    }
}
