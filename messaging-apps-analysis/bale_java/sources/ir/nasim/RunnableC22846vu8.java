package ir.nasim;

import android.util.Log;

/* renamed from: ir.nasim.vu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC22846vu8 implements Runnable {
    final /* synthetic */ NI6 a;

    RunnableC22846vu8(NI6 ni6) {
        this.a = ni6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a.k();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
