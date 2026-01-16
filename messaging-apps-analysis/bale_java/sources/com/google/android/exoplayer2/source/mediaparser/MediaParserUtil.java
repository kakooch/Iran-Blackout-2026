package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.X;
import ir.nasim.C15493jg5;

/* loaded from: classes2.dex */
public final class MediaParserUtil {

    private static final class Api31 {
        private Api31() {
        }

        public static void a(MediaParser mediaParser, C15493jg5 c15493jg5) {
            LogSessionId logSessionIdA = c15493jg5.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            mediaParser.setLogSessionId(logSessionIdA);
        }
    }

    private MediaParserUtil() {
    }

    public static void a(MediaParser mediaParser, C15493jg5 c15493jg5) {
        Api31.a(mediaParser, c15493jg5);
    }

    public static MediaFormat b(X x) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", x.l);
        int i = x.G;
        if (i != -1) {
            mediaFormat.setInteger("caption-service-number", i);
        }
        return mediaFormat;
    }
}
