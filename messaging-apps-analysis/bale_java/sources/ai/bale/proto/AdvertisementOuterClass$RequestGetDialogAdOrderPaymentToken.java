package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int COIN_AMOUNT_FIELD_NUMBER = 3;
    private static final AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RIAL_AMOUNT_FIELD_NUMBER = 2;
    private long coinAmount_;
    private String id_ = "";
    private long rialAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken advertisementOuterClass$RequestGetDialogAdOrderPaymentToken = new AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetDialogAdOrderPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.class, advertisementOuterClass$RequestGetDialogAdOrderPaymentToken);
    }

    private AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken() {
    }

    private void clearCoinAmount() {
        this.coinAmount_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearRialAmount() {
        this.rialAmount_ = 0L;
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCoinAmount(long j) {
        this.coinAmount_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setRialAmount(long j) {
        this.rialAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002", new Object[]{"id_", "rialAmount_", "coinAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.class) {
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

    public long getCoinAmount() {
        return this.coinAmount_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public long getRialAmount() {
        return this.rialAmount_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken advertisementOuterClass$RequestGetDialogAdOrderPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetDialogAdOrderPaymentToken);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
