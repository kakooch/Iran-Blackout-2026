package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.tg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2878tg extends AbstractC2568gg {
    public final Ld b;
    public final ProtobufStateStorage c;
    public final F2 d;
    public final C2481d2 e;
    public final C2984y2 f;

    public C2878tg(C2484d5 c2484d5, Ld ld) {
        this(c2484d5, ld, Ql.a(U1.class).a(c2484d5.getContext()), new F2(c2484d5.getContext()), new C2481d2(), new C2984y2(c2484d5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        C2484d5 c2484d5 = this.a;
        c2484d5.b.toString();
        if (!c2484d5.v.c() || !c2484d5.x()) {
            return false;
        }
        U1 u1 = (U1) this.c.read();
        List list = u1.a;
        E2 e2 = u1.b;
        F2 f2 = this.d;
        f2.getClass();
        U1 u12 = null;
        E2 e2A = AndroidUtils.isApiAchieved(28) ? B2.a(f2.a, f2.b) : null;
        List list2 = u1.c;
        List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.a, "getting available providers", "location manager", Collections.emptyList(), new C2960x2());
        Ld ld = this.b;
        Context context = this.a.a;
        ld.getClass();
        ArrayList arrayListA = new C2497di(context, new SafePackageManager()).a();
        if (CollectionUtils.areCollectionsEqual(arrayListA, list)) {
            arrayListA = null;
        }
        if (arrayListA != null || !hn.a(e2, e2A) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
            if (arrayListA != null) {
                list = arrayListA;
            }
            u12 = new U1(list, e2A, list3);
        }
        if (u12 != null) {
            C2537f9 c2537f9 = c2484d5.o;
            Q5 q5A = Q5.a(q5, u12.a, u12.b, this.e, u12.c);
            c2537f9.a(q5A, Sj.a(c2537f9.c.b(q5A), q5A.i));
            long jCurrentTimeSeconds = c2537f9.j.currentTimeSeconds();
            c2537f9.l = jCurrentTimeSeconds;
            c2537f9.a.a(jCurrentTimeSeconds).b();
            this.c.save(u12);
            return false;
        }
        if (!c2484d5.A()) {
            return false;
        }
        C2537f9 c2537f92 = c2484d5.o;
        Q5 q5A2 = Q5.a(q5, u1.a, u1.b, this.e, u1.c);
        c2537f92.a(q5A2, Sj.a(c2537f92.c.b(q5A2), q5A2.i));
        long jCurrentTimeSeconds2 = c2537f92.j.currentTimeSeconds();
        c2537f92.l = jCurrentTimeSeconds2;
        c2537f92.a.a(jCurrentTimeSeconds2).b();
        return false;
    }

    public C2878tg(C2484d5 c2484d5, Ld ld, ProtobufStateStorage protobufStateStorage, F2 f2, C2481d2 c2481d2, C2984y2 c2984y2) {
        super(c2484d5);
        this.b = ld;
        this.c = protobufStateStorage;
        this.d = f2;
        this.e = c2481d2;
        this.f = c2984y2;
    }
}
