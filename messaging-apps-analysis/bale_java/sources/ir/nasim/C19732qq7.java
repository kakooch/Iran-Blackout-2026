package ir.nasim;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: ir.nasim.qq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19732qq7 {
    public static final C19732qq7 a;
    private static TimeZone b;
    private static int c;
    public static final int d;

    static {
        C19732qq7 c19732qq7 = new C19732qq7();
        a = c19732qq7;
        b = Calendar.getInstance().getTimeZone();
        c = c19732qq7.d();
        d = 8;
    }

    private C19732qq7() {
    }

    private final int a(TimeZone timeZone) {
        return timeZone.getOffset(System.currentTimeMillis()) - timeZone.getRawOffset();
    }

    public static final Date b(long j) {
        return c(new Date(j));
    }

    public static final Date c(Date date) {
        AbstractC13042fc3.i(date, "date");
        return new Date((date.getTime() < 1679344200000L || !f(date)) ? date.getTime() : date.getTime() - c);
    }

    private final int d() {
        TimeZone timeZone = b;
        AbstractC13042fc3.h(timeZone, "defaultTimeZone");
        if (!h(timeZone)) {
            return 0;
        }
        TimeZone timeZone2 = b;
        AbstractC13042fc3.h(timeZone2, "defaultTimeZone");
        return a(timeZone2);
    }

    public static final long e(long j) {
        return b(j).getTime();
    }

    public static final boolean f(Date date) {
        AbstractC13042fc3.i(date, "date");
        return b.inDaylightTime(date);
    }

    public static final void g() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        if (AbstractC13042fc3.d(timeZone.getID(), b.getID())) {
            return;
        }
        b = timeZone;
        c = a.d();
    }

    private final boolean h(TimeZone timeZone) {
        return AbstractC10242bK.U(new String[]{EnumC20932sq7.d.j().getID(), EnumC20932sq7.c.j().getID()}, timeZone.getID());
    }
}
