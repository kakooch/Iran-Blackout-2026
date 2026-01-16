package com.google.android.exoplayer2t.audio;

import com.google.android.exoplayer2t.util.Util;

/* loaded from: classes.dex */
public final class WavUtil {
    public static int getPcmEncodingForType(int i, int i2) {
        if (i != 1) {
            if (i == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (i != 65534) {
                return 0;
            }
        }
        return Util.getPcmEncoding(i2);
    }
}
