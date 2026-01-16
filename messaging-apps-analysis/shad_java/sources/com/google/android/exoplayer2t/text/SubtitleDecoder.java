package com.google.android.exoplayer2t.text;

import com.google.android.exoplayer2t.decoder.Decoder;

/* loaded from: classes.dex */
public interface SubtitleDecoder extends Decoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> {
    void setPositionUs(long j);
}
