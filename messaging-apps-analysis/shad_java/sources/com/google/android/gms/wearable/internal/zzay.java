package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;

/* loaded from: classes3.dex */
public final class zzay extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzay> CREATOR = new zzbi();
    private final String zzce;
    private final String zzcl;
    private final String zzo;

    public zzay(String str, String str2, String str3) {
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzo = (String) Preconditions.checkNotNull(str2);
        this.zzcl = (String) Preconditions.checkNotNull(str3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, getNodeId(), false);
        SafeParcelWriter.writeString(parcel, 4, getPath(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toString() {
        int i = 0;
        for (char c : this.zzce.toCharArray()) {
            i += c;
        }
        String strTrim = this.zzce.trim();
        int length = strTrim.length();
        if (length > 25) {
            String strSubstring = strTrim.substring(0, 10);
            String strSubstring2 = strTrim.substring(length - 10, length);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 16 + String.valueOf(strSubstring2).length());
            sb.append(strSubstring);
            sb.append("...");
            sb.append(strSubstring2);
            sb.append("::");
            sb.append(i);
            strTrim = sb.toString();
        }
        String str = this.zzo;
        String str2 = this.zzcl;
        StringBuilder sb2 = new StringBuilder(String.valueOf(strTrim).length() + 31 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb2.append("Channel{token=");
        sb2.append(strTrim);
        sb2.append(", nodeId=");
        sb2.append(str);
        sb2.append(", path=");
        sb2.append(str2);
        sb2.append("}");
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzay)) {
            return false;
        }
        zzay zzayVar = (zzay) obj;
        return this.zzce.equals(zzayVar.zzce) && Objects.equal(zzayVar.zzo, this.zzo) && Objects.equal(zzayVar.zzcl, this.zzcl);
    }

    public final int hashCode() {
        return this.zzce.hashCode();
    }

    public final String getNodeId() {
        return this.zzo;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final String getPath() {
        return this.zzcl;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzaz(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbb(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbc(this, googleApiClient));
    }
}
