package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.fw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13265fw extends AbstractC10632bw {
    private C10015aw a;
    private long b;

    public C13265fw(C10015aw c10015aw, long j) {
        this.a = c10015aw;
        this.b = j;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C10015aw) c19084pl0.k(1, new C10015aw());
        this.b = c19084pl0.i(2);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC10632bw
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C10015aw c10015aw = this.a;
        if (c10015aw == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c10015aw);
        c19675ql0.g(2, this.b);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct BankRemain{}";
    }

    public C10015aw u() {
        return this.a;
    }

    public long w() {
        return this.b;
    }

    public C13265fw() {
    }
}
