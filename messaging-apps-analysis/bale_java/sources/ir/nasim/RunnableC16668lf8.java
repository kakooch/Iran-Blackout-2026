package ir.nasim;

import com.google.android.gms.signin.internal.zak;

/* renamed from: ir.nasim.lf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC16668lf8 implements Runnable {
    final /* synthetic */ zak a;
    final /* synthetic */ BinderC17850nf8 b;

    RunnableC16668lf8(BinderC17850nf8 binderC17850nf8, zak zakVar) {
        this.b = binderC17850nf8;
        this.a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BinderC17850nf8.D2(this.b, this.a);
    }
}
