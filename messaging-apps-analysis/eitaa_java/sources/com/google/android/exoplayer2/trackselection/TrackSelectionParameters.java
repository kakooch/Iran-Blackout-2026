package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final String preferredAudioLanguage;
    public final String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class Builder {
        String preferredAudioLanguage = null;
        String preferredTextLanguage = null;
        int preferredTextRoleFlags = 0;
        boolean selectUndeterminedTextLanguage = false;
        int disabledTextTrackSelectionFlags = 0;

        @Deprecated
        public Builder() {
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }
    }

    static {
        TrackSelectionParameters trackSelectionParametersBuild = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = trackSelectionParametersBuild;
        DEFAULT = trackSelectionParametersBuild;
        CREATOR = new Parcelable.Creator<TrackSelectionParameters>() { // from class: com.google.android.exoplayer2.trackselection.TrackSelectionParameters.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters createFromParcel(Parcel in) {
                return new TrackSelectionParameters(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters[] newArray(int size) {
                return new TrackSelectionParameters[size];
            }
        };
    }

    TrackSelectionParameters(String preferredAudioLanguage, String preferredTextLanguage, int preferredTextRoleFlags, boolean selectUndeterminedTextLanguage, int disabledTextTrackSelectionFlags) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(preferredAudioLanguage);
        this.preferredTextLanguage = Util.normalizeLanguageCode(preferredTextLanguage);
        this.preferredTextRoleFlags = preferredTextRoleFlags;
        this.selectUndeterminedTextLanguage = selectUndeterminedTextLanguage;
        this.disabledTextTrackSelectionFlags = disabledTextTrackSelectionFlags;
    }

    TrackSelectionParameters(Parcel in) {
        this.preferredAudioLanguage = in.readString();
        this.preferredTextLanguage = in.readString();
        this.preferredTextRoleFlags = in.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(in);
        this.disabledTextTrackSelectionFlags = in.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return TextUtils.equals(this.preferredAudioLanguage, trackSelectionParameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, trackSelectionParameters.preferredTextLanguage) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags;
    }

    public int hashCode() {
        String str = this.preferredAudioLanguage;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.preferredTextLanguage;
        return ((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.preferredAudioLanguage);
        dest.writeString(this.preferredTextLanguage);
        dest.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(dest, this.selectUndeterminedTextLanguage);
        dest.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
