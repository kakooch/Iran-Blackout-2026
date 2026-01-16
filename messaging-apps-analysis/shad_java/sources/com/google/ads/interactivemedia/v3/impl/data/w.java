package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class w extends az {
    private final String detailedReason;
    private final FriendlyObstructionPurpose purpose;
    private final View view;

    private w(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.view = view;
        this.purpose = friendlyObstructionPurpose;
        this.detailedReason = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.az
    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof az) {
            az azVar = (az) obj;
            if (this.view.equals(azVar.view()) && this.purpose.equals(azVar.purpose()) && ((str = this.detailedReason) != null ? str.equals(azVar.detailedReason()) : azVar.detailedReason() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.view.hashCode() ^ 1000003) * 1000003) ^ this.purpose.hashCode()) * 1000003;
        String str = this.detailedReason;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.az
    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.view);
        String strValueOf2 = String.valueOf(this.purpose);
        String str = this.detailedReason;
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 57 + strValueOf2.length() + String.valueOf(str).length());
        sb.append("FriendlyObstructionImpl{view=");
        sb.append(strValueOf);
        sb.append(", purpose=");
        sb.append(strValueOf2);
        sb.append(", detailedReason=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.az
    public View view() {
        return this.view;
    }
}
