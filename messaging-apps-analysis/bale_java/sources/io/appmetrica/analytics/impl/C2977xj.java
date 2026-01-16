package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.xj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2977xj implements ModuleRemoteConfig {
    public final SdkIdentifiers a;
    public final RemoteConfigMetaInfo b;
    public final Object c;

    public C2977xj(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        this.a = sdkIdentifiers;
        this.b = remoteConfigMetaInfo;
        this.c = obj;
    }

    public final C2977xj a(SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        return new C2977xj(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }

    public final RemoteConfigMetaInfo b() {
        return this.b;
    }

    public final Object c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2977xj)) {
            return false;
        }
        C2977xj c2977xj = (C2977xj) obj;
        return AbstractC13042fc3.d(this.a, c2977xj.a) && AbstractC13042fc3.d(this.b, c2977xj.b) && AbstractC13042fc3.d(this.c, c2977xj.c);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final Object getFeaturesConfig() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final SdkIdentifiers getIdentifiers() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig
    public final RemoteConfigMetaInfo getRemoteConfigMetaInfo() {
        return this.b;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Object obj = this.c;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "ServiceModuleRemoteConfigModel(identifiers=" + this.a + ", remoteConfigMetaInfo=" + this.b + ", featuresConfig=" + this.c + ')';
    }

    public final SdkIdentifiers a() {
        return this.a;
    }

    public static C2977xj a(C2977xj c2977xj, SdkIdentifiers sdkIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            sdkIdentifiers = c2977xj.a;
        }
        if ((i & 2) != 0) {
            remoteConfigMetaInfo = c2977xj.b;
        }
        if ((i & 4) != 0) {
            obj = c2977xj.c;
        }
        c2977xj.getClass();
        return new C2977xj(sdkIdentifiers, remoteConfigMetaInfo, obj);
    }
}
