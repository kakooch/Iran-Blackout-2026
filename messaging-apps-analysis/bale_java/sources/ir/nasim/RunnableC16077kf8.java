package ir.nasim;

import com.google.android.gms.common.ConnectionResult;

/* renamed from: ir.nasim.kf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC16077kf8 implements Runnable {
    final /* synthetic */ BinderC17850nf8 a;

    RunnableC16077kf8(BinderC17850nf8 binderC17850nf8) {
        this.a = binderC17850nf8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m.c(new ConnectionResult(4));
    }
}
