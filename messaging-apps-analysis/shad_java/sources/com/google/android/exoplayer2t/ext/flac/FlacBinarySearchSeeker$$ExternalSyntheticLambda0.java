package com.google.android.exoplayer2t.ext.flac;

import com.google.android.exoplayer2t.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2t.util.FlacStreamMetadata;

/* loaded from: classes.dex */
public final /* synthetic */ class FlacBinarySearchSeeker$$ExternalSyntheticLambda0 implements BinarySearchSeeker.SeekTimestampConverter {
    public final /* synthetic */ FlacStreamMetadata f$0;

    @Override // com.google.android.exoplayer2t.extractor.BinarySearchSeeker.SeekTimestampConverter
    public final long timeUsToTargetTime(long j) {
        return this.f$0.getSampleNumber(j);
    }
}
