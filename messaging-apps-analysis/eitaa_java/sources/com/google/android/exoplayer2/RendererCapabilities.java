package com.google.android.exoplayer2;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public interface RendererCapabilities {
    int getTrackType();

    int supportsFormat(Format format) throws ExoPlaybackException;

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;

    /* renamed from: com.google.android.exoplayer2.RendererCapabilities$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @SuppressLint({"WrongConstant"})
        public static int create(int formatSupport, int adaptiveSupport, int tunnelingSupport) {
            return formatSupport | adaptiveSupport | tunnelingSupport;
        }

        @SuppressLint({"WrongConstant"})
        public static int getFormatSupport(int supportFlags) {
            return supportFlags & 7;
        }

        @SuppressLint({"WrongConstant"})
        public static int getTunnelingSupport(int supportFlags) {
            return supportFlags & 32;
        }

        public static int create(int formatSupport) {
            return create(formatSupport, 0, 0);
        }

        public static String getFormatSupportString(int formatSupport) {
            if (formatSupport == 0) {
                return "NO";
            }
            if (formatSupport == 1) {
                return "NO_UNSUPPORTED_TYPE";
            }
            if (formatSupport == 2) {
                return "NO_UNSUPPORTED_DRM";
            }
            if (formatSupport == 3) {
                return "NO_EXCEEDS_CAPABILITIES";
            }
            if (formatSupport == 4) {
                return "YES";
            }
            throw new IllegalStateException();
        }
    }
}
