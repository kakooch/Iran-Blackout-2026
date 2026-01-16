package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import com.google.android.gms.internal.vision.AbstractC2178j0;
import com.google.android.gms.internal.vision.C2159a;
import com.google.android.gms.internal.vision.C2169f;
import com.google.android.gms.internal.vision.C2175i;
import com.google.android.gms.internal.vision.C2177j;
import com.google.android.gms.internal.vision.C2185n;
import com.google.android.gms.internal.vision.C2187o;
import com.google.android.gms.internal.vision.zzs;
import ir.nasim.AbstractC5985Lr3;
import ir.nasim.Fb8;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class LogUtils {
    public static C2187o zza(long j, int i, String str, String str2, List<C2185n> list, zzs zzsVar) {
        C2175i.a aVarV = C2175i.v();
        C2169f.b bVarU = C2169f.v().t(str2).r(j).u(i);
        bVarU.s(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((C2169f) ((AbstractC2178j0) bVarU.q()));
        return (C2187o) ((AbstractC2178j0) C2187o.v().r((C2175i) ((AbstractC2178j0) aVarV.s(arrayList).r((C2177j) ((AbstractC2178j0) C2177j.v().s(zzsVar.b).r(zzsVar.a).t(zzsVar.c).u(zzsVar.d).q())).q())).q());
    }

    private static String zzb(Context context) {
        try {
            return Fb8.a(context).e(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC5985Lr3.c(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }

    public static C2159a zza(Context context) {
        C2159a.C0175a c0175aR = C2159a.v().r(context.getPackageName());
        String strZzb = zzb(context);
        if (strZzb != null) {
            c0175aR.s(strZzb);
        }
        return (C2159a) ((AbstractC2178j0) c0175aR.q());
    }
}
