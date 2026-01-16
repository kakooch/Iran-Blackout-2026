package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.eD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12202eD extends AbstractC9585aD {
    private String a;
    private String b;
    private C6984Pv c;
    private C19330qA d;
    private List e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        this.b = c19084pl0.A(2);
        this.c = (C6984Pv) c19084pl0.z(3, new C6984Pv());
        this.d = (C19330qA) c19084pl0.z(4, new C19330qA());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new C10795cD());
        }
        this.e = c19084pl0.p(5, arrayList);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC9585aD
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        String str2 = this.b;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        C6984Pv c6984Pv = this.c;
        if (c6984Pv != null) {
            c19675ql0.i(3, c6984Pv);
        }
        C19330qA c19330qA = this.d;
        if (c19330qA != null) {
            c19675ql0.i(4, c19330qA);
        }
        c19675ql0.m(5, this.e);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct TextModernMessage{}";
    }
}
