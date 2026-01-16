package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;

/* renamed from: io.appmetrica.analytics.impl.i2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2602i2 extends AbstractC2568gg {
    public final tn b;
    public final C2642jj c;

    public C2602i2(C2484d5 c2484d5) {
        this(c2484d5, c2484d5.u(), C2642jj.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        C2484d5 c2484d5 = this.a;
        if (!this.b.c() && !this.b.d()) {
            if (((Cg) c2484d5.l.a()).f) {
                this.c.b();
            }
            F8 f8 = this.a.m;
            if (f8.c == null) {
                f8.a();
            }
            H8 h8 = f8.c;
            h8.getClass();
            h8.b = new HashSet();
            h8.d = 0;
            H8 h82 = f8.c;
            h82.a = true;
            K8 k8 = f8.b;
            IBinaryDataHelper iBinaryDataHelper = k8.c;
            J8 j8 = k8.b;
            k8.a.getClass();
            C2728n9 c2728n9A = I8.a(h82);
            j8.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(c2728n9A));
        }
        return false;
    }

    public C2602i2(C2484d5 c2484d5, tn tnVar, C2642jj c2642jj) {
        super(c2484d5);
        this.b = tnVar;
        this.c = c2642jj;
    }
}
