package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final int playlistType;
    public final DrmInitData protectionSchemes;
    public final List<Segment> segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public HlsPlaylist copy(List<StreamKey> streamKeys) {
        return this;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* renamed from: copy, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ HlsPlaylist copy2(List streamKeys) {
        return copy((List<StreamKey>) streamKeys);
    }

    public static final class Segment implements Comparable<Long> {
        public final long byterangeLength;
        public final long byterangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String title;
        public final String url;

        public Segment(String uri, long byterangeOffset, long byterangeLength, String fullSegmentEncryptionKeyUri, String encryptionIV) {
            this(uri, null, "", 0L, -1, -9223372036854775807L, null, fullSegmentEncryptionKeyUri, encryptionIV, byterangeOffset, byterangeLength, false);
        }

        public Segment(String url, Segment initializationSegment, String title, long durationUs, int relativeDiscontinuitySequence, long relativeStartTimeUs, DrmInitData drmInitData, String fullSegmentEncryptionKeyUri, String encryptionIV, long byterangeOffset, long byterangeLength, boolean hasGapTag) {
            this.url = url;
            this.initializationSegment = initializationSegment;
            this.title = title;
            this.durationUs = durationUs;
            this.relativeDiscontinuitySequence = relativeDiscontinuitySequence;
            this.relativeStartTimeUs = relativeStartTimeUs;
            this.drmInitData = drmInitData;
            this.fullSegmentEncryptionKeyUri = fullSegmentEncryptionKeyUri;
            this.encryptionIV = encryptionIV;
            this.byterangeOffset = byterangeOffset;
            this.byterangeLength = byterangeLength;
            this.hasGapTag = hasGapTag;
        }

        @Override // java.lang.Comparable
        public int compareTo(Long relativeStartTimeUs) {
            if (this.relativeStartTimeUs > relativeStartTimeUs.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < relativeStartTimeUs.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(int playlistType, String baseUri, List<String> tags, long startOffsetUs, long startTimeUs, boolean hasDiscontinuitySequence, int discontinuitySequence, long mediaSequence, int version, long targetDurationUs, boolean hasIndependentSegments, boolean hasEndTag, boolean hasProgramDateTime, DrmInitData protectionSchemes, List<Segment> segments) {
        long j;
        super(baseUri, tags, hasIndependentSegments);
        this.playlistType = playlistType;
        this.startTimeUs = startTimeUs;
        this.hasDiscontinuitySequence = hasDiscontinuitySequence;
        this.discontinuitySequence = discontinuitySequence;
        this.mediaSequence = mediaSequence;
        this.version = version;
        this.targetDurationUs = targetDurationUs;
        this.hasEndTag = hasEndTag;
        this.hasProgramDateTime = hasProgramDateTime;
        this.protectionSchemes = protectionSchemes;
        this.segments = Collections.unmodifiableList(segments);
        if (!segments.isEmpty()) {
            Segment segment = segments.get(segments.size() - 1);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0L;
        }
        if (startOffsetUs == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else {
            j = startOffsetUs >= 0 ? startOffsetUs : this.durationUs + startOffsetUs;
        }
        this.startOffsetUs = j;
    }

    public boolean isNewerThan(HlsMediaPlaylist other) {
        if (other == null) {
            return true;
        }
        long j = this.mediaSequence;
        long j2 = other.mediaSequence;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.segments.size();
        int size2 = other.segments.size();
        if (size <= size2) {
            return size == size2 && this.hasEndTag && !other.hasEndTag;
        }
        return true;
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public HlsMediaPlaylist copyWith(long startTimeUs, int discontinuitySequence) {
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, startTimeUs, true, discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public HlsMediaPlaylist copyWithEndTag() {
        return this.hasEndTag ? this : new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }
}
