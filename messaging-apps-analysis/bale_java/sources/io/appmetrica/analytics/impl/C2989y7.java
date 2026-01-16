package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;

/* renamed from: io.appmetrica.analytics.impl.y7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2989y7 implements AskForPermissionStrategyModuleProvider {
    public final C2756od a = new C2756od();

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.a;
    }
}
