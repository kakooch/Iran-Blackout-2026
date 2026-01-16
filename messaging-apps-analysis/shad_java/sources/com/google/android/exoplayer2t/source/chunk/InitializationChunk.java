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
public final class InitializationChunk extends Chunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = new PositionHolder();
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;
    private ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.extractorWrapper = chunkExtractorWrapper;
    }

    public void init(ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider) {
        this.trackOutputProvider = trackOutputProvider;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public void load() throws InterruptedException, IOException {
        if (this.nextLoadPosition == 0) {
            this.extractorWrapper.init(this.trackOutputProvider, -9223372036854775807L, -9223372036854775807L);
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
            } finally {
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition;
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}
