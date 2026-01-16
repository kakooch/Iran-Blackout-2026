package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.n5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2724n5 implements PermissionStrategy {
    public final PermissionStrategy[] a;

    public C2724n5(PermissionStrategy... permissionStrategyArr) {
        this.a = permissionStrategyArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        for (PermissionStrategy permissionStrategy : this.a) {
            if (permissionStrategy.forbidUsePermission(str)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "CompositePermissionStrategy(strategies=" + Arrays.toString(this.a) + ')';
    }
}
