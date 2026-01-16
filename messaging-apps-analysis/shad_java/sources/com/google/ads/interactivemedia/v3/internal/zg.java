package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zg implements qy {
    public static final Parcelable.Creator<zg> CREATOR = new zd();
    public final String a;
    public final String b;
    public final List<zf> c;

    zg(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add((zf) parcel.readParcelable(zf.class.getClassLoader()));
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zg.class == obj.getClass()) {
            zg zgVar = (zg) obj;
            if (TextUtils.equals(this.a, zgVar.a) && TextUtils.equals(this.b, zgVar.b) && this.c.equals(zgVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode();
    }

    public final String toString() {
        String string;
        String str = this.a;
        if (str != null) {
            String str2 = this.b;
            StringBuilder sb = new StringBuilder(str.length() + 5 + String.valueOf(str2).length());
            sb.append(" [");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            sb.append("]");
            string = sb.toString();
        } else {
            string = BuildConfig.FLAVOR;
        }
        String strValueOf = String.valueOf(string);
        return strValueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(strValueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        int size = this.c.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.c.get(i2), 0);
        }
    }

    public zg(String str, String str2, List<zf> list) {
        this.a = str;
        this.b = str2;
        this.c = Collections.unmodifiableList(new ArrayList(list));
    }
}
