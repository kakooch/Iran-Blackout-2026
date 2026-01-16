package ir.nasim;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* loaded from: classes3.dex */
final class Jj8 implements InterfaceC19653qi8 {
    Jj8() {
    }

    static void c(ClassLoader classLoader, Set set) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Ti8.c(classLoader, set, new Ej8());
    }

    static boolean d(ClassLoader classLoader, File file, File file2, boolean z) {
        return Fi8.d(classLoader, file, file2, z, new Ki8(), "path", new Hj8());
    }

    @Override // ir.nasim.InterfaceC19653qi8
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z);
    }

    @Override // ir.nasim.InterfaceC19653qi8
    public final void b(ClassLoader classLoader, Set set) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c(classLoader, set);
    }
}
