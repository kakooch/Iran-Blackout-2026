package ir.nasim;

import android.util.Log;
import java.util.Set;

/* loaded from: classes3.dex */
final class Du8 implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ NI6 b;

    Du8(NI6 ni6, Set set) {
        this.b = ni6;
        this.a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.f(this.a);
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
