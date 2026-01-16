package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class ExoPlayerLibraryInfo {
    public static final String DEFAULT_USER_AGENT = "ExoPlayerLib/2.12.2 (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.12.2";
    private static final HashSet<String> registeredModules = new HashSet<>();
    private static String registeredModulesString = "goog.exo.core";

    public static synchronized String registeredModules() {
        return registeredModulesString;
    }

    public static synchronized void registerModule(String str) {
        if (registeredModules.add(str)) {
            registeredModulesString += ", " + str;
        }
    }
}
