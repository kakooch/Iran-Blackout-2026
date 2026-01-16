package io.appmetrica.analytics.coreapi.internal.servicecomponents;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/servicecomponents/FirstExecutionDelayedTask;", "", "", "delay", "Lir/nasim/rB7;", "setInitialDelaySeconds", "(J)V", "launchDelaySeconds", "", "tryExecute", "(J)Z", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface FirstExecutionDelayedTask {
    void setInitialDelaySeconds(long delay);

    boolean tryExecute(long launchDelaySeconds);
}
