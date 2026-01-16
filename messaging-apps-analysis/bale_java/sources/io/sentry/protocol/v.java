package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.A3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.q;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class v implements A0 {
    public static final v b = new v("00000000-0000-0000-0000-000000000000".replace("-", ""));
    private final io.sentry.util.q a;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return new v(interfaceC3118g1.T0());
        }
    }

    public v() {
        this((UUID) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String d(UUID uuid) {
        return e(io.sentry.util.H.c(uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String e(String str) {
        return io.sentry.util.B.e(str).replace("-", "");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        return ((String) this.a.a()).equals(((v) obj).a.a());
    }

    public int hashCode() {
        return ((String) this.a.a()).hashCode();
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h(toString());
    }

    public String toString() {
        return (String) this.a.a();
    }

    public v(final UUID uuid) {
        if (uuid != null) {
            this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.protocol.r
                @Override // io.sentry.util.q.a
                public final Object a() {
                    return this.a.d(uuid);
                }
            });
        } else {
            this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.protocol.s
                @Override // io.sentry.util.q.a
                public final Object a() {
                    return A3.a();
                }
            });
        }
    }

    public v(String str) {
        final String strE = io.sentry.util.B.e(str);
        if (strE.length() != 32 && strE.length() != 36) {
            throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
        }
        if (strE.length() == 36) {
            this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.protocol.t
                @Override // io.sentry.util.q.a
                public final Object a() {
                    return this.a.e(strE);
                }
            });
        } else {
            this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.protocol.u
                @Override // io.sentry.util.q.a
                public final Object a() {
                    return v.f(strE);
                }
            });
        }
    }
}
