package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23867xf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetAccountsByState extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAccountsByState DEFAULT_INSTANCE;
    public static final int PAGE_DATA_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private AdvertisementStruct$PagingData pageData_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAccountsByState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAccountsByState advertisementOuterClass$RequestGetAccountsByState = new AdvertisementOuterClass$RequestGetAccountsByState();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAccountsByState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAccountsByState.class, advertisementOuterClass$RequestGetAccountsByState);
    }

    private AdvertisementOuterClass$RequestGetAccountsByState() {
    }

    private void clearPageData() {
        this.pageData_ = null;
        this.bitField0_ &= -2;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePageData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        AdvertisementStruct$PagingData advertisementStruct$PagingData2 = this.pageData_;
        if (advertisementStruct$PagingData2 == null || advertisementStruct$PagingData2 == AdvertisementStruct$PagingData.getDefaultInstance()) {
            this.pageData_ = advertisementStruct$PagingData;
        } else {
            this.pageData_ = (AdvertisementStruct$PagingData) ((AdvertisementStruct$PagingData.a) AdvertisementStruct$PagingData.newBuilder(this.pageData_).v(advertisementStruct$PagingData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPageData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        this.pageData_ = advertisementStruct$PagingData;
        this.bitField0_ |= 1;
    }

    private void setState(EnumC23867xf enumC23867xf) {
        this.state_ = enumC23867xf.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAccountsByState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "state_", "pageData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAccountsByState.class) {
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

    public AdvertisementStruct$PagingData getPageData() {
        AdvertisementStruct$PagingData advertisementStruct$PagingData = this.pageData_;
        return advertisementStruct$PagingData == null ? AdvertisementStruct$PagingData.getDefaultInstance() : advertisementStruct$PagingData;
    }

    public EnumC23867xf getState() {
        EnumC23867xf enumC23867xfJ = EnumC23867xf.j(this.state_);
        return enumC23867xfJ == null ? EnumC23867xf.UNRECOGNIZED : enumC23867xfJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public boolean hasPageData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAccountsByState advertisementOuterClass$RequestGetAccountsByState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAccountsByState);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAccountsByState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountsByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
