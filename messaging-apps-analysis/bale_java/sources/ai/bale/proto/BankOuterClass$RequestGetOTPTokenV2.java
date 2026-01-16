package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
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
public final class BankOuterClass$RequestGetOTPTokenV2 extends GeneratedMessageLite implements U64 {
    public static final int CARD_NUMBER_STARTING_SIX_FIELD_NUMBER = 5;
    private static final BankOuterClass$RequestGetOTPTokenV2 DEFAULT_INSTANCE;
    public static final int MESSAGE_PEER_FIELD_NUMBER = 1;
    public static final int MSG_DATE_FIELD_NUMBER = 3;
    public static final int MSG_RID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_USER_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private String cardNumberStartingSix_ = "";
    private PeersStruct$Peer messagePeer_;
    private long msgDate_;
    private long msgRid_;
    private Int32Value peerUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetOTPTokenV2.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetOTPTokenV2 bankOuterClass$RequestGetOTPTokenV2 = new BankOuterClass$RequestGetOTPTokenV2();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetOTPTokenV2;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetOTPTokenV2.class, bankOuterClass$RequestGetOTPTokenV2);
    }

    private BankOuterClass$RequestGetOTPTokenV2() {
    }

    private void clearCardNumberStartingSix() {
        this.cardNumberStartingSix_ = getDefaultInstance().getCardNumberStartingSix();
    }

    private void clearMessagePeer() {
        this.messagePeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMsgDate() {
        this.msgDate_ = 0L;
    }

    private void clearMsgRid() {
        this.msgRid_ = 0L;
    }

    private void clearPeerUserId() {
        this.peerUserId_ = null;
        this.bitField0_ &= -3;
    }

    public static BankOuterClass$RequestGetOTPTokenV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessagePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.messagePeer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.messagePeer_ = peersStruct$Peer;
        } else {
            this.messagePeer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.messagePeer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePeerUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.peerUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.peerUserId_ = int32Value;
        } else {
            this.peerUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.peerUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardNumberStartingSix(String str) {
        str.getClass();
        this.cardNumberStartingSix_ = str;
    }

    private void setCardNumberStartingSixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardNumberStartingSix_ = abstractC2383g.f0();
    }

    private void setMessagePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.messagePeer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setMsgDate(long j) {
        this.msgDate_ = j;
    }

    private void setMsgRid(long j) {
        this.msgRid_ = j;
    }

    private void setPeerUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.peerUserId_ = int32Value;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetOTPTokenV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004ဉ\u0001\u0005Ȉ", new Object[]{"bitField0_", "messagePeer_", "msgRid_", "msgDate_", "peerUserId_", "cardNumberStartingSix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetOTPTokenV2.class) {
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

    public String getCardNumberStartingSix() {
        return this.cardNumberStartingSix_;
    }

    public AbstractC2383g getCardNumberStartingSixBytes() {
        return AbstractC2383g.N(this.cardNumberStartingSix_);
    }

    public PeersStruct$Peer getMessagePeer() {
        PeersStruct$Peer peersStruct$Peer = this.messagePeer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getMsgDate() {
        return this.msgDate_;
    }

    public long getMsgRid() {
        return this.msgRid_;
    }

    public Int32Value getPeerUserId() {
        Int32Value int32Value = this.peerUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasMessagePeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPeerUserId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGetOTPTokenV2 bankOuterClass$RequestGetOTPTokenV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetOTPTokenV2);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetOTPTokenV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPTokenV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
