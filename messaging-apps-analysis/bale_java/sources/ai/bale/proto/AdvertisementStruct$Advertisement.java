package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7789Tf;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$Advertisement extends GeneratedMessageLite implements InterfaceC7789Tf {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$Advertisement DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long date_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7789Tf {
        private a() {
            super(AdvertisementStruct$Advertisement.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$Advertisement advertisementStruct$Advertisement = new AdvertisementStruct$Advertisement();
        DEFAULT_INSTANCE = advertisementStruct$Advertisement;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$Advertisement.class, advertisementStruct$Advertisement);
    }

    private AdvertisementStruct$Advertisement() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    public static AdvertisementStruct$Advertisement getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$Advertisement parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$Advertisement parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$Advertisement();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$Advertisement.class) {
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

    public long getDate() {
        return this.date_;
    }

    public static a newBuilder(AdvertisementStruct$Advertisement advertisementStruct$Advertisement) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$Advertisement);
    }

    public static AdvertisementStruct$Advertisement parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$Advertisement parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$Advertisement parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$Advertisement parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$Advertisement parseFrom(byte[] bArr) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$Advertisement parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$Advertisement parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$Advertisement parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$Advertisement parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$Advertisement parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$Advertisement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
