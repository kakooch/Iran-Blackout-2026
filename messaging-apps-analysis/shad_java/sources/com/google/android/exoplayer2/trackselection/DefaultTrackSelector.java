package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.LiteMode;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    private boolean allowMultipleAdaptiveSelections;
    private final AtomicReference<Parameters> parametersReference;
    private final TrackSelection.Factory trackSelectionFactory;
    private static final int[] NO_TRACKS = new int[0];
    private static final Ordering<Integer> FORMAT_VALUE_ORDERING = Ordering.from(new Comparator() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.lambda$static$0((Integer) obj, (Integer) obj2);
        }
    });
    private static final Ordering<Integer> NO_ORDER = Ordering.from(new Comparator() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.lambda$static$1((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(Integer num, Integer num2) {
        return 0;
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
        private int minVideoBitrate;
        private int minVideoFrameRate;
        private int minVideoHeight;
        private int minVideoWidth;
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

        public ParametersBuilder(Context context) {
            super(context);
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }

        public ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            this.viewportWidth = i;
            this.viewportHeight = i2;
            this.viewportOrientationMayChange = z;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.minVideoWidth, this.minVideoHeight, this.minVideoFrameRate, this.minVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredAudioLanguage, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingAudioSessionId, this.selectionOverrides, this.rendererDisabledFlags);
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
        public final int minVideoBitrate;
        public final int minVideoFrameRate;
        public final int minVideoHeight;
        public final int minVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.1
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

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        Parameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, int i9, int i10, boolean z4, String str, int i11, int i12, boolean z5, boolean z6, boolean z7, boolean z8, String str2, int i13, boolean z9, int i14, boolean z10, boolean z11, boolean z12, int i15, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i13, z9, i14);
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoFrameRate = i3;
            this.maxVideoBitrate = i4;
            this.minVideoWidth = i5;
            this.minVideoHeight = i6;
            this.minVideoFrameRate = i7;
            this.minVideoBitrate = i8;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z2;
            this.allowVideoNonSeamlessAdaptiveness = z3;
            this.viewportWidth = i9;
            this.viewportHeight = i10;
            this.viewportOrientationMayChange = z4;
            this.maxAudioChannelCount = i11;
            this.maxAudioBitrate = i12;
            this.exceedAudioConstraintsIfNecessary = z5;
            this.allowAudioMixedMimeTypeAdaptiveness = z6;
            this.allowAudioMixedSampleRateAdaptiveness = z7;
            this.allowAudioMixedChannelCountAdaptiveness = z8;
            this.forceLowestBitrate = z10;
            this.forceHighestSupportedBitrate = z11;
            this.exceedRendererCapabilitiesIfNecessary = z12;
            this.tunnelingAudioSessionId = i15;
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.minVideoWidth = parcel.readInt();
            this.minVideoHeight = parcel.readInt();
            this.minVideoFrameRate = parcel.readInt();
            this.minVideoBitrate = parcel.readInt();
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

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.minVideoWidth == parameters.minVideoWidth && this.minVideoHeight == parameters.minVideoHeight && this.minVideoFrameRate == parameters.minVideoFrameRate && this.minVideoBitrate == parameters.minVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            parcel.writeInt(this.minVideoWidth);
            parcel.writeInt(this.minVideoHeight);
            parcel.writeInt(this.minVideoFrameRate);
            parcel.writeInt(this.minVideoBitrate);
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
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.1
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

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 2, 0);
        }

        public SelectionOverride(int i, int[] iArr, int i2, int i3) {
            this.groupIndex = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = iArrCopyOf;
            this.length = iArr.length;
            this.reason = i2;
            this.data = i3;
            Arrays.sort(iArrCopyOf);
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

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, TrackSelection.Factory factory) {
        this(Parameters.getDefaults(context), factory);
    }

    public DefaultTrackSelector(Parameters parameters, TrackSelection.Factory factory) {
        this.trackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(parameters);
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
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
        Parameters parameters2 = parameters;
        int i2 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i3);
            int i4 = i3;
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i3], z, i2, parameters2.maxVideoWidth, parameters2.maxVideoHeight, parameters2.maxVideoFrameRate, parameters2.maxVideoBitrate, parameters2.minVideoWidth, parameters2.minVideoHeight, parameters2.minVideoFrameRate, parameters2.minVideoBitrate, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new TrackSelection.Definition(trackGroup, adaptiveVideoTracksForGroup);
            }
            i3 = i4 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2) {
        String str;
        int i12;
        int i13;
        HashSet hashSet;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i10, i11, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i15 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i15).intValue()).sampleMimeType;
                if (hashSet2.add(str3)) {
                    i12 = i14;
                    i13 = i15;
                    hashSet = hashSet2;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, i4, i5, i6, i7, i8, i9, viewportFilteredTrackIndices);
                    if (adaptiveVideoTrackCountForMimeType > i12) {
                        i14 = adaptiveVideoTrackCountForMimeType;
                        str2 = str3;
                    }
                    i15 = i13 + 1;
                    hashSet2 = hashSet;
                } else {
                    i12 = i14;
                    i13 = i15;
                    hashSet = hashSet2;
                }
                i14 = i12;
                i15 = i13 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, i5, i6, i7, i8, i9, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Ints.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue = list.get(i11).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                i10++;
            }
        }
        return i10;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                list.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((format.roleFlags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0 || !isSupported(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i11 = format.width;
        if (i11 != -1 && (i7 > i11 || i11 > i3)) {
            return false;
        }
        int i12 = format.height;
        if (i12 != -1 && (i8 > i12 || i12 > i4)) {
            return false;
        }
        float f = format.frameRate;
        if (f != -1.0f && (i9 > f || f > i5)) {
            return false;
        }
        int i13 = format.bitrate;
        return i13 == -1 || (i10 <= i13 && i13 <= i6);
    }

    private static TrackSelection.Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i = -1;
        TrackGroup trackGroup = null;
        VideoTrackScore videoTrackScore = null;
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i2);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                Format format = trackGroup2.getFormat(i3);
                if ((format.roleFlags & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) == 0 && isSupported(iArr2[i3], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    VideoTrackScore videoTrackScore2 = new VideoTrackScore(format, parameters, iArr2[i3], viewportFilteredTrackIndices.contains(Integer.valueOf(i3)));
                    if ((videoTrackScore2.isWithinMaxConstraints || parameters.exceedVideoConstraintsIfNecessary) && (videoTrackScore == null || videoTrackScore2.compareTo(videoTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i = i3;
                        videoTrackScore = videoTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i);
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
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i2], i3, parameters.maxAudioBitrate, parameters.allowAudioMixedMimeTypeAdaptiveness, parameters.allowAudioMixedSampleRateAdaptiveness, parameters.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 1) {
                definition = new TrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new TrackSelection.Definition(trackGroup2, i3);
        }
        return Pair.create(definition, (AudioTrackScore) Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        Format format = trackGroup.getFormat(i);
        int[] iArr2 = new int[trackGroup.length];
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup.length; i4++) {
            if (i4 == i || isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i4), iArr[i4], format, i2, z, z2, z3)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return Arrays.copyOf(iArr2, i3);
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i, Format format2, int i2, boolean z, boolean z2, boolean z3) {
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
        if (!z3 && ((i4 = format.channelCount) == -1 || i4 != format2.channelCount)) {
            return false;
        }
        if (z || ((str = format.sampleMimeType) != null && TextUtils.equals(str, format2.sampleMimeType))) {
            return z2 || ((i3 = format.sampleRate) != -1 && i3 == format2.sampleRate);
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
        OtherTrackScore otherTrackScore = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i4), iArr2[i4]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        otherTrackScore = otherTrackScore2;
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
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class VideoTrackScore implements Comparable<VideoTrackScore> {
        private final int bitrate;
        public final boolean isWithinMaxConstraints;
        private final boolean isWithinMinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final Parameters parameters;
        private final int pixelCount;

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public VideoTrackScore(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.parameters = r8
                r0 = 1
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L33
                int r4 = r7.width
                if (r4 == r3) goto L14
                int r5 = r8.maxVideoWidth
                if (r4 > r5) goto L33
            L14:
                int r4 = r7.height
                if (r4 == r3) goto L1c
                int r5 = r8.maxVideoHeight
                if (r4 > r5) goto L33
            L1c:
                float r4 = r7.frameRate
                int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r5 == 0) goto L29
                int r5 = r8.maxVideoFrameRate
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L33
            L29:
                int r4 = r7.bitrate
                if (r4 == r3) goto L31
                int r5 = r8.maxVideoBitrate
                if (r4 > r5) goto L33
            L31:
                r4 = 1
                goto L34
            L33:
                r4 = 0
            L34:
                r6.isWithinMaxConstraints = r4
                if (r10 == 0) goto L5e
                int r10 = r7.width
                if (r10 == r3) goto L40
                int r4 = r8.minVideoWidth
                if (r10 < r4) goto L5e
            L40:
                int r10 = r7.height
                if (r10 == r3) goto L48
                int r4 = r8.minVideoHeight
                if (r10 < r4) goto L5e
            L48:
                float r10 = r7.frameRate
                int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r1 == 0) goto L55
                int r1 = r8.minVideoFrameRate
                float r1 = (float) r1
                int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r10 < 0) goto L5e
            L55:
                int r10 = r7.bitrate
                if (r10 == r3) goto L5f
                int r8 = r8.minVideoBitrate
                if (r10 < r8) goto L5e
                goto L5f
            L5e:
                r0 = 0
            L5f:
                r6.isWithinMinConstraints = r0
                boolean r8 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(r9, r2)
                r6.isWithinRendererCapabilities = r8
                int r8 = r7.bitrate
                r6.bitrate = r8
                int r7 = r7.getPixelCount()
                r6.pixelCount = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        @Override // java.lang.Comparable
        public int compareTo(VideoTrackScore videoTrackScore) {
            Ordering orderingReverse = (this.isWithinMaxConstraints && this.isWithinRendererCapabilities) ? DefaultTrackSelector.FORMAT_VALUE_ORDERING : DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, videoTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isWithinMaxConstraints, videoTrackScore.isWithinMaxConstraints).compareFalseFirst(this.isWithinMinConstraints, videoTrackScore.isWithinMinConstraints).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compare(Integer.valueOf(this.pixelCount), Integer.valueOf(videoTrackScore.pixelCount), orderingReverse).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), orderingReverse).result();
        }
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
            Ordering orderingReverse = (this.isWithinConstraints && this.isWithinRendererCapabilities) ? DefaultTrackSelector.FORMAT_VALUE_ORDERING : DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            ComparisonChain comparisonChainCompare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, audioTrackScore.isWithinRendererCapabilities).compare(this.preferredLanguageScore, audioTrackScore.preferredLanguageScore).compareFalseFirst(this.isWithinConstraints, audioTrackScore.isWithinConstraints).compare(Integer.valueOf(this.bitrate), Integer.valueOf(audioTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackScore.isDefaultSelectionFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackScore.localeLanguageMatchIndex), Ordering.natural().reverse()).compare(this.localeLanguageScore, audioTrackScore.localeLanguageScore).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackScore.channelCount), orderingReverse).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackScore.sampleRate), orderingReverse);
            Integer numValueOf = Integer.valueOf(this.bitrate);
            Integer numValueOf2 = Integer.valueOf(audioTrackScore.bitrate);
            if (!Util.areEqual(this.language, audioTrackScore.language)) {
                orderingReverse = DefaultTrackSelector.NO_ORDER;
            }
            return comparisonChainCompare.compare(numValueOf, numValueOf2, orderingReverse).result();
        }
    }

    protected static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean isDefault;
        private final boolean isForced;
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
            this.isForced = z3;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.preferredLanguageScore = formatLanguageScore;
            int iBitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = iBitCount;
            this.hasCaptionRoleFlags = (format.roleFlags & 1088) != 0;
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore2;
            if (formatLanguageScore > 0 || ((parameters.preferredTextLanguage == null && iBitCount > 0) || z2 || (z3 && formatLanguageScore2 > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(TextTrackScore textTrackScore) {
            ComparisonChain comparisonChainCompare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, textTrackScore.isWithinRendererCapabilities).compare(this.preferredLanguageScore, textTrackScore.preferredLanguageScore).compare(this.preferredRoleFlagsScore, textTrackScore.preferredRoleFlagsScore).compareFalseFirst(this.isDefault, textTrackScore.isDefault).compare(Boolean.valueOf(this.isForced), Boolean.valueOf(textTrackScore.isForced), this.preferredLanguageScore == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.selectedAudioLanguageScore, textTrackScore.selectedAudioLanguageScore);
            if (this.preferredRoleFlagsScore == 0) {
                comparisonChainCompare = comparisonChainCompare.compareTrueFirst(this.hasCaptionRoleFlags, textTrackScore.hasCaptionRoleFlags);
            }
            return comparisonChainCompare.result();
        }
    }

    protected static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean isDefault;
        private final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i) {
            this.isDefault = (format.selectionFlags & 1) != 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
        }

        @Override // java.lang.Comparable
        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }
}
