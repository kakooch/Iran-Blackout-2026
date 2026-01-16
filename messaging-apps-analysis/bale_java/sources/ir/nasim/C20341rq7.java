package ir.nasim;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: ir.nasim.rq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20341rq7 {
    public static final C20341rq7 a;
    private static TimeZone b;
    private static int c;

    static {
        C20341rq7 c20341rq7 = new C20341rq7();
        a = c20341rq7;
        b = Calendar.getInstance().getTimeZone();
        c = c20341rq7.d();
    }

    private C20341rq7() {
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
        if (!g(timeZone)) {
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

    private final boolean g(TimeZone timeZone) {
        return AbstractC10242bK.U(new String[]{EnumC21619tq7.d.j().getID(), EnumC21619tq7.c.j().getID()}, timeZone.getID());
    }
}
