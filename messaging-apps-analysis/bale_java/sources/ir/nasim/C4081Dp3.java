package ir.nasim;

/* renamed from: ir.nasim.Dp3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4081Dp3 implements R12 {
    private final b a;

    /* renamed from: ir.nasim.Dp3$a */
    public static final class a extends AbstractC3374Ap3 {
        private int c;

        public /* synthetic */ a(Object obj, K22 k22, int i, ED1 ed1) {
            this(obj, k22, i);
        }

        public final int d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(aVar.b(), b()) && AbstractC13042fc3.d(aVar.a(), a()) && OI.c(aVar.c, this.c);
        }

        public int hashCode() {
            Object objB = b();
            return ((((objB != null ? objB.hashCode() : 0) * 31) + OI.d(this.c)) * 31) + a().hashCode();
        }

        public /* synthetic */ a(Object obj, K22 k22, int i, int i2, ED1 ed1) {
            this(obj, (i2 & 2) != 0 ? T22.e() : k22, (i2 & 4) != 0 ? OI.a.a() : i, null);
        }

        private a(Object obj, K22 k22, int i) {
            super(obj, k22, null);
            this.c = i;
        }
    }

    /* renamed from: ir.nasim.Dp3$b */
    public static final class b extends AbstractC4315Ep3 {
        public b() {
            super(null);
        }

        public a f(Object obj, int i) {
            a aVar = new a(obj, null, 0, 6, null);
            c().r(i, aVar);
            return aVar;
        }
    }

    public C4081Dp3(b bVar) {
        this.a = bVar;
    }

    @Override // ir.nasim.R12, ir.nasim.InterfaceC5766Kt
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C14765iR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i;
        C16143km4 c16143km4 = new C16143km4(this.a.c().d() + 2);
        C16734lm4 c16734lm4 = new C16734lm4(this.a.c().d());
        C16734lm4 c16734lm4C = this.a.c();
        int[] iArr3 = c16734lm4C.b;
        Object[] objArr = c16734lm4C.c;
        long[] jArr3 = c16734lm4C.a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr3[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            int i7 = iArr3[i6];
                            a aVar = (a) objArr[i6];
                            c16143km4.j(i7);
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            c16734lm4.r(i7, new C14154hR7((AbstractC8151Ut) interfaceC5342Ix7.a().invoke(aVar.b()), aVar.a(), aVar.d(), null));
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                        jArr3 = jArr2;
                        iArr3 = iArr2;
                    }
                    jArr = jArr3;
                    iArr = iArr3;
                    if (i4 != i3) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    iArr = iArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                jArr3 = jArr;
                iArr3 = iArr;
            }
        }
        if (!this.a.c().a(0)) {
            c16143km4.i(0, 0);
        }
        if (!this.a.c().a(this.a.b())) {
            c16143km4.j(this.a.b());
        }
        c16143km4.o();
        return new C14765iR7(c16143km4, c16734lm4, this.a.b(), this.a.a(), T22.e(), OI.a.a(), null);
    }
}
