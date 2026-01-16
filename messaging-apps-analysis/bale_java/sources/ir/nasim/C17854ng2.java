package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.ng2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17854ng2 implements Serializable {
    private final String a;
    private final TimeZone b;
    private final Locale c;
    private final int d;
    private final int e;
    private transient Pattern f;
    private transient g[] g;
    private transient String h;
    private transient g i;
    static final Locale j = new Locale("ja", "JP", "JP");
    private static final Pattern k = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|L+|S+|W+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    private static final ConcurrentMap[] l = new ConcurrentMap[17];
    private static final g m = new a(1);
    private static final g n = new b(2);
    private static final g o = new f(1);
    private static final g p = new f(3);
    private static final g q = new f(4);
    private static final g r = new f(6);
    private static final g s = new f(5);
    private static final g t = new f(8);
    private static final g u = new f(11);
    private static final g v = new c(11);
    private static final g w = new d(10);
    private static final g x = new f(10);
    private static final g y = new f(12);
    private static final g z = new f(13);
    private static final g A = new f(14);

    /* renamed from: ir.nasim.ng2$a */
    class a extends f {
        a(int i) {
            super(i);
        }

        @Override // ir.nasim.C17854ng2.f, ir.nasim.C17854ng2.g
        void c(C17854ng2 c17854ng2, Calendar calendar, String str) throws NumberFormatException {
            int iD = Integer.parseInt(str);
            if (iD < 100) {
                iD = c17854ng2.d(iD);
            }
            calendar.set(1, iD);
        }
    }

    /* renamed from: ir.nasim.ng2$b */
    class b extends f {
        b(int i) {
            super(i);
        }

        @Override // ir.nasim.C17854ng2.f
        int d(int i) {
            return i - 1;
        }
    }

    /* renamed from: ir.nasim.ng2$c */
    class c extends f {
        c(int i) {
            super(i);
        }

        @Override // ir.nasim.C17854ng2.f
        int d(int i) {
            return i % 24;
        }
    }

    /* renamed from: ir.nasim.ng2$d */
    class d extends f {
        d(int i) {
            super(i);
        }

        @Override // ir.nasim.C17854ng2.f
        int d(int i) {
            return i % 12;
        }
    }

    /* renamed from: ir.nasim.ng2$e */
    private static class e extends g {
        private final String a;

        e(String str) {
            super();
            this.a = str;
        }

        @Override // ir.nasim.C17854ng2.g
        boolean a(C17854ng2 c17854ng2, StringBuilder sb) {
            C17854ng2.e(sb, this.a, true);
            return false;
        }

        @Override // ir.nasim.C17854ng2.g
        boolean b() {
            char cCharAt = this.a.charAt(0);
            if (cCharAt == '\'') {
                cCharAt = this.a.charAt(1);
            }
            return Character.isDigit(cCharAt);
        }
    }

    /* renamed from: ir.nasim.ng2$h */
    private static class h extends g {
        private final int a;
        private final Map b;

        h(int i, Calendar calendar, Locale locale) {
            super();
            this.a = i;
            this.b = C17854ng2.j(i, calendar, locale);
        }

        @Override // ir.nasim.C17854ng2.g
        boolean a(C17854ng2 c17854ng2, StringBuilder sb) {
            sb.append('(');
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                C17854ng2.e(sb, (String) it.next(), false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            return true;
        }

        @Override // ir.nasim.C17854ng2.g
        void c(C17854ng2 c17854ng2, Calendar calendar, String str) {
            Integer num = (Integer) this.b.get(str);
            if (num != null) {
                calendar.set(this.a, num.intValue());
                return;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append(" not in (");
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(' ');
            }
            sb.setCharAt(sb.length() - 1, ')');
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: ir.nasim.ng2$i */
    private static class i extends g {
        private final String a;
        private final SortedMap b;

        i(Locale locale) {
            super();
            this.b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(strArr[0]);
                    if (!this.b.containsKey(strArr[1])) {
                        this.b.put(strArr[1], timeZone);
                    }
                    if (!this.b.containsKey(strArr[2])) {
                        this.b.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.b.containsKey(strArr[3])) {
                            this.b.put(strArr[3], timeZone);
                        }
                        if (!this.b.containsKey(strArr[4])) {
                            this.b.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                C17854ng2.e(sb, (String) it.next(), false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            this.a = sb.toString();
        }

        @Override // ir.nasim.C17854ng2.g
        boolean a(C17854ng2 c17854ng2, StringBuilder sb) {
            sb.append(this.a);
            return true;
        }

        @Override // ir.nasim.C17854ng2.g
        void c(C17854ng2 c17854ng2, Calendar calendar, String str) {
            TimeZone timeZone;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                timeZone = TimeZone.getTimeZone("GMT" + str);
            } else if (str.startsWith("GMT")) {
                timeZone = TimeZone.getTimeZone(str);
            } else {
                timeZone = (TimeZone) this.b.get(str);
                if (timeZone == null) {
                    throw new IllegalArgumentException(str + " is not a supported timezone name");
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    protected C17854ng2(String str, TimeZone timeZone, Locale locale, Date date) {
        int i2;
        this.a = str;
        this.b = timeZone;
        this.c = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i2 = calendar.get(1);
        } else if (locale.equals(j)) {
            i2 = 0;
        } else {
            calendar.setTime(new Date());
            i2 = calendar.get(1) - 80;
        }
        int i3 = (i2 / 100) * 100;
        this.d = i3;
        this.e = i2 - i3;
        p(calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i2) {
        int i3 = this.d + i2;
        return i2 >= this.e ? i3 : i3 + 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder e(StringBuilder sb, String str, boolean z2) {
        sb.append("\\Q");
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\'') {
                if (cCharAt == '\\' && (i2 = i2 + 1) != str.length()) {
                    sb.append(cCharAt);
                    cCharAt = str.charAt(i2);
                    if (cCharAt == 'E') {
                        sb.append("E\\\\E\\");
                        cCharAt = 'Q';
                    }
                }
            } else if (z2) {
                i2++;
                if (i2 == str.length()) {
                    return sb;
                }
                cCharAt = str.charAt(i2);
            } else {
                continue;
            }
            sb.append(cCharAt);
            i2++;
        }
        sb.append("\\E");
        return sb;
    }

    private static ConcurrentMap f(int i2) {
        ConcurrentMap concurrentMap;
        ConcurrentMap[] concurrentMapArr = l;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i2] == null) {
                    concurrentMapArr[i2] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i2];
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentMap;
    }

    private static String[] g(int i2, boolean z2, Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        if (i2 == 0) {
            return dateFormatSymbols.getEras();
        }
        if (i2 == 2) {
            return z2 ? dateFormatSymbols.getMonths() : dateFormatSymbols.getShortMonths();
        }
        if (i2 == 7) {
            return z2 ? dateFormatSymbols.getWeekdays() : dateFormatSymbols.getShortWeekdays();
        }
        if (i2 != 9) {
            return null;
        }
        return dateFormatSymbols.getAmPmStrings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map j(int i2, Calendar calendar, Locale locale) {
        return k(i2, locale);
    }

    private static Map k(int i2, Locale locale) {
        HashMap map = new HashMap();
        q(map, g(i2, false, locale));
        q(map, g(i2, true, locale));
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    private g m(int i2, Calendar calendar) {
        ConcurrentMap concurrentMapF = f(i2);
        g iVar = (g) concurrentMapF.get(this.c);
        if (iVar == null) {
            iVar = i2 == 15 ? new i(this.c) : new h(i2, calendar, this.c);
            g gVar = (g) concurrentMapF.putIfAbsent(this.c, iVar);
            if (gVar != null) {
                return gVar;
            }
        }
        return iVar;
    }

    private g n(String str, Calendar calendar) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'y') {
            return str.length() > 2 ? o : m;
        }
        if (cCharAt != 'z') {
            switch (cCharAt) {
                case '\'':
                    if (str.length() > 2) {
                        return new e(str.substring(1, str.length() - 1));
                    }
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                    return A;
                case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
                    return q;
                case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                    break;
                case WKSRecord.Service.SWIFT_RVF /* 97 */:
                    return m(9, calendar);
                case 'd':
                    return s;
                case 'h':
                    return w;
                case 'k':
                    return u;
                case 'm':
                    return y;
                case 's':
                    return z;
                case 'w':
                    return p;
                default:
                    switch (cCharAt) {
                        case WKSRecord.Service.BOOTPC /* 68 */:
                            return r;
                        case 'E':
                            return m(7, calendar);
                        case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                            return t;
                        case 'G':
                            return m(0, calendar);
                        case 'H':
                            return v;
                        default:
                            switch (cCharAt) {
                                case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
                                    return x;
                                case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                                case 'M':
                                    return str.length() >= 3 ? m(2, calendar) : n;
                            }
                    }
            }
            return new e(str);
        }
        return m(15, calendar);
    }

    private void p(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = k.matcher(this.a);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("Illegal pattern character '" + this.a.charAt(matcher.regionStart()) + Separators.QUOTE);
        }
        String strGroup = matcher.group();
        this.h = strGroup;
        g gVarN = n(strGroup, calendar);
        while (true) {
            matcher.region(matcher.end(), matcher.regionEnd());
            if (!matcher.lookingAt()) {
                break;
            }
            String strGroup2 = matcher.group();
            this.i = n(strGroup2, calendar);
            if (gVarN.a(this, sb)) {
                arrayList.add(gVarN);
            }
            this.h = strGroup2;
            gVarN = this.i;
        }
        this.i = null;
        if (matcher.regionStart() == matcher.regionEnd()) {
            if (gVarN.a(this, sb)) {
                arrayList.add(gVarN);
            }
            this.h = null;
            this.g = (g[]) arrayList.toArray(new g[arrayList.size()]);
            this.f = Pattern.compile(sb.toString());
            return;
        }
        throw new IllegalArgumentException("Failed to parse \"" + this.a + "\" ; gave up at index " + matcher.regionStart());
    }

    private static void q(Map map, String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str != null && str.length() > 0) {
                map.put(strArr[i2], Integer.valueOf(i2));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C17854ng2)) {
            return false;
        }
        C17854ng2 c17854ng2 = (C17854ng2) obj;
        return this.a.equals(c17854ng2.a) && this.b.equals(c17854ng2.b) && this.c.equals(c17854ng2.c);
    }

    public int hashCode() {
        return this.a.hashCode() + ((this.b.hashCode() + (this.c.hashCode() * 13)) * 13);
    }

    int l() {
        return this.h.length();
    }

    boolean r() {
        g gVar = this.i;
        return gVar != null && gVar.b();
    }

    public Date s(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Matcher matcher = this.f.matcher(str.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(this.b, this.c);
        calendar.clear();
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.g;
            if (i2 >= gVarArr.length) {
                parsePosition.setIndex(index + matcher.end());
                return calendar.getTime();
            }
            int i3 = i2 + 1;
            gVarArr[i2].c(this, calendar, matcher.group(i3));
            i2 = i3;
        }
    }

    public String toString() {
        return "FastDateParser[" + this.a + "," + this.c + "," + this.b.getID() + "]";
    }

    public Object u(String str, ParsePosition parsePosition) {
        return s(str, parsePosition);
    }

    /* renamed from: ir.nasim.ng2$f */
    private static class f extends g {
        private final int a;

        f(int i) {
            super();
            this.a = i;
        }

        @Override // ir.nasim.C17854ng2.g
        boolean a(C17854ng2 c17854ng2, StringBuilder sb) {
            if (!c17854ng2.r()) {
                sb.append("(\\p{Nd}++)");
                return true;
            }
            sb.append("(\\p{Nd}{");
            sb.append(c17854ng2.l());
            sb.append("}+)");
            return true;
        }

        @Override // ir.nasim.C17854ng2.g
        boolean b() {
            return true;
        }

        @Override // ir.nasim.C17854ng2.g
        void c(C17854ng2 c17854ng2, Calendar calendar, String str) {
            calendar.set(this.a, d(Integer.parseInt(str)));
        }

        int d(int i) {
            return i;
        }
    }

    /* renamed from: ir.nasim.ng2$g */
    private static abstract class g {
        private g() {
        }

        abstract boolean a(C17854ng2 c17854ng2, StringBuilder sb);

        boolean b() {
            return false;
        }

        void c(C17854ng2 c17854ng2, Calendar calendar, String str) {
        }
    }
}
