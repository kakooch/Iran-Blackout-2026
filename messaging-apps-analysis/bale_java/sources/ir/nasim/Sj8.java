package ir.nasim;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* loaded from: classes3.dex */
final class Sj8 implements InterfaceC19653qi8 {
    Sj8() {
    }

    @Override // ir.nasim.InterfaceC19653qi8
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return Fi8.d(classLoader, file, file2, z, new Ki8(), "path", new Qj8());
    }

    @Override // ir.nasim.InterfaceC19653qi8
    public final void b(ClassLoader classLoader, Set set) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Jj8.c(classLoader, set);
    }
}
