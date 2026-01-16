package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.aC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9576aC extends VB {
    private C6984Pv a;

    public C9576aC(C6984Pv c6984Pv) {
        this.a = c6984Pv;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C6984Pv) c19084pl0.z(1, new C6984Pv());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.VB
    public int s() {
        return 6;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C6984Pv c6984Pv = this.a;
        if (c6984Pv != null) {
            c19675ql0.i(1, c6984Pv);
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
        return "struct ServiceExChangedAvatar{}";
    }

    public C6984Pv u() {
        return this.a;
    }

    public C9576aC() {
    }
}
