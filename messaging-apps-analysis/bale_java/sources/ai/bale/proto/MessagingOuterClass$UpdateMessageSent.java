package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
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
public final class MessagingOuterClass$UpdateMessageSent extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$UpdateMessageSent DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PREVIOUS_MESSAGE_ID_FIELD_NUMBER = 4;
    public static final int RID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long date_;
    private PeersStruct$Peer peer_;
    private MessagingStruct$MessageId previousMessageId_;
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessageSent.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessageSent messagingOuterClass$UpdateMessageSent = new MessagingOuterClass$UpdateMessageSent();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessageSent;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessageSent.class, messagingOuterClass$UpdateMessageSent);
    }

    private MessagingOuterClass$UpdateMessageSent() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPreviousMessageId() {
        this.previousMessageId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static MessagingOuterClass$UpdateMessageSent getDefaultInstance() {
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

    private void mergePreviousMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.previousMessageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.previousMessageId_ = messagingStruct$MessageId;
        } else {
            this.previousMessageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.previousMessageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessageSent parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setPreviousMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.previousMessageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessageSent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004ဉ\u0001", new Object[]{"bitField0_", "peer_", "rid_", "date_", "previousMessageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessageSent.class) {
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

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public MessagingStruct$MessageId getPreviousMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.previousMessageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPreviousMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessageSent messagingOuterClass$UpdateMessageSent) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessageSent);
    }

    public static MessagingOuterClass$UpdateMessageSent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessageSent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
