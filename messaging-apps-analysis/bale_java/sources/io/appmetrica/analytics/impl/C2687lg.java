package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.io.File;

/* renamed from: io.appmetrica.analytics.impl.lg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2687lg {
    public final Context a;
    public final ICommonExecutor b;
    public final C2723n4 c;
    public final U9 d;

    public C2687lg(Context context, C2723n4 c2723n4, IHandlerExecutor iHandlerExecutor, U9 u9) {
        this.a = context;
        this.b = iHandlerExecutor;
        this.c = c2723n4;
        this.d = u9;
    }

    public final void a(C2934w0 c2934w0, Consumer consumer, Function function) {
        ICommonExecutor iCommonExecutor = this.b;
        U9 u9 = this.d;
        String str = c2934w0.d;
        u9.getClass();
        iCommonExecutor.execute(new RunnableC2567gf(new File(str), new C2517ed(new C2541fd(c2934w0.a, c2934w0.b), new C2492dd()), consumer, new C2663kg(this, c2934w0.f, function)));
    }
}
