package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C9475a16;
import ir.nasim.PI7;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: ir.nasim.iA1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14593iA1 {
    public static final C14593iA1 a;
    private static boolean b;
    private static Locale c;
    private static SimpleDateFormat d;
    private static DateFormat e;
    private static SimpleDateFormat f;
    public static final int g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.iA1$a */
    private static final class a {
        public static final a c = new a("January", 0, AbstractC12217eE5.all_months_january_compact, AbstractC12217eE5.all_months_january);
        public static final a d = new a("February", 1, AbstractC12217eE5.all_months_february_compact, AbstractC12217eE5.all_months_february);
        public static final a e = new a("March", 2, AbstractC12217eE5.all_months_march_compact, AbstractC12217eE5.all_months_march);
        public static final a f = new a("April", 3, AbstractC12217eE5.all_months_april_compact, AbstractC12217eE5.all_months_april);
        public static final a g = new a("May", 4, AbstractC12217eE5.all_months_may_compact, AbstractC12217eE5.all_months_may);
        public static final a h = new a("June", 5, AbstractC12217eE5.all_months_june_compact, AbstractC12217eE5.all_months_june);
        public static final a i = new a("July", 6, AbstractC12217eE5.all_months_july_compact, AbstractC12217eE5.all_months_july);
        public static final a j = new a("August", 7, AbstractC12217eE5.all_months_august_compact, AbstractC12217eE5.all_months_august);
        public static final a k = new a("September", 8, AbstractC12217eE5.all_months_september_compact, AbstractC12217eE5.all_months_september);
        public static final a l = new a("October", 9, AbstractC12217eE5.all_months_october_compact, AbstractC12217eE5.all_months_october);
        public static final a m = new a("November", 10, AbstractC12217eE5.all_months_november_compact, AbstractC12217eE5.all_months_november);
        public static final a n = new a("December", 11, AbstractC12217eE5.all_months_december_compact, AbstractC12217eE5.all_months_december);
        private static final /* synthetic */ a[] o;
        private static final /* synthetic */ F92 p;
        private final int a;
        private final int b;

        static {
            a[] aVarArrA = a();
            o = aVarArrA;
            p = G92.a(aVarArrA);
        }

        private a(String str, int i2, int i3, int i4) {
            this.a = i3;
            this.b = i4;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{c, d, e, f, g, h, i, j, k, l, m, n};
        }

        public static F92 j() {
            return p;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) o.clone();
        }

        public final int p() {
            return this.b;
        }

        public final int q() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.iA1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PI7.a.values().length];
            try {
                iArr[PI7.a.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PI7.a.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        C14593iA1 c14593iA1 = new C14593iA1();
        a = c14593iA1;
        b = c14593iA1.E(PH3.e());
        c = Locale.getDefault();
        d = c14593iA1.c();
        e = c14593iA1.b();
        f = c14593iA1.d();
        g = 8;
    }

    private C14593iA1() {
    }

    public static final String A(long j) {
        String str = d.format(Long.valueOf(a.e(j)));
        AbstractC13042fc3.h(str, "format(...)");
        return XY6.v(str);
    }

    private final String B(long j) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(f.format(Long.valueOf(e(j))));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            C14593iA1 c14593iA1 = a;
            objB = c14593iA1.d().format(Long.valueOf(c14593iA1.e(j)));
        }
        AbstractC13042fc3.h(objB, "getOrElse(...)");
        return (String) objB;
    }

    private final Calendar C(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        AbstractC13042fc3.h(calendar, "apply(...)");
        return calendar;
    }

    private final C17428mw7 D(long j) {
        Calendar calendarC = C(j);
        return new C17428mw7(Integer.valueOf(calendarC.get(1)), Integer.valueOf(calendarC.get(2) + 1), Integer.valueOf(calendarC.get(5)));
    }

    private final boolean E(String str) {
        if (str != null) {
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (!AbstractC13042fc3.d(lowerCase, "fa")) {
                Locale locale2 = Locale.getDefault();
                AbstractC13042fc3.h(locale2, "getDefault(...)");
                String lowerCase2 = str.toLowerCase(locale2);
                AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                if (!AbstractC13042fc3.d(lowerCase2, "ks")) {
                    return false;
                }
            }
        }
        return true;
    }

    private final String F(PI7 pi7, Context context, boolean z) {
        return pi7.w() ? R(pi7.r(), context) : S(pi7.r(), context, z);
    }

    private final String G(Context context, int i, boolean z) {
        if (i < 0 || i >= 12) {
            throw new IllegalArgumentException();
        }
        a aVar = (a) a.j().get(i);
        String string = context.getString(z ? aVar.q() : aVar.p());
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public static final void H() {
        Locale locale = Locale.getDefault();
        if (AbstractC13042fc3.d(c, locale)) {
            return;
        }
        c = locale;
        C14593iA1 c14593iA1 = a;
        d = c14593iA1.c();
        e = c14593iA1.b();
        f = c14593iA1.d();
        b = c14593iA1.E(PH3.e());
    }

    private static final boolean I(long j) {
        C14593iA1 c14593iA1 = a;
        C17428mw7 c17428mw7D = c14593iA1.D(c14593iA1.e(j));
        int iIntValue = ((Number) c17428mw7D.a()).intValue();
        int iIntValue2 = ((Number) c17428mw7D.b()).intValue();
        int iIntValue3 = ((Number) c17428mw7D.c()).intValue();
        C17428mw7 c17428mw7D2 = c14593iA1.D(c14593iA1.e(c14593iA1.N()));
        return iIntValue2 == ((Number) c17428mw7D2.b()).intValue() && iIntValue == ((Number) c17428mw7D2.a()).intValue() && ((Number) c17428mw7D2.c()).intValue() - iIntValue3 < 7;
    }

    public static final boolean J(long j, long j2) {
        C14593iA1 c14593iA1 = a;
        C17428mw7 c17428mw7D = c14593iA1.D(c14593iA1.e(j));
        int iIntValue = ((Number) c17428mw7D.a()).intValue();
        int iIntValue2 = ((Number) c17428mw7D.b()).intValue();
        int iIntValue3 = ((Number) c17428mw7D.c()).intValue();
        C17428mw7 c17428mw7D2 = c14593iA1.D(c14593iA1.e(j2));
        return iIntValue3 == ((Number) c17428mw7D2.c()).intValue() && iIntValue2 == ((Number) c17428mw7D2.b()).intValue() && iIntValue == ((Number) c17428mw7D2.a()).intValue();
    }

    public static final boolean K(long j, long j2) {
        C14593iA1 c14593iA1 = a;
        C17428mw7 c17428mw7D = c14593iA1.D(c14593iA1.e(j));
        int iIntValue = ((Number) c17428mw7D.a()).intValue();
        int iIntValue2 = ((Number) c17428mw7D.b()).intValue();
        ((Number) c17428mw7D.c()).intValue();
        C17428mw7 c17428mw7D2 = c14593iA1.D(c14593iA1.e(j2));
        int iIntValue3 = ((Number) c17428mw7D2.a()).intValue();
        int iIntValue4 = ((Number) c17428mw7D2.b()).intValue();
        ((Number) c17428mw7D2.c()).intValue();
        if (!b) {
            return iIntValue2 == iIntValue4 && iIntValue == iIntValue3;
        }
        C45 c45 = new C45(Long.valueOf(j));
        C45 c452 = new C45(Long.valueOf(j2));
        return AbstractC13042fc3.d(c45.H(), c452.H()) && c45.y() == c452.y();
    }

    public static final boolean L(long j) {
        return J(j, a.N());
    }

    public static final boolean M(long j) {
        return L(j + 86400000);
    }

    private final long N() {
        return AbstractC20507s76.p();
    }

    public static final String O(Context context, long j) {
        AbstractC13042fc3.i(context, "context");
        if (L(j)) {
            return A(j);
        }
        if (M(j)) {
            String string = context.getString(AbstractC12217eE5.all_time_unit_yesterday_compact);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (!I(j)) {
            return p(context, j, false, false, 12, null);
        }
        C14593iA1 c14593iA1 = a;
        return c14593iA1.B(c14593iA1.e(j));
    }

    private final String P(int i) {
        switch (i) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                throw new IllegalArgumentException();
        }
    }

    private final String Q(long j) {
        return XY6.v(String.valueOf(j));
    }

    private final String R(long j, Context context) {
        long jN = N() - j;
        if (0 <= jN && jN < 172800001) {
            String string = context.getString(AbstractC12217eE5.dialog_presence_recently);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (172800000 <= jN && jN < 604800000) {
            String string2 = context.getString(AbstractC12217eE5.dialog_presence_timestamp_weeks_ago);
            AbstractC13042fc3.f(string2);
            return string2;
        }
        if (604800000 > jN || jN >= 2419200001L) {
            String string3 = context.getString(AbstractC12217eE5.dialog_presence_timestamp_long_time_ago);
            AbstractC13042fc3.h(string3, "getString(...)");
            return string3;
        }
        String string4 = context.getString(AbstractC12217eE5.dialog_presence_timestamp_month_ago);
        AbstractC13042fc3.f(string4);
        return string4;
    }

    private final String S(long j, Context context, boolean z) {
        C14593iA1 c14593iA1 = a;
        long jN = c14593iA1.N() - j;
        String string = (jN >= 60000 || z) ? (60000 > jN || jN >= 3540001 || z) ? L(j) ? context.getString(AbstractC12217eE5.user_hase_been_here_at, A(j)) : M(j) ? context.getString(AbstractC12217eE5.user_hase_been_here_yesterday_at, A(j)) : jN <= 604800000 ? c14593iA1.m(j, context) : jN <= 2419200000L ? context.getString(AbstractC12217eE5.user_hase_been_here_at, o(context, j, true, false)) : context.getString(AbstractC12217eE5.dialog_presence_timestamp_long_time_ago) : context.getString(AbstractC12217eE5.user_hase_been_here_minutes_ago, Integer.valueOf((int) Math.ceil(jN / 60000))) : context.getString(AbstractC12217eE5.user_hase_been_here_less_than_a_minute);
        AbstractC13042fc3.h(string, "run(...)");
        return string;
    }

    private final String a(int i) {
        DY6 dy6 = DY6.a;
        String str = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        AbstractC13042fc3.h(str, "format(...)");
        return str;
    }

    private final DateFormat b() {
        DateFormat dateInstance = DateFormat.getDateInstance(3, c);
        AbstractC13042fc3.h(dateInstance, "getDateInstance(...)");
        return dateInstance;
    }

    private final SimpleDateFormat c() {
        return new SimpleDateFormat("HH:mm", c);
    }

    private final SimpleDateFormat d() {
        return new SimpleDateFormat("EEE", c);
    }

    private final long e(long j) {
        return C19732qq7.b(j).getTime();
    }

    public static final String f(Context context, long j) {
        AbstractC13042fc3.i(context, "context");
        return h(context, j, false, 4, null);
    }

    public static final String g(Context context, long j, boolean z) {
        AbstractC13042fc3.i(context, "context");
        C14593iA1 c14593iA1 = a;
        Date date = new Date(c14593iA1.e(j));
        C17428mw7 c17428mw7D = c14593iA1.D(date.getTime());
        ((Number) c17428mw7D.a()).intValue();
        int iIntValue = ((Number) c17428mw7D.b()).intValue();
        int iIntValue2 = ((Number) c17428mw7D.c()).intValue();
        if (b) {
            return c14593iA1.u(j, !z);
        }
        if (!z) {
            String str = e.format(date);
            AbstractC13042fc3.f(str);
            return str;
        }
        return c14593iA1.G(context, iIntValue - 1, true) + Separators.SP + c14593iA1.a(iIntValue2);
    }

    public static /* synthetic */ String h(Context context, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return g(context, j, z);
    }

    public static final String i(Context context, long j, boolean z) {
        AbstractC13042fc3.i(context, "context");
        C14593iA1 c14593iA1 = a;
        long jN = c14593iA1.N() - j;
        if (jN < 60000) {
            String string = context.getString(AbstractC12217eE5.all_time_unit_now);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (jN < 3600000) {
            return AbstractC20655sN7.c(context, z ? AbstractC12217eE5.all_time_unit_minutes_compact : AbstractC12217eE5.all_time_unit_minutes, c14593iA1.Q(jN / 60000));
        }
        if (jN < 172800000) {
            return AbstractC20655sN7.c(context, z ? AbstractC12217eE5.all_time_unit_hours_compact : AbstractC12217eE5.all_time_unit_hours, c14593iA1.Q(jN / 3600000));
        }
        return AbstractC20655sN7.c(context, AbstractC12217eE5.all_time_unit_days, c14593iA1.Q(jN / 86400000));
    }

    public static /* synthetic */ String j(Context context, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return i(context, j, z);
    }

    public static final String k(Context context, long j, boolean z) {
        AbstractC13042fc3.i(context, "context");
        C14593iA1 c14593iA1 = a;
        long jN = c14593iA1.N() - j;
        if (jN < 60000) {
            String string = context.getString(AbstractC12217eE5.all_time_unit_now);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (jN < 3600000) {
            return AbstractC20655sN7.c(context, z ? AbstractC12217eE5.all_time_unit_minutes_compact : AbstractC12217eE5.all_time_unit_minutes, c14593iA1.Q(jN / 60000));
        }
        if (jN < 86400000) {
            return AbstractC20655sN7.c(context, z ? AbstractC12217eE5.all_time_unit_hours_compact : AbstractC12217eE5.all_time_unit_hours, c14593iA1.Q(jN / 3600000));
        }
        if (jN < 172800000) {
            String string2 = context.getString(z ? AbstractC12217eE5.all_time_unit_yesterday_compact : AbstractC12217eE5.all_time_unit_yesterday);
            AbstractC13042fc3.f(string2);
            return string2;
        }
        return g(context, j, z) + " . " + A(j);
    }

    public static /* synthetic */ String l(Context context, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return k(context, j, z);
    }

    private final String m(long j, Context context) {
        String string = context.getString(AbstractC12217eE5.user_hase_been_here_this_week_at, b ? new C45(new Date(j)).j() : P(C(j).get(7)), p(context, j, false, false, 8, null));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public static final String o(Context context, long j, boolean z, boolean z2) {
        AbstractC13042fc3.i(context, "context");
        C14593iA1 c14593iA1 = a;
        C17428mw7 c17428mw7D = c14593iA1.D(c14593iA1.e(j));
        int iIntValue = ((Number) c17428mw7D.a()).intValue();
        int iIntValue2 = ((Number) c17428mw7D.b()).intValue();
        int iIntValue3 = ((Number) c17428mw7D.c()).intValue();
        C17428mw7 c17428mw7D2 = c14593iA1.D(c14593iA1.e(c14593iA1.N()));
        int iIntValue4 = ((Number) c17428mw7D2.a()).intValue();
        ((Number) c17428mw7D2.b()).intValue();
        ((Number) c17428mw7D2.c()).intValue();
        boolean z3 = false;
        if (b) {
            int iY = new C45(Long.valueOf(j)).y();
            int iY2 = new C45(Long.valueOf(c14593iA1.N())).y();
            if (z && iY2 > iY) {
                z3 = true;
            }
            return z2 ? c14593iA1.v(j, z3) : c14593iA1.u(j, z3);
        }
        boolean z4 = z && iIntValue4 > iIntValue;
        String strG = c14593iA1.G(context, iIntValue2 - 1, false);
        String strA = c14593iA1.a(iIntValue3);
        if (!z4) {
            if (z2) {
                return String.valueOf(strG);
            }
            return strG + Separators.SP + strA;
        }
        if (z2) {
            return strG + Separators.SP + iIntValue;
        }
        return strG + Separators.SP + strA + ", " + iIntValue;
    }

    public static /* synthetic */ String p(Context context, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return o(context, j, z, z2);
    }

    public static final String q(Context context, long j) {
        AbstractC13042fc3.i(context, "context");
        if (L(j)) {
            return A(j);
        }
        if (M(j)) {
            String string = context.getString(AbstractC12217eE5.all_time_unit_yesterday_compact);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (I(j)) {
            return a.B(j);
        }
        C14593iA1 c14593iA1 = a;
        return g(context, j, !(c14593iA1.C(c14593iA1.e(j)).get(1) < c14593iA1.C(c14593iA1.N()).get(1)));
    }

    public static final String r(Context context, long j, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (L(j)) {
            return A(j);
        }
        if (!M(j)) {
            return p(context, j, z, false, 8, null);
        }
        String string = context.getString(AbstractC12217eE5.dialog_presence_timestamp_yesterday);
        AbstractC13042fc3.f(string);
        return string;
    }

    public static /* synthetic */ String s(Context context, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return r(context, j, z);
    }

    public static final String t(Context context, long j, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (L(j)) {
            String string = context.getString(AbstractC12217eE5.dialog_presence_timestamp_today);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (!M(j)) {
            return p(context, j, z, false, 8, null);
        }
        String string2 = context.getString(AbstractC12217eE5.dialog_presence_timestamp_yesterday);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final String u(long j, boolean z) {
        String str;
        C45 c45 = new C45(Long.valueOf(j));
        if (z) {
            str = c45.w() + Separators.SP + c45.H() + Separators.SP + c45.y();
        } else {
            str = c45.w() + Separators.SP + c45.H();
        }
        return XY6.v(str);
    }

    private final String v(long j, boolean z) {
        String strH;
        C45 c45 = new C45(Long.valueOf(j));
        if (z) {
            strH = c45.H() + Separators.SP + c45.y();
        } else {
            strH = c45.H();
        }
        AbstractC13042fc3.f(strH);
        return XY6.v(strH);
    }

    public static final String w(Context context, PI7 pi7) {
        AbstractC13042fc3.i(context, "context");
        return y(context, pi7, false, 4, null);
    }

    public static final String x(Context context, PI7 pi7, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (pi7 == null) {
            return "";
        }
        PI7.a aVarU = pi7.u();
        int i = aVarU == null ? -1 : b.a[aVarU.ordinal()];
        if (i == 1) {
            return a.F(pi7, context, z);
        }
        if (i != 2) {
            return "";
        }
        String string = context.getString(AbstractC12217eE5.dialog_presence_online);
        AbstractC13042fc3.f(string);
        return string;
    }

    public static /* synthetic */ String y(Context context, PI7 pi7, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return x(context, pi7, z);
    }

    private final String z(long j, Context context) {
        String string = context.getString(AbstractC12217eE5.reaction_set_someday, b ? new C45(new Date(j)).j() : P(C(j).get(7)), p(context, j, false, false, 8, null));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public final String T(long j, Context context) {
        AbstractC13042fc3.i(context, "context");
        long j2 = j * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        C14593iA1 c14593iA1 = a;
        long jN = c14593iA1.N() - j2;
        String string = jN < 60000 ? context.getString(AbstractC12217eE5.reaction_set_less_minutes_ago) : (60000 > jN || jN >= 3540001) ? L(j2) ? context.getString(AbstractC12217eE5.reaction_set_today, A(j2)) : M(j2) ? context.getString(AbstractC12217eE5.reaction_set_yesterday, A(j2)) : jN <= 604800000 ? c14593iA1.z(j2, context) : jN <= 2419200000L ? context.getString(AbstractC12217eE5.reaction_set_some_month, o(context, j2, true, false)) : context.getString(AbstractC12217eE5.reaction_set_long_time_ago) : context.getString(AbstractC12217eE5.reaction_set_minutes_ago, Long.valueOf(jN / 60000));
        AbstractC13042fc3.h(string, "run(...)");
        return XY6.v(string);
    }

    public final String n(long j) {
        String strA = H45.a(new C45(Long.valueOf(j)), "l j F H:i");
        AbstractC13042fc3.h(strA, "format(...)");
        return strA;
    }
}
