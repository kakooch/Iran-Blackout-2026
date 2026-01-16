package io.sentry;

import java.util.ArrayList;

/* renamed from: io.sentry.j2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3134j2 {
    private final C3139k2 a;
    private final Iterable b;

    public C3134j2(C3139k2 c3139k2, Iterable iterable) {
        this.a = (C3139k2) io.sentry.util.u.c(c3139k2, "SentryEnvelopeHeader is required.");
        this.b = (Iterable) io.sentry.util.u.c(iterable, "SentryEnvelope items are required.");
    }

    public static C3134j2 a(InterfaceC3107e0 interfaceC3107e0, C3 c3, io.sentry.protocol.p pVar) {
        io.sentry.util.u.c(interfaceC3107e0, "Serializer is required.");
        io.sentry.util.u.c(c3, "session is required.");
        return new C3134j2(null, pVar, J2.G(interfaceC3107e0, c3));
    }

    public C3139k2 b() {
        return this.a;
    }

    public Iterable c() {
        return this.b;
    }

    public C3134j2(io.sentry.protocol.v vVar, io.sentry.protocol.p pVar, J2 j2) {
        io.sentry.util.u.c(j2, "SentryEnvelopeItem is required.");
        this.a = new C3139k2(vVar, pVar);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(j2);
        this.b = arrayList;
    }
}
