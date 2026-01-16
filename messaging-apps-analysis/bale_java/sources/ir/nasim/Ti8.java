package ir.nasim;

import com.google.android.play.core.splitinstall.internal.zzbh;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
abstract class Ti8 implements InterfaceC19653qi8 {
    public static void c(ClassLoader classLoader, Set set, Pi8 pi8) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((File) it.next()).getParentFile());
        }
        Object objC = Fi8.c(classLoader);
        com.google.android.play.core.splitinstall.internal.b bVarB = com.google.android.play.core.splitinstall.internal.c.b(objC, "nativeLibraryDirectories", List.class);
        synchronized (As8.class) {
            ArrayList arrayList = new ArrayList((Collection) bVarB.a());
            hashSet.removeAll(arrayList);
            arrayList.addAll(hashSet);
            bVarB.c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Object[] objArrA = pi8.a(objC, new ArrayList(hashSet), null, arrayList2);
        if (arrayList2.isEmpty()) {
            synchronized (As8.class) {
                com.google.android.play.core.splitinstall.internal.c.a(objC, "nativeLibraryPathElements", Object.class).e(Arrays.asList(objArrA));
            }
            return;
        }
        zzbh zzbhVar = new zzbh("Error in makePathElements");
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            try {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, (IOException) arrayList2.get(i));
            } catch (Exception unused) {
            }
        }
        throw zzbhVar;
    }

    public static boolean d(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return Fi8.d(classLoader, file, file2, z, new Ki8(), "zip", new C23316wi8());
    }
}
