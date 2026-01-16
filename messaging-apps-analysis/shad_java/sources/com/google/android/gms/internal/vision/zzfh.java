package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzfh extends zzfd {
    private final zzfg zza = new zzfg();

    zzfh() {
    }

    @Override // com.google.android.gms.internal.vision.zzfd
    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> listZza = this.zza.zza(th, false);
        if (listZza == null) {
            return;
        }
        synchronized (listZza) {
            for (Throwable th2 : listZza) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
