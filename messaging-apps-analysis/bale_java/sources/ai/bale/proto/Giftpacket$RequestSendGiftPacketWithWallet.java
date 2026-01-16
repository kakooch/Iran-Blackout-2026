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
public final class Giftpacket$RequestSendGiftPacketWithWallet extends GeneratedMessageLite implements U64 {
    private static final Giftpacket$RequestSendGiftPacketWithWallet DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RANDOM_ID_FIELD_NUMBER = 2;
    public static final int SOURCE_WALLET_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private MessagingStruct$GiftPacketMessage message_;
    private PeersStruct$OutPeer peer_;
    private long randomId_;
    private String sourceWalletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Giftpacket$RequestSendGiftPacketWithWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        Giftpacket$RequestSendGiftPacketWithWallet giftpacket$RequestSendGiftPacketWithWallet = new Giftpacket$RequestSendGiftPacketWithWallet();
        DEFAULT_INSTANCE = giftpacket$RequestSendGiftPacketWithWallet;
        GeneratedMessageLite.registerDefaultInstance(Giftpacket$RequestSendGiftPacketWithWallet.class, giftpacket$RequestSendGiftPacketWithWallet);
    }

    private Giftpacket$RequestSendGiftPacketWithWallet() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    private void clearSourceWalletId() {
        this.sourceWalletId_ = getDefaultInstance().getSourceWalletId();
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet getDefaultInstance() {
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

    public static Giftpacket$RequestSendGiftPacketWithWallet parseDelimitedFrom(InputStream inputStream) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(ByteBuffer byteBuffer) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    private void setSourceWalletId(String str) {
        str.getClass();
        this.sourceWalletId_ = str;
    }

    private void setSourceWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sourceWalletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1865j0.a[gVar.ordinal()]) {
            case 1:
                return new Giftpacket$RequestSendGiftPacketWithWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001\u0004Ȉ", new Object[]{"bitField0_", "peer_", "randomId_", "message_", "sourceWalletId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Giftpacket$RequestSendGiftPacketWithWallet.class) {
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

    public MessagingStruct$GiftPacketMessage getMessage() {
        MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage = this.message_;
        return messagingStruct$GiftPacketMessage == null ? MessagingStruct$GiftPacketMessage.getDefaultInstance() : messagingStruct$GiftPacketMessage;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public String getSourceWalletId() {
        return this.sourceWalletId_;
    }

    public AbstractC2383g getSourceWalletIdBytes() {
        return AbstractC2383g.N(this.sourceWalletId_);
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Giftpacket$RequestSendGiftPacketWithWallet giftpacket$RequestSendGiftPacketWithWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacket$RequestSendGiftPacketWithWallet);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(byte[] bArr) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(InputStream inputStream) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Giftpacket$RequestSendGiftPacketWithWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Giftpacket$RequestSendGiftPacketWithWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
