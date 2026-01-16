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
public final class AdvertisementStruct$ConvertToPoints extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$ConvertToPoints DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int POINTS_FIELD_NUMBER = 2;
    private int groupId_;
    private long points_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$ConvertToPoints.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ConvertToPoints advertisementStruct$ConvertToPoints = new AdvertisementStruct$ConvertToPoints();
        DEFAULT_INSTANCE = advertisementStruct$ConvertToPoints;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ConvertToPoints.class, advertisementStruct$ConvertToPoints);
    }

    private AdvertisementStruct$ConvertToPoints() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearPoints() {
        this.points_ = 0L;
    }

    public static AdvertisementStruct$ConvertToPoints getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ConvertToPoints parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setPoints(long j) {
        this.points_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ConvertToPoints();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"groupId_", "points_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ConvertToPoints.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public long getPoints() {
        return this.points_;
    }

    public static a newBuilder(AdvertisementStruct$ConvertToPoints advertisementStruct$ConvertToPoints) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ConvertToPoints);
    }

    public static AdvertisementStruct$ConvertToPoints parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ConvertToPoints parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
