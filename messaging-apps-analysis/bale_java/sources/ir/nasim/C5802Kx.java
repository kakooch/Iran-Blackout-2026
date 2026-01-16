package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Kx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5802Kx extends AbstractC4383Ex {
    private int a;
    private String b;

    public C5802Kx(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.A(2);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC4383Ex
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
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
        return "struct DocumentExVoice{}";
    }

    public int u() {
        return this.a;
    }

    public String w() {
        return this.b;
    }

    public C5802Kx() {
    }
}
