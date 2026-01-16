package com.google.android.exoplayer2t.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2t.ExoPlaybackException;
import com.google.android.exoplayer2t.RendererCapabilities;
import com.google.android.exoplayer2t.RendererConfiguration;
import com.google.android.exoplayer2t.Timeline;
import com.google.android.exoplayer2t.source.MediaSource;
import com.google.android.exoplayer2t.source.TrackGroup;
import com.google.android.exoplayer2t.source.TrackGroupArray;
import com.google.android.exoplayer2t.util.MimeTypes;
import com.google.android.exoplayer2t.util.Util;

/* loaded from: classes.dex */
public abstract class MappingTrackSelector extends TrackSelector {
    protected abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    public static final class MappedTrackInfo {
        private final int rendererCount;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererCount = iArr.length;
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public int getRendererType(int i) {
            return this.rendererTrackTypes[i];
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.rendererTrackGroups[i];
        }
    }

    @Override // com.google.android.exoplayer2t.trackselection.TrackSelector
    public final void onSelectionActivated(Object obj) {
    }

    @Override // com.google.android.exoplayer2t.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        int[] formatSupport;
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroupArray.length;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr2[i] = new int[i2][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup = trackGroupArray.get(i3);
            int iFindRenderer = findRenderer(rendererCapabilitiesArr, trackGroup, iArr, MimeTypes.getTrackType(trackGroup.getFormat(0).sampleMimeType) == 4);
            if (iFindRenderer == rendererCapabilitiesArr.length) {
                formatSupport = new int[trackGroup.length];
            } else {
                formatSupport = getFormatSupport(rendererCapabilitiesArr[iFindRenderer], trackGroup);
            }
            int i4 = iArr[iFindRenderer];
            trackGroupArr[iFindRenderer][i4] = trackGroup;
            iArr2[iFindRenderer][i4] = formatSupport;
            iArr[iFindRenderer] = iArr[iFindRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i5 = 0; i5 < rendererCapabilitiesArr.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) Util.nullSafeArrayCopy(iArr2[i5], i6);
            iArr3[i5] = rendererCapabilitiesArr[i5].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr2, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> pairSelectTracks = selectTracks(mappedTrackInfo, iArr2, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) pairSelectTracks.first, (TrackSelection[]) pairSelectTracks.second, mappedTrackInfo);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                iMax = Math.max(iMax, RendererCapabilities.CC.getFormatSupport(rendererCapabilities.supportsFormat(trackGroup.getFormat(i3))));
            }
            boolean z3 = iArr[i2] == 0;
            if (iMax > i || (iMax == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = iMax;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
