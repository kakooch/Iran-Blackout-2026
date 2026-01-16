package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.vY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22619vY5 extends AbstractC10365bX5 {
    private List b;
    private String c;
    private String d;

    public static C22619vY5 s(byte[] bArr) {
        return (C22619vY5) AbstractC16720ll0.b(new C22619vY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C12065dz());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = c19084pl0.A(2);
        this.d = c19084pl0.A(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        String str = this.c;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
    }

    public String toString() {
        return "response GetMyKifpools{}";
    }
}
