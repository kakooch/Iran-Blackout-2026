package ir.nasim;

import androidx.compose.ui.e;
import java.util.List;

/* renamed from: ir.nasim.nY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17776nY2 {
    private final InterfaceC11379cu3 a;
    private final C12189eB4 b = new C12189eB4();
    private final C22166um4 c = new C22166um4(10);

    /* renamed from: ir.nasim.nY2$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ e.c f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e.c cVar) {
            super(0);
            this.f = cVar;
        }

        public final void a() {
            C17776nY2.this.g(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C17776nY2(InterfaceC11379cu3 interfaceC11379cu3) {
        this.a = interfaceC11379cu3;
    }

    private final void f(long j, C3587Bm4 c3587Bm4) {
        this.b.h(j, c3587Bm4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(e.c cVar) {
        this.b.i(cVar);
    }

    public final void b(long j, List list, boolean z) {
        Object obj;
        C12189eB4 c12189eB4 = this.b;
        this.c.g();
        int size = list.size();
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            e.c cVar = (e.c) list.get(i);
            if (cVar.b2()) {
                cVar.n2(new a(cVar));
                if (z2) {
                    C12544en4 c12544en4G = c12189eB4.g();
                    Object[] objArr = c12544en4G.a;
                    int iO = c12544en4G.o();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= iO) {
                            obj = null;
                            break;
                        }
                        obj = objArr[i2];
                        if (AbstractC13042fc3.d(((UA4) obj).k(), cVar)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    UA4 ua4 = (UA4) obj;
                    if (ua4 != null) {
                        ua4.n();
                        ua4.l().a(j);
                        C22166um4 c22166um4 = this.c;
                        Object objB = c22166um4.b(j);
                        if (objB == null) {
                            objB = new C3587Bm4(0, 1, null);
                            c22166um4.q(j, objB);
                        }
                        ((C3587Bm4) objB).n(ua4);
                        c12189eB4 = ua4;
                    } else {
                        z2 = false;
                    }
                }
                UA4 ua42 = new UA4(cVar);
                ua42.l().a(j);
                C22166um4 c22166um42 = this.c;
                Object objB2 = c22166um42.b(j);
                if (objB2 == null) {
                    objB2 = new C3587Bm4(0, 1, null);
                    c22166um42.q(j, objB2);
                }
                ((C3587Bm4) objB2).n(ua42);
                c12189eB4.g().d(ua42);
                c12189eB4 = ua42;
            }
        }
        if (!z) {
            return;
        }
        C22166um4 c22166um43 = this.c;
        long[] jArr = c22166um43.b;
        Object[] objArr2 = c22166um43.c;
        long[] jArr2 = c22166um43.a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j2 = jArr2[i3];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j2) < 128) {
                        int i6 = (i3 << 3) + i5;
                        f(jArr[i6], (C3587Bm4) objArr2[i6]);
                    }
                    j2 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void c() {
        this.b.c();
    }

    public final boolean d(C7286Rb3 c7286Rb3, boolean z) {
        if (this.b.a(c7286Rb3.b(), this.a, c7286Rb3, z)) {
            return this.b.e(c7286Rb3) || this.b.f(c7286Rb3.b(), this.a, c7286Rb3, z);
        }
        return false;
    }

    public final void e() {
        this.b.d();
        c();
    }
}
