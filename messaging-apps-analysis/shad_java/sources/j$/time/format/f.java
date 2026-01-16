package j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f {
    public static final /* synthetic */ int f = 0;
    private f a;
    private final f b;
    private final List c;
    private final boolean d;
    private int e;

    static final class a implements g {
        private final g[] a;
        private final boolean b;

        a(List list, boolean z) {
            this.a = (g[]) list.toArray(new g[list.size()]);
            this.b = z;
        }

        a(g[] gVarArr, boolean z) {
            this.a = gVarArr;
            this.b = z;
        }

        @Override // j$.time.format.g
        public boolean a(q qVar, StringBuilder sb) {
            int length = sb.length();
            if (this.b) {
                qVar.g();
            }
            try {
                for (g gVar : this.a) {
                    if (!gVar.a(qVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.b) {
                    qVar.a();
                }
                return true;
            } finally {
                if (this.b) {
                    qVar.a();
                }
            }
        }

        public a b(boolean z) {
            return z == this.b ? this : new a(this.a, z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append(this.b ? "[" : "(");
                for (g gVar : this.a) {
                    sb.append(gVar);
                }
                sb.append(this.b ? "]" : ")");
            }
            return sb.toString();
        }
    }

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.l lVar = j$.time.temporal.i.a;
        map.put('Q', lVar);
        map.put('q', lVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
    }

    public f() {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = null;
        this.d = false;
    }

    private f(f fVar, boolean z) {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = fVar;
        this.d = z;
    }

    private int d(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("pp");
        }
        f fVar = this.a;
        fVar.getClass();
        fVar.c.add(gVar);
        this.a.e = -1;
        return r2.c.size() - 1;
    }

    private f j(j jVar) {
        j jVarC;
        f fVar = this.a;
        int i = fVar.e;
        if (i >= 0) {
            j jVar2 = (j) fVar.c.get(i);
            if (jVar.b == jVar.c && jVar.d == t.NOT_NEGATIVE) {
                jVarC = jVar2.d(jVar.c);
                d(jVar.c());
                this.a.e = i;
            } else {
                jVarC = jVar2.c();
                this.a.e = d(jVar);
            }
            this.a.c.set(i, jVarC);
        } else {
            fVar.e = d(jVar);
        }
        return this;
    }

    public f a(DateTimeFormatter dateTimeFormatter) {
        d(dateTimeFormatter.f(false));
        return this;
    }

    public f b(j$.time.temporal.l lVar, int i, int i2, boolean z) {
        d(new h(lVar, i, i2, z));
        return this;
    }

    public f c() {
        d(new i(-2));
        return this;
    }

    public f e(char c) {
        d(new e(c));
        return this;
    }

    public f f(String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new e(str.charAt(0)) : new m(str));
        }
        return this;
    }

    public f g(String str, String str2) {
        d(new k(str, str2));
        return this;
    }

    public f h() {
        d(k.d);
        return this;
    }

    public f i(j$.time.temporal.l lVar, Map map) {
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        u uVar = u.FULL;
        d(new n(lVar, uVar, new b(this, new r(Collections.singletonMap(uVar, linkedHashMap)))));
        return this;
    }

    public f k(j$.time.temporal.l lVar, int i) {
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        if (i >= 1 && i <= 19) {
            j(new j(lVar, i, i, t.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
    }

    public f l(j$.time.temporal.l lVar, int i, int i2, t tVar) {
        if (i == i2 && tVar == t.NOT_NEGATIVE) {
            k(lVar, i2);
            return this;
        }
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        if (tVar == null) {
            throw new NullPointerException("signStyle");
        }
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i2 >= i) {
            j(new j(lVar, i, i2, tVar));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    public f m() {
        d(new o(j$.time.format.a.a, "ZoneRegionId()"));
        return this;
    }

    public f n() {
        f fVar = this.a;
        if (fVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (fVar.c.size() > 0) {
            f fVar2 = this.a;
            a aVar = new a(fVar2.c, fVar2.d);
            this.a = this.a.b;
            d(aVar);
        } else {
            this.a = this.a.b;
        }
        return this;
    }

    public f o() {
        f fVar = this.a;
        fVar.e = -1;
        this.a = new f(fVar, true);
        return this;
    }

    public f p() {
        d(l.INSENSITIVE);
        return this;
    }

    public f q() {
        d(l.SENSITIVE);
        return this;
    }

    public f r() {
        d(l.LENIENT);
        return this;
    }

    DateTimeFormatter s(int i, j$.time.chrono.g gVar) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        while (this.a.b != null) {
            n();
        }
        return new DateTimeFormatter(new a(this.c, false), locale, s.a, i, null, gVar, null);
    }
}
