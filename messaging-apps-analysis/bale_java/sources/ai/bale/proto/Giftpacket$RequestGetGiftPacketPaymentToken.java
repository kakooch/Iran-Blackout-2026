package ai.bale.proto;

import ai.bale.proto.MessagingStruct$GiftPacketMessage;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Giftpacket$RequestGetGiftPacketPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final Giftpacket$RequestGetGiftPacketPaymentToken DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private long amount_;
    private int bitField0_;
    private MessagingStruct$GiftPacketMessage message_;
    private PeersStruct$OutPeer peer_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Giftpacket$RequestGetGiftPacketPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Giftpacket$RequestGetGiftPacketPaymentToken giftpacket$RequestGetGiftPacketPaymentToken = new Giftpacket$RequestGetGiftPacketPaymentToken();
        DEFAULT_INSTANCE = giftpacket$RequestGetGiftPacketPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Giftpacket$RequestGetGiftPacketPaymentToken.class, giftpacket$RequestGetGiftPacketPaymentToken);
    }

    private Giftpacket$RequestGetGiftPacketPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        messagingStruct$GiftPacketMessage.getClass();
        MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage2 = this.message_;
        if (messagingStruct$GiftPacketMessage2 == null || messagingStruct$GiftPacketMessage2 == MessagingStruct$GiftPacketMessage.getDefaultInstance()) {
            this.message_ = messagingStruct$GiftPacketMessage;
        } else {
            this.message_ = (MessagingStruct$GiftPacketMessage) ((MessagingStruct$GiftPacketMessage.a) MessagingStruct$GiftPacketMessage.newBuilder(this.message_).v(messagingStruct$GiftPacketMessage)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setMessage(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        messagingStruct$GiftPacketMessage.getClass();
        this.message_ = messagingStruct$GiftPacketMessage;
        this.bitField0_ |= 2;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1865j0.a[gVar.ordinal()]) {
            case 1:
                return new Giftpacket$RequestGetGiftPacketPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "token_", "amount_", "peer_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Giftpacket$RequestGetGiftPacketPaymentToken.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public MessagingStruct$GiftPacketMessage getMessage() {
        MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage = this.message_;
        return messagingStruct$GiftPacketMessage == null ? MessagingStruct$GiftPacketMessage.getDefaultInstance() : messagingStruct$GiftPacketMessage;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Giftpacket$RequestGetGiftPacketPaymentToken giftpacket$RequestGetGiftPacketPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacket$RequestGetGiftPacketPaymentToken);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(byte[] bArr) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(InputStream inputStream) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Giftpacket$RequestGetGiftPacketPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Giftpacket$RequestGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
