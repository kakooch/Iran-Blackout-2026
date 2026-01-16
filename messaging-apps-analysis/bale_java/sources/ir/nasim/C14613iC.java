package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.iC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14613iC extends VB {
    private int a;
    private int b;
    private long c;
    private long d;

    public C14613iC(int i, int i2, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.VB
    public int s() {
        return 62979;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ServiceExGiftPacketOpenedCompact{}";
    }

    public int u() {
        return this.a;
    }

    public long w() {
        return this.d;
    }

    public long y() {
        return this.c;
    }

    public int z() {
        return this.b;
    }

    public C14613iC() {
    }
}
