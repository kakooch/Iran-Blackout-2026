package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.TuringStruct$DownloadSource;
import ai.bale.proto.TuringStruct$TuringError;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Turing$UpdateTranscriptReady extends GeneratedMessageLite implements U64 {
    private static final Turing$UpdateTranscriptReady DEFAULT_INSTANCE;
    public static final int DOWNLOAD_SOURCE_FIELD_NUMBER = 1;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int MESSAGE_ID_FIELD_NUMBER = 3;
    public static final int OUT_PEER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private TuringStruct$DownloadSource downloadSource_;
    private TuringStruct$TuringError error_;
    private MessagingStruct$MessageId messageId_;
    private PeersStruct$OutExPeer outPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Turing$UpdateTranscriptReady.DEFAULT_INSTANCE);
        }
    }

    static {
        Turing$UpdateTranscriptReady turing$UpdateTranscriptReady = new Turing$UpdateTranscriptReady();
        DEFAULT_INSTANCE = turing$UpdateTranscriptReady;
        GeneratedMessageLite.registerDefaultInstance(Turing$UpdateTranscriptReady.class, turing$UpdateTranscriptReady);
    }

    private Turing$UpdateTranscriptReady() {
    }

    private void clearDownloadSource() {
        this.downloadSource_ = null;
        this.bitField0_ &= -2;
    }

    private void clearError() {
        this.error_ = null;
        this.bitField0_ &= -9;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOutPeer() {
        this.outPeer_ = null;
        this.bitField0_ &= -3;
    }

    public static Turing$UpdateTranscriptReady getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDownloadSource(TuringStruct$DownloadSource turingStruct$DownloadSource) {
        turingStruct$DownloadSource.getClass();
        TuringStruct$DownloadSource turingStruct$DownloadSource2 = this.downloadSource_;
        if (turingStruct$DownloadSource2 == null || turingStruct$DownloadSource2 == TuringStruct$DownloadSource.getDefaultInstance()) {
            this.downloadSource_ = turingStruct$DownloadSource;
        } else {
            this.downloadSource_ = (TuringStruct$DownloadSource) ((TuringStruct$DownloadSource.a) TuringStruct$DownloadSource.newBuilder(this.downloadSource_).v(turingStruct$DownloadSource)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeError(TuringStruct$TuringError turingStruct$TuringError) {
        turingStruct$TuringError.getClass();
        TuringStruct$TuringError turingStruct$TuringError2 = this.error_;
        if (turingStruct$TuringError2 == null || turingStruct$TuringError2 == TuringStruct$TuringError.getDefaultInstance()) {
            this.error_ = turingStruct$TuringError;
        } else {
            this.error_ = (TuringStruct$TuringError) ((TuringStruct$TuringError.a) TuringStruct$TuringError.newBuilder(this.error_).v(turingStruct$TuringError)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeOutPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.outPeer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.outPeer_ = peersStruct$OutExPeer;
        } else {
            this.outPeer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.outPeer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Turing$UpdateTranscriptReady parseDelimitedFrom(InputStream inputStream) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$UpdateTranscriptReady parseFrom(ByteBuffer byteBuffer) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDownloadSource(TuringStruct$DownloadSource turingStruct$DownloadSource) {
        turingStruct$DownloadSource.getClass();
        this.downloadSource_ = turingStruct$DownloadSource;
        this.bitField0_ |= 1;
    }

    private void setError(TuringStruct$TuringError turingStruct$TuringError) {
        turingStruct$TuringError.getClass();
        this.error_ = turingStruct$TuringError;
        this.bitField0_ |= 8;
    }

    private void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 4;
    }

    private void setOutPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.outPeer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (m2.a[gVar.ordinal()]) {
            case 1:
                return new Turing$UpdateTranscriptReady();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"bitField0_", "downloadSource_", "outPeer_", "messageId_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Turing$UpdateTranscriptReady.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public TuringStruct$DownloadSource getDownloadSource() {
        TuringStruct$DownloadSource turingStruct$DownloadSource = this.downloadSource_;
        return turingStruct$DownloadSource == null ? TuringStruct$DownloadSource.getDefaultInstance() : turingStruct$DownloadSource;
    }

    public TuringStruct$TuringError getError() {
        TuringStruct$TuringError turingStruct$TuringError = this.error_;
        return turingStruct$TuringError == null ? TuringStruct$TuringError.getDefaultInstance() : turingStruct$TuringError;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public PeersStruct$OutExPeer getOutPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.outPeer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public boolean hasDownloadSource() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasError() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOutPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Turing$UpdateTranscriptReady turing$UpdateTranscriptReady) {
        return (a) DEFAULT_INSTANCE.createBuilder(turing$UpdateTranscriptReady);
    }

    public static Turing$UpdateTranscriptReady parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$UpdateTranscriptReady parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Turing$UpdateTranscriptReady parseFrom(AbstractC2383g abstractC2383g) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Turing$UpdateTranscriptReady parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Turing$UpdateTranscriptReady parseFrom(byte[] bArr) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Turing$UpdateTranscriptReady parseFrom(byte[] bArr, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Turing$UpdateTranscriptReady parseFrom(InputStream inputStream) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$UpdateTranscriptReady parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$UpdateTranscriptReady parseFrom(AbstractC2384h abstractC2384h) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Turing$UpdateTranscriptReady parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Turing$UpdateTranscriptReady) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
