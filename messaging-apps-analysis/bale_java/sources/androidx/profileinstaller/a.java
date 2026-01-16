package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes2.dex */
abstract class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    private static class C0108a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = a(file2) && z;
        }
        return z;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        if (a(Build.VERSION.SDK_INT >= 34 ? b.a(context).getCacheDir() : C0108a.a(b.a(context)))) {
            aVar.a(14, null);
        } else {
            aVar.a(15, null);
        }
    }
}
