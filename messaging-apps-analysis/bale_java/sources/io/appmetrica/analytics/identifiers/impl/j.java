package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;

/* loaded from: classes3.dex */
public final class j implements b {
    public final f a;

    public j(f fVar) {
        this.a = fVar;
    }

    @Override // io.appmetrica.analytics.identifiers.impl.b
    public final c a(Context context) {
        c cVar;
        f fVar;
        try {
            try {
                try {
                    try {
                        m mVar = (m) ((o) this.a.a(context));
                        cVar = new c(IdentifierStatus.OK, new a("huawei", mVar.a(), Boolean.valueOf(mVar.b())), null, 4);
                        fVar = this.a;
                    } catch (g e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "unknown exception during binding huawei services";
                        }
                        cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message);
                        fVar = this.a;
                    }
                } finally {
                    fVar.b(context);
                }
                fVar.b(context);
            } catch (Throwable th) {
                try {
                    this.a.b(context);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return cVar;
    }

    public j() {
        this(new f(k.a, i.a, "huawei"));
    }
}
