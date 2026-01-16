package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
final class HlsMediaChunk extends MediaChunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = new PositionHolder();
    private static final AtomicInteger uidSource = new AtomicInteger();
    public final int discontinuitySequenceNumber;
    private final DrmInitData drmInitData;
    private Extractor extractor;
    private final HlsExtractorFactory extractorFactory;
    private final boolean hasGapTag;
    private final Id3Decoder id3Decoder;
    private boolean initDataLoadRequired;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private final boolean initSegmentEncrypted;
    private boolean isExtractorReusable;
    private final boolean isMasterTimestampSource;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final boolean mediaSegmentEncrypted;
    private final List<Format> muxedCaptionFormats;
    private int nextLoadPosition;
    private HlsSampleStreamWrapper output;
    public final Uri playlistUrl;
    private final Extractor previousExtractor;
    private final ParsableByteArray scratchId3Data;
    private final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    public static HlsMediaChunk createInstance(HlsExtractorFactory extractorFactory, DataSource dataSource, Format format, long startOfPlaylistInPeriodUs, HlsMediaPlaylist mediaPlaylist, int segmentIndexInPlaylist, Uri playlistUrl, List<Format> muxedCaptionFormats, int trackSelectionReason, Object trackSelectionData, boolean isMasterTimestampSource, TimestampAdjusterProvider timestampAdjusterProvider, HlsMediaChunk previousChunk, byte[] mediaSegmentKey, byte[] initSegmentKey) {
        DataSpec dataSpec;
        boolean z;
        DataSource dataSourceBuildDataSource;
        Id3Decoder id3Decoder;
        ParsableByteArray parsableByteArray;
        Extractor extractor;
        boolean z2;
        HlsMediaPlaylist.Segment segment = mediaPlaylist.segments.get(segmentIndexInPlaylist);
        DataSpec dataSpec2 = new DataSpec(UriUtil.resolveToUri(mediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null);
        boolean z3 = mediaSegmentKey != null;
        DataSource dataSourceBuildDataSource2 = buildDataSource(dataSource, mediaSegmentKey, z3 ? getEncryptionIvArray((String) Assertions.checkNotNull(segment.encryptionIV)) : null);
        HlsMediaPlaylist.Segment segment2 = segment.initializationSegment;
        if (segment2 != null) {
            boolean z4 = initSegmentKey != null;
            byte[] encryptionIvArray = z4 ? getEncryptionIvArray((String) Assertions.checkNotNull(segment2.encryptionIV)) : null;
            DataSpec dataSpec3 = new DataSpec(UriUtil.resolveToUri(mediaPlaylist.baseUri, segment2.url), segment2.byterangeOffset, segment2.byterangeLength, null);
            z = z4;
            dataSourceBuildDataSource = buildDataSource(dataSource, initSegmentKey, encryptionIvArray);
            dataSpec = dataSpec3;
        } else {
            dataSpec = null;
            z = false;
            dataSourceBuildDataSource = null;
        }
        long j = startOfPlaylistInPeriodUs + segment.relativeStartTimeUs;
        long j2 = j + segment.durationUs;
        int i = mediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
        if (previousChunk != null) {
            Id3Decoder id3Decoder2 = previousChunk.id3Decoder;
            ParsableByteArray parsableByteArray2 = previousChunk.scratchId3Data;
            boolean z5 = (playlistUrl.equals(previousChunk.playlistUrl) && previousChunk.loadCompleted) ? false : true;
            id3Decoder = id3Decoder2;
            parsableByteArray = parsableByteArray2;
            extractor = (previousChunk.isExtractorReusable && previousChunk.discontinuitySequenceNumber == i && !z5) ? previousChunk.extractor : null;
            z2 = z5;
        } else {
            id3Decoder = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            extractor = null;
            z2 = false;
        }
        return new HlsMediaChunk(extractorFactory, dataSourceBuildDataSource2, dataSpec2, format, z3, dataSourceBuildDataSource, dataSpec, z, playlistUrl, muxedCaptionFormats, trackSelectionReason, trackSelectionData, j, j2, mediaPlaylist.mediaSequence + segmentIndexInPlaylist, i, segment.hasGapTag, isMasterTimestampSource, timestampAdjusterProvider.getAdjuster(i), segment.drmInitData, extractor, id3Decoder, parsableByteArray, z2);
    }

    private HlsMediaChunk(HlsExtractorFactory extractorFactory, DataSource mediaDataSource, DataSpec dataSpec, Format format, boolean mediaSegmentEncrypted, DataSource initDataSource, DataSpec initDataSpec, boolean initSegmentEncrypted, Uri playlistUrl, List<Format> muxedCaptionFormats, int trackSelectionReason, Object trackSelectionData, long startTimeUs, long endTimeUs, long chunkMediaSequence, int discontinuitySequenceNumber, boolean hasGapTag, boolean isMasterTimestampSource, TimestampAdjuster timestampAdjuster, DrmInitData drmInitData, Extractor previousExtractor, Id3Decoder id3Decoder, ParsableByteArray scratchId3Data, boolean shouldSpliceIn) {
        super(mediaDataSource, dataSpec, format, trackSelectionReason, trackSelectionData, startTimeUs, endTimeUs, chunkMediaSequence);
        this.mediaSegmentEncrypted = mediaSegmentEncrypted;
        this.discontinuitySequenceNumber = discontinuitySequenceNumber;
        this.initDataSpec = initDataSpec;
        this.initDataSource = initDataSource;
        this.initDataLoadRequired = initDataSpec != null;
        this.initSegmentEncrypted = initSegmentEncrypted;
        this.playlistUrl = playlistUrl;
        this.isMasterTimestampSource = isMasterTimestampSource;
        this.timestampAdjuster = timestampAdjuster;
        this.hasGapTag = hasGapTag;
        this.extractorFactory = extractorFactory;
        this.muxedCaptionFormats = muxedCaptionFormats;
        this.drmInitData = drmInitData;
        this.previousExtractor = previousExtractor;
        this.id3Decoder = id3Decoder;
        this.scratchId3Data = scratchId3Data;
        this.shouldSpliceIn = shouldSpliceIn;
        this.uid = uidSource.getAndIncrement();
    }

    public void init(HlsSampleStreamWrapper output) {
        this.output = output;
        output.init(this.uid, this.shouldSpliceIn);
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws InterruptedException, IOException {
        Extractor extractor;
        Assertions.checkNotNull(this.output);
        if (this.extractor == null && (extractor = this.previousExtractor) != null) {
            this.extractor = extractor;
            this.isExtractorReusable = true;
            this.initDataLoadRequired = false;
        }
        maybeLoadInitData();
        if (this.loadCanceled) {
            return;
        }
        if (!this.hasGapTag) {
            loadMedia();
        }
        this.loadCompleted = true;
    }

    @RequiresNonNull({"output"})
    private void maybeLoadInitData() throws InterruptedException, IOException {
        if (this.initDataLoadRequired) {
            Assertions.checkNotNull(this.initDataSource);
            Assertions.checkNotNull(this.initDataSpec);
            feedDataToExtractor(this.initDataSource, this.initDataSpec, this.initSegmentEncrypted);
            this.nextLoadPosition = 0;
            this.initDataLoadRequired = false;
        }
    }

    @RequiresNonNull({"output"})
    private void loadMedia() throws InterruptedException, IOException {
        if (!this.isMasterTimestampSource) {
            this.timestampAdjuster.waitUntilInitialized();
        } else if (this.timestampAdjuster.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
            this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
        }
        feedDataToExtractor(this.dataSource, this.dataSpec, this.mediaSegmentEncrypted);
    }

    @RequiresNonNull({"output"})
    private void feedDataToExtractor(DataSource dataSource, DataSpec dataSpec, boolean dataIsEncrypted) throws InterruptedException, IOException {
        DataSpec dataSpecSubrange;
        boolean z;
        int i = 0;
        if (dataIsEncrypted) {
            z = this.nextLoadPosition != 0;
            dataSpecSubrange = dataSpec;
        } else {
            dataSpecSubrange = dataSpec.subrange(this.nextLoadPosition);
            z = false;
        }
        try {
            DefaultExtractorInput defaultExtractorInputPrepareExtraction = prepareExtraction(dataSource, dataSpecSubrange);
            if (z) {
                defaultExtractorInputPrepareExtraction.skipFully(this.nextLoadPosition);
            }
            while (i == 0) {
                try {
                    if (this.loadCanceled) {
                        break;
                    } else {
                        i = this.extractor.read(defaultExtractorInputPrepareExtraction, DUMMY_POSITION_HOLDER);
                    }
                } finally {
                    this.nextLoadPosition = (int) (defaultExtractorInputPrepareExtraction.getPosition() - dataSpec.absoluteStreamPosition);
                }
            }
        } finally {
            Util.closeQuietly(dataSource);
        }
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({"output"})
    private DefaultExtractorInput prepareExtraction(DataSource dataSource, DataSpec dataSpec) throws InterruptedException, IOException {
        DefaultExtractorInput defaultExtractorInput;
        long jAdjustTsTimestamp;
        DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(dataSource, dataSpec.absoluteStreamPosition, dataSource.open(dataSpec));
        if (this.extractor == null) {
            long jPeekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput2);
            defaultExtractorInput2.resetPeekPosition();
            defaultExtractorInput = defaultExtractorInput2;
            HlsExtractorFactory.Result resultCreateExtractor = this.extractorFactory.createExtractor(this.previousExtractor, dataSpec.uri, this.trackFormat, this.muxedCaptionFormats, this.timestampAdjuster, dataSource.getResponseHeaders(), defaultExtractorInput2);
            this.extractor = resultCreateExtractor.extractor;
            this.isExtractorReusable = resultCreateExtractor.isReusable;
            if (resultCreateExtractor.isPackedAudioExtractor) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.output;
                if (jPeekId3PrivTimestamp != -9223372036854775807L) {
                    jAdjustTsTimestamp = this.timestampAdjuster.adjustTsTimestamp(jPeekId3PrivTimestamp);
                } else {
                    jAdjustTsTimestamp = this.startTimeUs;
                }
                hlsSampleStreamWrapper.setSampleOffsetUs(jAdjustTsTimestamp);
            } else {
                this.output.setSampleOffsetUs(0L);
            }
            this.output.onNewExtractor();
            this.extractor.init(this.output);
        } else {
            defaultExtractorInput = defaultExtractorInput2;
        }
        this.output.setDrmInitData(this.drmInitData);
        return defaultExtractorInput;
    }

    private long peekId3PrivTimestamp(ExtractorInput input) throws InterruptedException, IOException {
        input.resetPeekPosition();
        try {
            input.peekFully(this.scratchId3Data.data, 0, 10);
            this.scratchId3Data.reset(10);
        } catch (EOFException unused) {
        }
        if (this.scratchId3Data.readUnsignedInt24() != 4801587) {
            return -9223372036854775807L;
        }
        this.scratchId3Data.skipBytes(3);
        int synchSafeInt = this.scratchId3Data.readSynchSafeInt();
        int i = synchSafeInt + 10;
        if (i > this.scratchId3Data.capacity()) {
            ParsableByteArray parsableByteArray = this.scratchId3Data;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(i);
            System.arraycopy(bArr, 0, this.scratchId3Data.data, 0, 10);
        }
        input.peekFully(this.scratchId3Data.data, 10, synchSafeInt);
        Metadata metadataDecode = this.id3Decoder.decode(this.scratchId3Data.data, synchSafeInt);
        if (metadataDecode == null) {
            return -9223372036854775807L;
        }
        int length = metadataDecode.length();
        for (int i2 = 0; i2 < length; i2++) {
            Metadata.Entry entry = metadataDecode.get(i2);
            if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                    System.arraycopy(privFrame.privateData, 0, this.scratchId3Data.data, 0, 8);
                    this.scratchId3Data.reset(8);
                    return this.scratchId3Data.readLong() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    private static byte[] getEncryptionIvArray(String ivString) {
        if (Util.toLowerInvariant(ivString).startsWith("0x")) {
            ivString = ivString.substring(2);
        }
        byte[] byteArray = new BigInteger(ivString, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] fullSegmentEncryptionKey, byte[] encryptionIv) {
        if (fullSegmentEncryptionKey == null) {
            return dataSource;
        }
        Assertions.checkNotNull(encryptionIv);
        return new Aes128DataSource(dataSource, fullSegmentEncryptionKey, encryptionIv);
    }
}
