package io.appmetrica.analytics.coreutils.internal.services.frequency;

import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/frequency/InMemoryEventFrequencyStorage;", "Lio/appmetrica/analytics/coreutils/internal/services/frequency/EventFrequencyStorage;", "<init>", "()V", "", "key", "", "value", "Lir/nasim/rB7;", "putWindowStart", "(Ljava/lang/String;J)V", "getWindowStart", "(Ljava/lang/String;)Ljava/lang/Long;", "", "putWindowOccurrencesCount", "(Ljava/lang/String;I)V", "getWindowOccurrencesCount", "(Ljava/lang/String;)Ljava/lang/Integer;", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class InMemoryEventFrequencyStorage implements EventFrequencyStorage {
    private final LinkedHashMap a = new LinkedHashMap();
    private final LinkedHashMap b = new LinkedHashMap();

    @Override // io.appmetrica.analytics.coreutils.internal.services.frequency.EventFrequencyStorage
    public Integer getWindowOccurrencesCount(String key) {
        return (Integer) this.b.get(key);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.services.frequency.EventFrequencyStorage
    public Long getWindowStart(String key) {
        return (Long) this.a.get(key);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.services.frequency.EventFrequencyStorage
    public void putWindowOccurrencesCount(String key, int value) {
        this.b.put(key, Integer.valueOf(value));
    }

    @Override // io.appmetrica.analytics.coreutils.internal.services.frequency.EventFrequencyStorage
    public void putWindowStart(String key, long value) {
        this.a.put(key, Long.valueOf(value));
    }
}
