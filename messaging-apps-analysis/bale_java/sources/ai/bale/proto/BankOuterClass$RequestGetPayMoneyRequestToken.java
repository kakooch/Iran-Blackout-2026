package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$RequestGetPayMoneyRequestToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$RequestGetPayMoneyRequestToken DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int MESSAGE_PEER_FIELD_NUMBER = 1;
    public static final int MSG_DATE_FIELD_NUMBER = 3;
    public static final int MSG_RID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RECIPIENT_FIELD_NUMBER = 4;
    private int bitField0_;
    private StringValue description_;
    private PeersStruct$Peer messagePeer_;
    private long msgDate_;
    private long msgRid_;
    private int recipient_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetPayMoneyRequestToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetPayMoneyRequestToken bankOuterClass$RequestGetPayMoneyRequestToken = new BankOuterClass$RequestGetPayMoneyRequestToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetPayMoneyRequestToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetPayMoneyRequestToken.class, bankOuterClass$RequestGetPayMoneyRequestToken);
    }

    private BankOuterClass$RequestGetPayMoneyRequestToken() {
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
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

    private void clearRecipient() {
        this.recipient_ = 0;
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 2;
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

    private void setRecipient(int i) {
        this.recipient_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetPayMoneyRequestToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004\u0004\u0005ဉ\u0001", new Object[]{"bitField0_", "messagePeer_", "msgRid_", "msgDate_", "recipient_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetPayMoneyRequestToken.class) {
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

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public int getRecipient() {
        return this.recipient_;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMessagePeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGetPayMoneyRequestToken bankOuterClass$RequestGetPayMoneyRequestToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetPayMoneyRequestToken);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetPayMoneyRequestToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayMoneyRequestToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
