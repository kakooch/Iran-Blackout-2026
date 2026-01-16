package ir.nasim;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class FI3 implements XK3 {
    private static final Set a = new HashSet();

    @Override // ir.nasim.XK3
    public void a(String str, Throwable th) {
        if (AbstractC6219Mr3.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // ir.nasim.XK3
    public void b(String str) {
        e(str, null);
    }

    @Override // ir.nasim.XK3
    public void c(String str) {
        d(str, null);
    }

    @Override // ir.nasim.XK3
    public void d(String str, Throwable th) {
        Set set = a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void e(String str, Throwable th) {
        if (AbstractC6219Mr3.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
