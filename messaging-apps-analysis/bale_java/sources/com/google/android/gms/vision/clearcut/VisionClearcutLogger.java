package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.vision.C2162b0;
import com.google.android.gms.internal.vision.C2187o;
import ir.nasim.AbstractC5985Lr3;
import ir.nasim.Ln8;

@Keep
/* loaded from: classes3.dex */
public class VisionClearcutLogger {
    private final com.google.android.gms.clearcut.a zza;
    private boolean zzb = true;

    public VisionClearcutLogger(@RecentlyNonNull Context context) {
        this.zza = new com.google.android.gms.clearcut.a(context, "VISION", null);
    }

    public final void zza(int i, C2187o c2187o) {
        byte[] bArrD = c2187o.d();
        if (i < 0 || i > 3) {
            AbstractC5985Lr3.d("Illegal event code: %d", Integer.valueOf(i));
            return;
        }
        try {
            if (this.zzb) {
                this.zza.a(bArrD).b(i).a();
                return;
            }
            C2187o.a aVarV = C2187o.v();
            try {
                aVarV.d(bArrD, 0, bArrD.length, C2162b0.c());
                AbstractC5985Lr3.b("Would have logged:\n%s", aVarV.toString());
            } catch (Exception e) {
                AbstractC5985Lr3.c(e, "Parsing error", new Object[0]);
            }
        } catch (Exception e2) {
            Ln8.b(e2);
            AbstractC5985Lr3.c(e2, "Failed to log", new Object[0]);
        }
    }
}
