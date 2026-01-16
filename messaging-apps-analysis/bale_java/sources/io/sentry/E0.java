package io.sentry;

import java.util.Locale;

/* loaded from: classes3.dex */
public interface E0 {

    public enum a implements E0 {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        @Override // io.sentry.E0
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    String apiName();
}
