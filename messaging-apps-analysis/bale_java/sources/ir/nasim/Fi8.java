package ir.nasim;

import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbh;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
abstract class Fi8 implements InterfaceC19653qi8 {
    static Object c(ClassLoader classLoader) {
        return com.google.android.play.core.splitinstall.internal.c.b(classLoader, "pathList", Object.class).a();
    }

    static boolean d(ClassLoader classLoader, File file, File file2, boolean z, Ci8 ci8, String str, InterfaceC25090zi8 interfaceC25090zi8) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        Object objC = c(classLoader);
        com.google.android.play.core.splitinstall.internal.a aVarA = com.google.android.play.core.splitinstall.internal.c.a(objC, "dexElements", Object.class);
        List listAsList = Arrays.asList((Object[]) aVarA.a());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList2.add((File) com.google.android.play.core.splitinstall.internal.c.b(it.next(), str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (!z && !interfaceC25090zi8.a(objC, file2, file)) {
            Log.w("SplitCompat", "Should be optimized ".concat(String.valueOf(file2.getPath())));
            return false;
        }
        aVarA.d(Arrays.asList(ci8.a(objC, new ArrayList(Collections.singleton(file2)), file, arrayList)));
        if (arrayList.isEmpty()) {
            return true;
        }
        zzbh zzbhVar = new zzbh("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            IOException iOException = (IOException) arrayList.get(i);
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
            try {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, iOException);
            } catch (Exception unused) {
            }
        }
        com.google.android.play.core.splitinstall.internal.c.a(objC, "dexElementsSuppressedExceptions", IOException.class).d(arrayList);
        throw zzbhVar;
    }
}
