package io.appmetrica.analytics.profile;

import android.gov.nist.core.Separators;
import io.appmetrica.analytics.impl.C2587hb;
import io.appmetrica.analytics.impl.C2962x4;
import io.appmetrica.analytics.impl.C2993yb;
import io.appmetrica.analytics.impl.Wl;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* loaded from: classes3.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new C2587hb(), new C2993yb(new C2962x4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new C2587hb(), new C2993yb(new C2962x4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new C2587hb(), new C2993yb(new C2962x4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new Wl(200, "String attribute \"" + str + Separators.DOUBLE_QUOTE, PublicLogger.getAnonymousInstance()), new C2587hb(), new C2993yb(new C2962x4(100)));
    }

    public static GenderAttribute gender() {
        return new GenderAttribute();
    }

    public static NameAttribute name() {
        return new NameAttribute();
    }

    public static NotificationsEnabledAttribute notificationsEnabled() {
        return new NotificationsEnabledAttribute();
    }
}
