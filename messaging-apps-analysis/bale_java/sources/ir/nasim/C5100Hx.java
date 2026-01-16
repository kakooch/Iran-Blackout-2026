package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Hx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5100Hx extends AbstractC4383Ex {
    private int a;
    private int b;

    public C5100Hx(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC4383Ex
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct DocumentExPhoto{}";
    }

    public int u() {
        return this.b;
    }

    public int w() {
        return this.a;
    }

    public C5100Hx() {
    }
}
