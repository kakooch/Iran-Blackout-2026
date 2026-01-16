package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.vision.C2187o;
import ir.nasim.AbstractC5985Lr3;
import ir.nasim.C17890nj8;
import ir.nasim.Nm8;
import ir.nasim.Zp8;
import java.util.concurrent.ExecutorService;

@Keep
/* loaded from: classes3.dex */
public class DynamiteClearcutLogger {
    private static final ExecutorService zza = Nm8.a().n(2, Zp8.a);
    private C17890nj8 zzb = new C17890nj8(0.03333333333333333d);
    private VisionClearcutLogger zzc;

    public DynamiteClearcutLogger(@RecentlyNonNull Context context) {
        this.zzc = new VisionClearcutLogger(context);
    }

    public final void zza(int i, C2187o c2187o) {
        if (i != 3 || this.zzb.a()) {
            zza.execute(new a(this, i, c2187o));
        } else {
            AbstractC5985Lr3.e("Skipping image analysis log due to rate limiting", new Object[0]);
        }
    }
}
