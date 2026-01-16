package ai.bale.proto;

import ai.bale.proto.MessagingStruct$QuotedMessage;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessageQuotedChanged extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateMessageQuotedChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int QUOTED_MESSAGE_FIELD_NUMBER = 3;
    public static final int RID_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$Peer peer_;
    private MessagingStruct$QuotedMessage quotedMessage_;
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessageQuotedChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessageQuotedChanged messagingOuterClass$UpdateMessageQuotedChanged = new MessagingOuterClass$UpdateMessageQuotedChanged();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessageQuotedChanged;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessageQuotedChanged.class, messagingOuterClass$UpdateMessageQuotedChanged);
    }

    private MessagingOuterClass$UpdateMessageQuotedChanged() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuotedMessage() {
        this.quotedMessage_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage2 = this.quotedMessage_;
        if (messagingStruct$QuotedMessage2 == null || messagingStruct$QuotedMessage2 == MessagingStruct$QuotedMessage.getDefaultInstance()) {
            this.quotedMessage_ = messagingStruct$QuotedMessage;
        } else {
            this.quotedMessage_ = (MessagingStruct$QuotedMessage) ((MessagingStruct$QuotedMessage.a) MessagingStruct$QuotedMessage.newBuilder(this.quotedMessage_).v(messagingStruct$QuotedMessage)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        this.quotedMessage_ = messagingStruct$QuotedMessage;
        this.bitField0_ |= 2;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessageQuotedChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001", new Object[]{"bitField0_", "peer_", "rid_", "quotedMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessageQuotedChanged.class) {
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

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public MessagingStruct$QuotedMessage getQuotedMessage() {
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage = this.quotedMessage_;
        return messagingStruct$QuotedMessage == null ? MessagingStruct$QuotedMessage.getDefaultInstance() : messagingStruct$QuotedMessage;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQuotedMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessageQuotedChanged messagingOuterClass$UpdateMessageQuotedChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessageQuotedChanged);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessageQuotedChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageQuotedChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
