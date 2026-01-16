package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class VC extends AbstractC24063xz {
    private String a;
    private long b;
    private AbstractC24063xz c;

    public VC(String str, long j, AbstractC24063xz abstractC24063xz) {
        this.a = str;
        this.b = j;
        this.c = abstractC24063xz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(3);
        if (c19084pl0.v(4) != null) {
            this.c = AbstractC24063xz.r(c19084pl0.d(4));
        }
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 13;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(3, this.b);
        AbstractC24063xz abstractC24063xz = this.c;
        if (abstractC24063xz != null) {
            c19675ql0.b(4, abstractC24063xz.q());
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
        return "struct TemplateMessageResponse{}";
    }

    public long u() {
        return this.b;
    }

    public String w() {
        return this.a;
    }

    public VC() {
    }
}
