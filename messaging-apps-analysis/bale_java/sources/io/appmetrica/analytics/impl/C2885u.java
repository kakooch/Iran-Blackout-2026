package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.UA2;

/* renamed from: io.appmetrica.analytics.impl.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2885u extends AbstractC8614Ws3 implements UA2 {
    public final /* synthetic */ C2861t a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2885u(C2861t c2861t) {
        super(1);
        this.a = c2861t;
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        this.a.e = (byte[]) obj;
        return C19938rB7.a;
    }
}
