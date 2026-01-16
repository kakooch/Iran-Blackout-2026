package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementnewStruct$PagingData extends GeneratedMessageLite implements U64 {
    private static final AdvertisementnewStruct$PagingData DEFAULT_INSTANCE;
    public static final int PAGE_NUMBER_FIELD_NUMBER = 1;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int pageNumber_;
    private int pageSize_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementnewStruct$PagingData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData = new AdvertisementnewStruct$PagingData();
        DEFAULT_INSTANCE = advertisementnewStruct$PagingData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementnewStruct$PagingData.class, advertisementnewStruct$PagingData);
    }

    private AdvertisementnewStruct$PagingData() {
    }

    private void clearPageNumber() {
        this.pageNumber_ = 0;
    }

    private void clearPageSize() {
        this.pageSize_ = 0;
    }

    public static AdvertisementnewStruct$PagingData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementnewStruct$PagingData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPageNumber(int i) {
        this.pageNumber_ = i;
    }

    private void setPageSize(int i) {
        this.pageSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1852f.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementnewStruct$PagingData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"pageNumber_", "pageSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementnewStruct$PagingData.class) {
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

    public int getPageNumber() {
        return this.pageNumber_;
    }

    public int getPageSize() {
        return this.pageSize_;
    }

    public static a newBuilder(AdvertisementnewStruct$PagingData advertisementnewStruct$PagingData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnewStruct$PagingData);
    }

    public static AdvertisementnewStruct$PagingData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(byte[] bArr) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementnewStruct$PagingData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementnewStruct$PagingData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
