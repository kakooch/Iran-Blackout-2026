package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ey, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12647ey extends AbstractC17902nl0 {
    private long a;
    private String b;
    private int c;
    private String d;
    private List e;
    private Integer f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.A(4);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new C4158Dy());
        }
        this.e = c19084pl0.p(5, arrayList);
        this.f = Integer.valueOf(c19084pl0.x(6));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.f(3, this.c);
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
        c19675ql0.m(5, this.e);
        Integer num = this.f;
        if (num != null) {
            c19675ql0.f(6, num.intValue());
        }
    }

    public String toString() {
        return "struct FileUrlDescription{}";
    }
}
