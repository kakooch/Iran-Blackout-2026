package com.google.android.gms.internal.measurement;

import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgu extends zzgv {
    private int zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzgu(byte[] bArr, int i, int i2, boolean z, zzgt zzgtVar) {
        super(null);
        this.zzd = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.zzb = 0;
    }

    public final int zza(int i) throws zzic {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
