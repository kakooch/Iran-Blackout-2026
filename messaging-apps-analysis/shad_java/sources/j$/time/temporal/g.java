package j$.time.temporal;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DAY_OF_QUARTER' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
abstract class g implements l {
    public static final g DAY_OF_QUARTER;
    public static final g QUARTER_OF_YEAR;
    public static final g WEEK_BASED_YEAR;
    public static final g WEEK_OF_WEEK_BASED_YEAR;
    private static final int[] a;
    private static final /* synthetic */ g[] b;

    static {
        final String str = "DAY_OF_QUARTER";
        final int i = 0;
        g gVar = new g(str, i) { // from class: j$.time.temporal.c
            @Override // j$.time.temporal.l
            public x a() {
                return x.j(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.l
            public long c(k kVar) {
                if (!d(kVar)) {
                    throw new w("Unsupported field: DayOfQuarter");
                }
                return kVar.a(a.DAY_OF_YEAR) - g.a[((kVar.a(a.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.h.a.a(kVar.c(a.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.l
            public boolean d(k kVar) {
                return kVar.e(a.DAY_OF_YEAR) && kVar.e(a.MONTH_OF_YEAR) && kVar.e(a.YEAR) && g.g(kVar);
            }

            @Override // j$.time.temporal.g, j$.time.temporal.l
            public x e(k kVar) {
                if (!d(kVar)) {
                    throw new w("Unsupported field: DayOfQuarter");
                }
                long jC = kVar.c(g.QUARTER_OF_YEAR);
                if (jC == 1) {
                    return j$.time.chrono.h.a.a(kVar.c(a.YEAR)) ? x.i(1L, 91L) : x.i(1L, 90L);
                }
                return jC == 2 ? x.i(1L, 91L) : (jC == 3 || jC == 4) ? x.i(1L, 92L) : a();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = gVar;
        final String str2 = "QUARTER_OF_YEAR";
        final int i2 = 1;
        g gVar2 = new g(str2, i2) { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.l
            public x a() {
                return x.i(1L, 4L);
            }

            @Override // j$.time.temporal.l
            public long c(k kVar) {
                if (d(kVar)) {
                    return (kVar.c(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new w("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.l
            public boolean d(k kVar) {
                return kVar.e(a.MONTH_OF_YEAR) && g.g(kVar);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = gVar2;
        final String str3 = "WEEK_OF_WEEK_BASED_YEAR";
        final int i3 = 2;
        g gVar3 = new g(str3, i3) { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.l
            public x a() {
                return x.j(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.l
            public long c(k kVar) {
                if (d(kVar)) {
                    return g.j(j$.time.g.h(kVar));
                }
                throw new w("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean d(k kVar) {
                return kVar.e(a.EPOCH_DAY) && g.g(kVar);
            }

            @Override // j$.time.temporal.g, j$.time.temporal.l
            public x e(k kVar) {
                if (d(kVar)) {
                    return g.m(j$.time.g.h(kVar));
                }
                throw new w("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = gVar3;
        final String str4 = "WEEK_BASED_YEAR";
        final int i4 = 3;
        g gVar4 = new g(str4, i4) { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.l
            public x a() {
                return a.YEAR.a();
            }

            @Override // j$.time.temporal.l
            public long c(k kVar) {
                if (d(kVar)) {
                    return g.l(j$.time.g.h(kVar));
                }
                throw new w("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean d(k kVar) {
                return kVar.e(a.EPOCH_DAY) && g.g(kVar);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = gVar4;
        b = new g[]{gVar, gVar2, gVar3, gVar4};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    g(String str, int i, j jVar) {
    }

    static boolean g(k kVar) {
        int i = t.a;
        Object obj = (j$.time.chrono.g) kVar.d(n.a);
        if (obj == null) {
            obj = j$.time.chrono.h.a;
        }
        return ((j$.time.chrono.a) obj).equals(j$.time.chrono.h.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int j(j$.time.g r5) {
        /*
            j$.time.d r0 = r5.j()
            int r0 = r0.ordinal()
            int r1 = r5.k()
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
            j$.time.g r5 = r5.r(r0)
            r0 = -1
            j$.time.g r5 = r5.p(r0)
            j$.time.temporal.x r5 = m(r5)
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
            boolean r5 = r5.m()
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
        throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.g.j(j$.time.g):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(j$.time.g gVar) {
        int iL = gVar.l();
        int iK = gVar.k();
        if (iK <= 3) {
            return iK - gVar.j().ordinal() < -2 ? iL - 1 : iL;
        }
        if (iK >= 363) {
            return ((iK - 363) - (gVar.m() ? 1 : 0)) - gVar.j().ordinal() >= 0 ? iL + 1 : iL;
        }
        return iL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x m(j$.time.g gVar) {
        j$.time.g gVarN = j$.time.g.n(l(gVar), 1, 1);
        return x.i(1L, (gVarN.j() == j$.time.d.THURSDAY || (gVarN.j() == j$.time.d.WEDNESDAY && gVarN.m())) ? 53 : 52);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) b.clone();
    }

    @Override // j$.time.temporal.l
    public boolean b() {
        return false;
    }

    public x e(k kVar) {
        return a();
    }

    @Override // j$.time.temporal.l
    public boolean f() {
        return true;
    }
}
