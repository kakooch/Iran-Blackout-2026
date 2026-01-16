package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public final class HandlerDispatcherKt {
    public static final Handler asHandler(Looper looper, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            if (objInvoke != null) {
                return (Handler) objInvoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    static {
        Object objM542constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th));
        }
    }
}
