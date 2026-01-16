package j$.time.format;

import j$.time.format.f;
import j$.time.m;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {
    public static final /* synthetic */ int a = 0;
    private c b;
    private final c c;
    private final List d;
    private final boolean e;
    private int f;

    class a extends j$.time.format.f {
        final /* synthetic */ f.b c;

        a(c cVar, f.b bVar) {
            this.c = bVar;
        }
    }

    static final class b implements d {
        private final char a;

        b(char c) {
            this.a = c;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            sb.append(this.a);
            return true;
        }

        public String toString() {
            if (this.a == '\'') {
                return "''";
            }
            StringBuilder sbA = j$.com.android.tools.r8.a.a("'");
            sbA.append(this.a);
            sbA.append("'");
            return sbA.toString();
        }
    }

    /* renamed from: j$.time.format.c$c, reason: collision with other inner class name */
    static final class C0041c implements d {
        private final d[] a;
        private final boolean b;

        C0041c(List list, boolean z) {
            this.a = (d[]) list.toArray(new d[list.size()]);
            this.b = z;
        }

        C0041c(d[] dVarArr, boolean z) {
            this.a = dVarArr;
            this.b = z;
        }

        public C0041c a(boolean z) {
            return z == this.b ? this : new C0041c(this.a, z);
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            int length = sb.length();
            if (this.b) {
                eVar.g();
            }
            try {
                for (d dVar : this.a) {
                    if (!dVar.h(eVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.b) {
                    eVar.a();
                }
                return true;
            } finally {
                if (this.b) {
                    eVar.a();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append(this.b ? "[" : "(");
                for (d dVar : this.a) {
                    sb.append(dVar);
                }
                sb.append(this.b ? "]" : ")");
            }
            return sb.toString();
        }
    }

    interface d {
        boolean h(j$.time.format.e eVar, StringBuilder sb);
    }

    static final class e implements d {
        private final j$.time.temporal.l a;
        private final int b;
        private final int c;
        private final boolean d;

        e(j$.time.temporal.l lVar, int i, int i2, boolean z) {
            if (lVar == null) {
                throw new NullPointerException("field");
            }
            if (!lVar.h().f()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + lVar);
            }
            if (i < 0 || i > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
            }
            if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
            }
            if (i2 >= i) {
                this.a = lVar;
                this.b = i;
                this.c = i2;
                this.d = z;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(this.a);
            if (lE == null) {
                return false;
            }
            j$.time.format.g gVarB = eVar.b();
            long jLongValue = lE.longValue();
            q qVarH = this.a.h();
            qVarH.b(jLongValue, this.a);
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(qVarH.e());
            BigDecimal bigDecimalDivide = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(qVarH.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimalStripTrailingZeros = bigDecimalDivide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimalDivide.stripTrailingZeros();
            if (bigDecimalStripTrailingZeros.scale() != 0) {
                String strA = gVarB.a(bigDecimalStripTrailingZeros.setScale(Math.min(Math.max(bigDecimalStripTrailingZeros.scale(), this.b), this.c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.d) {
                    sb.append(gVarB.b());
                }
                sb.append(strA);
                return true;
            }
            if (this.b <= 0) {
                return true;
            }
            if (this.d) {
                sb.append(gVarB.b());
            }
            for (int i = 0; i < this.b; i++) {
                sb.append(gVarB.e());
            }
            return true;
        }

        public String toString() {
            String str = this.d ? ",DecimalPoint" : "";
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Fraction(");
            sbA.append(this.a);
            sbA.append(",");
            sbA.append(this.b);
            sbA.append(",");
            sbA.append(this.c);
            sbA.append(str);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static final class f implements d {
        f(int i) {
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(j$.time.temporal.h.INSTANT_SECONDS);
            j$.time.temporal.k kVarD = eVar.d();
            j$.time.temporal.h hVar = j$.time.temporal.h.NANO_OF_SECOND;
            Long lValueOf = kVarD.d(hVar) ? Long.valueOf(eVar.d().l(hVar)) : null;
            int i = 0;
            if (lE == null) {
                return false;
            }
            long jLongValue = lE.longValue();
            int iW = hVar.w(lValueOf != null ? lValueOf.longValue() : 0L);
            if (jLongValue >= -62167219200L) {
                long j = (jLongValue - 315569520000L) + 62167219200L;
                long jA = j$.time.a.A(j, 315569520000L) + 1;
                j$.time.h hVarA = j$.time.h.A(j$.time.a.z(j, 315569520000L) - 62167219200L, 0, m.d);
                if (jA > 0) {
                    sb.append('+');
                    sb.append(jA);
                }
                sb.append(hVarA);
                if (hVarA.w() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = jLongValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                j$.time.h hVarA2 = j$.time.h.A(j4 - 62167219200L, 0, m.d);
                int length = sb.length();
                sb.append(hVarA2);
                if (hVarA2.w() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (hVarA2.x() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            if (iW > 0) {
                sb.append('.');
                int i2 = 100000000;
                while (true) {
                    if (iW <= 0 && i % 3 == 0 && i >= -2) {
                        break;
                    }
                    int i3 = iW / i2;
                    sb.append((char) (i3 + 48));
                    iW -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    static class g implements d {
        static final long[] a = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
        final j$.time.temporal.l b;
        final int c;
        final int d;
        private final j$.time.format.i e;
        final int f;

        g(j$.time.temporal.l lVar, int i, int i2, j$.time.format.i iVar) {
            this.b = lVar;
            this.c = i;
            this.d = i2;
            this.e = iVar;
            this.f = 0;
        }

        protected g(j$.time.temporal.l lVar, int i, int i2, j$.time.format.i iVar, int i3) {
            this.b = lVar;
            this.c = i;
            this.d = i2;
            this.e = iVar;
            this.f = i3;
        }

        g b() {
            return this.f == -1 ? this : new g(this.b, this.c, this.d, this.e, -1);
        }

        g c(int i) {
            return new g(this.b, this.c, this.d, this.e, this.f + i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        
            if (r4 != 4) goto L40;
         */
        @Override // j$.time.format.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean h(j$.time.format.e r12, java.lang.StringBuilder r13) {
            /*
                r11 = this;
                j$.time.temporal.l r0 = r11.b
                java.lang.Long r0 = r12.e(r0)
                r1 = 0
                if (r0 != 0) goto La
                return r1
            La:
                long r2 = r0.longValue()
                j$.time.format.g r12 = r12.b()
                r4 = -9223372036854775808
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L1b
                java.lang.String r0 = "9223372036854775808"
                goto L23
            L1b:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r0 = java.lang.Long.toString(r4)
            L23:
                int r4 = r0.length()
                int r5 = r11.d
                java.lang.String r6 = " cannot be printed as the value "
                java.lang.String r7 = "Field "
                if (r4 > r5) goto L9f
                java.lang.String r0 = r12.a(r0)
                r4 = 0
                r8 = 4
                r9 = 1
                int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                j$.time.format.i r4 = r11.e
                int r4 = r4.ordinal()
                if (r10 < 0) goto L59
                if (r4 == r9) goto L54
                if (r4 == r8) goto L46
                goto L88
            L46:
                int r4 = r11.c
                r5 = 19
                if (r4 >= r5) goto L88
                long[] r5 = j$.time.format.c.g.a
                r4 = r5[r4]
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L88
            L54:
                char r2 = r12.d()
                goto L85
            L59:
                if (r4 == 0) goto L81
                if (r4 == r9) goto L81
                r5 = 3
                if (r4 == r5) goto L63
                if (r4 == r8) goto L81
                goto L88
            L63:
                j$.time.c r12 = new j$.time.c
                java.lang.StringBuilder r13 = j$.com.android.tools.r8.a.a(r7)
                j$.time.temporal.l r0 = r11.b
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " cannot be negative according to the SignStyle"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L81:
                char r2 = r12.c()
            L85:
                r13.append(r2)
            L88:
                int r2 = r11.c
                int r3 = r0.length()
                int r2 = r2 - r3
                if (r1 >= r2) goto L9b
                char r2 = r12.e()
                r13.append(r2)
                int r1 = r1 + 1
                goto L88
            L9b:
                r13.append(r0)
                return r9
            L9f:
                j$.time.c r12 = new j$.time.c
                java.lang.StringBuilder r13 = j$.com.android.tools.r8.a.a(r7)
                j$.time.temporal.l r0 = r11.b
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " exceeds the maximum print width of "
                r13.append(r0)
                int r0 = r11.d
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                goto Lc3
            Lc2:
                throw r12
            Lc3:
                goto Lc2
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.c.g.h(j$.time.format.e, java.lang.StringBuilder):boolean");
        }

        public String toString() {
            StringBuilder sbA;
            Object obj;
            int i = this.c;
            if (i == 1 && this.d == 19 && this.e == j$.time.format.i.NORMAL) {
                sbA = j$.com.android.tools.r8.a.a("Value(");
                obj = this.b;
            } else {
                if (i == this.d && this.e == j$.time.format.i.NOT_NEGATIVE) {
                    sbA = j$.com.android.tools.r8.a.a("Value(");
                    sbA.append(this.b);
                    sbA.append(",");
                    sbA.append(this.c);
                    sbA.append(")");
                    return sbA.toString();
                }
                sbA = j$.com.android.tools.r8.a.a("Value(");
                sbA.append(this.b);
                sbA.append(",");
                sbA.append(this.c);
                sbA.append(",");
                sbA.append(this.d);
                sbA.append(",");
                obj = this.e;
            }
            sbA.append(obj);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static final class h implements d {
        static final String[] a = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final h b = new h("+HH:MM:ss", "Z");
        private final String c;
        private final int d;

        static {
            new h("+HH:MM:ss", "0");
        }

        h(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("pattern");
            }
            if (str2 == null) {
                throw new NullPointerException("noOffsetText");
            }
            int i = 0;
            while (true) {
                String[] strArr = a;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i].equals(str)) {
                    this.d = i;
                    this.c = str2;
                    return;
                }
                i++;
            }
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(j$.time.temporal.h.OFFSET_SECONDS);
            if (lE == null) {
                return false;
            }
            long jLongValue = lE.longValue();
            int i = (int) jLongValue;
            if (jLongValue != i) {
                throw new ArithmeticException();
            }
            if (i == 0) {
                sb.append(this.c);
            } else {
                int iAbs = Math.abs((i / 3600) % 100);
                int iAbs2 = Math.abs((i / 60) % 60);
                int iAbs3 = Math.abs(i % 60);
                int length = sb.length();
                sb.append(i < 0 ? "-" : "+");
                sb.append((char) ((iAbs / 10) + 48));
                sb.append((char) ((iAbs % 10) + 48));
                int i2 = this.d;
                if (i2 >= 3 || (i2 >= 1 && iAbs2 > 0)) {
                    sb.append(i2 % 2 == 0 ? ":" : "");
                    sb.append((char) ((iAbs2 / 10) + 48));
                    sb.append((char) ((iAbs2 % 10) + 48));
                    iAbs += iAbs2;
                    int i3 = this.d;
                    if (i3 >= 7 || (i3 >= 5 && iAbs3 > 0)) {
                        sb.append(i3 % 2 != 0 ? "" : ":");
                        sb.append((char) ((iAbs3 / 10) + 48));
                        sb.append((char) ((iAbs3 % 10) + 48));
                        iAbs += iAbs3;
                    }
                }
                if (iAbs == 0) {
                    sb.setLength(length);
                    sb.append(this.c);
                }
            }
            return true;
        }

        public String toString() {
            String strReplace = this.c.replace("'", "''");
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Offset(");
            sbA.append(a[this.d]);
            sbA.append(",'");
            sbA.append(strReplace);
            sbA.append("')");
            return sbA.toString();
        }
    }

    enum i implements d {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (iOrdinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (iOrdinal == 2) {
                return "ParseStrict(true)";
            }
            if (iOrdinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class j implements d {
        private final String a;

        j(String str) {
            this.a = str;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            sb.append(this.a);
            return true;
        }

        public String toString() {
            return "'" + this.a.replace("'", "''") + "'";
        }
    }

    static final class k implements d {
        private final j$.time.temporal.l a;
        private final j$.time.format.j b;
        private final j$.time.format.f c;
        private volatile g d;

        k(j$.time.temporal.l lVar, j$.time.format.j jVar, j$.time.format.f fVar) {
            this.a = lVar;
            this.b = jVar;
            this.c = fVar;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            String strA;
            j$.time.chrono.i iVar;
            Long lE = eVar.e(this.a);
            if (lE == null) {
                return false;
            }
            j$.time.temporal.k kVarD = eVar.d();
            int i = j$.time.temporal.m.a;
            j$.time.chrono.h hVar = (j$.time.chrono.h) kVarD.n(j$.time.temporal.b.a);
            if (hVar == null || hVar == (iVar = j$.time.chrono.i.a)) {
                j$.time.format.f fVar = this.c;
                long jLongValue = lE.longValue();
                j$.time.format.j jVar = this.b;
                eVar.c();
                strA = ((a) fVar).c.a(jLongValue, jVar);
            } else {
                j$.time.format.f fVar2 = this.c;
                j$.time.temporal.l lVar = this.a;
                long jLongValue2 = lE.longValue();
                j$.time.format.j jVar2 = this.b;
                eVar.c();
                fVar2.getClass();
                strA = (hVar == iVar || !(lVar instanceof j$.time.temporal.h)) ? ((a) fVar2).c.a(jLongValue2, jVar2) : null;
            }
            if (strA != null) {
                sb.append(strA);
                return true;
            }
            if (this.d == null) {
                this.d = new g(this.a, 1, 19, j$.time.format.i.NORMAL);
            }
            return this.d.h(eVar, sb);
        }

        public String toString() {
            StringBuilder sbA;
            Object obj;
            if (this.b == j$.time.format.j.FULL) {
                sbA = j$.com.android.tools.r8.a.a("Text(");
                obj = this.a;
            } else {
                sbA = j$.com.android.tools.r8.a.a("Text(");
                sbA.append(this.a);
                sbA.append(",");
                obj = this.b;
            }
            sbA.append(obj);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static class l implements d {
        l(n nVar, String str) {
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            j$.time.l lVar = (j$.time.l) eVar.f(j$.time.format.a.a);
            if (lVar == null) {
                return false;
            }
            sb.append(lVar.g());
            return true;
        }

        public String toString() {
            return "ZoneRegionId()";
        }
    }

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.h.ERA);
        map.put('y', j$.time.temporal.h.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.h.YEAR);
        j$.time.temporal.l lVar = j$.time.temporal.j.a;
        map.put('Q', lVar);
        map.put('q', lVar);
        j$.time.temporal.h hVar = j$.time.temporal.h.MONTH_OF_YEAR;
        map.put('M', hVar);
        map.put('L', hVar);
        map.put('D', j$.time.temporal.h.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.h.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.h.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.h hVar2 = j$.time.temporal.h.DAY_OF_WEEK;
        map.put('E', hVar2);
        map.put('c', hVar2);
        map.put('e', hVar2);
        map.put('a', j$.time.temporal.h.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.h.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.h.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.h.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.h.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.h.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.h.SECOND_OF_MINUTE);
        j$.time.temporal.h hVar3 = j$.time.temporal.h.NANO_OF_SECOND;
        map.put('S', hVar3);
        map.put('A', j$.time.temporal.h.MILLI_OF_DAY);
        map.put('n', hVar3);
        map.put('N', j$.time.temporal.h.NANO_OF_DAY);
    }

    public c() {
        this.b = this;
        this.d = new ArrayList();
        this.f = -1;
        this.c = null;
        this.e = false;
    }

    private c(c cVar, boolean z) {
        this.b = this;
        this.d = new ArrayList();
        this.f = -1;
        this.c = cVar;
        this.e = z;
    }

    private int d(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("pp");
        }
        c cVar = this.b;
        cVar.getClass();
        cVar.d.add(dVar);
        this.b.f = -1;
        return r2.d.size() - 1;
    }

    private c j(g gVar) {
        g gVarB;
        c cVar = this.b;
        int i2 = cVar.f;
        if (i2 >= 0) {
            g gVar2 = (g) cVar.d.get(i2);
            if (gVar.c == gVar.d && gVar.e == j$.time.format.i.NOT_NEGATIVE) {
                gVarB = gVar2.c(gVar.d);
                d(gVar.b());
                this.b.f = i2;
            } else {
                gVarB = gVar2.b();
                this.b.f = d(gVar);
            }
            this.b.d.set(i2, gVarB);
        } else {
            cVar.f = d(gVar);
        }
        return this;
    }

    public c a(j$.time.format.b bVar) {
        d(bVar.f(false));
        return this;
    }

    public c b(j$.time.temporal.l lVar, int i2, int i3, boolean z) {
        d(new e(lVar, i2, i3, z));
        return this;
    }

    public c c() {
        d(new f(-2));
        return this;
    }

    public c e(char c) {
        d(new b(c));
        return this;
    }

    public c f(String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new b(str.charAt(0)) : new j(str));
        }
        return this;
    }

    public c g(String str, String str2) {
        d(new h(str, str2));
        return this;
    }

    public c h() {
        d(h.b);
        return this;
    }

    public c i(j$.time.temporal.l lVar, Map map) {
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        j$.time.format.j jVar = j$.time.format.j.FULL;
        d(new k(lVar, jVar, new a(this, new f.b(Collections.singletonMap(jVar, linkedHashMap)))));
        return this;
    }

    public c k(j$.time.temporal.l lVar, int i2) {
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        if (i2 >= 1 && i2 <= 19) {
            j(new g(lVar, i2, i2, j$.time.format.i.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
    }

    public c l(j$.time.temporal.l lVar, int i2, int i3, j$.time.format.i iVar) {
        if (i2 == i3 && iVar == j$.time.format.i.NOT_NEGATIVE) {
            k(lVar, i3);
            return this;
        }
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        if (iVar == null) {
            throw new NullPointerException("signStyle");
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        }
        if (i3 >= i2) {
            j(new g(lVar, i2, i3, iVar));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    public c m() {
        d(new l(j$.time.format.a.a, "ZoneRegionId()"));
        return this;
    }

    public c n() {
        c cVar = this.b;
        if (cVar.c == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (cVar.d.size() > 0) {
            c cVar2 = this.b;
            C0041c c0041c = new C0041c(cVar2.d, cVar2.e);
            this.b = this.b.c;
            d(c0041c);
        } else {
            this.b = this.b.c;
        }
        return this;
    }

    public c o() {
        c cVar = this.b;
        cVar.f = -1;
        this.b = new c(cVar, true);
        return this;
    }

    public c p() {
        d(i.INSENSITIVE);
        return this;
    }

    public c q() {
        d(i.SENSITIVE);
        return this;
    }

    public c r() {
        d(i.LENIENT);
        return this;
    }

    j$.time.format.b s(j$.time.format.h hVar, j$.time.chrono.h hVar2) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        while (this.b.c != null) {
            n();
        }
        return new j$.time.format.b(new C0041c(this.d, false), locale, j$.time.format.g.a, hVar, null, hVar2, null);
    }
}
