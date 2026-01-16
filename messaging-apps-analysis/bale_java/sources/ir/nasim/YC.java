package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class YC extends AbstractC9585aD {
    private C13883gz a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C13883gz) c19084pl0.k(1, new C13883gz());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC9585aD
    public int s() {
        return 4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C13883gz c13883gz = this.a;
        if (c13883gz == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c13883gz);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct TextLinkPreview{}";
    }
}
