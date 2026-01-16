package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11550dC extends VB {
    private String a;

    public C11550dC(String str) {
        this.a = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.VB
    public int s() {
        return 18;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
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
        return "struct ServiceExChangedTopic{}";
    }

    public String u() {
        return this.a;
    }

    public C11550dC() {
    }
}
