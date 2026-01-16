package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import ir.nasim.AbstractC4597Fu6;
import java.util.Set;

/* loaded from: classes3.dex */
public final class e implements PermissionStrategy {
    public Set a = AbstractC4597Fu6.d();

    public final synchronized void a(Set<String> set) {
        this.a = set;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final synchronized boolean forbidUsePermission(String str) {
        return !this.a.contains(str);
    }
}
