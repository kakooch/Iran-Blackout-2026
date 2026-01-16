package j$.util;

import j$.time.ZonedDateTime;
import java.util.GregorianCalendar;

/* loaded from: classes2.dex */
public class DesugarGregorianCalendar {
    private DesugarGregorianCalendar() {
    }

    public static ZonedDateTime toZonedDateTime(GregorianCalendar gregorianCalendar) {
        return ZonedDateTime.t(j$.time.f.y(gregorianCalendar.getTimeInMillis()), j$.time.l.v(gregorianCalendar.getTimeZone().getID(), j$.time.l.a));
    }
}
