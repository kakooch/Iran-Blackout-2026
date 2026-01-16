package ir.nasim;

/* renamed from: ir.nasim.gc2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13659gc2 {
    public static final boolean a(Throwable th) {
        AbstractC13042fc3.i(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!AbstractC13042fc3.d(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable th) throws Throwable {
        AbstractC13042fc3.i(th, "e");
        throw th;
    }
}
