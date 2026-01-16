package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import ir.nasim.AbstractC10662bz3;
import ir.nasim.AbstractC22215ur3;
import ir.nasim.C12822fE1;
import ir.nasim.C17613nG1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.minSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : (Build.VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C17613nG1.b());
        arrayList.add(C12822fE1.h());
        arrayList.add(AbstractC10662bz3.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(AbstractC10662bz3.b("fire-core", "20.2.0"));
        arrayList.add(AbstractC10662bz3.b("device-name", i(Build.PRODUCT)));
        arrayList.add(AbstractC10662bz3.b("device-model", i(Build.DEVICE)));
        arrayList.add(AbstractC10662bz3.b("device-brand", i(Build.BRAND)));
        arrayList.add(AbstractC10662bz3.c("android-target-sdk", new AbstractC10662bz3.a() { // from class: ir.nasim.Ko2
            @Override // ir.nasim.AbstractC10662bz3.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.e((Context) obj);
            }
        }));
        arrayList.add(AbstractC10662bz3.c("android-min-sdk", new AbstractC10662bz3.a() { // from class: ir.nasim.Lo2
            @Override // ir.nasim.AbstractC10662bz3.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.f((Context) obj);
            }
        }));
        arrayList.add(AbstractC10662bz3.c("android-platform", new AbstractC10662bz3.a() { // from class: ir.nasim.Mo2
            @Override // ir.nasim.AbstractC10662bz3.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.g((Context) obj);
            }
        }));
        arrayList.add(AbstractC10662bz3.c("android-installer", new AbstractC10662bz3.a() { // from class: ir.nasim.No2
            @Override // ir.nasim.AbstractC10662bz3.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.h((Context) obj);
            }
        }));
        String strA = AbstractC22215ur3.a();
        if (strA != null) {
            arrayList.add(AbstractC10662bz3.b("kotlin", strA));
        }
        return arrayList;
    }
}
