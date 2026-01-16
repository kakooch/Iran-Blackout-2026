package org.xbill.DNS.io;

/* loaded from: classes8.dex */
public interface IoClientFactory {
    TcpIoClient createOrGetTcpClient();

    UdpIoClient createOrGetUdpClient();
}
