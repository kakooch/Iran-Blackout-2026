package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$DialogAdOrder;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestSubmitDialogAdOrder extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestSubmitDialogAdOrder DEFAULT_INSTANCE;
    public static final int DIALOG_AD_ORDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$DialogAdOrder dialogAdOrder_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSubmitDialogAdOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSubmitDialogAdOrder advertisementOuterClass$RequestSubmitDialogAdOrder = new AdvertisementOuterClass$RequestSubmitDialogAdOrder();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSubmitDialogAdOrder;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSubmitDialogAdOrder.class, advertisementOuterClass$RequestSubmitDialogAdOrder);
    }

    private AdvertisementOuterClass$RequestSubmitDialogAdOrder() {
    }

    private void clearDialogAdOrder() {
        this.dialogAdOrder_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDialogAdOrder(AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder2 = this.dialogAdOrder_;
        if (advertisementStruct$DialogAdOrder2 == null || advertisementStruct$DialogAdOrder2 == AdvertisementStruct$DialogAdOrder.getDefaultInstance()) {
            this.dialogAdOrder_ = advertisementStruct$DialogAdOrder;
        } else {
            this.dialogAdOrder_ = (AdvertisementStruct$DialogAdOrder) ((AdvertisementStruct$DialogAdOrder.a) AdvertisementStruct$DialogAdOrder.newBuilder(this.dialogAdOrder_).v(advertisementStruct$DialogAdOrder)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDialogAdOrder(AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        this.dialogAdOrder_ = advertisementStruct$DialogAdOrder;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSubmitDialogAdOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "dialogAdOrder_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSubmitDialogAdOrder.class) {
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

    public AdvertisementStruct$DialogAdOrder getDialogAdOrder() {
        AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder = this.dialogAdOrder_;
        return advertisementStruct$DialogAdOrder == null ? AdvertisementStruct$DialogAdOrder.getDefaultInstance() : advertisementStruct$DialogAdOrder;
    }

    public boolean hasDialogAdOrder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSubmitDialogAdOrder advertisementOuterClass$RequestSubmitDialogAdOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSubmitDialogAdOrder);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSubmitDialogAdOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
