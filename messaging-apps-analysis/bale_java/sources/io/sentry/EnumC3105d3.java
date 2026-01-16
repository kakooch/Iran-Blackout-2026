package io.sentry;

import java.util.Locale;

/* renamed from: io.sentry.d3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC3105d3 implements A0 {
    TRACE(1),
    DEBUG(5),
    INFO(9),
    WARN(13),
    ERROR(17),
    FATAL(21);

    private final int severityNumber;

    /* renamed from: io.sentry.d3$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3105d3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return EnumC3105d3.valueOf(interfaceC3118g1.T0().toUpperCase(Locale.ROOT));
        }
    }

    EnumC3105d3(int i) {
        this.severityNumber = i;
    }

    public int getSeverityNumber() {
        return this.severityNumber;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h(name().toLowerCase(Locale.ROOT));
    }
}
