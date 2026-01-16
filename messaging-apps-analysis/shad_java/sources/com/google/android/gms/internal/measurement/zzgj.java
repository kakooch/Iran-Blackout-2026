package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgj implements Comparator<zzgs> {
    zzgj() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzgs zzgsVar, zzgs zzgsVar2) {
        zzgs zzgsVar3 = zzgsVar;
        zzgs zzgsVar4 = zzgsVar2;
        zzgi zzgiVar = new zzgi(zzgsVar3);
        zzgi zzgiVar2 = new zzgi(zzgsVar4);
        while (zzgiVar.hasNext() && zzgiVar2.hasNext()) {
            int iM = KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(zzgiVar.zza() & 255, zzgiVar2.zza() & 255);
            if (iM != 0) {
                return iM;
            }
        }
        return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(zzgsVar3.zzc(), zzgsVar4.zzc());
    }
}
