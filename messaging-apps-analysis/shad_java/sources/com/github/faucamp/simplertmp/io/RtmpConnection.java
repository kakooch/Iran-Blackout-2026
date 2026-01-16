package com.github.faucamp.simplertmp.io;

import android.util.Log;
import com.github.faucamp.simplertmp.RtmpPublisher;
import com.github.faucamp.simplertmp.Util;
import com.github.faucamp.simplertmp.amf.AmfMap;
import com.github.faucamp.simplertmp.amf.AmfNull;
import com.github.faucamp.simplertmp.amf.AmfObject;
import com.github.faucamp.simplertmp.packets.Abort;
import com.github.faucamp.simplertmp.packets.Audio;
import com.github.faucamp.simplertmp.packets.Command;
import com.github.faucamp.simplertmp.packets.Data;
import com.github.faucamp.simplertmp.packets.Handshake;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import com.github.faucamp.simplertmp.packets.RtmpPacket;
import com.github.faucamp.simplertmp.packets.UserControl;
import com.github.faucamp.simplertmp.packets.Video;
import com.github.faucamp.simplertmp.packets.WindowAckSize;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ossrs.rtmp.BitrateManager;
import net.ossrs.rtmp.ConnectCheckerRtmp;
import net.ossrs.rtmp.CreateSSLSocket;

/* loaded from: classes.dex */
public class RtmpConnection implements RtmpPublisher {
    private String appName;
    private BitrateManager bitrateManager;
    private ConnectCheckerRtmp connectCheckerRtmp;
    private String host;
    private BufferedInputStream inputStream;
    private String netConnectionDescription;
    private BufferedOutputStream outputStream;
    private String pageUrl;
    private int port;
    private String publishType;
    private RtmpDecoder rtmpDecoder;
    private RtmpSessionInfo rtmpSessionInfo;
    private Thread rxPacketHandler;
    private Socket socket;
    private String streamName;
    private String swfUrl;
    private String tcUrl;
    private boolean tlsEnabled;
    private int videoHeight;
    private int videoWidth;
    private static final Pattern rtmpUrlPattern = Pattern.compile("^rtmps?://([^/:]+)(?::(\\d+))*/([^/]+)/?([^*]*)$");
    public static long lastAcknowledgementTime = 9223372036854775805L;
    public static long lastAcknowledgementTimeSendPacket = 9223372036854775805L;
    private volatile boolean connected = false;
    private volatile boolean publishPermitted = false;
    private final Object connectingLock = new Object();
    private final Object publishLock = new Object();
    private int currentStreamId = 0;
    private int transactionIdCounter = 0;
    private String user = null;
    private String password = null;
    private String salt = null;
    private String challenge = null;
    private String opaque = null;
    private boolean onAuth = false;

    public RtmpConnection(ConnectCheckerRtmp connectCheckerRtmp) {
        this.connectCheckerRtmp = connectCheckerRtmp;
        this.bitrateManager = new BitrateManager(connectCheckerRtmp);
        lastAcknowledgementTime = System.currentTimeMillis();
        lastAcknowledgementTimeSendPacket = System.currentTimeMillis();
    }

    private void handshake(InputStream inputStream, OutputStream outputStream) throws IOException, InvalidKeyException {
        Handshake handshake = new Handshake();
        handshake.writeC0(outputStream);
        handshake.writeC1(outputStream);
        outputStream.flush();
        handshake.readS0(inputStream);
        handshake.readS1(inputStream);
        handshake.writeC2(outputStream);
        outputStream.flush();
        handshake.readS2(inputStream);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public boolean connect(String str) throws IOException, InvalidKeyException {
        Matcher matcher = rtmpUrlPattern.matcher(str);
        if (matcher.matches()) {
            this.tlsEnabled = matcher.group(0).startsWith("rtmps");
            this.swfUrl = BuildConfig.FLAVOR;
            this.pageUrl = BuildConfig.FLAVOR;
            this.host = matcher.group(1);
            String strGroup = matcher.group(2);
            this.port = strGroup != null ? Integer.parseInt(strGroup) : 1935;
            this.appName = matcher.group(3);
            this.streamName = matcher.group(4);
            this.tcUrl = matcher.group(0).substring(0, matcher.group(0).length() - this.streamName.length());
            Log.d("RtmpConnection", "connect() called. Host: " + this.host + ", port: " + this.port + ", appName: " + this.appName + ", publishPath: " + this.streamName);
            RtmpSessionInfo rtmpSessionInfo = new RtmpSessionInfo();
            this.rtmpSessionInfo = rtmpSessionInfo;
            this.rtmpDecoder = new RtmpDecoder(rtmpSessionInfo);
            try {
                if (!this.tlsEnabled) {
                    this.socket = new Socket();
                    this.socket.connect(new InetSocketAddress(this.host, this.port), 5000);
                } else {
                    Socket socketCreateSSlSocket = CreateSSLSocket.createSSlSocket(this.host, this.port);
                    this.socket = socketCreateSSlSocket;
                    if (socketCreateSSlSocket == null) {
                        throw new IOException("Socket creation failed");
                    }
                }
                this.inputStream = new BufferedInputStream(this.socket.getInputStream());
                this.outputStream = new BufferedOutputStream(this.socket.getOutputStream());
                Log.d("RtmpConnection", "connect(): socket connection established, doing handhake...");
                handshake(this.inputStream, this.outputStream);
                Log.d("RtmpConnection", "connect(): handshake done");
                Thread thread = new Thread(new Runnable() { // from class: com.github.faucamp.simplertmp.io.RtmpConnection.1
                    @Override // java.lang.Runnable
                    public void run() throws SocketException {
                        Log.d("RtmpConnection", "starting main rx handler loop");
                        RtmpConnection.this.handleRxPacketLoop();
                    }
                });
                this.rxPacketHandler = thread;
                thread.start();
                return rtmpConnect();
            } catch (IOException e) {
                Log.e("RtmpConnection", "Error", e);
                this.connectCheckerRtmp.onConnectionFailedRtmp("Connect error, " + e.getMessage());
                return false;
            }
        }
        this.connectCheckerRtmp.onConnectionFailedRtmp("Endpoint malformed, should be: rtmp://ip:port/appname/streamname");
        return false;
    }

    private boolean rtmpConnect() throws IOException {
        if (this.connected) {
            this.connectCheckerRtmp.onConnectionFailedRtmp("Already connected");
            return false;
        }
        if (this.user != null && this.password != null) {
            sendConnect("?authmod=adobe&user=" + this.user);
        } else {
            sendConnect(BuildConfig.FLAVOR);
        }
        synchronized (this.connectingLock) {
            try {
                this.connectingLock.wait(5000L);
            } catch (InterruptedException unused) {
            }
        }
        if (!this.connected) {
            shutdown(true);
            this.connectCheckerRtmp.onConnectionFailedRtmp("Fail to connect, time out");
        }
        return this.connected;
    }

    private void sendConnect(String str) throws IOException {
        ChunkStreamInfo.markSessionTimestampTx();
        Log.d("RtmpConnection", "rtmpConnect(): Building 'connect' invoke packet");
        ChunkStreamInfo chunkStreamInfo = this.rtmpSessionInfo.getChunkStreamInfo(5);
        int i = this.transactionIdCounter + 1;
        this.transactionIdCounter = i;
        Command command = new Command("connect", i, chunkStreamInfo);
        command.getHeader().setMessageStreamId(0);
        AmfObject amfObject = new AmfObject();
        amfObject.setProperty("app", this.appName + str);
        amfObject.setProperty("flashVer", "FMLE/3.0 (compatible; Lavf57.56.101)");
        amfObject.setProperty("swfUrl", this.swfUrl);
        amfObject.setProperty("tcUrl", this.tcUrl + str);
        amfObject.setProperty("fpad", false);
        amfObject.setProperty("capabilities", 239);
        amfObject.setProperty("audioCodecs", 3191);
        amfObject.setProperty("videoCodecs", 252);
        amfObject.setProperty("videoFunction", 1);
        amfObject.setProperty("pageUrl", this.pageUrl);
        amfObject.setProperty("objectEncoding", 0);
        command.addData(amfObject);
        sendRtmpPacket(command);
    }

    private String getAuthUserResult(String str, String str2, String str3, String str4, String str5) throws NoSuchAlgorithmException {
        String str6 = String.format("%08x", Integer.valueOf(new Random().nextInt()));
        String strStringToMD5BASE64 = Util.stringToMD5BASE64(str + str3 + str2);
        if (!str5.isEmpty()) {
            strStringToMD5BASE64 = strStringToMD5BASE64 + str5;
        } else if (!str4.isEmpty()) {
            strStringToMD5BASE64 = strStringToMD5BASE64 + str4;
        }
        String str7 = "?authmod=adobe&user=" + str + "&challenge=" + str6 + "&response=" + Util.stringToMD5BASE64(strStringToMD5BASE64 + str6);
        if (str5.isEmpty()) {
            return str7;
        }
        return str7 + "&opaque=" + str5;
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public boolean publish(String str) {
        if (str == null) {
            this.connectCheckerRtmp.onConnectionFailedRtmp("Null publish type");
            return false;
        }
        this.publishType = str;
        return createStream();
    }

    private boolean createStream() throws IOException {
        if (!this.connected || this.currentStreamId != 0) {
            this.connectCheckerRtmp.onConnectionFailedRtmp("Create stream failed, connected= " + this.connected + ", StreamId= " + this.currentStreamId);
            return false;
        }
        this.netConnectionDescription = null;
        Log.d("RtmpConnection", "createStream(): Sending releaseStream command...");
        int i = this.transactionIdCounter + 1;
        this.transactionIdCounter = i;
        Command command = new Command("releaseStream", i);
        command.getHeader().setChunkStreamId(5);
        command.addData(new AmfNull());
        command.addData(this.streamName);
        sendRtmpPacket(command);
        Log.d("RtmpConnection", "createStream(): Sending FCPublish command...");
        int i2 = this.transactionIdCounter + 1;
        this.transactionIdCounter = i2;
        Command command2 = new Command("FCPublish", i2);
        command2.getHeader().setChunkStreamId(5);
        command2.addData(new AmfNull());
        command2.addData(this.streamName);
        sendRtmpPacket(command2);
        Log.d("RtmpConnection", "createStream(): Sending createStream command...");
        ChunkStreamInfo chunkStreamInfo = this.rtmpSessionInfo.getChunkStreamInfo(3);
        int i3 = this.transactionIdCounter + 1;
        this.transactionIdCounter = i3;
        Command command3 = new Command("createStream", i3, chunkStreamInfo);
        command3.addData(new AmfNull());
        sendRtmpPacket(command3);
        synchronized (this.publishLock) {
            try {
                this.publishLock.wait(5000L);
            } catch (InterruptedException unused) {
            }
        }
        if (!this.publishPermitted) {
            shutdown(true);
            String str = this.netConnectionDescription;
            if (str != null && !str.isEmpty()) {
                this.connectCheckerRtmp.onConnectionFailedRtmp(this.netConnectionDescription);
            } else {
                this.connectCheckerRtmp.onConnectionFailedRtmp("Error configure stream, publish permitted failed");
            }
        }
        return this.publishPermitted;
    }

    private void fmlePublish() throws IOException {
        if (!this.connected || this.currentStreamId == 0) {
            Log.e("RtmpConnection", "fmlePublish failed");
            return;
        }
        Log.d("RtmpConnection", "fmlePublish(): Sending publish command...");
        Command command = new Command("publish", 0);
        command.getHeader().setChunkStreamId(5);
        command.getHeader().setMessageStreamId(this.currentStreamId);
        command.addData(new AmfNull());
        command.addData(this.streamName);
        command.addData(this.publishType);
        sendRtmpPacket(command);
    }

    private void onMetaData() throws IOException {
        if (!this.connected || this.currentStreamId == 0) {
            Log.e("RtmpConnection", "onMetaData failed");
            return;
        }
        Log.d("RtmpConnection", "onMetaData(): Sending empty onMetaData...");
        Data data = new Data("@setDataFrame");
        data.getHeader().setMessageStreamId(this.currentStreamId);
        data.addData("onMetaData");
        AmfMap amfMap = new AmfMap();
        amfMap.setProperty("duration", 0);
        amfMap.setProperty("width", this.videoWidth);
        amfMap.setProperty("height", this.videoHeight);
        amfMap.setProperty("videocodecid", 7);
        amfMap.setProperty("framerate", 30);
        amfMap.setProperty("videodatarate", 0);
        amfMap.setProperty("audiocodecid", 10);
        amfMap.setProperty("audiosamplerate", 44100);
        amfMap.setProperty("audiosamplesize", 16);
        amfMap.setProperty("audiodatarate", 0);
        amfMap.setProperty("stereo", true);
        amfMap.setProperty("filesize", 0);
        data.addData(amfMap);
        sendRtmpPacket(data);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void close() {
        if (this.socket != null) {
            closeStream();
        }
        shutdown(true);
    }

    private void closeStream() {
        if (this.connected && this.currentStreamId != 0 && this.publishPermitted) {
            return;
        }
        Log.e("RtmpConnection", "closeStream failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0018, B:13:0x001c, B:14:0x001f, B:17:0x002c, B:16:0x0027, B:18:0x002f, B:21:0x003d, B:23:0x0046, B:10:0x0011), top: B:29:0x0001, inners: #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void shutdown(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.net.Socket r0 = r3.socket     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L44
            r0.shutdownInput()     // Catch: java.lang.UnsupportedOperationException -> Le java.io.IOException -> L10 java.lang.Throwable -> L4b
            java.net.Socket r0 = r3.socket     // Catch: java.lang.UnsupportedOperationException -> Le java.io.IOException -> L10 java.lang.Throwable -> L4b
            r0.shutdownOutput()     // Catch: java.lang.UnsupportedOperationException -> Le java.io.IOException -> L10 java.lang.Throwable -> L4b
            goto L18
        Le:
            r0 = move-exception
            goto L11
        L10:
            r0 = move-exception
        L11:
            java.lang.String r1 = "RtmpConnection"
            java.lang.String r2 = "Shutdown socket"
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L4b
        L18:
            java.lang.Thread r0 = r3.rxPacketHandler     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L2f
            r0.interrupt()     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r0 = r3.rxPacketHandler     // Catch: java.lang.InterruptedException -> L27 java.lang.Throwable -> L4b
            r1 = 100
            r0.join(r1)     // Catch: java.lang.InterruptedException -> L27 java.lang.Throwable -> L4b
            goto L2c
        L27:
            java.lang.Thread r0 = r3.rxPacketHandler     // Catch: java.lang.Throwable -> L4b
            r0.interrupt()     // Catch: java.lang.Throwable -> L4b
        L2c:
            r0 = 0
            r3.rxPacketHandler = r0     // Catch: java.lang.Throwable -> L4b
        L2f:
            java.net.Socket r0 = r3.socket     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L4b
            r0.close()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L4b
            java.lang.String r0 = "RtmpConnection"
            java.lang.String r1 = "socket closed"
            android.util.Log.d(r0, r1)     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L4b
            goto L44
        L3c:
            r0 = move-exception
            java.lang.String r1 = "RtmpConnection"
            java.lang.String r2 = "shutdown(): failed to close socket"
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L4b
        L44:
            if (r4 == 0) goto L49
            r3.reset()     // Catch: java.lang.Throwable -> L4b
        L49:
            monitor-exit(r3)
            return
        L4b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.faucamp.simplertmp.io.RtmpConnection.shutdown(boolean):void");
    }

    private void reset() {
        this.connected = false;
        this.publishPermitted = false;
        this.netConnectionDescription = null;
        this.tcUrl = null;
        this.swfUrl = null;
        this.pageUrl = null;
        this.appName = null;
        this.streamName = null;
        this.publishType = null;
        this.currentStreamId = 0;
        this.transactionIdCounter = 0;
        this.socket = null;
        this.rtmpSessionInfo = null;
        this.user = null;
        this.password = null;
        this.salt = null;
        this.challenge = null;
        this.opaque = null;
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void publishAudioData(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null || bArr.length == 0 || i2 < 0 || !this.connected || this.currentStreamId == 0 || !this.publishPermitted) {
            return;
        }
        Audio audio = new Audio();
        audio.setData(bArr, i);
        audio.getHeader().setAbsoluteTimestamp(i2);
        audio.getHeader().setMessageStreamId(this.currentStreamId);
        sendRtmpPacket(audio);
        this.bitrateManager.calculateBitrate(i * 8);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void publishVideoData(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null || bArr.length == 0 || i2 < 0 || !this.connected || this.currentStreamId == 0 || !this.publishPermitted) {
            return;
        }
        Video video = new Video();
        video.setData(bArr, i);
        video.getHeader().setAbsoluteTimestamp(i2);
        video.getHeader().setMessageStreamId(this.currentStreamId);
        sendRtmpPacket(video);
        this.bitrateManager.calculateBitrate(i * 8);
    }

    private void sendRtmpPacket(RtmpPacket rtmpPacket) throws IOException {
        try {
            lastAcknowledgementTimeSendPacket = System.currentTimeMillis();
            ChunkStreamInfo chunkStreamInfo = this.rtmpSessionInfo.getChunkStreamInfo(rtmpPacket.getHeader().getChunkStreamId());
            chunkStreamInfo.setPrevHeaderTx(rtmpPacket.getHeader());
            if (!(rtmpPacket instanceof Video) && !(rtmpPacket instanceof Audio)) {
                rtmpPacket.getHeader().setAbsoluteTimestamp((int) chunkStreamInfo.markAbsoluteTimestampTx());
            }
            rtmpPacket.writeTo(this.outputStream, this.rtmpSessionInfo.getTxChunkSize(), chunkStreamInfo);
            Log.d("RtmpConnection", "wrote packet: " + rtmpPacket + ", size: " + rtmpPacket.getHeader().getPacketLength());
            if (rtmpPacket instanceof Command) {
                this.rtmpSessionInfo.addInvokedCommand(((Command) rtmpPacket).getTransactionId(), ((Command) rtmpPacket).getCommandName());
            }
            this.outputStream.flush();
        } catch (SocketException e) {
            this.connectCheckerRtmp.onConnectionFailedRtmp("Error send packet: " + e.getMessage());
            Log.e("RtmpConnection", "Caught SocketException during write loop, shutting down: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (IOException e2) {
            this.connectCheckerRtmp.onConnectionFailedRtmp("Error send packet: " + e2.getMessage());
            Log.e("RtmpConnection", "Caught IOException during write loop, shutting down: " + e2.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRxPacketLoop() throws SocketException {
        while (!Thread.interrupted()) {
            try {
                RtmpPacket packet = this.rtmpDecoder.readPacket(this.inputStream);
                if (packet != null) {
                    switch (AnonymousClass3.$SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[packet.getHeader().getMessageType().ordinal()]) {
                        case 1:
                            this.rtmpSessionInfo.getChunkStreamInfo(((Abort) packet).getChunkStreamId()).clearStoredChunks();
                            continue;
                        case 2:
                            UserControl userControl = (UserControl) packet;
                            int i = AnonymousClass3.$SwitchMap$com$github$faucamp$simplertmp$packets$UserControl$Type[userControl.getType().ordinal()];
                            if (i == 2) {
                                ChunkStreamInfo chunkStreamInfo = this.rtmpSessionInfo.getChunkStreamInfo(2);
                                Log.d("RtmpConnection", "handleRxPacketLoop(): Sending PONG reply..");
                                sendRtmpPacket(new UserControl(userControl, chunkStreamInfo));
                                continue;
                            } else if (i == 3) {
                                Log.i("RtmpConnection", "handleRxPacketLoop(): Stream EOF reached, closing RTMP writer...");
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            int acknowledgementWindowSize = ((WindowAckSize) packet).getAcknowledgementWindowSize();
                            Log.d("RtmpConnection", "handleRxPacketLoop(): Setting acknowledgement window size: " + acknowledgementWindowSize);
                            this.rtmpSessionInfo.setAcknowledgmentWindowSize(acknowledgementWindowSize);
                            continue;
                        case 4:
                            this.rtmpSessionInfo.setAcknowledgmentWindowSize(this.socket.getSendBufferSize());
                            int acknowledgementWindowSize2 = this.rtmpSessionInfo.getAcknowledgementWindowSize();
                            ChunkStreamInfo chunkStreamInfo2 = this.rtmpSessionInfo.getChunkStreamInfo(2);
                            Log.d("RtmpConnection", "handleRxPacketLoop(): Send acknowledgement window size: " + acknowledgementWindowSize2);
                            sendRtmpPacket(new WindowAckSize(acknowledgementWindowSize2, chunkStreamInfo2));
                            this.socket.setSendBufferSize(acknowledgementWindowSize2);
                            continue;
                        case 5:
                            handleRxInvoke((Command) packet);
                            continue;
                        case 6:
                            lastAcknowledgementTime = System.currentTimeMillis();
                            break;
                    }
                    Log.w("RtmpConnection", "handleRxPacketLoop(): Not handling unimplemented/unknown packet of type: " + packet.getHeader().getMessageType());
                }
            } catch (EOFException unused) {
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                this.connectCheckerRtmp.onConnectionFailedRtmp("Error reading packet: " + e.getMessage());
                Log.e("RtmpConnection", "Caught SocketException while reading/decoding packet, shutting down: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: com.github.faucamp.simplertmp.io.RtmpConnection$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType;
        static final /* synthetic */ int[] $SwitchMap$com$github$faucamp$simplertmp$packets$UserControl$Type;

        static {
            int[] iArr = new int[RtmpHeader.MessageType.values().length];
            $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType = iArr;
            try {
                iArr[RtmpHeader.MessageType.ABORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.USER_CONTROL_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.WINDOW_ACKNOWLEDGEMENT_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.SET_PEER_BANDWIDTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.COMMAND_AMF0.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.ACKNOWLEDGEMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[UserControl.Type.values().length];
            $SwitchMap$com$github$faucamp$simplertmp$packets$UserControl$Type = iArr2;
            try {
                iArr2[UserControl.Type.STREAM_BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$UserControl$Type[UserControl.Type.PING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$UserControl$Type[UserControl.Type.STREAM_EOF.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleRxInvoke(com.github.faucamp.simplertmp.packets.Command r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.faucamp.simplertmp.io.RtmpConnection.handleRxInvoke(com.github.faucamp.simplertmp.packets.Command):void");
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void setVideoResolution(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
    }
}
