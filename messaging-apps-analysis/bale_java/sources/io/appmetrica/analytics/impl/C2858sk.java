package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;

/* renamed from: io.appmetrica.analytics.impl.sk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2858sk implements PermissionExtractor {
    public static final String b = "[SimplePermissionExtractor]";
    public final PermissionStrategy a;

    public C2858sk(PermissionStrategy permissionStrategy) {
        this.a = permissionStrategy;
    }

    public final PermissionStrategy a() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor
    public final boolean hasPermission(Context context, String str) {
        if (this.a.forbidUsePermission(str)) {
            return false;
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
