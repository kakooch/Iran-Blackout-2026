package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Turing$RequestGetTranscript extends GeneratedMessageLite implements U64 {
    private static final Turing$RequestGetTranscript DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 3;
    public static final int OUT_PEER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VOICE_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$MessageId messageId_;
    private PeersStruct$OutExPeer outPeer_;
    private MessagingStruct$DocumentMessage voice_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((Turing$RequestGetTranscript) this.b).setMessageId(messagingStruct$MessageId);
            return this;
        }

        public a B(PeersStruct$OutExPeer peersStruct$OutExPeer) {
            q();
            ((Turing$RequestGetTranscript) this.b).setOutPeer(peersStruct$OutExPeer);
            return this;
        }

        public a C(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
            q();
            ((Turing$RequestGetTranscript) this.b).setVoice(messagingStruct$DocumentMessage);
            return this;
        }

        private a() {
            super(Turing$RequestGetTranscript.DEFAULT_INSTANCE);
        }
    }

    static {
        Turing$RequestGetTranscript turing$RequestGetTranscript = new Turing$RequestGetTranscript();
        DEFAULT_INSTANCE = turing$RequestGetTranscript;
        GeneratedMessageLite.registerDefaultInstance(Turing$RequestGetTranscript.class, turing$RequestGetTranscript);
    }

    private Turing$RequestGetTranscript() {
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOutPeer() {
        this.outPeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearVoice() {
        this.voice_ = null;
        this.bitField0_ &= -2;
    }

    public static Turing$RequestGetTranscript getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeVoice(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.voice_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.voice_ = messagingStruct$DocumentMessage;
        } else {
            this.voice_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.voice_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Turing$RequestGetTranscript parseDelimitedFrom(InputStream inputStream) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$RequestGetTranscript parseFrom(ByteBuffer byteBuffer) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.outPeer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVoice(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.voice_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (m2.a[gVar.ordinal()]) {
            case 1:
                return new Turing$RequestGetTranscript();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "voice_", "outPeer_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Turing$RequestGetTranscript.class) {
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

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public PeersStruct$OutExPeer getOutPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.outPeer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public MessagingStruct$DocumentMessage getVoice() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.voice_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOutPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasVoice() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Turing$RequestGetTranscript turing$RequestGetTranscript) {
        return (a) DEFAULT_INSTANCE.createBuilder(turing$RequestGetTranscript);
    }

    public static Turing$RequestGetTranscript parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$RequestGetTranscript parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Turing$RequestGetTranscript parseFrom(AbstractC2383g abstractC2383g) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Turing$RequestGetTranscript parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Turing$RequestGetTranscript parseFrom(byte[] bArr) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Turing$RequestGetTranscript parseFrom(byte[] bArr, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Turing$RequestGetTranscript parseFrom(InputStream inputStream) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$RequestGetTranscript parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$RequestGetTranscript parseFrom(AbstractC2384h abstractC2384h) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Turing$RequestGetTranscript parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Turing$RequestGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
