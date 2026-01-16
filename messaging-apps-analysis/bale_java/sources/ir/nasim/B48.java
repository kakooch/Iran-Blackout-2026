package ir.nasim;

import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
final class B48 {
    private final WeakReference a;
    private final int b;
    private ClassLoader c;

    public B48(ClassLoader classLoader) {
        AbstractC13042fc3.i(classLoader, "classLoader");
        this.a = new WeakReference(classLoader);
        this.b = System.identityHashCode(classLoader);
        this.c = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.c = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof B48) && ((ClassLoader) this.a.get()) == ((ClassLoader) ((B48) obj).a.get());
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
