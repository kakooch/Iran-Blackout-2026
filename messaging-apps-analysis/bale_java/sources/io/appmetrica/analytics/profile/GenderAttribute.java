package io.appmetrica.analytics.profile;

import android.gov.nist.javax.sip.parser.TokenNames;
import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.C2978xk;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.Ph;
import io.appmetrica.analytics.impl.U7;
import io.appmetrica.analytics.impl.V7;
import io.appmetrica.analytics.impl.Xl;
import io.appmetrica.analytics.impl.Yj;

/* loaded from: classes3.dex */
public class GenderAttribute {
    private final C2797q6 a = new C2797q6("appmetrica_gender", new V7(), new C2978xk());

    public enum Gender {
        MALE(TokenNames.M),
        FEMALE(TokenNames.F),
        OTHER(TokenNames.O);

        private final String a;

        Gender(String str) {
            this.a = str;
        }

        public String getStringValue() {
            return this.a;
        }
    }

    GenderAttribute() {
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValue(Gender gender) {
        String str = this.a.c;
        String stringValue = gender.getStringValue();
        U7 u7 = new U7();
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new Xl(str, stringValue, u7, c2797q6.a, new D4(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueIfUndefined(Gender gender) {
        String str = this.a.c;
        String stringValue = gender.getStringValue();
        U7 u7 = new U7();
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new Xl(str, stringValue, u7, c2797q6.a, new Yj(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueReset() {
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new Ph(0, c2797q6.c, c2797q6.a, c2797q6.b));
    }
}
