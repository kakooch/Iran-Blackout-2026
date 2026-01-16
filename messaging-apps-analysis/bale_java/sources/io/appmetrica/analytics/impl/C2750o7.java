package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.ED1;

/* renamed from: io.appmetrica.analytics.impl.o7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2750o7 implements Converter {
    public final C2726n7 a;

    /* JADX WARN: Multi-variable type inference failed */
    public C2750o7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final byte[] a(C2774p7 c2774p7) {
        return MessageNano.toByteArray(this.a.fromModel(c2774p7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.a.fromModel((C2774p7) obj));
    }

    public C2750o7(C2726n7 c2726n7) {
        this.a = c2726n7;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000f A[Catch: InvalidProtocolBufferNanoException -> 0x0015, TRY_LEAVE, TryCatch #0 {InvalidProtocolBufferNanoException -> 0x0015, blocks: (B:3:0x0002, B:5:0x000f), top: B:10:0x0002 }] */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.C2774p7 toModel(byte[] r2) {
        /*
            r1 = this;
            if (r2 == 0) goto Lf
            io.appmetrica.analytics.impl.m7 r0 = new io.appmetrica.analytics.impl.m7     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            r0.<init>()     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            io.appmetrica.analytics.protobuf.nano.MessageNano r2 = io.appmetrica.analytics.protobuf.nano.MessageNano.mergeFrom(r0, r2)     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            io.appmetrica.analytics.impl.m7 r2 = (io.appmetrica.analytics.impl.C2702m7) r2     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            if (r2 != 0) goto L1a
        Lf:
            io.appmetrica.analytics.impl.m7 r2 = new io.appmetrica.analytics.impl.m7     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            r2.<init>()     // Catch: io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException -> L15
            goto L1a
        L15:
            io.appmetrica.analytics.impl.m7 r2 = new io.appmetrica.analytics.impl.m7
            r2.<init>()
        L1a:
            io.appmetrica.analytics.impl.n7 r0 = r1.a
            io.appmetrica.analytics.impl.p7 r2 = r0.toModel(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2750o7.toModel(byte[]):io.appmetrica.analytics.impl.p7");
    }

    public /* synthetic */ C2750o7(C2726n7 c2726n7, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C2726n7(null, 1, null) : c2726n7);
    }
}
