package ir.nasim;

/* renamed from: ir.nasim.rL4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20025rL4 extends AbstractC20634sL4 {
    public int b;
    public int d;
    public int f;
    private int g;
    public AbstractC14699iL4[] a = new AbstractC14699iL4[16];
    public int[] c = new int[16];
    public Object[] e = new Object[16];

    /* renamed from: ir.nasim.rL4$a */
    public final class a implements InterfaceC16479lL4 {
        private int a;
        private int b;
        private int c;

        public a() {
        }

        @Override // ir.nasim.InterfaceC16479lL4
        public Object a(int i) {
            return C20025rL4.this.e[this.c + i];
        }

        public final AbstractC14699iL4 b() {
            return C20025rL4.this.a[this.a];
        }

        public final boolean c() {
            if (this.a >= C20025rL4.this.b) {
                return false;
            }
            AbstractC14699iL4 abstractC14699iL4B = b();
            this.b += abstractC14699iL4B.b();
            this.c += abstractC14699iL4B.d();
            int i = this.a + 1;
            this.a = i;
            return i < C20025rL4.this.b;
        }

        @Override // ir.nasim.InterfaceC16479lL4
        public int getInt(int i) {
            return C20025rL4.this.c[this.b + i];
        }
    }

    private final int b(int i, int i2) {
        return AbstractC23053wG5.e(i + AbstractC23053wG5.i(i, 1024), i2);
    }

    private final void k(int i, int i2) {
        int[] iArr = new int[b(i, i2)];
        AbstractC9648aK.j(this.c, iArr, 0, 0, i);
        this.c = iArr;
    }

    private final void l(int i, int i2) {
        Object[] objArr = new Object[b(i, i2)];
        System.arraycopy(this.e, 0, objArr, 0, i);
        this.e = objArr;
    }

    private final void m() {
        int i = AbstractC23053wG5.i(this.b, 1024);
        int i2 = this.b;
        AbstractC14699iL4[] abstractC14699iL4Arr = new AbstractC14699iL4[i + i2];
        System.arraycopy(this.a, 0, abstractC14699iL4Arr, 0, i2);
        this.a = abstractC14699iL4Arr;
    }

    public final void a() {
        this.b = 0;
        this.d = 0;
        AbstractC9648aK.v(this.e, null, 0, this.f);
        this.f = 0;
    }

    public final void c(AbstractC14699iL4 abstractC14699iL4) {
        int i = this.g;
        int iB = abstractC14699iL4.b();
        if (i == ((iB == 0 ? 0 : -1) >>> (32 - iB))) {
            abstractC14699iL4.d();
        }
    }

    public final void d(InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
        if (g()) {
            a aVar = new a();
            do {
                aVar.b().a(aVar, interfaceC15247jG, c24216yE6, xm5);
            } while (aVar.c());
        }
        a();
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return e() == 0;
    }

    public final boolean g() {
        return e() != 0;
    }

    public final void h(C20025rL4 c20025rL4) {
        AbstractC14699iL4[] abstractC14699iL4Arr = this.a;
        int i = this.b - 1;
        this.b = i;
        AbstractC14699iL4 abstractC14699iL4 = abstractC14699iL4Arr[i];
        abstractC14699iL4Arr[i] = null;
        c20025rL4.j(abstractC14699iL4);
        Object[] objArr = this.e;
        Object[] objArr2 = c20025rL4.e;
        int iD = c20025rL4.f - abstractC14699iL4.d();
        int iD2 = this.f - abstractC14699iL4.d();
        System.arraycopy(objArr, iD2, objArr2, iD, this.f - iD2);
        AbstractC9648aK.v(this.e, null, this.f - abstractC14699iL4.d(), this.f);
        AbstractC9648aK.j(this.c, c20025rL4.c, c20025rL4.d - abstractC14699iL4.b(), this.d - abstractC14699iL4.b(), this.d);
        this.f -= abstractC14699iL4.d();
        this.d -= abstractC14699iL4.b();
    }

    public final void i(AbstractC14699iL4 abstractC14699iL4) {
        j(abstractC14699iL4);
    }

    public final void j(AbstractC14699iL4 abstractC14699iL4) {
        if (this.b == this.a.length) {
            m();
        }
        int iB = this.d + abstractC14699iL4.b();
        int length = this.c.length;
        if (iB > length) {
            k(length, iB);
        }
        int iD = this.f + abstractC14699iL4.d();
        int length2 = this.e.length;
        if (iD > length2) {
            l(length2, iD);
        }
        AbstractC14699iL4[] abstractC14699iL4Arr = this.a;
        int i = this.b;
        this.b = i + 1;
        abstractC14699iL4Arr[i] = abstractC14699iL4;
        this.d += abstractC14699iL4.b();
        this.f += abstractC14699iL4.d();
    }

    public String toString() {
        return super.toString();
    }

    /* renamed from: ir.nasim.rL4$b */
    public static final class b {
        public static final void b(C20025rL4 c20025rL4, int i, Object obj) {
            c20025rL4.e[(c20025rL4.f - c20025rL4.a[c20025rL4.b - 1].d()) + i] = obj;
        }

        public static final void c(C20025rL4 c20025rL4, int i, Object obj, int i2, Object obj2) {
            int iD = c20025rL4.f - c20025rL4.a[c20025rL4.b - 1].d();
            Object[] objArr = c20025rL4.e;
            objArr[i + iD] = obj;
            objArr[iD + i2] = obj2;
        }

        public static final void d(C20025rL4 c20025rL4, int i, Object obj, int i2, Object obj2, int i3, Object obj3, int i4, Object obj4) {
            int iD = c20025rL4.f - c20025rL4.a[c20025rL4.b - 1].d();
            Object[] objArr = c20025rL4.e;
            objArr[i + iD] = obj;
            objArr[i2 + iD] = obj2;
            objArr[i3 + iD] = obj3;
            objArr[iD + i4] = obj4;
        }

        public static final void e(C20025rL4 c20025rL4, int i, Object obj, int i2, Object obj2, int i3, Object obj3) {
            int iD = c20025rL4.f - c20025rL4.a[c20025rL4.b - 1].d();
            Object[] objArr = c20025rL4.e;
            objArr[i + iD] = obj;
            objArr[i2 + iD] = obj2;
            objArr[iD + i3] = obj3;
        }

        public static C20025rL4 a(C20025rL4 c20025rL4) {
            return c20025rL4;
        }
    }
}
