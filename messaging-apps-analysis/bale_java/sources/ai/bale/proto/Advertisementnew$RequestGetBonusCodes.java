package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestGetBonusCodes extends GeneratedMessageLite implements U64 {
    private static final Advertisementnew$RequestGetBonusCodes DEFAULT_INSTANCE;
    public static final int PAGE_DATA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$PagingData pageData_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestGetBonusCodes.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestGetBonusCodes advertisementnew$RequestGetBonusCodes = new Advertisementnew$RequestGetBonusCodes();
        DEFAULT_INSTANCE = advertisementnew$RequestGetBonusCodes;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestGetBonusCodes.class, advertisementnew$RequestGetBonusCodes);
    }

    private Advertisementnew$RequestGetBonusCodes() {
    }

    private void clearPageData() {
        this.pageData_ = null;
    }

    public static Advertisementnew$RequestGetBonusCodes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePageData(AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData) {
        advertisementnewStruct$PagingData.getClass();
        AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData2 = this.pageData_;
        if (advertisementnewStruct$PagingData2 == null || advertisementnewStruct$PagingData2 == AdvertisementnewStruct$PagingData.getDefaultInstance()) {
            this.pageData_ = advertisementnewStruct$PagingData;
        } else {
            this.pageData_ = (AdvertisementnewStruct$PagingData) ((AdvertisementnewStruct$PagingData.a) AdvertisementnewStruct$PagingData.newBuilder(this.pageData_).v(advertisementnewStruct$PagingData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestGetBonusCodes parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPageData(AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData) {
        advertisementnewStruct$PagingData.getClass();
        this.pageData_ = advertisementnewStruct$PagingData;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestGetBonusCodes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"pageData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestGetBonusCodes.class) {
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

    public AdvertisementnewStruct$PagingData getPageData() {
        AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData = this.pageData_;
        return advertisementnewStruct$PagingData == null ? AdvertisementnewStruct$PagingData.getDefaultInstance() : advertisementnewStruct$PagingData;
    }

    public boolean hasPageData() {
        return this.pageData_ != null;
    }

    public static a newBuilder(Advertisementnew$RequestGetBonusCodes advertisementnew$RequestGetBonusCodes) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestGetBonusCodes);
    }

    public static Advertisementnew$RequestGetBonusCodes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestGetBonusCodes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
