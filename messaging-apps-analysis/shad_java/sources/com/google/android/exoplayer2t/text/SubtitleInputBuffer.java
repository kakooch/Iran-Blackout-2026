package com.google.android.exoplayer2t.text;

import com.google.android.exoplayer2t.decoder.DecoderInputBuffer;

/* loaded from: classes.dex */
public class SubtitleInputBuffer extends DecoderInputBuffer {
    public long subsampleOffsetUs;

    public SubtitleInputBuffer() {
        super(1);
    }
}
