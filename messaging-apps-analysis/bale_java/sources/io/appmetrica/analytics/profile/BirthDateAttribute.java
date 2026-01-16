package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.C2978xk;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.Ph;
import io.appmetrica.analytics.impl.R2;
import io.appmetrica.analytics.impl.U7;
import io.appmetrica.analytics.impl.V7;
import io.appmetrica.analytics.impl.Xl;
import io.appmetrica.analytics.impl.Yj;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class BirthDateAttribute {
    private final C2797q6 a = new C2797q6("appmetrica_birth_date", new V7(), new C2978xk());

    BirthDateAttribute() {
    }

    final UserProfileUpdate a(Calendar calendar, String str, R2 r2) {
        return new UserProfileUpdate(new Xl(this.a.c, new SimpleDateFormat(str).format(calendar.getTime()), new U7(), new V7(), r2));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new D4(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Yj(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new D4(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Yj(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueReset() {
        return new UserProfileUpdate<>(new Ph(0, this.a.c, new V7(), new C2978xk()));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new D4(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Yj(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new D4(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Yj(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new D4(this.a.b));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Yj(this.a.b));
    }
}
