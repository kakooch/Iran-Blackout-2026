package ir.nasim;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import ir.nasim.C9475a16;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.tT2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21324tT2 {
    public static final AbstractC20704sT2 a;
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(new C20095rT2(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        a = (AbstractC20704sT2) (C9475a16.g(objB) ? null : objB);
    }

    public static final Handler a(Looper looper, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    public static final AbstractC20704sT2 b(Handler handler, String str) {
        return new C20095rT2(handler, str);
    }
}
