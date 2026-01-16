package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* renamed from: io.appmetrica.analytics.impl.w9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2943w9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2835rl fromModel(C2919v9 c2919v9) {
        C2835rl c2835rl = new C2835rl();
        if (c2919v9 != null) {
            c2835rl.a = c2919v9.a;
        }
        return c2835rl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C2919v9(((C2835rl) obj).a);
    }

    public final C2919v9 a(C2835rl c2835rl) {
        return new C2919v9(c2835rl.a);
    }
}
