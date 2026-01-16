package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.j0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0171j0 extends AbstractC0134d {
    private final C0135d0 j;

    C0171j0(C0135d0 c0135d0, AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        super(abstractC0256y2, tVar);
        this.j = c0135d0;
    }

    C0171j0(C0171j0 c0171j0, j$.util.t tVar) {
        super(c0171j0, tVar);
        this.j = c0171j0.j;
    }

    private void m(Object obj) {
        boolean z;
        C0171j0 c0171j0 = this;
        while (true) {
            if (c0171j0 != null) {
                AbstractC0146f abstractC0146fC = c0171j0.c();
                if (abstractC0146fC != null && abstractC0146fC.d != c0171j0) {
                    z = false;
                    break;
                }
                c0171j0 = abstractC0146fC;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            l(obj);
        } else {
            j();
        }
    }

    @Override // j$.util.stream.AbstractC0146f
    protected Object a() {
        AbstractC0256y2 abstractC0256y2 = this.a;
        P4 p4 = (P4) this.j.e.get();
        abstractC0256y2.v0(p4, this.b);
        Object obj = p4.get();
        if (!this.j.b) {
            if (obj != null) {
                l(obj);
            }
            return null;
        }
        if (obj == null) {
            return null;
        }
        m(obj);
        return obj;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected AbstractC0146f f(j$.util.t tVar) {
        return new C0171j0(this, tVar);
    }

    @Override // j$.util.stream.AbstractC0134d
    protected Object k() {
        return this.j.c;
    }

    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (this.j.b) {
            C0171j0 c0171j0 = (C0171j0) this.d;
            C0171j0 c0171j02 = null;
            while (true) {
                if (c0171j0 != c0171j02) {
                    Object objB = c0171j0.b();
                    if (objB != null && this.j.d.test(objB)) {
                        g(objB);
                        m(objB);
                        break;
                    } else {
                        c0171j02 = c0171j0;
                        c0171j0 = (C0171j0) this.e;
                    }
                } else {
                    break;
                }
            }
        }
        this.b = null;
        this.e = null;
        this.d = null;
    }
}
