package androidx.camera.core.impl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import androidx.camera.core.impl.t;
import ir.nasim.InterfaceC21819uB2;
import ir.nasim.InterfaceC5592Jz5;
import ir.nasim.PI3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class QuirkSettingsLoader implements InterfaceC21819uB2 {

    public static class MetadataHolderService extends Service {
        private MetadataHolderService() {
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            throw new UnsupportedOperationException();
        }
    }

    private static t b(Context context, Bundle bundle) {
        boolean z = bundle.getBoolean("androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED", true);
        String[] strArrC = c(context, bundle, "androidx.camera.core.quirks.FORCE_ENABLED");
        String[] strArrC2 = c(context, bundle, "androidx.camera.core.quirks.FORCE_DISABLED");
        PI3.a("QuirkSettingsLoader", "Loaded quirk settings from metadata:");
        PI3.a("QuirkSettingsLoader", "  KEY_DEFAULT_QUIRK_ENABLED = " + z);
        PI3.a("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(strArrC));
        PI3.a("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(strArrC2));
        return new t.b().d(z).c(e(strArrC)).b(e(strArrC2)).a();
    }

    private static String[] c(Context context, Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            return new String[0];
        }
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            PI3.l("QuirkSettingsLoader", "Resource ID not found for key: " + str);
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(i);
        } catch (Resources.NotFoundException e) {
            PI3.m("QuirkSettingsLoader", "Quirk class names resource not found: " + i, e);
            return new String[0];
        }
    }

    private static Class d(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            if (InterfaceC5592Jz5.class.isAssignableFrom(cls)) {
                return cls;
            }
            PI3.l("QuirkSettingsLoader", str + " does not implement the Quirk interface.");
            return null;
        } catch (ClassNotFoundException e) {
            PI3.m("QuirkSettingsLoader", "Class not found: " + str, e);
            return null;
        }
    }

    private static Set e(String[] strArr) throws ClassNotFoundException {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            Class clsD = d(str);
            if (clsD != null) {
                hashSet.add(clsD);
            }
        }
        return hashSet;
    }

    @Override // ir.nasim.InterfaceC21819uB2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public t apply(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) MetadataHolderService.class), 640).metaData;
            if (bundle != null) {
                return b(context, bundle);
            }
            PI3.l("QuirkSettingsLoader", "No metadata in MetadataHolderService.");
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            PI3.a("QuirkSettingsLoader", "QuirkSettings$MetadataHolderService is not found.");
            return null;
        }
    }
}
