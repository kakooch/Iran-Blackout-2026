package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessageReadByMe extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateMessageReadByMe DEFAULT_INSTANCE;
    public static final int END_DATE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int START_DATE_FIELD_NUMBER = 2;
    public static final int UNREAD_COUNTER_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$Int64Value endDate_;
    private PeersStruct$Peer peer_;
    private long startDate_;
    private Int32Value unreadCounter_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessageReadByMe.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessageReadByMe messagingOuterClass$UpdateMessageReadByMe = new MessagingOuterClass$UpdateMessageReadByMe();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessageReadByMe;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessageReadByMe.class, messagingOuterClass$UpdateMessageReadByMe);
    }

    private MessagingOuterClass$UpdateMessageReadByMe() {
    }

    private void clearEndDate() {
        this.endDate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
    }

    private void clearUnreadCounter() {
        this.unreadCounter_ = null;
        this.bitField0_ &= -3;
    }

    public static MessagingOuterClass$UpdateMessageReadByMe getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.endDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.endDate_ = collectionsStruct$Int64Value;
        } else {
            this.endDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.endDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
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

    private void mergeUnreadCounter(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.unreadCounter_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.unreadCounter_ = int32Value;
        } else {
            this.unreadCounter_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.unreadCounter_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.endDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    private void setUnreadCounter(Int32Value int32Value) {
        int32Value.getClass();
        this.unreadCounter_ = int32Value;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessageReadByMe();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "peer_", "startDate_", "unreadCounter_", "endDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessageReadByMe.class) {
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

    public CollectionsStruct$Int64Value getEndDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.endDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public Int32Value getUnreadCounter() {
        Int32Value int32Value = this.unreadCounter_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasEndDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUnreadCounter() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessageReadByMe messagingOuterClass$UpdateMessageReadByMe) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessageReadByMe);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessageReadByMe parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
