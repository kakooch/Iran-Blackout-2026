package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class B6 implements DataSendingRestrictionController {
    public final InterfaceC3012z6 a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public B6(InterfaceC3012z6 interfaceC3012z6) {
        this.a = interfaceC3012z6;
        this.b = ((A6) interfaceC3012z6).a();
    }

    public final synchronized void a(Boolean bool) {
        try {
            if (hn.a(bool) || this.b == null) {
                boolean zEquals = Boolean.FALSE.equals(bool);
                this.b = Boolean.valueOf(zEquals);
                ((A6) this.a).a.b(zEquals).b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final boolean isRestrictedForBackgroundDataCollection() {
        Boolean bool = this.b;
        return bool == null ? !this.c.isEmpty() || this.d.isEmpty() : bool.booleanValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForReporter() {
        Boolean bool;
        try {
            bool = this.b;
        } finally {
        }
        return bool == null ? this.d.isEmpty() && this.c.isEmpty() : bool.booleanValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForSdk() {
        Boolean bool;
        try {
            bool = this.b;
        } catch (Throwable th) {
            throw th;
        }
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public final synchronized void a(String str, Boolean bool) {
        try {
            if (hn.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
                if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
                    this.d.add(str);
                    this.c.remove(str);
                } else {
                    this.c.add(str);
                    this.d.remove(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
