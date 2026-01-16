package io.grpc;

import io.grpc.Attributes;
import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public final class Grpc {
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("remote-addr");
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("local-addr");
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("ssl-session");
}
