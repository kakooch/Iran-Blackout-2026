package org.xbill.DNS;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import org.xbill.DNS.io.TcpIoClient;
import org.xbill.DNS.io.UdpIoClient;

/* loaded from: classes8.dex */
public class DefaultIoClient implements TcpIoClient, UdpIoClient {
    private final TcpIoClient tcpIoClient = new NioTcpClient();
    private final UdpIoClient udpIoClient = new NioUdpClient();

    @Override // org.xbill.DNS.io.TcpIoClient
    public CompletableFuture<byte[]> sendAndReceiveTcp(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, Duration duration) {
        return this.tcpIoClient.sendAndReceiveTcp(inetSocketAddress, inetSocketAddress2, message, bArr, duration);
    }

    @Override // org.xbill.DNS.io.UdpIoClient
    public CompletableFuture<byte[]> sendAndReceiveUdp(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, int i, Duration duration) {
        return this.udpIoClient.sendAndReceiveUdp(inetSocketAddress, inetSocketAddress2, message, bArr, i, duration);
    }
}
