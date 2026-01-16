package io.sentry;

/* renamed from: io.sentry.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3031a implements InterfaceC3137k0 {
    @Override // io.sentry.InterfaceC3137k0
    public io.sentry.transport.q a(C3155n3 c3155n3, C3227y1 c3227y1) {
        io.sentry.util.u.c(c3155n3, "options is required");
        io.sentry.util.u.c(c3227y1, "requestDetails is required");
        return new io.sentry.transport.e(c3155n3, new io.sentry.transport.A(c3155n3), c3155n3.getTransportGate(), c3227y1);
    }
}
