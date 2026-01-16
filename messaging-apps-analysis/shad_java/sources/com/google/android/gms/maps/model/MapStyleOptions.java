package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
/* loaded from: classes3.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzh();
    private String zzb;

    public MapStyleOptions(@RecentlyNonNull String str) {
        Preconditions.checkNotNull(str, "json must not be null");
        this.zzb = str;
    }

    @RecentlyNonNull
    public static MapStyleOptions loadRawResourceStyle(@RecentlyNonNull Context context, int i) throws Resources.NotFoundException {
        try {
            return new MapStyleOptions(new String(IOUtils.readInputStreamFully(context.getResources().openRawResource(i)), Utf8Charset.NAME));
        } catch (IOException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append("Failed to read resource ");
            sb.append(i);
            sb.append(": ");
            sb.append(strValueOf);
            throw new Resources.NotFoundException(sb.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
