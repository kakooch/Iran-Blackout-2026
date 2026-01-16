package ir.nasim;

/* renamed from: ir.nasim.fJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12871fJ5 extends AbstractC17902nl0 {
    public C23698xM6 a;
    private int b;

    public C12871fJ5(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "byteArray");
        this.b = -1;
        load(bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0 == null) {
            return;
        }
        s(new C23698xM6(c19084pl0.d(1)));
        this.b = c19084pl0.g(2);
    }

    public final C23698xM6 q() {
        C23698xM6 c23698xM6 = this.a;
        if (c23698xM6 != null) {
            return c23698xM6;
        }
        AbstractC13042fc3.y("sticker");
        return null;
    }

    public final int r() {
        return this.b;
    }

    public final void s(C23698xM6 c23698xM6) {
        AbstractC13042fc3.i(c23698xM6, "<set-?>");
        this.a = c23698xM6;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        if (c19675ql0 != null) {
            c19675ql0.i(1, q());
        }
        if (c19675ql0 != null) {
            c19675ql0.f(2, this.b);
        }
    }

    public C12871fJ5(C23698xM6 c23698xM6, int i) {
        AbstractC13042fc3.i(c23698xM6, "sticker");
        this.b = -1;
        s(c23698xM6);
        this.b = i;
    }
}
