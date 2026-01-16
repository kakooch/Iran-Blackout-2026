package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.hC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14011hC extends VB {
    private int a;
    private long b;
    private long c;

    public C14011hC(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.VB
    public int s() {
        return 62978;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct ServiceExGiftPacketOpened{}";
    }

    public long u() {
        return this.c;
    }

    public long w() {
        return this.b;
    }

    public int y() {
        return this.a;
    }

    public C14011hC() {
    }
}
