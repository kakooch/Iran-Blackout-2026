package livekit.org.webrtc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes8.dex */
public @interface NetworkPreference {
    public static final int NEUTRAL = 0;
    public static final int NOT_PREFERRED = -1;
}
