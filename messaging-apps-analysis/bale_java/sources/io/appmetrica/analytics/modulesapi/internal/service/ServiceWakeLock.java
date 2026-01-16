package io.appmetrica.analytics.modulesapi.internal.service;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/ServiceWakeLock;", "", "", "wakeLockId", "", "acquireWakeLock", "(Ljava/lang/String;)Z", "Lir/nasim/rB7;", "releaseWakeLock", "(Ljava/lang/String;)V", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface ServiceWakeLock {
    boolean acquireWakeLock(String wakeLockId);

    void releaseWakeLock(String wakeLockId);
}
