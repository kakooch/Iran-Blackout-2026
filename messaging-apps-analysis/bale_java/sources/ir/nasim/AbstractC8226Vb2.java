package ir.nasim;

/* renamed from: ir.nasim.Vb2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8226Vb2 {
    public static final Throwable a = new a();

    public static NullPointerException a(String str) {
        return new NullPointerException(c(str));
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw a(str);
    }

    public static String c(String str) {
        return str + " Null values are generally not allowed in 3.x operators and sources.";
    }

    public static RuntimeException d(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    /* renamed from: ir.nasim.Vb2$a */
    static final class a extends Throwable {
        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
