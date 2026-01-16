package io.sentry.transport;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* loaded from: classes3.dex */
final class v extends Authenticator {
    private final String a;
    private final String b;

    v(String str, String str2) {
        this.a = (String) io.sentry.util.u.c(str, "user is required");
        this.b = (String) io.sentry.util.u.c(str2, "password is required");
    }

    @Override // java.net.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.a, this.b.toCharArray());
        }
        return null;
    }
}
