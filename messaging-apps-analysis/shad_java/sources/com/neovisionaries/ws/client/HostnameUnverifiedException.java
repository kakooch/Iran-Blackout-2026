package com.neovisionaries.ws.client;

import io.github.inflationx.calligraphy3.BuildConfig;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public class HostnameUnverifiedException extends WebSocketException {
    public HostnameUnverifiedException(SSLSocket sSLSocket, String str) {
        super(WebSocketError.HOSTNAME_UNVERIFIED, String.format("The certificate of the peer%s does not match the expected hostname (%s)", stringifyPrincipal(sSLSocket), str));
    }

    private static String stringifyPrincipal(SSLSocket sSLSocket) {
        try {
            return String.format(" (%s)", sSLSocket.getSession().getPeerPrincipal().toString());
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
