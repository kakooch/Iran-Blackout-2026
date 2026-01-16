package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import ir.nasim.VS4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Kp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5733Kp2 {
    private int a;
    private int b;
    private final BJ c = new BJ();
    private final C20889sm4 d = new C20889sm4();
    private C14653iG3 e;
    private boolean f;

    /* renamed from: ir.nasim.Kp2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private final void c(VS4.b bVar) {
        this.d.b(bVar.m());
        this.e = bVar.i();
        int i = a.a[bVar.h().ordinal()];
        if (i == 1) {
            this.a = bVar.l();
            Iterator it = AbstractC23053wG5.r(bVar.j().size() - 1, 0).iterator();
            while (it.hasNext()) {
                this.c.addFirst(bVar.j().get(((AbstractC18386oa3) it).b()));
            }
            return;
        }
        if (i == 2) {
            this.b = bVar.k();
            this.c.addAll(bVar.j());
        } else {
            if (i != 3) {
                return;
            }
            this.c.clear();
            this.b = bVar.k();
            this.a = bVar.l();
            this.c.addAll(bVar.j());
        }
    }

    private final void d(VS4.c cVar) {
        this.d.b(cVar.f());
        this.e = cVar.e();
    }

    private final void e(VS4.a aVar) {
        this.d.c(aVar.e(), AbstractC13460gG3.c.b.b());
        int i = a.a[aVar.e().ordinal()];
        int i2 = 0;
        if (i == 1) {
            this.a = aVar.i();
            int iH = aVar.h();
            while (i2 < iH) {
                this.c.removeFirst();
                i2++;
            }
            return;
        }
        if (i != 2) {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
        this.b = aVar.i();
        int iH2 = aVar.h();
        while (i2 < iH2) {
            this.c.removeLast();
            i2++;
        }
    }

    private final void f(VS4.d dVar) {
        if (dVar.g() != null) {
            this.d.b(dVar.g());
        }
        if (dVar.f() != null) {
            this.e = dVar.f();
        }
        this.c.clear();
        this.b = 0;
        this.a = 0;
        this.c.add(new C15054iv7(0, dVar.e()));
    }

    public final void a(VS4 vs4) {
        AbstractC13042fc3.i(vs4, "event");
        this.f = true;
        if (vs4 instanceof VS4.b) {
            c((VS4.b) vs4);
            return;
        }
        if (vs4 instanceof VS4.a) {
            e((VS4.a) vs4);
        } else if (vs4 instanceof VS4.c) {
            d((VS4.c) vs4);
        } else if (vs4 instanceof VS4.d) {
            f((VS4.d) vs4);
        }
    }

    public final List b() {
        if (!this.f) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        C14653iG3 c14653iG3D = this.d.d();
        if (!this.c.isEmpty()) {
            arrayList.add(VS4.b.g.c(AbstractC15401jX0.m1(this.c), this.a, this.b, c14653iG3D, this.e));
        } else {
            arrayList.add(new VS4.c(c14653iG3D, this.e));
        }
        return arrayList;
    }
}
