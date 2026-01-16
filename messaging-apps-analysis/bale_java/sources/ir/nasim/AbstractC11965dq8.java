package ir.nasim;

import android.content.Context;
import android.os.StrictMode;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.dq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11965dq8 implements InterfaceC21610tp8 {
    private static final Map a = new KJ();

    static AbstractC11965dq8 b(Context context, String str, Runnable runnable) {
        if (AbstractC13204fp8.b()) {
            throw null;
        }
        synchronized (AbstractC11965dq8.class) {
            AbstractC18350oW3.a(a.get(null));
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                throw null;
            } finally {
            }
        }
    }

    static synchronized void c() {
        Map map = a;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        map.clear();
    }
}
