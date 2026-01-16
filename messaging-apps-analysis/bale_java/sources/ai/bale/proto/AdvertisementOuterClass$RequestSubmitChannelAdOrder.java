package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$ChannelAdOrder;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestSubmitChannelAdOrder extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestSubmitChannelAdOrder DEFAULT_INSTANCE;
    public static final int ORDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$ChannelAdOrder order_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSubmitChannelAdOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSubmitChannelAdOrder advertisementOuterClass$RequestSubmitChannelAdOrder = new AdvertisementOuterClass$RequestSubmitChannelAdOrder();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSubmitChannelAdOrder;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSubmitChannelAdOrder.class, advertisementOuterClass$RequestSubmitChannelAdOrder);
    }

    private AdvertisementOuterClass$RequestSubmitChannelAdOrder() {
    }

    private void clearOrder() {
        this.order_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrder(AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder) {
        advertisementStruct$ChannelAdOrder.getClass();
        AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder2 = this.order_;
        if (advertisementStruct$ChannelAdOrder2 == null || advertisementStruct$ChannelAdOrder2 == AdvertisementStruct$ChannelAdOrder.getDefaultInstance()) {
            this.order_ = advertisementStruct$ChannelAdOrder;
        } else {
            this.order_ = (AdvertisementStruct$ChannelAdOrder) ((AdvertisementStruct$ChannelAdOrder.a) AdvertisementStruct$ChannelAdOrder.newBuilder(this.order_).v(advertisementStruct$ChannelAdOrder)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrder(AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder) {
        advertisementStruct$ChannelAdOrder.getClass();
        this.order_ = advertisementStruct$ChannelAdOrder;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSubmitChannelAdOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "order_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSubmitChannelAdOrder.class) {
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

    public AdvertisementStruct$ChannelAdOrder getOrder() {
        AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder = this.order_;
        return advertisementStruct$ChannelAdOrder == null ? AdvertisementStruct$ChannelAdOrder.getDefaultInstance() : advertisementStruct$ChannelAdOrder;
    }

    public boolean hasOrder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSubmitChannelAdOrder advertisementOuterClass$RequestSubmitChannelAdOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSubmitChannelAdOrder);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSubmitChannelAdOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
