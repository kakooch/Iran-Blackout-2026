package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.II2;
import ir.nasim.KI2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Balebank$ResponseOpenGoldGiftPacket extends GeneratedMessageLite implements U64 {
    private static final Balebank$ResponseOpenGoldGiftPacket DEFAULT_INSTANCE;
    public static final int GIFT_RECEIVERS_FIELD_NUMBER = 4;
    public static final int OPENED_COUNT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RANK_FIELD_NUMBER = 3;
    public static final int SELF_WIN_AMOUNT_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 5;
    private B.j giftReceivers_ = GeneratedMessageLite.emptyProtobufList();
    private long openedCount_;
    private long rank_;
    private long selfWinAmount_;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$ResponseOpenGoldGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$ResponseOpenGoldGiftPacket balebank$ResponseOpenGoldGiftPacket = new Balebank$ResponseOpenGoldGiftPacket();
        DEFAULT_INSTANCE = balebank$ResponseOpenGoldGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(Balebank$ResponseOpenGoldGiftPacket.class, balebank$ResponseOpenGoldGiftPacket);
    }

    private Balebank$ResponseOpenGoldGiftPacket() {
    }

    private void addAllGiftReceivers(Iterable<? extends GiftpacketStruct$GiftReceiver> iterable) {
        ensureGiftReceiversIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.giftReceivers_);
    }

    private void addGiftReceivers(GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.add(giftpacketStruct$GiftReceiver);
    }

    private void clearGiftReceivers() {
        this.giftReceivers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOpenedCount() {
        this.openedCount_ = 0L;
    }

    private void clearRank() {
        this.rank_ = 0L;
    }

    private void clearSelfWinAmount() {
        this.selfWinAmount_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void ensureGiftReceiversIsMutable() {
        B.j jVar = this.giftReceivers_;
        if (jVar.u()) {
            return;
        }
        this.giftReceivers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Balebank$ResponseOpenGoldGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGiftReceivers(int i) {
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.remove(i);
    }

    private void setGiftReceivers(int i, GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.set(i, giftpacketStruct$GiftReceiver);
    }

    private void setOpenedCount(long j) {
        this.openedCount_ = j;
    }

    private void setRank(long j) {
        this.rank_ = j;
    }

    private void setSelfWinAmount(long j) {
        this.selfWinAmount_ = j;
    }

    private void setStatus(II2 ii2) {
        this.status_ = ii2.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$ResponseOpenGoldGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u001b\u0005\f", new Object[]{"openedCount_", "selfWinAmount_", "rank_", "giftReceivers_", GiftpacketStruct$GiftReceiver.class, "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$ResponseOpenGoldGiftPacket.class) {
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

    public long getOpenedCount() {
        return this.openedCount_;
    }

    public long getRank() {
        return this.rank_;
    }

    public long getSelfWinAmount() {
        return this.selfWinAmount_;
    }

    public II2 getStatus() {
        II2 ii2J = II2.j(this.status_);
        return ii2J == null ? II2.UNRECOGNIZED : ii2J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(Balebank$ResponseOpenGoldGiftPacket balebank$ResponseOpenGoldGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$ResponseOpenGoldGiftPacket);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGiftReceivers(int i, GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        giftpacketStruct$GiftReceiver.getClass();
        ensureGiftReceiversIsMutable();
        this.giftReceivers_.add(i, giftpacketStruct$GiftReceiver);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(byte[] bArr) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(InputStream inputStream) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$ResponseOpenGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$ResponseOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
