package io.sentry;

import io.sentry.util.q;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class M3 implements A0 {
    public static final M3 b = new M3("00000000-0000-0000-0000-000000000000".replace("-", "").substring(0, 16));
    private final io.sentry.util.q a;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public M3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return new M3(interfaceC3118g1.T0());
        }
    }

    public M3(final String str) {
        Objects.requireNonNull(str, "value is required");
        this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.L3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return M3.b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String b(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || M3.class != obj.getClass()) {
            return false;
        }
        return ((String) this.a.a()).equals(((M3) obj).a.a());
    }

    public int hashCode() {
        return ((String) this.a.a()).hashCode();
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h((String) this.a.a());
    }

    public String toString() {
        return (String) this.a.a();
    }

    public M3() {
        this.a = new io.sentry.util.q(new q.a() { // from class: io.sentry.K3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return A3.b();
            }
        });
    }
}
