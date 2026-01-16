package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
@KeepName
/* loaded from: classes3.dex */
public class CommonWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zzb();
    String name;
    int state;
    String zzce;
    String zzcg;
    String zzcj;
    String zzck;
    String zzcl;

    @Deprecated
    String zzcm;
    String zzcn;
    ArrayList<WalletObjectMessage> zzco;
    TimeInterval zzcp;
    ArrayList<LatLng> zzcq;

    @Deprecated
    String zzcr;

    @Deprecated
    String zzcs;
    ArrayList<LabelValueRow> zzct;
    boolean zzcu;
    ArrayList<UriData> zzcv;
    ArrayList<TextModuleData> zzcw;
    ArrayList<UriData> zzcx;

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    public final class zza {
        private zza() {
        }

        public final zza zza(String str) {
            CommonWalletObject.this.zzce = str;
            return this;
        }

        public final CommonWalletObject zzh() {
            return CommonWalletObject.this;
        }
    }

    public static zza zzg() {
        return new zza();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcn, false);
        SafeParcelWriter.writeString(parcel, 4, this.name, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzcg, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzcj, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzck, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcl, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzcm, false);
        SafeParcelWriter.writeInt(parcel, 10, this.state);
        SafeParcelWriter.writeTypedList(parcel, 11, this.zzco, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzcp, i, false);
        SafeParcelWriter.writeTypedList(parcel, 13, this.zzcq, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzcr, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzcs, false);
        SafeParcelWriter.writeTypedList(parcel, 16, this.zzct, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzcu);
        SafeParcelWriter.writeTypedList(parcel, 18, this.zzcv, false);
        SafeParcelWriter.writeTypedList(parcel, 19, this.zzcw, false);
        SafeParcelWriter.writeTypedList(parcel, 20, this.zzcx, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    CommonWalletObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, ArrayList<WalletObjectMessage> arrayList, TimeInterval timeInterval, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<LabelValueRow> arrayList3, boolean z, ArrayList<UriData> arrayList4, ArrayList<TextModuleData> arrayList5, ArrayList<UriData> arrayList6) {
        this.zzce = str;
        this.zzcn = str2;
        this.name = str3;
        this.zzcg = str4;
        this.zzcj = str5;
        this.zzck = str6;
        this.zzcl = str7;
        this.zzcm = str8;
        this.state = i;
        this.zzco = arrayList;
        this.zzcp = timeInterval;
        this.zzcq = arrayList2;
        this.zzcr = str9;
        this.zzcs = str10;
        this.zzct = arrayList3;
        this.zzcu = z;
        this.zzcv = arrayList4;
        this.zzcw = arrayList5;
        this.zzcx = arrayList6;
    }

    CommonWalletObject() {
        this.zzco = ArrayUtils.newArrayList();
        this.zzcq = ArrayUtils.newArrayList();
        this.zzct = ArrayUtils.newArrayList();
        this.zzcv = ArrayUtils.newArrayList();
        this.zzcw = ArrayUtils.newArrayList();
        this.zzcx = ArrayUtils.newArrayList();
    }
}
