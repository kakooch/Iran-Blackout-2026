package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes3.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object objM35constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM35constructorimpl = Result.m35constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM35constructorimpl = Result.m35constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m38isSuccessimpl(objM35constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
