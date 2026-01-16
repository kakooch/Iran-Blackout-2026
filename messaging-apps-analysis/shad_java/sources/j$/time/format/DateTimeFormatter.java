package j$.time.format;

import j$.time.format.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter f;
    private final f.a a;
    private final Locale b;
    private final s c;
    private final j$.time.chrono.g d;
    private final j$.time.l e;

    static {
        f fVar = new f();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        t tVar = t.EXCEEDS_PAD;
        f fVarL = fVar.l(aVar, 4, 10, tVar);
        fVarL.e('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        fVarL.k(aVar2, 2);
        fVarL.e('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        fVarL.k(aVar3, 2);
        j$.time.chrono.h hVar = j$.time.chrono.h.a;
        DateTimeFormatter dateTimeFormatterS = fVarL.s(1, hVar);
        ISO_LOCAL_DATE = dateTimeFormatterS;
        f fVar2 = new f();
        fVar2.p();
        fVar2.a(dateTimeFormatterS);
        fVar2.h();
        fVar2.s(1, hVar);
        f fVar3 = new f();
        fVar3.p();
        fVar3.a(dateTimeFormatterS);
        fVar3.o();
        fVar3.h();
        fVar3.s(1, hVar);
        f fVar4 = new f();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        fVar4.k(aVar4, 2);
        fVar4.e(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        fVar4.k(aVar5, 2);
        fVar4.o();
        fVar4.e(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        fVar4.k(aVar6, 2);
        fVar4.o();
        fVar4.b(j$.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterS2 = fVar4.s(1, null);
        f fVar5 = new f();
        fVar5.p();
        fVar5.a(dateTimeFormatterS2);
        fVar5.h();
        fVar5.s(1, null);
        f fVar6 = new f();
        fVar6.p();
        fVar6.a(dateTimeFormatterS2);
        fVar6.o();
        fVar6.h();
        fVar6.s(1, null);
        f fVar7 = new f();
        fVar7.p();
        fVar7.a(dateTimeFormatterS);
        fVar7.e('T');
        fVar7.a(dateTimeFormatterS2);
        DateTimeFormatter dateTimeFormatterS3 = fVar7.s(1, hVar);
        f fVar8 = new f();
        fVar8.p();
        fVar8.a(dateTimeFormatterS3);
        fVar8.h();
        DateTimeFormatter dateTimeFormatterS4 = fVar8.s(1, hVar);
        f fVar9 = new f();
        fVar9.a(dateTimeFormatterS4);
        fVar9.o();
        fVar9.e('[');
        fVar9.q();
        fVar9.m();
        fVar9.e(']');
        fVar9.s(1, hVar);
        f fVar10 = new f();
        fVar10.a(dateTimeFormatterS3);
        fVar10.o();
        fVar10.h();
        fVar10.o();
        fVar10.e('[');
        fVar10.q();
        fVar10.m();
        fVar10.e(']');
        fVar10.s(1, hVar);
        f fVar11 = new f();
        fVar11.p();
        f fVarL2 = fVar11.l(aVar, 4, 10, tVar);
        fVarL2.e('-');
        fVarL2.k(j$.time.temporal.a.DAY_OF_YEAR, 3);
        fVarL2.o();
        fVarL2.h();
        fVarL2.s(1, hVar);
        f fVar12 = new f();
        fVar12.p();
        f fVarL3 = fVar12.l(j$.time.temporal.i.c, 4, 10, tVar);
        fVarL3.f("-W");
        fVarL3.k(j$.time.temporal.i.b, 2);
        fVarL3.e('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        fVarL3.k(aVar7, 1);
        fVarL3.o();
        fVarL3.h();
        fVarL3.s(1, hVar);
        f fVar13 = new f();
        fVar13.p();
        fVar13.c();
        f = fVar13.s(1, null);
        f fVar14 = new f();
        fVar14.p();
        fVar14.k(aVar, 4);
        fVar14.k(aVar2, 2);
        fVar14.k(aVar3, 2);
        fVar14.o();
        fVar14.g("+HHMMss", "Z");
        fVar14.s(1, hVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        f fVar15 = new f();
        fVar15.p();
        fVar15.r();
        fVar15.o();
        fVar15.i(aVar7, map);
        fVar15.f(", ");
        fVar15.n();
        f fVarL4 = fVar15.l(aVar3, 1, 2, t.NOT_NEGATIVE);
        fVarL4.e(' ');
        fVarL4.i(aVar2, map2);
        fVarL4.e(' ');
        fVarL4.k(aVar, 4);
        fVarL4.e(' ');
        fVarL4.k(aVar4, 2);
        fVarL4.e(':');
        fVarL4.k(aVar5, 2);
        fVarL4.o();
        fVarL4.e(':');
        fVarL4.k(aVar6, 2);
        fVarL4.n();
        fVarL4.e(' ');
        fVarL4.g("+HHMM", "GMT");
        fVarL4.s(2, hVar);
    }

    DateTimeFormatter(f.a aVar, Locale locale, s sVar, int i, Set set, j$.time.chrono.g gVar, j$.time.l lVar) {
        if (aVar == null) {
            throw new NullPointerException("printerParser");
        }
        this.a = aVar;
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        this.b = locale;
        if (sVar == null) {
            throw new NullPointerException("decimalStyle");
        }
        this.c = sVar;
        if (i == 0) {
            throw new NullPointerException("resolverStyle");
        }
        this.d = gVar;
        this.e = lVar;
    }

    public String a(j$.time.temporal.k kVar) {
        StringBuilder sb = new StringBuilder(32);
        try {
            this.a.a(new q(kVar, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new j$.time.c(e.getMessage(), e);
        }
    }

    public j$.time.chrono.g b() {
        return this.d;
    }

    public s c() {
        return this.c;
    }

    public Locale d() {
        return this.b;
    }

    public j$.time.l e() {
        return this.e;
    }

    f.a f(boolean z) {
        return this.a.b(z);
    }

    public String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }
}
