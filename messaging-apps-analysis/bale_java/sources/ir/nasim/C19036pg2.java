package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.pg2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C19036pg2 implements Serializable {
    private static final ConcurrentMap f = new ConcurrentHashMap(7);
    private final String a;
    private final TimeZone b;
    private final Locale c;
    private transient d[] d;
    private transient int e;

    /* renamed from: ir.nasim.pg2$a */
    private static class a implements d {
        private final char a;

        a(char c) {
            this.a = c;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 1;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.a);
        }
    }

    /* renamed from: ir.nasim.pg2$b */
    private interface b extends d {
        void c(StringBuffer stringBuffer, int i);
    }

    /* renamed from: ir.nasim.pg2$c */
    private static class c implements b {
        private final int a;
        private final int b;

        c(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.a = i;
            this.b = i2;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 4;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(this.a));
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                int i2 = this.b;
                while (true) {
                    i2--;
                    if (i2 < 2) {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                    stringBuffer.append('0');
                }
            } else {
                int length = i < 1000 ? 3 : Integer.toString(i).length();
                int i3 = this.b;
                while (true) {
                    i3--;
                    if (i3 < length) {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                    stringBuffer.append('0');
                }
            }
        }
    }

    /* renamed from: ir.nasim.pg2$d */
    private interface d {
        int a();

        void b(StringBuffer stringBuffer, Calendar calendar);
    }

    /* renamed from: ir.nasim.pg2$e */
    private static class e implements d {
        private final String a;

        e(String str) {
            this.a = str;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return this.a.length();
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.a);
        }
    }

    /* renamed from: ir.nasim.pg2$f */
    private static class f implements d {
        private final int a;
        private final String[] b;

        f(int i, String[] strArr) {
            this.a = i;
            this.b = strArr;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            int length = this.b.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.b[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.b[calendar.get(this.a)]);
        }
    }

    /* renamed from: ir.nasim.pg2$g */
    private static class g {
        private final TimeZone a;
        private final int b;
        private final Locale c;

        g(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.a = timeZone;
            if (z) {
                this.b = Integer.MIN_VALUE | i;
            } else {
                this.b = i;
            }
            this.c = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a.equals(gVar.a) && this.b == gVar.b && this.c.equals(gVar.c);
        }

        public int hashCode() {
            return (((this.b * 31) + this.c.hashCode()) * 31) + this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.pg2$h */
    private static class h implements d {
        private final Locale a;
        private final int b;
        private final String c;
        private final String d;

        h(TimeZone timeZone, Locale locale, int i) {
            this.a = locale;
            this.b = i;
            this.c = C19036pg2.n(timeZone, false, i, locale);
            this.d = C19036pg2.n(timeZone, true, i, locale);
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return Math.max(this.c.length(), this.d.length());
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(C19036pg2.n(timeZone, false, this.b, this.a));
            } else {
                stringBuffer.append(C19036pg2.n(timeZone, true, this.b, this.a));
            }
        }
    }

    /* renamed from: ir.nasim.pg2$i */
    private static class i implements d {
        static final i b = new i(true);
        static final i c = new i(false);
        final boolean a;

        i(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 5;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.a) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }
    }

    /* renamed from: ir.nasim.pg2$j */
    private static class j implements b {
        private final b a;

        j(b bVar) {
            this.a = bVar;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return this.a.a();
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.a.c(stringBuffer, leastMaximum);
        }

        @Override // ir.nasim.C19036pg2.b
        public void c(StringBuffer stringBuffer, int i) {
            this.a.c(stringBuffer, i);
        }
    }

    /* renamed from: ir.nasim.pg2$k */
    private static class k implements b {
        private final b a;

        k(b bVar) {
            this.a = bVar;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return this.a.a();
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.a.c(stringBuffer, maximum);
        }

        @Override // ir.nasim.C19036pg2.b
        public void c(StringBuffer stringBuffer, int i) {
            this.a.c(stringBuffer, i);
        }
    }

    /* renamed from: ir.nasim.pg2$l */
    private static class l implements b {
        static final l a = new l();

        l() {
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 2;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(2) + 1);
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* renamed from: ir.nasim.pg2$m */
    private static class m implements b {
        private final int a;

        m(int i) {
            this.a = i;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 2;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(this.a));
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    /* renamed from: ir.nasim.pg2$n */
    private static class n implements b {
        static final n a = new n();

        n() {
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 2;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(1) % 100);
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* renamed from: ir.nasim.pg2$o */
    private static class o implements b {
        static final o a = new o();

        o() {
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 2;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(2) + 1);
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    /* renamed from: ir.nasim.pg2$p */
    private static class p implements b {
        private final int a;

        p(int i) {
            this.a = i;
        }

        @Override // ir.nasim.C19036pg2.d
        public int a() {
            return 4;
        }

        @Override // ir.nasim.C19036pg2.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            c(stringBuffer, calendar.get(this.a));
        }

        @Override // ir.nasim.C19036pg2.b
        public final void c(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    protected C19036pg2(String str, TimeZone timeZone, Locale locale) {
        this.a = str;
        this.b = timeZone;
        this.c = locale;
        p();
    }

    private String b(Calendar calendar) {
        return a(calendar, new StringBuffer(this.e)).toString();
    }

    static String n(TimeZone timeZone, boolean z, int i2, Locale locale) {
        g gVar = new g(timeZone, z, i2, locale);
        ConcurrentMap concurrentMap = f;
        String str = (String) concurrentMap.get(gVar);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String str2 = (String) concurrentMap.putIfAbsent(gVar, displayName);
        return str2 != null ? str2 : displayName;
    }

    private void p() {
        List listR = r();
        d[] dVarArr = (d[]) listR.toArray(new d[listR.size()]);
        this.d = dVarArr;
        int length = dVarArr.length;
        int iA = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.e = iA;
                return;
            }
            iA += this.d[length].a();
        }
    }

    private GregorianCalendar q() {
        return new GregorianCalendar(this.b, this.c);
    }

    protected StringBuffer a(Calendar calendar, StringBuffer stringBuffer) {
        for (d dVar : this.d) {
            dVar.b(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public String c(long j2) {
        GregorianCalendar gregorianCalendarQ = q();
        gregorianCalendarQ.setTimeInMillis(j2);
        return b(gregorianCalendarQ);
    }

    public String d(Date date) {
        GregorianCalendar gregorianCalendarQ = q();
        gregorianCalendarQ.setTime(date);
        return b(gregorianCalendarQ);
    }

    public StringBuffer e(long j2, StringBuffer stringBuffer) {
        return j(new Date(j2), stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C19036pg2)) {
            return false;
        }
        C19036pg2 c19036pg2 = (C19036pg2) obj;
        return this.a.equals(c19036pg2.a) && this.b.equals(c19036pg2.b) && this.c.equals(c19036pg2.c);
    }

    public StringBuffer f(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return j((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return g((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return e(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public StringBuffer g(Calendar calendar, StringBuffer stringBuffer) {
        return a(calendar, stringBuffer);
    }

    public int hashCode() {
        return this.a.hashCode() + ((this.b.hashCode() + (this.c.hashCode() * 13)) * 13);
    }

    public StringBuffer j(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendarQ = q();
        gregorianCalendarQ.setTime(date);
        return a(gregorianCalendarQ, stringBuffer);
    }

    public Locale k() {
        return this.c;
    }

    public String l() {
        return this.a;
    }

    public TimeZone m() {
        return this.b;
    }

    protected List r() {
        int i2;
        int i3;
        d dVarU;
        d hVar;
        d hVar2;
        int i4;
        d fVar;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.c);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.a.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            int[] iArr = {i6};
            String strS = s(this.a, iArr);
            int i7 = iArr[i5];
            int length2 = strS.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = strS.charAt(i5);
            if (cCharAt == 'y') {
                i2 = 0;
                if (length2 == 2) {
                    hVar = n.a;
                    dVarU = hVar;
                    i3 = 1;
                } else {
                    if (length2 < 4) {
                        length2 = 4;
                    }
                    i3 = 1;
                    dVarU = u(1, length2);
                }
            } else if (cCharAt != 'z') {
                switch (cCharAt) {
                    case '\'':
                        String strSubstring = strS.substring(1);
                        dVarU = strSubstring.length() == 1 ? new a(strSubstring.charAt(0)) : new e(strSubstring);
                        i3 = 1;
                        i2 = 0;
                        break;
                    case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                        i4 = 1;
                        hVar2 = u(14, length2);
                        dVarU = hVar2;
                        i3 = i4;
                        i2 = 0;
                        break;
                    case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
                        i4 = 1;
                        hVar2 = u(4, length2);
                        dVarU = hVar2;
                        i3 = i4;
                        i2 = 0;
                        break;
                    case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                        i4 = 1;
                        hVar2 = length2 == 1 ? i.c : i.b;
                        dVarU = hVar2;
                        i3 = i4;
                        i2 = 0;
                        break;
                    case WKSRecord.Service.SWIFT_RVF /* 97 */:
                        fVar = new f(9, amPmStrings);
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 'd':
                        fVar = u(5, length2);
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 'h':
                        fVar = new j(u(10, length2));
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 'k':
                        fVar = new k(u(11, length2));
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 'm':
                        fVar = u(12, length2);
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 's':
                        fVar = u(13, length2);
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    case 'w':
                        fVar = u(3, length2);
                        dVarU = fVar;
                        i3 = 1;
                        i2 = 0;
                        break;
                    default:
                        switch (cCharAt) {
                            case WKSRecord.Service.BOOTPC /* 68 */:
                                fVar = u(6, length2);
                                dVarU = fVar;
                                i3 = 1;
                                i2 = 0;
                                break;
                            case 'E':
                                dVarU = new f(7, length2 < 4 ? shortWeekdays : weekdays);
                                i3 = 1;
                                i2 = 0;
                                break;
                            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                                fVar = u(8, length2);
                                dVarU = fVar;
                                i3 = 1;
                                i2 = 0;
                                break;
                            case 'G':
                                hVar = new f(0, eras);
                                i2 = 0;
                                dVarU = hVar;
                                i3 = 1;
                                break;
                            case 'H':
                                fVar = u(11, length2);
                                dVarU = fVar;
                                i3 = 1;
                                i2 = 0;
                                break;
                            default:
                                switch (cCharAt) {
                                    case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
                                        fVar = u(10, length2);
                                        break;
                                    case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                                        if (length2 < 4) {
                                            if (length2 != 3) {
                                                if (length2 != 2) {
                                                    fVar = o.a;
                                                    break;
                                                } else {
                                                    fVar = l.a;
                                                    break;
                                                }
                                            } else {
                                                fVar = new f(2, shortMonths);
                                                break;
                                            }
                                        } else {
                                            fVar = new f(2, months);
                                            break;
                                        }
                                    case 'M':
                                        if (length2 < 4) {
                                            if (length2 != 3) {
                                                if (length2 != 2) {
                                                    fVar = o.a;
                                                    break;
                                                } else {
                                                    fVar = l.a;
                                                    break;
                                                }
                                            } else {
                                                fVar = new f(2, shortMonths);
                                                break;
                                            }
                                        } else {
                                            fVar = new f(2, months);
                                            break;
                                        }
                                    default:
                                        throw new IllegalArgumentException("Illegal pattern component: " + strS);
                                }
                                dVarU = fVar;
                                i3 = 1;
                                i2 = 0;
                                break;
                        }
                }
            } else if (length2 >= 4) {
                i4 = 1;
                hVar2 = new h(this.b, this.c, 1);
                dVarU = hVar2;
                i3 = i4;
                i2 = 0;
            } else {
                i2 = 0;
                hVar = new h(this.b, this.c, 0);
                dVarU = hVar;
                i3 = 1;
            }
            arrayList.add(dVarU);
            i6 = i7 + i3;
            i5 = i2;
        }
        return arrayList;
    }

    protected String s(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i2);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            sb.append('\'');
            boolean z = false;
            while (i2 < length) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 != '\'') {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i2--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i3 = i2 + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i2 = i3;
                    }
                }
                i2++;
            }
        } else {
            sb.append(cCharAt);
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= length || str.charAt(i4) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i2 = i4;
            }
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public String toString() {
        return "FastDatePrinter[" + this.a + "," + this.c + "," + this.b.getID() + "]";
    }

    protected b u(int i2, int i3) {
        return i3 != 1 ? i3 != 2 ? new c(i2, i3) : new m(i2) : new p(i2);
    }
}
