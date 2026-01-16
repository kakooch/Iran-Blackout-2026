package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC12529em;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.iW3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14806iW3 implements InterfaceC9734aT4 {
    private final int a;
    private final int b;
    private final List c;
    private final long d;
    private final Object e;
    private final InterfaceC12529em.b f;
    private final InterfaceC12529em.c g;
    private final EnumC12613eu3 h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int[] l;
    private int m;
    private int n;

    public /* synthetic */ C14806iW3(int i, int i2, List list, long j, Object obj, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, EnumC12613eu3 enumC12613eu3, boolean z, ED1 ed1) {
        this(i, i2, list, j, obj, enumC24286yM4, bVar, cVar, enumC12613eu3, z);
    }

    private final int d(AbstractC21430te5 abstractC21430te5) {
        return this.j ? abstractC21430te5.A0() : abstractC21430te5.P0();
    }

    private final long e(int i) {
        int[] iArr = this.l;
        int i2 = i * 2;
        return C22045ua3.f((iArr[i2] << 32) | (iArr[i2 + 1] & 4294967295L));
    }

    public final void a(int i) {
        this.m = getOffset() + i;
        int length = this.l.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolean z = this.j;
            if ((z && i2 % 2 == 1) || (!z && i2 % 2 == 0)) {
                int[] iArr = this.l;
                iArr[i2] = iArr[i2] + i;
            }
        }
    }

    public final int b() {
        return this.k;
    }

    public Object c() {
        return this.e;
    }

    public final int f() {
        return this.b;
    }

    public final void g(AbstractC21430te5.a aVar) {
        if (!(this.n != Integer.MIN_VALUE)) {
            P73.a("position() should be called first");
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) this.c.get(i);
            long jE = e(i);
            if (this.i) {
                jE = C22045ua3.f(((this.j ? C22045ua3.k(jE) : (this.n - C22045ua3.k(jE)) - d(abstractC21430te5)) << 32) | ((this.j ? (this.n - C22045ua3.l(jE)) - d(abstractC21430te5) : C22045ua3.l(jE)) & 4294967295L));
            }
            long jO = C22045ua3.o(jE, this.d);
            if (this.j) {
                AbstractC21430te5.a.y(aVar, abstractC21430te5, jO, 0.0f, null, 6, null);
            } else {
                AbstractC21430te5.a.s(aVar, abstractC21430te5, jO, 0.0f, null, 6, null);
            }
        }
    }

    @Override // ir.nasim.InterfaceC9734aT4
    public int getIndex() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC9734aT4
    public int getOffset() {
        return this.m;
    }

    public final void h(int i, int i2, int i3) {
        int iP0;
        this.m = i;
        this.n = this.j ? i3 : i2;
        List list = this.c;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list.get(i4);
            int i5 = i4 * 2;
            if (this.j) {
                int[] iArr = this.l;
                InterfaceC12529em.b bVar = this.f;
                if (bVar == null) {
                    P73.b("null horizontalAlignment");
                    throw new KotlinNothingValueException();
                }
                iArr[i5] = bVar.a(abstractC21430te5.P0(), i2, this.h);
                this.l[i5 + 1] = i;
                iP0 = abstractC21430te5.A0();
            } else {
                int[] iArr2 = this.l;
                iArr2[i5] = i;
                int i6 = i5 + 1;
                InterfaceC12529em.c cVar = this.g;
                if (cVar == null) {
                    P73.b("null verticalAlignment");
                    throw new KotlinNothingValueException();
                }
                iArr2[i6] = cVar.a(abstractC21430te5.A0(), i3);
                iP0 = abstractC21430te5.P0();
            }
            i += iP0;
        }
    }

    private C14806iW3(int i, int i2, List list, long j, Object obj, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, EnumC12613eu3 enumC12613eu3, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = list;
        this.d = j;
        this.e = obj;
        this.f = bVar;
        this.g = cVar;
        this.h = enumC12613eu3;
        this.i = z;
        this.j = enumC24286yM4 == EnumC24286yM4.a;
        int size = list.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list.get(i3);
            iMax = Math.max(iMax, !this.j ? abstractC21430te5.A0() : abstractC21430te5.P0());
        }
        this.k = iMax;
        this.l = new int[this.c.size() * 2];
        this.n = RecyclerView.UNDEFINED_DURATION;
    }
}
