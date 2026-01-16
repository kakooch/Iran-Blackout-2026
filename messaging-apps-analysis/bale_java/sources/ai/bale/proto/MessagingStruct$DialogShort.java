package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$ExInfo;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19579qb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$DialogShort extends GeneratedMessageLite implements InterfaceC19579qb4 {
    public static final int COUNTER_FIELD_NUMBER = 2;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingStruct$DialogShort DEFAULT_INSTANCE;
    public static final int EX_INFO_FIELD_NUMBER = 4;
    public static final int FIRST_UNREAD_DATE_FIELD_NUMBER = 5;
    public static final int MARKED_AS_UNREAD_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private int counter_;
    private long date_;
    private PeersStruct$ExInfo exInfo_;
    private CollectionsStruct$Int64Value firstUnreadDate_;
    private BoolValue markedAsUnread_;
    private PeersStruct$Peer peer_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19579qb4 {
        private a() {
            super(MessagingStruct$DialogShort.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DialogShort messagingStruct$DialogShort = new MessagingStruct$DialogShort();
        DEFAULT_INSTANCE = messagingStruct$DialogShort;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DialogShort.class, messagingStruct$DialogShort);
    }

    private MessagingStruct$DialogShort() {
    }

    private void clearCounter() {
        this.counter_ = 0;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFirstUnreadDate() {
        this.firstUnreadDate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMarkedAsUnread() {
        this.markedAsUnread_ = null;
        this.bitField0_ &= -9;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$DialogShort getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeFirstUnreadDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.firstUnreadDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.firstUnreadDate_ = collectionsStruct$Int64Value;
        } else {
            this.firstUnreadDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.firstUnreadDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMarkedAsUnread(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.markedAsUnread_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.markedAsUnread_ = boolValue;
        } else {
            this.markedAsUnread_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.markedAsUnread_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DialogShort parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DialogShort parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCounter(int i) {
        this.counter_ = i;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 2;
    }

    private void setFirstUnreadDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.firstUnreadDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setMarkedAsUnread(BoolValue boolValue) {
        boolValue.getClass();
        this.markedAsUnread_ = boolValue;
        this.bitField0_ |= 8;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DialogShort();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0002\u0004ဉ\u0001\u0005ဉ\u0002\u0006ဉ\u0003", new Object[]{"bitField0_", "peer_", "counter_", "date_", "exInfo_", "firstUnreadDate_", "markedAsUnread_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DialogShort.class) {
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

    public int getCounter() {
        return this.counter_;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    public CollectionsStruct$Int64Value getFirstUnreadDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.firstUnreadDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public BoolValue getMarkedAsUnread() {
        BoolValue boolValue = this.markedAsUnread_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFirstUnreadDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMarkedAsUnread() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$DialogShort messagingStruct$DialogShort) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DialogShort);
    }

    public static MessagingStruct$DialogShort parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DialogShort parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DialogShort parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DialogShort parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DialogShort parseFrom(byte[] bArr) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DialogShort parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DialogShort parseFrom(InputStream inputStream) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DialogShort parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DialogShort parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DialogShort parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DialogShort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
