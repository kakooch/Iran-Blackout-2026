package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;

/* loaded from: classes3.dex */
public class SharedPreferencesUtils {
    private final FirebaseApp firebaseApp;

    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public void setBooleanPreference(String str, boolean z) {
        SharedPreferences.Editor editorEdit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public boolean getAndSetBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z);
        }
        setBooleanPreference(str, z);
        return z;
    }

    public boolean getBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z) : z;
    }

    public boolean isPreferenceSet(String str) {
        return ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public boolean isManifestSet(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.containsKey(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean getBooleanManifestValue(String str, boolean z) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z;
    }
}
