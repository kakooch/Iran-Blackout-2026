package io.sentry;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum Y2 implements A0 {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Y2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return Y2.valueOf(interfaceC3118g1.T0().toUpperCase(Locale.ROOT));
        }
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h(name().toLowerCase(Locale.ROOT));
    }
}
