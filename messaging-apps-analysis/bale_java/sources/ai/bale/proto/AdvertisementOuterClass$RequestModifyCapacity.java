package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestModifyCapacity extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestModifyCapacity DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VAL_FIELD_NUMBER = 2;
    private long date_;
    private int val_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestModifyCapacity.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestModifyCapacity advertisementOuterClass$RequestModifyCapacity = new AdvertisementOuterClass$RequestModifyCapacity();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestModifyCapacity;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestModifyCapacity.class, advertisementOuterClass$RequestModifyCapacity);
    }

    private AdvertisementOuterClass$RequestModifyCapacity() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearVal() {
        this.val_ = 0;
    }

    public static AdvertisementOuterClass$RequestModifyCapacity getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setVal(int i) {
        this.val_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestModifyCapacity();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"date_", "val_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestModifyCapacity.class) {
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

    public int getVal() {
        return this.val_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestModifyCapacity advertisementOuterClass$RequestModifyCapacity) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestModifyCapacity);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestModifyCapacity parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestModifyCapacity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
