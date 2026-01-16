package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4424Fb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Balebank$RequestSendGoldGiftPacket extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int COUNT_FIELD_NUMBER = 3;
    private static final Balebank$RequestSendGoldGiftPacket DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int GIVING_TYPE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 7;
    public static final int RANDOM_ID_FIELD_NUMBER = 6;
    private long amount_;
    private int bitField0_;
    private long count_;
    private String description_ = "";
    private int givingType_;
    private PeersStruct$OutPeer peer_;
    private long randomId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$RequestSendGoldGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$RequestSendGoldGiftPacket balebank$RequestSendGoldGiftPacket = new Balebank$RequestSendGoldGiftPacket();
        DEFAULT_INSTANCE = balebank$RequestSendGoldGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(Balebank$RequestSendGoldGiftPacket.class, balebank$RequestSendGoldGiftPacket);
    }

    private Balebank$RequestSendGoldGiftPacket() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCount() {
        this.count_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearGivingType() {
        this.givingType_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    public static Balebank$RequestSendGoldGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static Balebank$RequestSendGoldGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCount(long j) {
        this.count_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setGivingType(EnumC4424Fb4 enumC4424Fb4) {
        this.givingType_ = enumC4424Fb4.getNumber();
    }

    private void setGivingTypeValue(int i) {
        this.givingType_ = i;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$RequestSendGoldGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0002\u0007\u0006\u0000\u0000\u0000\u0002\u0002\u0003\u0002\u0004Ȉ\u0005\f\u0006\u0002\u0007ဉ\u0000", new Object[]{"bitField0_", "amount_", "count_", "description_", "givingType_", "randomId_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$RequestSendGoldGiftPacket.class) {
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

    public long getCount() {
        return this.count_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public EnumC4424Fb4 getGivingType() {
        EnumC4424Fb4 enumC4424Fb4J = EnumC4424Fb4.j(this.givingType_);
        return enumC4424Fb4J == null ? EnumC4424Fb4.UNRECOGNIZED : enumC4424Fb4J;
    }

    public int getGivingTypeValue() {
        return this.givingType_;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Balebank$RequestSendGoldGiftPacket balebank$RequestSendGoldGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$RequestSendGoldGiftPacket);
    }

    public static Balebank$RequestSendGoldGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(byte[] bArr) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(InputStream inputStream) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$RequestSendGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$RequestSendGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
