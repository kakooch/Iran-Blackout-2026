package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.x1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0195x1<P_IN, P_OUT, O> extends AbstractC0152m1<P_IN, P_OUT, O, C0195x1<P_IN, P_OUT, O>> {
    private final C0187v1 j;

    C0195x1(C0187v1 c0187v1, V1 v1, Spliterator spliterator) {
        super(v1, spliterator);
        this.j = c0187v1;
    }

    C0195x1(C0195x1 c0195x1, Spliterator spliterator) {
        super(c0195x1, spliterator);
        this.j = c0195x1.j;
    }

    private void m(Object obj) {
        boolean z;
        AbstractC0160o1 abstractC0160o1 = this;
        while (true) {
            if (abstractC0160o1 != null) {
                AbstractC0160o1 abstractC0160o1C = abstractC0160o1.c();
                if (abstractC0160o1C != null && abstractC0160o1C.e != abstractC0160o1) {
                    z = false;
                    break;
                }
                abstractC0160o1 = abstractC0160o1C;
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

    @Override // j$.util.stream.AbstractC0160o1
    protected Object a() {
        V1 v1 = this.b;
        j3 j3Var = (j3) this.j.e.get();
        v1.s0(j3Var, this.c);
        Object obj = j3Var.get();
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

    @Override // j$.util.stream.AbstractC0160o1
    protected AbstractC0160o1 f(Spliterator spliterator) {
        return new C0195x1(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0152m1
    protected Object k() {
        return this.j.c;
    }

    @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (this.j.b) {
            C0195x1 c0195x1 = (C0195x1) this.e;
            C0195x1 c0195x12 = null;
            while (true) {
                if (c0195x1 != c0195x12) {
                    Object objB = c0195x1.b();
                    if (objB != null && this.j.d.test(objB)) {
                        g(objB);
                        m(objB);
                        break;
                    } else {
                        c0195x12 = c0195x1;
                        c0195x1 = (C0195x1) this.f;
                    }
                } else {
                    break;
                }
            }
        }
        this.c = null;
        this.f = null;
        this.e = null;
    }
}
