package ir.nasim;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: ir.nasim.Xo, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8840Xo extends L0 implements InterfaceC14371ho1 {
    private volatile Object _preHandler;

    public C8840Xo() {
        super(InterfaceC14371ho1.h0);
        this._preHandler = this;
    }

    private final Method x0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // ir.nasim.InterfaceC14371ho1
    public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
        int i = Build.VERSION.SDK_INT;
        if (26 > i || i >= 28) {
            return;
        }
        Method methodX0 = x0();
        Object objInvoke = methodX0 != null ? methodX0.invoke(null, null) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}
