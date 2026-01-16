package ir.nasim;

import java.util.HashMap;

/* loaded from: classes5.dex */
public class L78 extends AbstractC17902nl0 {
    private final HashMap a = new HashMap();
    private final HashMap b = new HashMap();
    private boolean c = false;

    public L78() {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.c = c19084pl0.b(1);
        int iG = c19084pl0.g(2);
        int i = 2;
        for (int i2 = 0; i2 < iG; i2++) {
            String strR = c19084pl0.r(i + 1);
            i += 2;
            this.a.put(strR, c19084pl0.r(i));
        }
        int i3 = i + 1;
        int iG2 = c19084pl0.g(i3);
        for (int i4 = 0; i4 < iG2; i4++) {
            String strR2 = c19084pl0.r(i3 + 1);
            i3 += 2;
            this.b.put(strR2, c19084pl0.r(i3));
        }
    }

    public HashMap q() {
        return this.b;
    }

    public HashMap r() {
        return this.a;
    }

    public boolean s() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.c);
        c19675ql0.f(2, this.a.size());
        int i = 2;
        for (String str : this.a.keySet()) {
            c19675ql0.o(i + 1, str);
            i += 2;
            c19675ql0.o(i, (String) this.a.get(str));
        }
        int i2 = i + 1;
        c19675ql0.f(i2, this.b.size());
        for (String str2 : this.b.keySet()) {
            c19675ql0.o(i2 + 1, str2);
            i2 += 2;
            c19675ql0.o(i2, (String) this.b.get(str2));
        }
    }

    public void u(boolean z) {
        this.c = z;
    }

    public L78(byte[] bArr) {
        super.load(bArr);
    }
}
