package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.cD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10795cD extends AbstractC17902nl0 {
    private String a;
    private String b;
    private C4626Fy c;
    private String d;
    private C19330qA e;
    private List f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        this.b = c19084pl0.A(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
        this.d = c19084pl0.A(4);
        this.e = (C19330qA) c19084pl0.z(5, new C19330qA());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(6); i++) {
            arrayList.add(new C11559dD());
        }
        this.f = c19084pl0.p(6, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        String str2 = this.b;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        C4626Fy c4626Fy = this.c;
        if (c4626Fy != null) {
            c19675ql0.i(3, c4626Fy);
        }
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
        C19330qA c19330qA = this.e;
        if (c19330qA != null) {
            c19675ql0.i(5, c19330qA);
        }
        c19675ql0.m(6, this.f);
    }

    public String toString() {
        return "struct TextModernAttach{}";
    }
}
