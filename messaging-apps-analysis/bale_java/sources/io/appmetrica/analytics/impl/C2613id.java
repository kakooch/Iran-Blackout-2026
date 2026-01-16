package io.appmetrica.analytics.impl;

import ir.nasim.C19938rB7;
import ir.nasim.EB2;
import ir.nasim.UA2;

/* renamed from: io.appmetrica.analytics.impl.id, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2613id extends EB2 implements UA2 {
    public C2613id(C2636jd c2636jd) {
        super(1, c2636jd, C2636jd.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        C2636jd c2636jd = (C2636jd) this.receiver;
        c2636jd.a.markCrashCompleted((String) obj);
        c2636jd.a.deleteCompletedCrashes();
        return C19938rB7.a;
    }
}
