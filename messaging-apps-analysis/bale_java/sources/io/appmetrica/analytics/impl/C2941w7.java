package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.w7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2941w7 {
    public final Ca a;
    public String b = "";

    public C2941w7(Ca ca) {
        this.a = ca;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || AbstractC13042fc3.d(this.b, str)) {
                return;
            }
            this.b = str;
            this.a.a(str, z);
        }
    }
}
