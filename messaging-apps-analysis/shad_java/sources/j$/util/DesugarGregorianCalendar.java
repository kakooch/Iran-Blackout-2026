package j$.util;

import j$.time.Instant;
import j$.time.ZonedDateTime;
import java.util.GregorianCalendar;

/* loaded from: classes2.dex */
public class DesugarGregorianCalendar {
    public static ZonedDateTime toZonedDateTime(GregorianCalendar gregorianCalendar) {
        return ZonedDateTime.i(Instant.j(gregorianCalendar.getTimeInMillis()), j$.time.l.h(gregorianCalendar.getTimeZone().getID(), j$.time.l.a));
    }
}
