package io.sentry.transport;

import java.net.Authenticator;

/* loaded from: classes3.dex */
final class m {
    private static final m a = new m();

    private m() {
    }

    public static m a() {
        return a;
    }

    public void b(Authenticator authenticator) {
        Authenticator.setDefault(authenticator);
    }
}
