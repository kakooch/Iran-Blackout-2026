package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class XC extends AbstractC9585aD {
    private String a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(2);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC9585aD
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct TextExMarkdown{}";
    }

    public String u() {
        return this.a;
    }
}
