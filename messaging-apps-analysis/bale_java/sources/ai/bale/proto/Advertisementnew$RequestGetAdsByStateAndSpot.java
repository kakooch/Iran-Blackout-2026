package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20844si;
import ir.nasim.EnumC4938Hf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestGetAdsByStateAndSpot extends GeneratedMessageLite implements U64 {
    private static final Advertisementnew$RequestGetAdsByStateAndSpot DEFAULT_INSTANCE;
    public static final int PAGING_DATA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SPOT_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 2;
    private AdvertisementnewStruct$PagingData pagingData_;
    private int spot_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestGetAdsByStateAndSpot.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestGetAdsByStateAndSpot advertisementnew$RequestGetAdsByStateAndSpot = new Advertisementnew$RequestGetAdsByStateAndSpot();
        DEFAULT_INSTANCE = advertisementnew$RequestGetAdsByStateAndSpot;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestGetAdsByStateAndSpot.class, advertisementnew$RequestGetAdsByStateAndSpot);
    }

    private Advertisementnew$RequestGetAdsByStateAndSpot() {
    }

    private void clearPagingData() {
        this.pagingData_ = null;
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagingData(AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData) {
        advertisementnewStruct$PagingData.getClass();
        AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData2 = this.pagingData_;
        if (advertisementnewStruct$PagingData2 == null || advertisementnewStruct$PagingData2 == AdvertisementnewStruct$PagingData.getDefaultInstance()) {
            this.pagingData_ = advertisementnewStruct$PagingData;
        } else {
            this.pagingData_ = (AdvertisementnewStruct$PagingData) ((AdvertisementnewStruct$PagingData.a) AdvertisementnewStruct$PagingData.newBuilder(this.pagingData_).v(advertisementnewStruct$PagingData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPagingData(AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData) {
        advertisementnewStruct$PagingData.getClass();
        this.pagingData_ = advertisementnewStruct$PagingData;
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setState(EnumC20844si enumC20844si) {
        this.state_ = enumC20844si.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestGetAdsByStateAndSpot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\f\u0003\f", new Object[]{"pagingData_", "state_", "spot_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestGetAdsByStateAndSpot.class) {
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

    public AdvertisementnewStruct$PagingData getPagingData() {
        AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData = this.pagingData_;
        return advertisementnewStruct$PagingData == null ? AdvertisementnewStruct$PagingData.getDefaultInstance() : advertisementnewStruct$PagingData;
    }

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public EnumC20844si getState() {
        EnumC20844si enumC20844siJ = EnumC20844si.j(this.state_);
        return enumC20844siJ == null ? EnumC20844si.UNRECOGNIZED : enumC20844siJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public boolean hasPagingData() {
        return this.pagingData_ != null;
    }

    public static a newBuilder(Advertisementnew$RequestGetAdsByStateAndSpot advertisementnew$RequestGetAdsByStateAndSpot) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestGetAdsByStateAndSpot);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
