package io.github.inflationx.viewpump;

/* compiled from: Interceptor.kt */
/* loaded from: classes.dex */
public interface Interceptor {

    /* compiled from: Interceptor.kt */
    /* loaded from: classes3.dex */
    public interface Chain {
        InflateResult proceed(InflateRequest inflateRequest);

        InflateRequest request();
    }

    InflateResult intercept(Chain chain);
}
