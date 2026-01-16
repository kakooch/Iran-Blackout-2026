package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC7782Te1;
import ir.nasim.InterfaceC9654aK5;
import ir.nasim.ND6;
import ir.nasim.UP5;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class NioWebSocketMessageChannel extends NioTcpMessageChannel {
    private static StackLogger logger = CommonLogger.getLogger(NioWebSocketMessageChannel.class);
    boolean client;
    private WebSocketCodec codec;
    AtomicBoolean httpClientRequestSent;
    String httpHostHeader;
    String httpInput;
    String httpLocation;
    String httpMethod;
    boolean readingHttp;
    private SIPTransactionStack stack;

    protected NioWebSocketMessageChannel(SIPTransactionStack sIPTransactionStack, NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        super(nioTcpMessageProcessor, socketChannel);
        this.codec = new WebSocketCodec(true, true);
        this.readingHttp = true;
        this.httpInput = "";
        this.httpClientRequestSent = new AtomicBoolean(false);
        this.stack = sIPTransactionStack;
        this.messageProcessor = nioTcpMessageProcessor;
        this.myClientInputStream = socketChannel.socket().getInputStream();
    }

    public static byte[] wrapBufferIntoWebSocketFrame(byte[] bArr, boolean z) {
        try {
            return WebSocketCodec.encode(bArr, 0, true, z);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel
    protected void addBytes(byte[] bArr) throws Throwable {
        String str = new String(bArr);
        boolean z = this.readingHttp;
        if (z) {
            byte[] bArr2 = null;
            for (int i = 0; i < bArr.length - 3; i++) {
                if (bArr[i] == 13 && bArr[i + 1] == 10 && bArr[i + 2] == 13 && bArr[i + 3] == 10) {
                    int i2 = i + 4;
                    str = str.substring(0, i2);
                    int length = (bArr.length - i) - 4;
                    byte[] bArr3 = new byte[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        bArr3[i3] = bArr[i2 + i3];
                    }
                    bArr2 = bArr3;
                }
            }
            this.httpInput += str;
            if (str.endsWith(Separators.NEWLINE) || str.endsWith(Separators.RETURN)) {
                this.readingHttp = false;
                if (this.httpInput.startsWith("HTTP")) {
                    logger.logDebug("HTTP Response. We are websocket client.\n" + this.httpInput);
                } else {
                    sendNonWebSocketMessage(new WebSocketHttpHandshake().createHttpResponse(str), false);
                }
            }
            if (bArr2 != null) {
                addBytes(bArr2);
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (true) {
            byte[] bArrDecode = this.codec.decode(byteArrayInputStream);
            if (this.codec.isCloseOpcodeReceived()) {
                logger.logDebug("Websocket close, sending polite close response");
                this.socketChannel.write(ByteBuffer.wrap(new byte[]{-120, 0}));
                return;
            } else {
                if (bArrDecode == null) {
                    return;
                }
                this.nioParser.addBytes(bArrDecode);
                logger.logDebug("Nio websocket bytes were added " + bArrDecode.length);
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return this.messageProcessor.transport;
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel
    public void onNewSocket(byte[] bArr) {
        super.onNewSocket(bArr);
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel, android.gov.nist.javax.sip.parser.SIPMessageListener, android.gov.nist.javax.sip.stack.RawMessageChannel
    public void processMessage(SIPMessage sIPMessage) throws Exception {
        if (this.stack.isPatchWebSocketHeaders()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Patching WebSocket headers");
            }
            if (sIPMessage instanceof UP5) {
                InterfaceC7782Te1 interfaceC7782Te1 = (InterfaceC7782Te1) sIPMessage.getHeader(SIPHeaderNames.CONTACT);
                InterfaceC9654aK5 interfaceC9654aK5 = (InterfaceC9654aK5) sIPMessage.getHeader(SIPHeaderNames.RECORD_ROUTE);
                InterfaceC18318oS7 topmostViaHeader = sIPMessage.getTopmostViaHeader();
                if (interfaceC9654aK5 != null) {
                    rewriteUri((ND6) interfaceC9654aK5.getAddress().getURI());
                } else if (interfaceC7782Te1 != null) {
                    rewriteUri((ND6) interfaceC7782Te1.getAddress().getURI());
                }
                if (topmostViaHeader.getHost().endsWith(".invalid")) {
                    topmostViaHeader.setHost(getPeerAddress());
                    topmostViaHeader.setPort(getPeerPort());
                }
            } else {
                InterfaceC7782Te1 interfaceC7782Te12 = (InterfaceC7782Te1) sIPMessage.getHeader(SIPHeaderNames.CONTACT);
                if (interfaceC7782Te12 != null) {
                    rewriteUri((ND6) interfaceC7782Te12.getAddress().getURI());
                }
            }
        }
        super.processMessage(sIPMessage);
    }

    public void rewriteUri(ND6 nd6) {
        try {
            if (nd6.getHost().endsWith(".invalid")) {
                nd6.setHost(getPeerAddress());
            }
        } catch (ParseException e) {
            logger.logError("Cant parse address", e);
        }
        nd6.setPort(getPeerPort());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    public void sendMessage(byte[] bArr, boolean z) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendMessage isClient  = " + z + " this = " + this);
        }
        this.lastActivityTimeStamp = System.currentTimeMillis();
        NIOHandler nIOHandler = ((NioTcpMessageProcessor) this.messageProcessor).nioHandler;
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null && socketChannel.isConnected() && this.socketChannel.isOpen()) {
            nIOHandler.putSocket(NIOHandler.makeKey(this.peerAddress, this.peerPort), this.socketChannel);
        }
        sendWrapped(bArr, this.peerAddress, this.peerPort, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendNonWebSocketMessage(byte[] bArr, boolean z) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendMessage isClient  = " + z + " this = " + this);
        }
        this.lastActivityTimeStamp = System.currentTimeMillis();
        NIOHandler nIOHandler = ((NioTcpMessageProcessor) this.messageProcessor).nioHandler;
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null && socketChannel.isConnected() && this.socketChannel.isOpen()) {
            nIOHandler.putSocket(NIOHandler.makeKey(this.peerAddress, this.peerPort), this.socketChannel);
        }
        super.sendTCPMessage(bArr, this.peerAddress, this.peerPort, z);
    }

    public void sendWrapped(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws Throwable {
        if (this.client && this.readingHttp && this.httpClientRequestSent.compareAndSet(false, true)) {
            super.sendTCPMessage("null null HTTP/1.1\r\nHost: null \r\nUpgrade: websocket\r\nConnection: Upgrade\r\nSec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==\r\nSec-WebSocket-Protocol: sip\r\nSec-WebSocket-Version: 13\r\n\r\n".getBytes(), inetAddress, i, false);
            try {
                Thread.sleep(150L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.sendTCPMessage(wrapBufferIntoWebSocketFrame(bArr, this.client), inetAddress, i, z);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws Throwable {
        sendWrapped(bArr, inetAddress, i, z);
    }

    public NioWebSocketMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, NioTcpMessageProcessor nioTcpMessageProcessor) {
        super(inetAddress, i, sIPTransactionStack, nioTcpMessageProcessor);
        this.codec = new WebSocketCodec(true, true);
        this.readingHttp = true;
        this.httpInput = "";
        this.httpClientRequestSent = new AtomicBoolean(false);
        this.client = true;
        this.stack = sIPTransactionStack;
        this.codec = new WebSocketCodec(false, true);
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(SIPMessage sIPMessage, InetAddress inetAddress, int i) throws Throwable {
        if ((sIPMessage instanceof SIPRequest) && this.client && this.httpClientRequestSent.compareAndSet(false, true)) {
            ND6 nd6 = (ND6) ((SIPRequest) sIPMessage).getRequestURI();
            this.httpHostHeader = nd6.getHeader("Host");
            this.httpLocation = nd6.getHeader("Location");
            this.httpMethod = nd6.getMethodParam();
            super.sendTCPMessage((this.httpMethod + Separators.SP + this.httpLocation + " HTTP/1.1\r\nHost: " + this.httpHostHeader + Separators.NEWLINE + "Upgrade: websocket\r\nConnection: Upgrade\r\nSec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==\r\nSec-WebSocket-Protocol: sip\r\nSec-WebSocket-Version: 13\r\n\r\n").getBytes(), inetAddress, i, false);
            try {
                Thread.sleep(150L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.sendMessage(sIPMessage, inetAddress, i);
    }
}
