package com.google.android.gms.internal.vision;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzhv implements Comparator<zzht> {
    zzhv() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzht zzhtVar, zzht zzhtVar2) {
        zzht zzhtVar3 = zzhtVar;
        zzht zzhtVar4 = zzhtVar2;
        zzhy zzhyVar = (zzhy) zzhtVar3.iterator();
        zzhy zzhyVar2 = (zzhy) zzhtVar4.iterator();
        while (zzhyVar.hasNext() && zzhyVar2.hasNext()) {
            int iM = KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(zzht.zzb(zzhyVar.zza()), zzht.zzb(zzhyVar2.zza()));
            if (iM != 0) {
                return iM;
            }
        }
        return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(zzhtVar3.zza(), zzhtVar4.zza());
    }
}
