package io.appmetrica.analytics.coreutils.internal.services.frequency;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/frequency/EventFrequencyOverWindowLimitDetector;", "", "", "window", "", "limitPerWindow", "Lio/appmetrica/analytics/coreutils/internal/services/frequency/EventFrequencyStorage;", "storage", "<init>", "(JILio/appmetrica/analytics/coreutils/internal/services/frequency/EventFrequencyStorage;)V", "", "key", "", "detect", "(Ljava/lang/String;)Z", "Lir/nasim/rB7;", "updateParameters", "(JI)V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class EventFrequencyOverWindowLimitDetector {
    private long a;
    private int b;
    private final EventFrequencyStorage c;
    private final SystemTimeProvider d = new SystemTimeProvider();

    public EventFrequencyOverWindowLimitDetector(long j, int i, EventFrequencyStorage eventFrequencyStorage) {
        this.a = j;
        this.b = i;
        this.c = eventFrequencyStorage;
    }

    public final boolean detect(String key) {
        long jLongValue;
        long jUptimeMillis = this.d.uptimeMillis();
        EventFrequencyStorage eventFrequencyStorage = this.c;
        Long windowStart = eventFrequencyStorage.getWindowStart(key);
        if (windowStart == null) {
            eventFrequencyStorage.putWindowStart(key, jUptimeMillis);
            jLongValue = jUptimeMillis;
        } else {
            jLongValue = windowStart.longValue();
        }
        long j = jUptimeMillis - jLongValue;
        if (j < 0 || j > this.a) {
            this.c.putWindowStart(key, jUptimeMillis);
            this.c.putWindowOccurrencesCount(key, 1);
            return false;
        }
        Integer windowOccurrencesCount = this.c.getWindowOccurrencesCount(key);
        int iIntValue = (windowOccurrencesCount != null ? windowOccurrencesCount.intValue() : 0) + 1;
        this.c.putWindowOccurrencesCount(key, iIntValue);
        return iIntValue > this.b;
    }

    public final synchronized void updateParameters(long window, int limitPerWindow) {
        this.a = window;
        this.b = limitPerWindow;
    }
}
