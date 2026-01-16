package org.xbill.DNS;

import ir.nasim.AbstractC24620yv2;
import ir.nasim.AbstractC3900Cv2;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/* loaded from: classes8.dex */
final class FormattedTime {
    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC);

    private FormattedTime() {
    }

    public static String format(Instant instant) {
        return DEFAULT_FORMAT.format(instant);
    }

    public static Instant parse(String str) {
        if (str.length() == 14) {
            return AbstractC24620yv2.a(DEFAULT_FORMAT.parse(str, new TemporalQuery() { // from class: ir.nasim.Dv2
                @Override // java.time.temporal.TemporalQuery
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return Instant.from(temporalAccessor);
                }
            }));
        }
        if (str.length() <= 10) {
            return Instant.ofEpochSecond(Long.parseLong(str));
        }
        throw AbstractC3900Cv2.a("Invalid time encoding: ", str, 0);
    }
}
