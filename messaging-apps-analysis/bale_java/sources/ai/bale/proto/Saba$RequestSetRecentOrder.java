package ai.bale.proto;

import ai.bale.proto.SabaStruct$Order;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Saba$RequestSetRecentOrder extends GeneratedMessageLite implements U64 {
    private static final Saba$RequestSetRecentOrder DEFAULT_INSTANCE;
    public static final int ORDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private SabaStruct$Order order_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$RequestSetRecentOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$RequestSetRecentOrder saba$RequestSetRecentOrder = new Saba$RequestSetRecentOrder();
        DEFAULT_INSTANCE = saba$RequestSetRecentOrder;
        GeneratedMessageLite.registerDefaultInstance(Saba$RequestSetRecentOrder.class, saba$RequestSetRecentOrder);
    }

    private Saba$RequestSetRecentOrder() {
    }

    private void clearOrder() {
        this.order_ = null;
        this.bitField0_ &= -2;
    }

    public static Saba$RequestSetRecentOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrder(SabaStruct$Order sabaStruct$Order) {
        sabaStruct$Order.getClass();
        SabaStruct$Order sabaStruct$Order2 = this.order_;
        if (sabaStruct$Order2 == null || sabaStruct$Order2 == SabaStruct$Order.getDefaultInstance()) {
            this.order_ = sabaStruct$Order;
        } else {
            this.order_ = (SabaStruct$Order) ((SabaStruct$Order.a) SabaStruct$Order.newBuilder(this.order_).v(sabaStruct$Order)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$RequestSetRecentOrder parseDelimitedFrom(InputStream inputStream) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestSetRecentOrder parseFrom(ByteBuffer byteBuffer) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrder(SabaStruct$Order sabaStruct$Order) {
        sabaStruct$Order.getClass();
        this.order_ = sabaStruct$Order;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$RequestSetRecentOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "order_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$RequestSetRecentOrder.class) {
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

    public SabaStruct$Order getOrder() {
        SabaStruct$Order sabaStruct$Order = this.order_;
        return sabaStruct$Order == null ? SabaStruct$Order.getDefaultInstance() : sabaStruct$Order;
    }

    public boolean hasOrder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Saba$RequestSetRecentOrder saba$RequestSetRecentOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$RequestSetRecentOrder);
    }

    public static Saba$RequestSetRecentOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestSetRecentOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$RequestSetRecentOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$RequestSetRecentOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$RequestSetRecentOrder parseFrom(byte[] bArr) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$RequestSetRecentOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$RequestSetRecentOrder parseFrom(InputStream inputStream) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestSetRecentOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestSetRecentOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$RequestSetRecentOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$RequestSetRecentOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
