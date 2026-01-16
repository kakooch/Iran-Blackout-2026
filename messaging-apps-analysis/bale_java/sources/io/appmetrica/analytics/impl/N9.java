package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import ir.nasim.AbstractC13042fc3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class N9 {
    public final Sk a = new Sk();
    public P9 b = new P9();

    public final synchronized void a(P9 p9) {
        this.b = p9;
    }

    public final synchronized void a(List list, HashMap map) {
        Boolean bool;
        String str;
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (AbstractC13042fc3.d((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.a) != null) {
                    boolean zBooleanValue = bool.booleanValue();
                    P9 p9 = this.b;
                    IdentifierStatus identifierStatus = p9.b;
                    String str2 = p9.c;
                    if (zBooleanValue) {
                        str = "true";
                    } else {
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str = "false";
                    }
                    map.put("appmetrica_lib_ssl_enabled", this.a.a(new IdentifiersResult(str, identifierStatus, str2)));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
