package ir.nasim;

import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzft;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class RJ2 extends C13715gh8 {
    private static List i = new ArrayList();
    private boolean f;
    private Set g;
    private boolean h;

    public RJ2(zzbv zzbvVar) {
        super(zzbvVar);
        this.g = new HashSet();
    }

    public static void g() {
        synchronized (RJ2.class) {
            try {
                List list = i;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(boolean z) {
        this.h = z;
    }

    public final void h() {
        zzft zzftVarZzq = c().zzq();
        zzftVarZzq.zzf();
        if (zzftVarZzq.zze()) {
            f(zzftVarZzq.zzc());
        }
        zzftVarZzq.zzf();
        this.f = true;
    }
}
