package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$ConvertToGiftPacket;
import ai.bale.proto.AdvertisementStruct$ConvertToGiftPacketForChannelOwner;
import ai.bale.proto.AdvertisementStruct$ConvertToPoints;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestConvertIncome extends GeneratedMessageLite implements U64 {
    public static final int CONVERT_TO_GIFT_PACKET_FIELD_NUMBER = 2;
    public static final int CONVERT_TO_GIFT_PACKET_FOR_CHANNEL_OWNER_FIELD_NUMBER = 3;
    public static final int CONVERT_TO_POINTS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestConvertIncome DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestConvertIncome.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        CONVERT_TO_POINTS(1),
        CONVERT_TO_GIFT_PACKET(2),
        CONVERT_TO_GIFT_PACKET_FOR_CHANNEL_OWNER(3),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return CONVERT_TO_POINTS;
            }
            if (i == 2) {
                return CONVERT_TO_GIFT_PACKET;
            }
            if (i != 3) {
                return null;
            }
            return CONVERT_TO_GIFT_PACKET_FOR_CHANNEL_OWNER;
        }
    }

    static {
        AdvertisementOuterClass$RequestConvertIncome advertisementOuterClass$RequestConvertIncome = new AdvertisementOuterClass$RequestConvertIncome();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestConvertIncome;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestConvertIncome.class, advertisementOuterClass$RequestConvertIncome);
    }

    private AdvertisementOuterClass$RequestConvertIncome() {
    }

    private void clearConvertToGiftPacket() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearConvertToGiftPacketForChannelOwner() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearConvertToPoints() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static AdvertisementOuterClass$RequestConvertIncome getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConvertToGiftPacket(AdvertisementStruct$ConvertToGiftPacket advertisementStruct$ConvertToGiftPacket) {
        advertisementStruct$ConvertToGiftPacket.getClass();
        if (this.traitCase_ != 2 || this.trait_ == AdvertisementStruct$ConvertToGiftPacket.getDefaultInstance()) {
            this.trait_ = advertisementStruct$ConvertToGiftPacket;
        } else {
            this.trait_ = ((AdvertisementStruct$ConvertToGiftPacket.a) AdvertisementStruct$ConvertToGiftPacket.newBuilder((AdvertisementStruct$ConvertToGiftPacket) this.trait_).v(advertisementStruct$ConvertToGiftPacket)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeConvertToGiftPacketForChannelOwner(AdvertisementStruct$ConvertToGiftPacketForChannelOwner advertisementStruct$ConvertToGiftPacketForChannelOwner) {
        advertisementStruct$ConvertToGiftPacketForChannelOwner.getClass();
        if (this.traitCase_ != 3 || this.trait_ == AdvertisementStruct$ConvertToGiftPacketForChannelOwner.getDefaultInstance()) {
            this.trait_ = advertisementStruct$ConvertToGiftPacketForChannelOwner;
        } else {
            this.trait_ = ((AdvertisementStruct$ConvertToGiftPacketForChannelOwner.a) AdvertisementStruct$ConvertToGiftPacketForChannelOwner.newBuilder((AdvertisementStruct$ConvertToGiftPacketForChannelOwner) this.trait_).v(advertisementStruct$ConvertToGiftPacketForChannelOwner)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeConvertToPoints(AdvertisementStruct$ConvertToPoints advertisementStruct$ConvertToPoints) {
        advertisementStruct$ConvertToPoints.getClass();
        if (this.traitCase_ != 1 || this.trait_ == AdvertisementStruct$ConvertToPoints.getDefaultInstance()) {
            this.trait_ = advertisementStruct$ConvertToPoints;
        } else {
            this.trait_ = ((AdvertisementStruct$ConvertToPoints.a) AdvertisementStruct$ConvertToPoints.newBuilder((AdvertisementStruct$ConvertToPoints) this.trait_).v(advertisementStruct$ConvertToPoints)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConvertToGiftPacket(AdvertisementStruct$ConvertToGiftPacket advertisementStruct$ConvertToGiftPacket) {
        advertisementStruct$ConvertToGiftPacket.getClass();
        this.trait_ = advertisementStruct$ConvertToGiftPacket;
        this.traitCase_ = 2;
    }

    private void setConvertToGiftPacketForChannelOwner(AdvertisementStruct$ConvertToGiftPacketForChannelOwner advertisementStruct$ConvertToGiftPacketForChannelOwner) {
        advertisementStruct$ConvertToGiftPacketForChannelOwner.getClass();
        this.trait_ = advertisementStruct$ConvertToGiftPacketForChannelOwner;
        this.traitCase_ = 3;
    }

    private void setConvertToPoints(AdvertisementStruct$ConvertToPoints advertisementStruct$ConvertToPoints) {
        advertisementStruct$ConvertToPoints.getClass();
        this.trait_ = advertisementStruct$ConvertToPoints;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestConvertIncome();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", AdvertisementStruct$ConvertToPoints.class, AdvertisementStruct$ConvertToGiftPacket.class, AdvertisementStruct$ConvertToGiftPacketForChannelOwner.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestConvertIncome.class) {
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

    public AdvertisementStruct$ConvertToGiftPacket getConvertToGiftPacket() {
        return this.traitCase_ == 2 ? (AdvertisementStruct$ConvertToGiftPacket) this.trait_ : AdvertisementStruct$ConvertToGiftPacket.getDefaultInstance();
    }

    public AdvertisementStruct$ConvertToGiftPacketForChannelOwner getConvertToGiftPacketForChannelOwner() {
        return this.traitCase_ == 3 ? (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) this.trait_ : AdvertisementStruct$ConvertToGiftPacketForChannelOwner.getDefaultInstance();
    }

    public AdvertisementStruct$ConvertToPoints getConvertToPoints() {
        return this.traitCase_ == 1 ? (AdvertisementStruct$ConvertToPoints) this.trait_ : AdvertisementStruct$ConvertToPoints.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasConvertToGiftPacket() {
        return this.traitCase_ == 2;
    }

    public boolean hasConvertToGiftPacketForChannelOwner() {
        return this.traitCase_ == 3;
    }

    public boolean hasConvertToPoints() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestConvertIncome advertisementOuterClass$RequestConvertIncome) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestConvertIncome);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestConvertIncome parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestConvertIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
