package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qs implements qr {
    private qs() {
    }

    /* synthetic */ qs(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final MediaCodecInfo b(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean c() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && MediaController.VIDEO_MIME_TYPE.equals(str2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }
}
