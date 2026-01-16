package j$.time.temporal;

/* loaded from: classes2.dex */
public final class j {
    public static final l a;
    public static final l b;
    public static final l c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class b implements l {
        public static final b DAY_OF_QUARTER;
        public static final b QUARTER_OF_YEAR;
        public static final b WEEK_BASED_YEAR;
        public static final b WEEK_OF_WEEK_BASED_YEAR;
        private static final int[] a;
        private static final /* synthetic */ b[] b;

        enum a extends b {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // j$.time.temporal.l
            public q h() {
                return q.j(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (!n(kVar)) {
                    throw new p("Unsupported field: DayOfQuarter");
                }
                return kVar.h(h.DAY_OF_YEAR) - b.a[((kVar.h(h.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.i.a.h(kVar.l(h.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.DAY_OF_YEAR) && kVar.d(h.MONTH_OF_YEAR) && kVar.d(h.YEAR) && b.w(kVar);
            }

            @Override // j$.time.temporal.j.b, j$.time.temporal.l
            public q t(k kVar) {
                if (!n(kVar)) {
                    throw new p("Unsupported field: DayOfQuarter");
                }
                long jL = kVar.l(b.QUARTER_OF_YEAR);
                if (jL == 1) {
                    return j$.time.chrono.i.a.h(kVar.l(h.YEAR)) ? q.i(1L, 91L) : q.i(1L, 90L);
                }
                return jL == 2 ? q.i(1L, 91L) : (jL == 3 || jL == 4) ? q.i(1L, 92L) : h();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        }

        /* renamed from: j$.time.temporal.j$b$b, reason: collision with other inner class name */
        enum C0042b extends b {
            C0042b(String str, int i) {
                super(str, i, null);
            }

            @Override // j$.time.temporal.l
            public q h() {
                return q.i(1L, 4L);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return (kVar.l(h.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new p("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.MONTH_OF_YEAR) && b.w(kVar);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        }

        enum c extends b {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // j$.time.temporal.l
            public q h() {
                return q.j(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return b.z(j$.time.g.v(kVar));
                }
                throw new p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.EPOCH_DAY) && b.w(kVar);
            }

            @Override // j$.time.temporal.j.b, j$.time.temporal.l
            public q t(k kVar) {
                if (n(kVar)) {
                    return b.C(j$.time.g.v(kVar));
                }
                throw new p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        }

        enum d extends b {
            d(String str, int i) {
                super(str, i, null);
            }

            @Override // j$.time.temporal.l
            public q h() {
                return h.YEAR.h();
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return b.B(j$.time.g.v(kVar));
                }
                throw new p("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.EPOCH_DAY) && b.w(kVar);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        }

        static {
            a aVar = new a("DAY_OF_QUARTER", 0);
            DAY_OF_QUARTER = aVar;
            C0042b c0042b = new C0042b("QUARTER_OF_YEAR", 1);
            QUARTER_OF_YEAR = c0042b;
            c cVar = new c("WEEK_OF_WEEK_BASED_YEAR", 2);
            WEEK_OF_WEEK_BASED_YEAR = cVar;
            d dVar = new d("WEEK_BASED_YEAR", 3);
            WEEK_BASED_YEAR = dVar;
            b = new b[]{aVar, c0042b, cVar, dVar};
            a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        b(String str, int i, a aVar) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int B(j$.time.g gVar) {
            int iZ = gVar.z();
            int iY = gVar.y();
            if (iY <= 3) {
                return iY - gVar.x().ordinal() < -2 ? iZ - 1 : iZ;
            }
            if (iY >= 363) {
                return ((iY - 363) - (gVar.A() ? 1 : 0)) - gVar.x().ordinal() >= 0 ? iZ + 1 : iZ;
            }
            return iZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static q C(j$.time.g gVar) {
            j$.time.g gVarB = j$.time.g.B(B(gVar), 1, 1);
            return q.i(1L, (gVarB.x() == j$.time.d.THURSDAY || (gVarB.x() == j$.time.d.WEDNESDAY && gVarB.A())) ? 53 : 52);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) b.clone();
        }

        static boolean w(k kVar) {
            int i = m.a;
            j$.time.chrono.h hVar = (j$.time.chrono.h) kVar.n(j$.time.temporal.b.a);
            if (hVar == null) {
                hVar = j$.time.chrono.i.a;
            }
            return hVar.equals(j$.time.chrono.i.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static int z(j$.time.g r5) {
            /*
                j$.time.d r0 = r5.x()
                int r0 = r0.ordinal()
                int r1 = r5.y()
                r2 = 1
                int r1 = r1 - r2
                int r0 = 3 - r0
                int r0 = r0 + r1
                int r3 = r0 / 7
                int r3 = r3 * 7
                int r0 = r0 - r3
                r3 = -3
                int r0 = r0 + r3
                if (r0 >= r3) goto L1c
                int r0 = r0 + 7
            L1c:
                if (r1 >= r0) goto L34
                r0 = 180(0xb4, float:2.52E-43)
                j$.time.g r5 = r5.E(r0)
                r0 = -1
                j$.time.g r5 = r5.D(r0)
                j$.time.temporal.q r5 = C(r5)
                long r0 = r5.d()
                int r5 = (int) r0
                goto L50
            L34:
                int r1 = r1 - r0
                int r1 = r1 / 7
                int r1 = r1 + r2
                r4 = 53
                if (r1 != r4) goto L4e
                if (r0 == r3) goto L4a
                r3 = -2
                if (r0 != r3) goto L48
                boolean r5 = r5.A()
                if (r5 == 0) goto L48
                goto L4a
            L48:
                r5 = 0
                goto L4b
            L4a:
                r5 = 1
            L4b:
                if (r5 != 0) goto L4e
                goto L4f
            L4e:
                r2 = r1
            L4f:
                r5 = r2
            L50:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.j.b.z(j$.time.g):int");
        }

        @Override // j$.time.temporal.l
        public boolean j() {
            return false;
        }

        @Override // j$.time.temporal.l
        public q t(k kVar) {
            return h();
        }

        @Override // j$.time.temporal.l
        public boolean v() {
            return true;
        }
    }

    private enum c implements o {
        WEEK_BASED_YEARS("WeekBasedYears", j$.time.e.l(31556952)),
        QUARTER_YEARS("QuarterYears", j$.time.e.l(7889238));

        private final String b;

        c(String str, j$.time.e eVar) {
            this.b = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.b;
        }
    }

    static {
        b bVar = b.DAY_OF_QUARTER;
        a = b.QUARTER_OF_YEAR;
        b = b.WEEK_OF_WEEK_BASED_YEAR;
        c = b.WEEK_BASED_YEAR;
        c cVar = c.WEEK_BASED_YEARS;
        c cVar2 = c.QUARTER_YEARS;
    }
}
