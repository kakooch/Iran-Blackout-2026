package io.github.inflationx.calligraphy3;

import android.content.res.Resources;
import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class CalligraphyInterceptor implements Interceptor {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) throws IllegalAccessException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        InflateResult inflateResultProceed = chain.proceed(chain.request());
        return inflateResultProceed.toBuilder().view(this.calligraphy.onViewCreated(inflateResultProceed.view(), inflateResultProceed.context(), inflateResultProceed.attrs())).build();
    }
}
