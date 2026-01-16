package ir.nasim;

import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.yJ, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24254yJ {
    public static final C24254yJ a = new C24254yJ();
    private static final e b = new k();
    private static final e c = new d();
    private static final m d = new l();
    private static final m e = new b();
    private static final f f = new c();
    private static final f g = new i();
    private static final f h = new h();
    private static final f i = new g();

    /* renamed from: ir.nasim.yJ$a */
    public static final class a {
        public static final a a = new a();
        private static final e b = new b();
        private static final e c = new C1780a();
        private static final e d = new c();
        private static final e e = new e();
        private static final e f = new f();
        private static final e g = new d();

        /* renamed from: ir.nasim.yJ$a$a, reason: collision with other inner class name */
        public static final class C1780a implements e {
            C1780a() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.i(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        }

        /* renamed from: ir.nasim.yJ$a$b */
        public static final class b implements e {
            b() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.j(iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        }

        /* renamed from: ir.nasim.yJ$a$c */
        public static final class c implements e {
            c() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.k(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        }

        /* renamed from: ir.nasim.yJ$a$d */
        public static final class d implements e {
            d() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.l(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        }

        /* renamed from: ir.nasim.yJ$a$e */
        public static final class e implements e {
            e() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.m(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        }

        /* renamed from: ir.nasim.yJ$a$f */
        public static final class f implements e {
            f() {
            }

            @Override // ir.nasim.C24254yJ.e
            public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
                C24254yJ.a.n(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        }

        private a() {
        }

        public final e a() {
            return b;
        }

        public final e b() {
            return d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f c(float f2) {
            return new j(f2, false, null, 0 == true ? 1 : 0);
        }
    }

    /* renamed from: ir.nasim.yJ$b */
    public static final class b implements m {
        b() {
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.k(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    }

    /* renamed from: ir.nasim.yJ$c */
    public static final class c implements f {
        private final float a = C17784nZ1.q(0);

        c() {
        }

        @Override // ir.nasim.C24254yJ.e, ir.nasim.C24254yJ.m
        public float a() {
            return this.a;
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.i(i, iArr, iArr2, false);
            } else {
                C24254yJ.a.i(i, iArr, iArr2, true);
            }
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.i(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Center";
        }
    }

    /* renamed from: ir.nasim.yJ$d */
    public static final class d implements e {
        d() {
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.k(i, iArr, iArr2, false);
            } else {
                C24254yJ.a.j(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    }

    /* renamed from: ir.nasim.yJ$e */
    public interface e {
        default float a() {
            return C17784nZ1.q(0);
        }

        void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2);
    }

    /* renamed from: ir.nasim.yJ$f */
    public interface f extends e, m {
    }

    /* renamed from: ir.nasim.yJ$g */
    public static final class g implements f {
        private final float a = C17784nZ1.q(0);

        g() {
        }

        @Override // ir.nasim.C24254yJ.e, ir.nasim.C24254yJ.m
        public float a() {
            return this.a;
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.l(i, iArr, iArr2, false);
            } else {
                C24254yJ.a.l(i, iArr, iArr2, true);
            }
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.l(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    }

    /* renamed from: ir.nasim.yJ$h */
    public static final class h implements f {
        private final float a = C17784nZ1.q(0);

        h() {
        }

        @Override // ir.nasim.C24254yJ.e, ir.nasim.C24254yJ.m
        public float a() {
            return this.a;
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.m(i, iArr, iArr2, false);
            } else {
                C24254yJ.a.m(i, iArr, iArr2, true);
            }
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.m(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    }

    /* renamed from: ir.nasim.yJ$i */
    public static final class i implements f {
        private final float a = C17784nZ1.q(0);

        i() {
        }

        @Override // ir.nasim.C24254yJ.e, ir.nasim.C24254yJ.m
        public float a() {
            return this.a;
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.n(i, iArr, iArr2, false);
            } else {
                C24254yJ.a.n(i, iArr, iArr2, true);
            }
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.n(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    }

    /* renamed from: ir.nasim.yJ$j */
    public static final class j implements f {
        private final float a;
        private final boolean b;
        private final InterfaceC14603iB2 c;
        private final float d;

        public /* synthetic */ j(float f, boolean z, InterfaceC14603iB2 interfaceC14603iB2, ED1 ed1) {
            this(f, z, interfaceC14603iB2);
        }

        @Override // ir.nasim.C24254yJ.e, ir.nasim.C24254yJ.m
        public float a() {
            return this.d;
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            int i2;
            int i3;
            if (iArr.length == 0) {
                return;
            }
            int iB0 = wh1.B0(this.a);
            boolean z = this.b && enumC12613eu3 == EnumC12613eu3.b;
            C24254yJ c24254yJ = C24254yJ.a;
            if (z) {
                int length = iArr.length - 1;
                i2 = 0;
                i3 = 0;
                while (-1 < length) {
                    int i4 = iArr[length];
                    int iMin = Math.min(i2, i - i4);
                    iArr2[length] = iMin;
                    int iMin2 = Math.min(iB0, (i - iMin) - i4);
                    int i5 = iArr2[length] + i4 + iMin2;
                    length--;
                    i3 = iMin2;
                    i2 = i5;
                }
            } else {
                int length2 = iArr.length;
                int i6 = 0;
                i2 = 0;
                i3 = 0;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = iArr[i6];
                    int iMin3 = Math.min(i2, i - i8);
                    iArr2[i7] = iMin3;
                    int iMin4 = Math.min(iB0, (i - iMin3) - i8);
                    int i9 = iArr2[i7] + i8 + iMin4;
                    i6++;
                    i7++;
                    i3 = iMin4;
                    i2 = i9;
                }
            }
            int i10 = i2 - i3;
            InterfaceC14603iB2 interfaceC14603iB2 = this.c;
            if (interfaceC14603iB2 == null || i10 >= i) {
                return;
            }
            int iIntValue = ((Number) interfaceC14603iB2.invoke(Integer.valueOf(i - i10), enumC12613eu3)).intValue();
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iIntValue;
            }
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            b(wh1, i, iArr, EnumC12613eu3.a, iArr2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return C17784nZ1.s(this.a, jVar.a) && this.b == jVar.b && AbstractC13042fc3.d(this.c, jVar.c);
        }

        public int hashCode() {
            int iT = ((C17784nZ1.t(this.a) * 31) + Boolean.hashCode(this.b)) * 31;
            InterfaceC14603iB2 interfaceC14603iB2 = this.c;
            return iT + (interfaceC14603iB2 == null ? 0 : interfaceC14603iB2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) C17784nZ1.u(this.a));
            sb.append(", ");
            sb.append(this.c);
            sb.append(')');
            return sb.toString();
        }

        private j(float f, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = f;
            this.b = z;
            this.c = interfaceC14603iB2;
            this.d = f;
        }
    }

    /* renamed from: ir.nasim.yJ$k */
    public static final class k implements e {
        k() {
        }

        @Override // ir.nasim.C24254yJ.e
        public void b(WH1 wh1, int i, int[] iArr, EnumC12613eu3 enumC12613eu3, int[] iArr2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                C24254yJ.a.j(iArr, iArr2, false);
            } else {
                C24254yJ.a.k(i, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    }

    /* renamed from: ir.nasim.yJ$l */
    public static final class l implements m {
        l() {
        }

        @Override // ir.nasim.C24254yJ.m
        public void c(WH1 wh1, int i, int[] iArr, int[] iArr2) {
            C24254yJ.a.j(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    }

    /* renamed from: ir.nasim.yJ$m */
    public interface m {
        default float a() {
            return C17784nZ1.q(0);
        }

        void c(WH1 wh1, int i, int[] iArr, int[] iArr2);
    }

    /* renamed from: ir.nasim.yJ$n */
    static final class n extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final n e = new n();

        n() {
            super(2);
        }

        public final Integer a(int i, EnumC12613eu3 enumC12613eu3) {
            return Integer.valueOf(InterfaceC12529em.a.k().a(0, i, enumC12613eu3));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (EnumC12613eu3) obj2);
        }
    }

    /* renamed from: ir.nasim.yJ$o */
    static final class o extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12529em.b e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(InterfaceC12529em.b bVar) {
            super(2);
            this.e = bVar;
        }

        public final Integer a(int i, EnumC12613eu3 enumC12613eu3) {
            return Integer.valueOf(this.e.a(0, i, enumC12613eu3));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (EnumC12613eu3) obj2);
        }
    }

    /* renamed from: ir.nasim.yJ$p */
    static final class p extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12529em.c e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(InterfaceC12529em.c cVar) {
            super(2);
            this.e = cVar;
        }

        public final Integer a(int i, EnumC12613eu3 enumC12613eu3) {
            return Integer.valueOf(this.e.a(0, i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (EnumC12613eu3) obj2);
        }
    }

    private C24254yJ() {
    }

    public final m a() {
        return e;
    }

    public final f b() {
        return f;
    }

    public final e c() {
        return c;
    }

    public final f d() {
        return i;
    }

    public final f e() {
        return h;
    }

    public final f f() {
        return g;
    }

    public final e g() {
        return b;
    }

    public final m h() {
        return d;
    }

    public final void i(int i2, int[] iArr, int[] iArr2, boolean z) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        float f2 = (i2 - i4) / 2;
        if (!z) {
            int length = iArr.length;
            int i6 = 0;
            while (i3 < length) {
                int i7 = iArr[i3];
                iArr2[i6] = Math.round(f2);
                f2 += i7;
                i3++;
                i6++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i8 = iArr[length2];
            iArr2[length2] = Math.round(f2);
            f2 += i8;
        }
    }

    public final void j(int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        if (!z) {
            int length = iArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                int i5 = iArr[i2];
                iArr2[i3] = i4;
                i4 += i5;
                i2++;
                i3++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i6 = iArr[length2];
            iArr2[length2] = i2;
            i2 += i6;
        }
    }

    public final void k(int i2, int[] iArr, int[] iArr2, boolean z) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int i6 = i2 - i4;
        if (!z) {
            int length = iArr.length;
            int i7 = 0;
            while (i3 < length) {
                int i8 = iArr[i3];
                iArr2[i7] = i6;
                i6 += i8;
                i3++;
                i7++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i9 = iArr[length2];
            iArr2[length2] = i6;
            i6 += i9;
        }
    }

    public final void l(int i2, int[] iArr, int[] iArr2, boolean z) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        float length = (iArr.length == 0) ^ true ? (i2 - i4) / iArr.length : 0.0f;
        float f2 = length / 2;
        if (z) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i6 = iArr[length2];
                iArr2[length2] = Math.round(f2);
                f2 += i6 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i7 = 0;
        while (i3 < length3) {
            int i8 = iArr[i3];
            iArr2[i7] = Math.round(f2);
            f2 += i8 + length;
            i3++;
            i7++;
        }
    }

    public final void m(int i2, int[] iArr, int[] iArr2, boolean z) {
        if (iArr.length == 0) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        float fMax = (i2 - i4) / Math.max(AbstractC10242bK.j0(iArr), 1);
        float f2 = (z && iArr.length == 1) ? fMax : 0.0f;
        if (z) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i6 = iArr[length];
                iArr2[length] = Math.round(f2);
                f2 += i6 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i7 = 0;
        while (i3 < length2) {
            int i8 = iArr[i3];
            iArr2[i7] = Math.round(f2);
            f2 += i8 + fMax;
            i3++;
            i7++;
        }
    }

    public final void n(int i2, int[] iArr, int[] iArr2, boolean z) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        float length = (i2 - i4) / (iArr.length + 1);
        if (z) {
            float f2 = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i6 = iArr[length2];
                iArr2[length2] = Math.round(f2);
                f2 += i6 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f3 = length;
        int i7 = 0;
        while (i3 < length3) {
            int i8 = iArr[i3];
            iArr2[i7] = Math.round(f3);
            f3 += i8 + length;
            i3++;
            i7++;
        }
    }

    public final f o(float f2) {
        return new j(f2, true, n.e, null);
    }

    public final e p(float f2, InterfaceC12529em.b bVar) {
        return new j(f2, true, new o(bVar), null);
    }

    public final m q(float f2, InterfaceC12529em.c cVar) {
        return new j(f2, false, new p(cVar), null);
    }
}
