package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.ED1;

/* renamed from: io.appmetrica.analytics.impl.n7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2726n7 implements ProtobufConverter {
    public final Dd a;

    /* JADX WARN: Multi-variable type inference failed */
    public C2726n7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2702m7 fromModel(C2774p7 c2774p7) {
        C2702m7 c2702m7 = new C2702m7();
        Long l = c2774p7.a;
        if (l != null) {
            c2702m7.a = l.longValue();
        }
        Long l2 = c2774p7.b;
        if (l2 != null) {
            c2702m7.b = l2.longValue();
        }
        Boolean bool = c2774p7.c;
        if (bool != null) {
            c2702m7.c = this.a.fromModel(bool).intValue();
        }
        return c2702m7;
    }

    public C2726n7(Dd dd) {
        this.a = dd;
    }

    public /* synthetic */ C2726n7(Dd dd, int i, ED1 ed1) {
        this((i & 1) != 0 ? new Dd() : dd);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2774p7 toModel(C2702m7 c2702m7) {
        C2702m7 c2702m72 = new C2702m7();
        long j = c2702m7.a;
        Long lValueOf = Long.valueOf(j);
        if (j == c2702m72.a) {
            lValueOf = null;
        }
        long j2 = c2702m7.b;
        return new C2774p7(lValueOf, j2 != c2702m72.b ? Long.valueOf(j2) : null, this.a.a(c2702m7.c));
    }
}
