package com.google.android.exoplayer2t.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2t.util.Util;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public final int disabledTextTrackSelectionFlags;
    public final String preferredAudioLanguage;
    public final String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT = new Builder().build();
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new Parcelable.Creator<TrackSelectionParameters>() { // from class: com.google.android.exoplayer2t.trackselection.TrackSelectionParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackSelectionParameters[] newArray(int i) {
            return new TrackSelectionParameters[i];
        }
    };

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

    TrackSelectionParameters(String str, String str2, int i, boolean z, int i2) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
        this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
        this.preferredTextRoleFlags = i;
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = i2;
    }

    TrackSelectionParameters(Parcel parcel) {
        this.preferredAudioLanguage = parcel.readString();
        this.preferredTextLanguage = parcel.readString();
        this.preferredTextRoleFlags = parcel.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.preferredAudioLanguage);
        parcel.writeString(this.preferredTextLanguage);
        parcel.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
