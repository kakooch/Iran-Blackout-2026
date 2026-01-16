package com.google.android.exoplayer2t.trackselection;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.ExoPlaybackException;
import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.RendererCapabilities;
import com.google.android.exoplayer2t.RendererConfiguration;
import com.google.android.exoplayer2t.source.TrackGroup;
import com.google.android.exoplayer2t.source.TrackGroupArray;
import com.google.android.exoplayer2t.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2t.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2t.trackselection.TrackSelection;
import com.google.android.exoplayer2t.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.LiteMode;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] NO_TRACKS = new int[0];
    private boolean allowMultipleAdaptiveSelections;
    private final AtomicReference<Parameters> parametersReference;
    private final TrackSelection.Factory trackSelectionFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareFormatValues(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareInts(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private boolean allowAudioMixedChannelCountAdaptiveness;
        private boolean allowAudioMixedMimeTypeAdaptiveness;
        private boolean allowAudioMixedSampleRateAdaptiveness;
        private boolean allowVideoMixedMimeTypeAdaptiveness;
        private boolean allowVideoNonSeamlessAdaptiveness;
        private boolean exceedAudioConstraintsIfNecessary;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @Deprecated
        public ParametersBuilder() {
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
        }

        @Override // com.google.android.exoplayer2t.trackselection.TrackSelectionParameters.Builder
        public Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredAudioLanguage, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingAudioSessionId, this.selectionOverrides, this.rendererDisabledFlags);
        }

        private void setInitialValuesWithoutContext() {
            this.maxVideoWidth = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.maxVideoHeight = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.maxVideoFrameRate = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.maxVideoBitrate = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.viewportWidth = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.viewportHeight = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.viewportOrientationMayChange = true;
            this.maxAudioChannelCount = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.maxAudioBitrate = ConnectionsManager.DEFAULT_DATACENTER_ID;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingAudioSessionId = 0;
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() { // from class: com.google.android.exoplayer2t.trackselection.DefaultTrackSelector.Parameters.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Parameters[] newArray(int i) {
                return new Parameters[i];
            }
        };

        @Override // com.google.android.exoplayer2t.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Parameters(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, int i6, boolean z4, String str, int i7, int i8, boolean z5, boolean z6, boolean z7, boolean z8, String str2, int i9, boolean z9, int i10, boolean z10, boolean z11, boolean z12, int i11, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i9, z9, i10);
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoFrameRate = i3;
            this.maxVideoBitrate = i4;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z2;
            this.allowVideoNonSeamlessAdaptiveness = z3;
            this.viewportWidth = i5;
            this.viewportHeight = i6;
            this.viewportOrientationMayChange = z4;
            this.maxAudioChannelCount = i7;
            this.maxAudioBitrate = i8;
            this.exceedAudioConstraintsIfNecessary = z5;
            this.allowAudioMixedMimeTypeAdaptiveness = z6;
            this.allowAudioMixedSampleRateAdaptiveness = z7;
            this.allowAudioMixedChannelCountAdaptiveness = z8;
            this.forceLowestBitrate = z10;
            this.forceHighestSupportedBitrate = z11;
            this.exceedRendererCapabilitiesIfNecessary = z12;
            this.tunnelingAudioSessionId = i11;
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            this.maxAudioChannelCount = parcel.readInt();
            this.maxAudioBitrate = parcel.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel);
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = (SparseBooleanArray) Util.castNonNull(parcel.readSparseBooleanArray());
        }

        public final boolean getRendererDisabled(int i) {
            return this.rendererDisabledFlags.get(i);
        }

        public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        public final SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2t.trackselection.TrackSelectionParameters
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
        }

        @Override // com.google.android.exoplayer2t.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        @Override // com.google.android.exoplayer2t.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.maxAudioChannelCount);
            parcel.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.tunnelingAudioSessionId);
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int i = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                HashMap map = new HashMap(i4);
                for (int i5 = 0; i5 < i4; i5++) {
                    map.put((TrackGroupArray) Assertions.checkNotNull((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(i3, map);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int iKeyAt = sparseArray.keyAt(i);
                Map<TrackGroupArray, SelectionOverride> mapValueAt = sparseArray.valueAt(i);
                int size2 = mapValueAt.size();
                parcel.writeInt(iKeyAt);
                parcel.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : mapValueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(Map<TrackGroupArray, SelectionOverride> map, Map<TrackGroupArray, SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<TrackGroupArray, SelectionOverride> entry : map.entrySet()) {
                TrackGroupArray key = entry.getKey();
                if (!map2.containsKey(key) || !Util.areEqual(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() { // from class: com.google.android.exoplayer2t.trackselection.DefaultTrackSelector.SelectionOverride.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        };
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int i = parcel.readByte();
            this.length = i;
            int[] iArr = new int[i];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
            this.reason = parcel.readInt();
            this.data = parcel.readInt();
        }

        public int hashCode() {
            return (((((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.reason) * 31) + this.data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.reason == selectionOverride.reason && this.data == selectionOverride.data;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.reason);
            parcel.writeInt(this.data);
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Parameters parameters, TrackSelection.Factory factory) {
        this.trackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(parameters);
    }

    @Override // com.google.android.exoplayer2t.trackselection.MappingTrackSelector
    protected final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArrSelectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i = 0;
        while (true) {
            if (i >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i)) {
                definitionArrSelectAllTracks[i] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                if (parameters.hasSelectionOverride(i, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
                    definitionArrSelectAllTracks[i] = selectionOverride != null ? new TrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.reason, Integer.valueOf(selectionOverride.data)) : null;
                }
            }
            i++;
        }
        TrackSelection[] trackSelectionArrCreateTrackSelections = this.trackSelectionFactory.createTrackSelections(definitionArrSelectAllTracks, getBandwidthMeter());
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurationArr[i2] = !parameters.getRendererDisabled(i2) && (mappedTrackInfo.getRendererType(i2) == 6 || trackSelectionArrCreateTrackSelections[i2] != null) ? RendererConfiguration.DEFAULT : null;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, trackSelectionArrCreateTrackSelections, parameters.tunnelingAudioSessionId);
        return Pair.create(rendererConfigurationArr, trackSelectionArrCreateTrackSelections);
    }

    protected TrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i;
        String str;
        int i2;
        AudioTrackScore audioTrackScore;
        String str2;
        int i3;
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArr = new TrackSelection.Definition[rendererCount];
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo.getRendererType(i5)) {
                if (!z) {
                    definitionArr[i5] = selectVideoTrack(mappedTrackInfo.getTrackGroups(i5), iArr[i5], iArr2[i5], parameters, true);
                    z = definitionArr[i5] != null;
                }
                i6 |= mappedTrackInfo.getTrackGroups(i5).length <= 0 ? 0 : 1;
            }
            i5++;
        }
        AudioTrackScore audioTrackScore2 = null;
        String str3 = null;
        int i7 = -1;
        int i8 = 0;
        while (i8 < rendererCount) {
            if (i == mappedTrackInfo.getRendererType(i8)) {
                i2 = i7;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i3 = i8;
                Pair<TrackSelection.Definition, AudioTrackScore> pairSelectAudioTrack = selectAudioTrack(mappedTrackInfo.getTrackGroups(i8), iArr[i8], iArr2[i8], parameters, this.allowMultipleAdaptiveSelections || i6 == 0);
                if (pairSelectAudioTrack != null && (audioTrackScore == null || ((AudioTrackScore) pairSelectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i2 != -1) {
                        definitionArr[i2] = null;
                    }
                    TrackSelection.Definition definition = (TrackSelection.Definition) pairSelectAudioTrack.first;
                    definitionArr[i3] = definition;
                    str3 = definition.group.getFormat(definition.tracks[0]).language;
                    audioTrackScore2 = (AudioTrackScore) pairSelectAudioTrack.second;
                    i7 = i3;
                }
                i8 = i3 + 1;
                i = 1;
            } else {
                i2 = i7;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i3 = i8;
            }
            i7 = i2;
            audioTrackScore2 = audioTrackScore;
            str3 = str2;
            i8 = i3 + 1;
            i = 1;
        }
        String str4 = str3;
        TextTrackScore textTrackScore = null;
        int i9 = -1;
        while (i4 < rendererCount) {
            int rendererType = mappedTrackInfo.getRendererType(i4);
            if (rendererType == 1) {
                str = str4;
            } else if (rendererType == 2) {
                str = str4;
            } else if (rendererType == 3) {
                str = str4;
                Pair<TrackSelection.Definition, TextTrackScore> pairSelectTextTrack = selectTextTrack(mappedTrackInfo.getTrackGroups(i4), iArr[i4], parameters, str);
                if (pairSelectTextTrack != null && (textTrackScore == null || ((TextTrackScore) pairSelectTextTrack.second).compareTo(textTrackScore) > 0)) {
                    if (i9 != -1) {
                        definitionArr[i9] = null;
                    }
                    definitionArr[i4] = (TrackSelection.Definition) pairSelectTextTrack.first;
                    textTrackScore = (TextTrackScore) pairSelectTextTrack.second;
                    i9 = i4;
                }
            } else {
                definitionArr[i4] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i4), iArr[i4], parameters);
                str = str4;
            }
            i4++;
            str4 = str;
        }
        return definitionArr;
    }

    protected TrackSelection.Definition selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        TrackSelection.Definition definitionSelectAdaptiveVideoTrack = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || !z) ? null : selectAdaptiveVideoTrack(trackGroupArray, iArr, i, parameters);
        return definitionSelectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : definitionSelectAdaptiveVideoTrack;
    }

    private static TrackSelection.Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int i2 = parameters.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters.allowVideoMixedMimeTypeAdaptiveness && (i & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i3);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i3], z, i2, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoFrameRate, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new TrackSelection.Definition(trackGroup, adaptiveVideoTracksForGroup);
            }
            i3++;
            trackGroupArray2 = trackGroupArray;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        String str;
        int adaptiveVideoTrackCountForMimeType;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i6, i7, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < viewportFilteredTrackIndices.size(); i9++) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i9).intValue()).sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, i4, i5, viewportFilteredTrackIndices)) > i8) {
                    i8 = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, i5, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int iIntValue = list.get(i7).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((format.roleFlags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0 || !isSupported(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i7 = format.width;
        if (i7 != -1 && i7 > i3) {
            return false;
        }
        int i8 = format.height;
        if (i8 != -1 && i8 > i4) {
            return false;
        }
        float f = format.frameRate;
        if (f != -1.0f && f > i5) {
            return false;
        }
        int i9 = format.bitrate;
        return i9 == -1 || i9 <= i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2t.trackselection.TrackSelection.Definition selectFixedVideoTrack(com.google.android.exoplayer2t.source.TrackGroupArray r17, int[][] r18, com.google.android.exoplayer2t.trackselection.DefaultTrackSelector.Parameters r19) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2t.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.google.android.exoplayer2t.source.TrackGroupArray, int[][], com.google.android.exoplayer2t.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2t.trackselection.TrackSelection$Definition");
    }

    protected Pair<TrackSelection.Definition, AudioTrackScore> selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        TrackSelection.Definition definition = null;
        AudioTrackScore audioTrackScore = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i5), parameters, iArr2[i5]);
                    if ((audioTrackScore2.isWithinConstraints || parameters.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i2 = i4;
                        i3 = i5;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray.get(i2);
        if (!parameters.forceHighestSupportedBitrate && !parameters.forceLowestBitrate && z) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i2], parameters.maxAudioBitrate, parameters.allowAudioMixedMimeTypeAdaptiveness, parameters.allowAudioMixedSampleRateAdaptiveness, parameters.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                definition = new TrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new TrackSelection.Definition(trackGroup2, i3);
        }
        return Pair.create(definition, (AudioTrackScore) Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, int i, boolean z, boolean z2, boolean z3) {
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        AudioConfigurationTuple audioConfigurationTuple = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            Format format = trackGroup.getFormat(i3);
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(format.channelCount, format.sampleRate, format.sampleMimeType);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2, i, z, z2, z3)) > i2) {
                i2 = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i2 > 1) {
            Assertions.checkNotNull(audioConfigurationTuple);
            int[] iArr2 = new int[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i5), iArr[i5], audioConfigurationTuple, i, z, z2, z3)) {
                    iArr2[i4] = i5;
                    i4++;
                }
            }
            return iArr2;
        }
        return NO_TRACKS;
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple, int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i3), iArr[i3], audioConfigurationTuple, i, z, z2, z3)) {
                i2++;
            }
        }
        return i2;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i, AudioConfigurationTuple audioConfigurationTuple, int i2, boolean z, boolean z2, boolean z3) {
        int i3;
        String str;
        int i4;
        if (!isSupported(i, false)) {
            return false;
        }
        int i5 = format.bitrate;
        if (i5 != -1 && i5 > i2) {
            return false;
        }
        if (!z3 && ((i4 = format.channelCount) == -1 || i4 != audioConfigurationTuple.channelCount)) {
            return false;
        }
        if (z || ((str = format.sampleMimeType) != null && TextUtils.equals(str, audioConfigurationTuple.mimeType))) {
            return z2 || ((i3 = format.sampleRate) != -1 && i3 == audioConfigurationTuple.sampleRate);
        }
        return false;
    }

    protected Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        int i = -1;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i2);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                if (isSupported(iArr2[i3], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore2 = new TextTrackScore(trackGroup2.getFormat(i3), parameters, iArr2[i3], str);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i = i3;
                        textTrackScore = textTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new TrackSelection.Definition(trackGroup, i), (TextTrackScore) Assertions.checkNotNull(textTrackScore));
    }

    protected TrackSelection.Definition selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i6 = (trackGroup2.getFormat(i5).selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i5], false)) {
                        i6 += CloseCodes.NORMAL_CLOSURE;
                    }
                    if (i6 > i3) {
                        trackGroup = trackGroup2;
                        i2 = i5;
                        i3 = i6;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i2);
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i) {
        boolean z;
        if (i == 0) {
            return;
        }
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < mappedTrackInfo.getRendererCount(); i4++) {
            int rendererType = mappedTrackInfo.getRendererType(i4);
            TrackSelection trackSelection = trackSelectionArr[i4];
            if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i4], mappedTrackInfo.getTrackGroups(i4), trackSelection)) {
                if (rendererType == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(i);
            rendererConfigurationArr[i3] = rendererConfiguration;
            rendererConfigurationArr[i2] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int iIndexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i = 0; i < trackSelection.length(); i++) {
            if (RendererCapabilities.CC.getTunnelingSupport(iArr[iIndexOf][trackSelection.getIndexInTrackGroup(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSupported(int i, boolean z) {
        int formatSupport = RendererCapabilities.CC.getFormatSupport(i);
        return formatSupport == 4 || (z && formatSupport == 3);
    }

    protected static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int getFormatLanguageScore(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String strNormalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String strNormalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (strNormalizeUndeterminedLanguageToNull2 == null || strNormalizeUndeterminedLanguageToNull == null) {
            return (z && strNormalizeUndeterminedLanguageToNull2 == null) ? 1 : 0;
        }
        if (strNormalizeUndeterminedLanguageToNull2.startsWith(strNormalizeUndeterminedLanguageToNull) || strNormalizeUndeterminedLanguageToNull.startsWith(strNormalizeUndeterminedLanguageToNull2)) {
            return 3;
        }
        return Util.splitAtFirst(strNormalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(strNormalizeUndeterminedLanguageToNull, "-")[0]) ? 2 : 0;
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i4 = 0; i4 < trackGroup.length; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i5 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                Format format = trackGroup.getFormat(i6);
                int i7 = format.width;
                if (i7 > 0 && (i3 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, i7, i3);
                    int i8 = format.width;
                    int i9 = format.height;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (maxVideoSizeInViewport.x * 0.98f)) && i9 >= ((int) (maxVideoSizeInViewport.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2t.util.Util.ceilDivide(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2t.util.Util.ceilDivide(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2t.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageScore;
        private final int sampleRate;

        public AudioTrackScore(Format format, Parameters parameters, int i) {
            this.parameters = parameters;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i2 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            this.preferredLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredAudioLanguage, false);
            boolean z = true;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            int i3 = format.channelCount;
            this.channelCount = i3;
            this.sampleRate = format.sampleRate;
            int i4 = format.bitrate;
            this.bitrate = i4;
            if ((i4 != -1 && i4 > parameters.maxAudioBitrate) || (i3 != -1 && i3 > parameters.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i5 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int i6 = 0;
            while (true) {
                if (i6 >= systemLanguageCodes.length) {
                    break;
                }
                int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i6], false);
                if (formatLanguageScore > 0) {
                    i5 = i6;
                    i2 = formatLanguageScore;
                    break;
                }
                i6++;
            }
            this.localeLanguageMatchIndex = i5;
            this.localeLanguageScore = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(AudioTrackScore audioTrackScore) {
            int iCompareInts;
            int iCompareFormatValues;
            boolean z = this.isWithinRendererCapabilities;
            if (z != audioTrackScore.isWithinRendererCapabilities) {
                return z ? 1 : -1;
            }
            int i = this.preferredLanguageScore;
            int i2 = audioTrackScore.preferredLanguageScore;
            if (i != i2) {
                return DefaultTrackSelector.compareInts(i, i2);
            }
            boolean z2 = this.isWithinConstraints;
            if (z2 != audioTrackScore.isWithinConstraints) {
                return z2 ? 1 : -1;
            }
            if (this.parameters.forceLowestBitrate && (iCompareFormatValues = DefaultTrackSelector.compareFormatValues(this.bitrate, audioTrackScore.bitrate)) != 0) {
                return iCompareFormatValues > 0 ? -1 : 1;
            }
            boolean z3 = this.isDefaultSelectionFlag;
            if (z3 != audioTrackScore.isDefaultSelectionFlag) {
                return z3 ? 1 : -1;
            }
            int i3 = this.localeLanguageMatchIndex;
            int i4 = audioTrackScore.localeLanguageMatchIndex;
            if (i3 != i4) {
                return -DefaultTrackSelector.compareInts(i3, i4);
            }
            int i5 = this.localeLanguageScore;
            int i6 = audioTrackScore.localeLanguageScore;
            if (i5 != i6) {
                return DefaultTrackSelector.compareInts(i5, i6);
            }
            int i7 = (this.isWithinConstraints && this.isWithinRendererCapabilities) ? 1 : -1;
            int i8 = this.channelCount;
            int i9 = audioTrackScore.channelCount;
            if (i8 != i9) {
                iCompareInts = DefaultTrackSelector.compareInts(i8, i9);
            } else {
                int i10 = this.sampleRate;
                int i11 = audioTrackScore.sampleRate;
                if (i10 != i11) {
                    iCompareInts = DefaultTrackSelector.compareInts(i10, i11);
                } else {
                    if (!Util.areEqual(this.language, audioTrackScore.language)) {
                        return 0;
                    }
                    iCompareInts = DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                }
            }
            return i7 * iCompareInts;
        }
    }

    private static final class AudioConfigurationTuple {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i, int i2, String str) {
            this.channelCount = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioConfigurationTuple.class != obj.getClass()) {
                return false;
            }
            AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
            return this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType);
        }

        public int hashCode() {
            int i = ((this.channelCount * 31) + this.sampleRate) * 31;
            String str = this.mimeType;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    protected static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean hasPreferredIsForcedFlag;
        private final boolean isDefault;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format, Parameters parameters, int i, String str) {
            boolean z = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            int i2 = format.selectionFlags & (parameters.disabledTextTrackSelectionFlags ^ (-1));
            boolean z2 = (i2 & 1) != 0;
            this.isDefault = z2;
            boolean z3 = (i2 & 2) != 0;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.preferredLanguageScore = formatLanguageScore;
            int iBitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = iBitCount;
            this.hasCaptionRoleFlags = (format.roleFlags & 1088) != 0;
            this.hasPreferredIsForcedFlag = (formatLanguageScore > 0 && !z3) || (formatLanguageScore == 0 && z3);
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore2;
            if (formatLanguageScore > 0 || ((parameters.preferredTextLanguage == null && iBitCount > 0) || z2 || (z3 && formatLanguageScore2 > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(TextTrackScore textTrackScore) {
            boolean z;
            boolean z2 = this.isWithinRendererCapabilities;
            if (z2 != textTrackScore.isWithinRendererCapabilities) {
                return z2 ? 1 : -1;
            }
            int i = this.preferredLanguageScore;
            int i2 = textTrackScore.preferredLanguageScore;
            if (i != i2) {
                return DefaultTrackSelector.compareInts(i, i2);
            }
            int i3 = this.preferredRoleFlagsScore;
            int i4 = textTrackScore.preferredRoleFlagsScore;
            if (i3 != i4) {
                return DefaultTrackSelector.compareInts(i3, i4);
            }
            boolean z3 = this.isDefault;
            if (z3 != textTrackScore.isDefault) {
                return z3 ? 1 : -1;
            }
            boolean z4 = this.hasPreferredIsForcedFlag;
            if (z4 != textTrackScore.hasPreferredIsForcedFlag) {
                return z4 ? 1 : -1;
            }
            int i5 = this.selectedAudioLanguageScore;
            int i6 = textTrackScore.selectedAudioLanguageScore;
            if (i5 != i6) {
                return DefaultTrackSelector.compareInts(i5, i6);
            }
            if (i3 != 0 || (z = this.hasCaptionRoleFlags) == textTrackScore.hasCaptionRoleFlags) {
                return 0;
            }
            return z ? -1 : 1;
        }
    }
}
