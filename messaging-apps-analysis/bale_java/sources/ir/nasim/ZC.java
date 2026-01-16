package ir.nasim;

import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public class ZC extends AbstractC24063xz {
    private String a;
    private List b;
    private AbstractC9585aD c;
    private C5118Hz d;

    public ZC(String str, List list, AbstractC9585aD abstractC9585aD, C5118Hz c5118Hz) {
        this.a = str;
        this.b = list;
        this.c = abstractC9585aD;
        this.d = c5118Hz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.n(2);
        if (c19084pl0.v(3) != null) {
            this.c = AbstractC9585aD.r(c19084pl0.d(3));
        }
        this.d = (C5118Hz) c19084pl0.z(4, new C5118Hz());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.k(2, this.b);
        AbstractC9585aD abstractC9585aD = this.c;
        if (abstractC9585aD != null) {
            c19675ql0.b(3, abstractC9585aD.q());
        }
        C5118Hz c5118Hz = this.d;
        if (c5118Hz != null) {
            c19675ql0.i(4, c5118Hz);
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
        return "struct TextMessage{}";
    }

    public AbstractC9585aD u() {
        return this.c;
    }

    public List w() {
        return this.b;
    }

    public C5118Hz y() {
        return this.d;
    }

    public String z() {
        return this.a;
    }

    public ZC() {
    }
}
