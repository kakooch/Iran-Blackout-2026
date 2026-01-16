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
public final class AdvertisementStruct$ConvertToGiftPacketForChannelOwner extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final AdvertisementStruct$ConvertToGiftPacketForChannelOwner DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long amount_;
    private int groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$ConvertToGiftPacketForChannelOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ConvertToGiftPacketForChannelOwner advertisementStruct$ConvertToGiftPacketForChannelOwner = new AdvertisementStruct$ConvertToGiftPacketForChannelOwner();
        DEFAULT_INSTANCE = advertisementStruct$ConvertToGiftPacketForChannelOwner;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ConvertToGiftPacketForChannelOwner.class, advertisementStruct$ConvertToGiftPacketForChannelOwner);
    }

    private AdvertisementStruct$ConvertToGiftPacketForChannelOwner() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ConvertToGiftPacketForChannelOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"groupId_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ConvertToGiftPacketForChannelOwner.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public static a newBuilder(AdvertisementStruct$ConvertToGiftPacketForChannelOwner advertisementStruct$ConvertToGiftPacketForChannelOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ConvertToGiftPacketForChannelOwner);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ConvertToGiftPacketForChannelOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ConvertToGiftPacketForChannelOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
