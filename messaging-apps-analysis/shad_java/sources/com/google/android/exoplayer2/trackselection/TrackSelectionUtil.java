package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.TrackSelection;

/* loaded from: classes.dex */
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        TrackSelection createAdaptiveTrackSelection(TrackSelection.Definition definition);
    }

    public static TrackSelection[] createTrackSelectionsForDefinitions(TrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
        boolean z = false;
        for (int i = 0; i < definitionArr.length; i++) {
            TrackSelection.Definition definition = definitionArr[i];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length > 1 && !z) {
                    trackSelectionArr[i] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z = true;
                } else {
                    trackSelectionArr[i] = new FixedTrackSelection(definition.group, iArr[0], definition.reason, definition.data);
                }
            }
        }
        return trackSelectionArr;
    }
}
