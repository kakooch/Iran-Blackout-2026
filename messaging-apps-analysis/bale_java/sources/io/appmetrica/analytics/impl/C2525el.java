package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* renamed from: io.appmetrica.analytics.impl.el, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2525el {
    public final ProtobufStateStorage a;
    public final sn b;

    public C2525el(ProtobufStateStorage protobufStateStorage, sn snVar) {
        this.a = protobufStateStorage;
        this.b = snVar;
    }

    public C2525el(Context context) {
        this(Ql.a(C2644jl.class).a(context), C2586ha.h().A().a());
    }
}
