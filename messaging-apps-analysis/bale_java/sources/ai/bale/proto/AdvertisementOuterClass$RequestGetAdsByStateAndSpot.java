package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4938Hf;
import ir.nasim.EnumC5640Kf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetAdsByStateAndSpot extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAdsByStateAndSpot DEFAULT_INSTANCE;
    public static final int PAGING_DATA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SPOT_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private AdvertisementStruct$PagingData pagingData_;
    private int spot_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAdsByStateAndSpot.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAdsByStateAndSpot advertisementOuterClass$RequestGetAdsByStateAndSpot = new AdvertisementOuterClass$RequestGetAdsByStateAndSpot();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAdsByStateAndSpot;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAdsByStateAndSpot.class, advertisementOuterClass$RequestGetAdsByStateAndSpot);
    }

    private AdvertisementOuterClass$RequestGetAdsByStateAndSpot() {
    }

    private void clearPagingData() {
        this.pagingData_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        AdvertisementStruct$PagingData advertisementStruct$PagingData2 = this.pagingData_;
        if (advertisementStruct$PagingData2 == null || advertisementStruct$PagingData2 == AdvertisementStruct$PagingData.getDefaultInstance()) {
            this.pagingData_ = advertisementStruct$PagingData;
        } else {
            this.pagingData_ = (AdvertisementStruct$PagingData) ((AdvertisementStruct$PagingData.a) AdvertisementStruct$PagingData.newBuilder(this.pagingData_).v(advertisementStruct$PagingData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        this.pagingData_ = advertisementStruct$PagingData;
        this.bitField0_ |= 1;
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setState(EnumC5640Kf enumC5640Kf) {
        this.state_ = enumC5640Kf.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAdsByStateAndSpot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\f", new Object[]{"bitField0_", "pagingData_", "state_", "spot_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAdsByStateAndSpot.class) {
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

    public AdvertisementStruct$PagingData getPagingData() {
        AdvertisementStruct$PagingData advertisementStruct$PagingData = this.pagingData_;
        return advertisementStruct$PagingData == null ? AdvertisementStruct$PagingData.getDefaultInstance() : advertisementStruct$PagingData;
    }

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public EnumC5640Kf getState() {
        EnumC5640Kf enumC5640KfJ = EnumC5640Kf.j(this.state_);
        return enumC5640KfJ == null ? EnumC5640Kf.UNRECOGNIZED : enumC5640KfJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public boolean hasPagingData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAdsByStateAndSpot advertisementOuterClass$RequestGetAdsByStateAndSpot) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAdsByStateAndSpot);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
