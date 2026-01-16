package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* renamed from: io.appmetrica.analytics.impl.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2838s0 {
    public static ResultReceiverC2988y6 a(Handler handler, C2814r0 c2814r0) {
        return new ResultReceiverC2988y6(handler, c2814r0);
    }

    public static Oe a(Context context, ResultReceiverC2988y6 resultReceiverC2988y6) {
        return new Oe(context, resultReceiverC2988y6);
    }

    public static Lh a(Oe oe, Context context, ICommonExecutor iCommonExecutor) {
        C2552g0 c2552g0 = new C2552g0(context, iCommonExecutor, C2747o4.g().c());
        return new Lh(c2552g0, new Om(new C2490db()), new Q4(oe), new C2666kj(context, c2552g0));
    }

    public static Nk a(Context context, Lh lh, C2637je c2637je, Handler handler) {
        return new Nk(lh, new Vk(context, c2637je), handler);
    }

    public static C2997yf a(Lh lh, C2637je c2637je, Handler handler) {
        return new C2997yf(lh, c2637je, handler, c2637je.s());
    }

    public static C3023zh a(Context context, Oe oe, Lh lh, Handler handler, Nk nk) {
        return new C3023zh(context, oe, lh, handler, nk);
    }
}
