package com.google.android.exoplayer2t.ext.opus;

import com.google.android.exoplayer2t.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import com.google.android.exoplayer2t.util.Util;

/* loaded from: classes.dex */
public final class OpusLibrary {
    private static Class<? extends ExoMediaCrypto> exoMediaCryptoType;

    public static native String opusGetVersion();

    public static native boolean opusIsSecureDecodeSupported();

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.opus");
    }

    private OpusLibrary() {
    }

    public static void setLibraries(Class<? extends ExoMediaCrypto> cls, String... strArr) {
        exoMediaCryptoType = cls;
    }

    public static String getVersion() {
        return opusGetVersion();
    }

    public static boolean matchesExpectedExoMediaCryptoType(Class<? extends ExoMediaCrypto> cls) {
        return Util.areEqual(exoMediaCryptoType, cls);
    }
}
