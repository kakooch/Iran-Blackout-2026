package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4938Hf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdSpotOffer extends GeneratedMessageLite implements U64 {
    public static final int AD_SPOT_FIELD_NUMBER = 1;
    public static final int COST_FIELD_NUMBER = 4;
    private static final AdvertisementStruct$AdSpotOffer DEFAULT_INSTANCE;
    public static final int FROM_TIME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TO_TIME_FIELD_NUMBER = 3;
    private int adSpot_;
    private long cost_;
    private long fromTime_;
    private long id_;
    private long toTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$AdSpotOffer.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdSpotOffer advertisementStruct$AdSpotOffer = new AdvertisementStruct$AdSpotOffer();
        DEFAULT_INSTANCE = advertisementStruct$AdSpotOffer;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdSpotOffer.class, advertisementStruct$AdSpotOffer);
    }

    private AdvertisementStruct$AdSpotOffer() {
    }

    private void clearAdSpot() {
        this.adSpot_ = 0;
    }

    private void clearCost() {
        this.cost_ = 0L;
    }

    private void clearFromTime() {
        this.fromTime_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearToTime() {
        this.toTime_ = 0L;
    }

    public static AdvertisementStruct$AdSpotOffer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdSpotOffer parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdSpot(EnumC4938Hf enumC4938Hf) {
        this.adSpot_ = enumC4938Hf.getNumber();
    }

    private void setAdSpotValue(int i) {
        this.adSpot_ = i;
    }

    private void setCost(long j) {
        this.cost_ = j;
    }

    private void setFromTime(long j) {
        this.fromTime_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setToTime(long j) {
        this.toTime_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdSpotOffer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003\u0002\u0004\u0002\u0005\u0002", new Object[]{"adSpot_", "fromTime_", "toTime_", "cost_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdSpotOffer.class) {
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

    public EnumC4938Hf getAdSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.adSpot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getAdSpotValue() {
        return this.adSpot_;
    }

    public long getCost() {
        return this.cost_;
    }

    public long getFromTime() {
        return this.fromTime_;
    }

    public long getId() {
        return this.id_;
    }

    public long getToTime() {
        return this.toTime_;
    }

    public static a newBuilder(AdvertisementStruct$AdSpotOffer advertisementStruct$AdSpotOffer) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdSpotOffer);
    }

    public static AdvertisementStruct$AdSpotOffer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdSpotOffer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotOffer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
