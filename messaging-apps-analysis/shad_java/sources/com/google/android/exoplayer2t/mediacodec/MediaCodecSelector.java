package com.google.android.exoplayer2t.mediacodec;

import com.google.android.exoplayer2t.mediacodec.MediaCodecUtil;
import java.util.List;

/* loaded from: classes.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: com.google.android.exoplayer2t.mediacodec.MediaCodecSelector.1
        @Override // com.google.android.exoplayer2t.mediacodec.MediaCodecSelector
        public List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfos(str, z, z2);
        }

        @Override // com.google.android.exoplayer2t.mediacodec.MediaCodecSelector
        public MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}
