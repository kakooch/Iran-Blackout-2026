package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes.dex */
public final class HandlerDispatcherKt {
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

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

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object objM35constructorimpl;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Result.Companion companion = Result.Companion;
            objM35constructorimpl = Result.m35constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM35constructorimpl = Result.m35constructorimpl(ResultKt.createFailure(th));
        }
        Main = (HandlerDispatcher) (Result.m37isFailureimpl(objM35constructorimpl) ? null : objM35constructorimpl);
    }
}
