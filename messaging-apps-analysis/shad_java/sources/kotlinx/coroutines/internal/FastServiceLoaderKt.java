package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes4.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object objM542constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m545isSuccessimpl(objM542constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
