package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.II2;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KI2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Giftpacket$ResponseOpenGiftPacket extends GeneratedMessageLite implements U64 {
    private static final Giftpacket$ResponseOpenGiftPacket DEFAULT_INSTANCE;
    public static final int GIFT_RECEIVERS_FIELD_NUMBER = 1;
    public static final int OPENED_COUNT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RANK_FIELD_NUMBER = 5;
    public static final int SELF_WIN_AMOUNT_FIELD_NUMBER = 4;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int USER_OUT_PEERS_FIELD_NUMBER = 6;
    private int bitField0_;
    private int openedCount_;
    private Int32Value rank_;
    private CollectionsStruct$Int64Value selfWinAmount_;
    private int status_;
    private B.j giftReceivers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userOutPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Giftpacket$ResponseOpenGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket = new Giftpacket$ResponseOpenGiftPacket();
        DEFAULT_INSTANCE = giftpacket$ResponseOpenGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(Giftpacket$ResponseOpenGiftPacket.class, giftpacket$ResponseOpenGiftPacket);
    }

    private Giftpacket$ResponseOpenGiftPacket() {
    }

    private void addAllGiftReceivers(Iterable<? extends GiftpacketStruct$GiftReceiver> iterable) {
        ensureGiftReceiversIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.giftReceivers_);
    }

    private void addAllUserOutPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserOutPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userOutPeers_);
    }

    private void addGiftReceivers(GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.add(giftpacketStruct$GiftReceiver);
    }

    private void addUserOutPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(peersStruct$UserOutPeer);
    }

    private void clearGiftReceivers() {
        this.giftReceivers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOpenedCount() {
        this.openedCount_ = 0;
    }

    private void clearRank() {
        this.rank_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSelfWinAmount() {
        this.selfWinAmount_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearUserOutPeers() {
        this.userOutPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGiftReceiversIsMutable() {
        B.j jVar = this.giftReceivers_;
        if (jVar.u()) {
            return;
        }
        this.giftReceivers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUserOutPeersIsMutable() {
        B.j jVar = this.userOutPeers_;
        if (jVar.u()) {
            return;
        }
        this.userOutPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Giftpacket$ResponseOpenGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRank(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.rank_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.rank_ = int32Value;
        } else {
            this.rank_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.rank_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSelfWinAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.selfWinAmount_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.selfWinAmount_ = collectionsStruct$Int64Value;
        } else {
            this.selfWinAmount_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.selfWinAmount_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Giftpacket$ResponseOpenGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGiftReceivers(int i) {
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.remove(i);
    }

    private void removeUserOutPeers(int i) {
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.remove(i);
    }

    private void setGiftReceivers(int i, GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.set(i, giftpacketStruct$GiftReceiver);
    }

    private void setOpenedCount(int i) {
        this.openedCount_ = i;
    }

    private void setRank(Int32Value int32Value) {
        int32Value.getClass();
        this.rank_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setSelfWinAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.selfWinAmount_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setStatus(II2 ii2) {
        this.status_ = ii2.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setUserOutPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1865j0.a[gVar.ordinal()]) {
            case 1:
                return new Giftpacket$ResponseOpenGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u001b\u0002\f\u0003\u0004\u0004ဉ\u0000\u0005ဉ\u0001\u0006\u001b", new Object[]{"bitField0_", "giftReceivers_", GiftpacketStruct$GiftReceiver.class, "status_", "openedCount_", "selfWinAmount_", "rank_", "userOutPeers_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Giftpacket$ResponseOpenGiftPacket.class) {
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

    public GiftpacketStruct$GiftReceiver getGiftReceivers(int i) {
        return (GiftpacketStruct$GiftReceiver) this.giftReceivers_.get(i);
    }

    public int getGiftReceiversCount() {
        return this.giftReceivers_.size();
    }

    public List<GiftpacketStruct$GiftReceiver> getGiftReceiversList() {
        return this.giftReceivers_;
    }

    public KI2 getGiftReceiversOrBuilder(int i) {
        return (KI2) this.giftReceivers_.get(i);
    }

    public List<? extends KI2> getGiftReceiversOrBuilderList() {
        return this.giftReceivers_;
    }

    public int getOpenedCount() {
        return this.openedCount_;
    }

    public Int32Value getRank() {
        Int32Value int32Value = this.rank_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public CollectionsStruct$Int64Value getSelfWinAmount() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.selfWinAmount_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public II2 getStatus() {
        II2 ii2J = II2.j(this.status_);
        return ii2J == null ? II2.UNRECOGNIZED : ii2J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public PeersStruct$UserOutPeer getUserOutPeers(int i) {
        return (PeersStruct$UserOutPeer) this.userOutPeers_.get(i);
    }

    public int getUserOutPeersCount() {
        return this.userOutPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getUserOutPeersList() {
        return this.userOutPeers_;
    }

    public InterfaceC18084o35 getUserOutPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.userOutPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUserOutPeersOrBuilderList() {
        return this.userOutPeers_;
    }

    public boolean hasRank() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSelfWinAmount() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacket$ResponseOpenGiftPacket);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGiftReceivers(int i, GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.add(i, giftpacketStruct$GiftReceiver);
    }

    private void addUserOutPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserOutPeersIsMutable();
        this.userOutPeers_.add(i, peersStruct$UserOutPeer);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(byte[] bArr) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(InputStream inputStream) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Giftpacket$ResponseOpenGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Giftpacket$ResponseOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
