package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Gx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4866Gx extends AbstractC4383Ex {
    private int a;
    private int b;
    private int c;

    public C4866Gx(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.g(3);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC4383Ex
    public int s() {
        return 4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct DocumentExGif{}";
    }

    public int u() {
        return this.c;
    }

    public int w() {
        return this.b;
    }

    public int y() {
        return this.a;
    }

    public C4866Gx() {
    }
}
