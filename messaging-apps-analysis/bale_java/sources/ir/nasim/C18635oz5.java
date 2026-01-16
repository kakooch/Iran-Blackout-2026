package ir.nasim;

/* renamed from: ir.nasim.oz5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18635oz5 {
    public static final C18635oz5 a = new C18635oz5();
    private static int b = 5;

    private C18635oz5() {
    }

    private final String c() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        AbstractC13042fc3.f(className);
        String strSubstring = className.substring(AbstractC20762sZ6.q0(className, '.', 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    private final boolean d() {
        return b > 0;
    }

    private final boolean e() {
        return b > 4;
    }

    public final void a(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        if (d()) {
            exc.printStackTrace();
        }
    }

    public final void b(Object obj) {
        AbstractC13042fc3.i(obj, "obj");
        if (d()) {
            C19406qI3.b("RootBeer", c() + obj);
            C19406qI3.b("QLog", c() + obj);
        }
    }

    public final void f(Object obj) {
        AbstractC13042fc3.i(obj, "obj");
        if (e()) {
            C19406qI3.i("RootBeer", c() + obj, new Object[0]);
        }
    }
}
