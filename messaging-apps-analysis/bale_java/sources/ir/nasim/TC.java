package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TC extends AbstractC24063xz {
    private AbstractC24063xz a;
    private long b;
    private List c;
    private String d;
    private C5343Iy e;
    private C24772zB f;
    private AB g;

    public TC(AbstractC24063xz abstractC24063xz, long j, List list, String str, C5343Iy c5343Iy, C24772zB c24772zB, AB ab) {
        this.a = abstractC24063xz;
        this.b = j;
        this.c = list;
        this.d = str;
        this.e = c5343Iy;
        this.f = c24772zB;
        this.g = ab;
    }

    public String C() {
        return this.d;
    }

    public long D() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = AbstractC24063xz.r(c19084pl0.d(1));
        this.b = c19084pl0.i(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new UC());
        }
        this.c = c19084pl0.p(3, arrayList);
        this.d = c19084pl0.A(4);
        this.e = (C5343Iy) c19084pl0.z(5, new C5343Iy());
        this.f = (C24772zB) c19084pl0.z(6, new C24772zB());
        this.g = (AB) c19084pl0.z(7, new AB());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 12;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        AbstractC24063xz abstractC24063xz = this.a;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(1, abstractC24063xz.q());
        c19675ql0.g(2, this.b);
        c19675ql0.m(3, this.c);
        String str = this.d;
        if (str != null) {
            c19675ql0.o(4, str);
        }
        C5343Iy c5343Iy = this.e;
        if (c5343Iy != null) {
            c19675ql0.i(5, c5343Iy);
        }
        C24772zB c24772zB = this.f;
        if (c24772zB != null) {
            c19675ql0.i(6, c24772zB);
        }
        AB ab = this.g;
        if (ab != null) {
            c19675ql0.i(7, ab);
        }
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct TemplateMessage{}";
    }

    public AbstractC24063xz u() {
        return this.a;
    }

    public C5343Iy w() {
        return this.e;
    }

    public C24772zB y() {
        return this.f;
    }

    public AB z() {
        return this.g;
    }

    public TC() {
    }
}
