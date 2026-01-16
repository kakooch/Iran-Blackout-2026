package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;

    protected abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupport) throws ExoPlaybackException;

    public static final class MappedTrackInfo {

        @Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        MappedTrackInfo(int[] rendererTrackTypes, TrackGroupArray[] rendererTrackGroups, int[] rendererMixedMimeTypeAdaptiveSupports, int[][][] rendererFormatSupports, TrackGroupArray unmappedTrackGroups) {
            this.rendererTrackTypes = rendererTrackTypes;
            this.rendererTrackGroups = rendererTrackGroups;
            this.rendererFormatSupports = rendererFormatSupports;
            this.rendererMixedMimeTypeAdaptiveSupports = rendererMixedMimeTypeAdaptiveSupports;
            this.unmappedTrackGroups = unmappedTrackGroups;
            int length = rendererTrackTypes.length;
            this.rendererCount = length;
            this.length = length;
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public int getRendererType(int rendererIndex) {
            return this.rendererTrackTypes[rendererIndex];
        }

        public TrackGroupArray getTrackGroups(int rendererIndex) {
            return this.rendererTrackGroups[rendererIndex];
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object info) {
        this.currentMappedTrackInfo = (MappedTrackInfo) info;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilities, TrackGroupArray trackGroups, MediaSource.MediaPeriodId periodId, Timeline timeline) throws ExoPlaybackException {
        int[] formatSupport;
        int[] iArr = new int[rendererCapabilities.length + 1];
        int length = rendererCapabilities.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[rendererCapabilities.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroups.length;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr2[i] = new int[i2][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilities);
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            int iFindRenderer = findRenderer(rendererCapabilities, trackGroup, iArr, MimeTypes.getTrackType(trackGroup.getFormat(0).sampleMimeType) == 4);
            if (iFindRenderer == rendererCapabilities.length) {
                formatSupport = new int[trackGroup.length];
            } else {
                formatSupport = getFormatSupport(rendererCapabilities[iFindRenderer], trackGroup);
            }
            int i4 = iArr[iFindRenderer];
            trackGroupArr[iFindRenderer][i4] = trackGroup;
            iArr2[iFindRenderer][i4] = formatSupport;
            iArr[iFindRenderer] = iArr[iFindRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilities.length];
        int[] iArr3 = new int[rendererCapabilities.length];
        for (int i5 = 0; i5 < rendererCapabilities.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) Util.nullSafeArrayCopy(iArr2[i5], i6);
            iArr3[i5] = rendererCapabilities[i5].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr2, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilities.length], iArr[rendererCapabilities.length])));
        Pair<RendererConfiguration[], TrackSelection[]> pairSelectTracks = selectTracks(mappedTrackInfo, iArr2, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) pairSelectTracks.first, (TrackSelection[]) pairSelectTracks.second, mappedTrackInfo);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilities, TrackGroup group, int[] rendererTrackGroupCounts, boolean preferUnassociatedRenderer) throws ExoPlaybackException {
        int length = rendererCapabilities.length;
        int i = 0;
        boolean z = true;
        for (int i2 = 0; i2 < rendererCapabilities.length; i2++) {
            RendererCapabilities rendererCapabilities2 = rendererCapabilities[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < group.length; i3++) {
                iMax = Math.max(iMax, RendererCapabilities.CC.getFormatSupport(rendererCapabilities2.supportsFormat(group.getFormat(i3))));
            }
            boolean z2 = rendererTrackGroupCounts[i2] == 0;
            if (iMax > i || (iMax == i && preferUnassociatedRenderer && !z && z2)) {
                length = i2;
                z = z2;
                i = iMax;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup group) throws ExoPlaybackException {
        int[] iArr = new int[group.length];
        for (int i = 0; i < group.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(group.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilities) throws ExoPlaybackException {
        int length = rendererCapabilities.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilities[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
