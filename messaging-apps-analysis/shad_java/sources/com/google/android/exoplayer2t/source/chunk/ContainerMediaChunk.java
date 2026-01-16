package com.google.android.exoplayer2t.source.chunk;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2t.extractor.Extractor;
import com.google.android.exoplayer2t.extractor.PositionHolder;
import com.google.android.exoplayer2t.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2t.upstream.DataSource;
import com.google.android.exoplayer2t.upstream.DataSpec;
import com.google.android.exoplayer2t.upstream.StatsDataSource;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
public class ContainerMediaChunk extends BaseMediaChunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = new PositionHolder();
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    protected ChunkExtractorWrapper.TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3, j4, j5);
        this.chunkCount = i2;
        this.sampleOffsetUs = j6;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2t.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.chunkCount;
    }

    @Override // com.google.android.exoplayer2t.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public final void load() throws InterruptedException, IOException {
        if (this.nextLoadPosition == 0) {
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.sampleOffsetUs);
            ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrapper;
            ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j = this.clippedStartTimeUs;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.sampleOffsetUs;
            long j3 = this.clippedEndTimeUs;
            chunkExtractorWrapper.init(trackOutputProvider, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.sampleOffsetUs);
        }
        try {
            DataSpec dataSpecSubrange = this.dataSpec.subrange(this.nextLoadPosition);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecSubrange.absoluteStreamPosition, statsDataSource.open(dataSpecSubrange));
            try {
                Extractor extractor = this.extractorWrapper.extractor;
                int i = 0;
                while (i == 0 && !this.loadCanceled) {
                    i = extractor.read(defaultExtractorInput, DUMMY_POSITION_HOLDER);
                }
                Assertions.checkState(i != 1);
                Util.closeQuietly(this.dataSource);
                this.loadCompleted = true;
            } finally {
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition;
            }
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
