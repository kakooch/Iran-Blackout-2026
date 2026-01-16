package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;

/* loaded from: classes3.dex */
public final class Zf implements RemoteConfigMetaInfo {
    public final long a;
    public final long b;

    public Zf(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final Zf a(long j, long j2) {
        return new Zf(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Zf)) {
            return false;
        }
        Zf zf = (Zf) obj;
        return this.a == zf.a && this.b == zf.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.a;
    }

    public static Zf a(Zf zf, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = zf.a;
        }
        if ((i & 2) != 0) {
            j2 = zf.b;
        }
        zf.getClass();
        return new Zf(j, j2);
    }
}
