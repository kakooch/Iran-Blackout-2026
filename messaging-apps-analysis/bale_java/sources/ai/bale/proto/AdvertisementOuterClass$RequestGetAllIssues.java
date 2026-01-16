package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20824sg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetAllIssues extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAllIssues DEFAULT_INSTANCE;
    public static final int IS_RESOLVED_FIELD_NUMBER = 2;
    public static final int PAGINGDATA_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private BoolValue isResolved_;
    private AdvertisementStruct$PagingData pagingData_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAllIssues.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAllIssues advertisementOuterClass$RequestGetAllIssues = new AdvertisementOuterClass$RequestGetAllIssues();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAllIssues;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAllIssues.class, advertisementOuterClass$RequestGetAllIssues);
    }

    private AdvertisementOuterClass$RequestGetAllIssues() {
    }

    private void clearIsResolved() {
        this.isResolved_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPagingData() {
        this.pagingData_ = null;
        this.bitField0_ &= -3;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetAllIssues getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsResolved(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isResolved_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isResolved_ = boolValue;
        } else {
            this.isResolved_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isResolved_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        AdvertisementStruct$PagingData advertisementStruct$PagingData2 = this.pagingData_;
        if (advertisementStruct$PagingData2 == null || advertisementStruct$PagingData2 == AdvertisementStruct$PagingData.getDefaultInstance()) {
            this.pagingData_ = advertisementStruct$PagingData;
        } else {
            this.pagingData_ = (AdvertisementStruct$PagingData) ((AdvertisementStruct$PagingData.a) AdvertisementStruct$PagingData.newBuilder(this.pagingData_).v(advertisementStruct$PagingData)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsResolved(BoolValue boolValue) {
        boolValue.getClass();
        this.isResolved_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setPagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        this.pagingData_ = advertisementStruct$PagingData;
        this.bitField0_ |= 2;
    }

    private void setType(EnumC20824sg enumC20824sg) {
        this.type_ = enumC20824sg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAllIssues();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "type_", "isResolved_", "pagingData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAllIssues.class) {
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

    public BoolValue getIsResolved() {
        BoolValue boolValue = this.isResolved_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public AdvertisementStruct$PagingData getPagingData() {
        AdvertisementStruct$PagingData advertisementStruct$PagingData = this.pagingData_;
        return advertisementStruct$PagingData == null ? AdvertisementStruct$PagingData.getDefaultInstance() : advertisementStruct$PagingData;
    }

    public EnumC20824sg getType() {
        EnumC20824sg enumC20824sgJ = EnumC20824sg.j(this.type_);
        return enumC20824sgJ == null ? EnumC20824sg.UNRECOGNIZED : enumC20824sgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasIsResolved() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPagingData() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAllIssues advertisementOuterClass$RequestGetAllIssues) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAllIssues);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAllIssues parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAllIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
