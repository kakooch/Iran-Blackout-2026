package ir.nasim;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.sN3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20651sN3 {
    private final Context a;

    public C20651sN3(Context context) {
        this.a = context;
    }

    private ApplicationInfo a() {
        return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
    }

    private static SI2 c(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e) {
                d(cls, e);
            } catch (InstantiationException e2) {
                d(cls, e2);
            } catch (NoSuchMethodException e3) {
                d(cls, e3);
            } catch (InvocationTargetException e4) {
                d(cls, e4);
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void d(Class cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List b() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ApplicationInfo applicationInfoA;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            applicationInfoA = a();
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e);
            }
        }
        if (applicationInfoA != null && applicationInfoA.metaData != null) {
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + applicationInfoA.metaData);
            }
            for (String str : applicationInfoA.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfoA.metaData.get(str))) {
                    c(str);
                    arrayList.add(null);
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        }
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Got null app info metadata");
        }
        return arrayList;
    }
}
