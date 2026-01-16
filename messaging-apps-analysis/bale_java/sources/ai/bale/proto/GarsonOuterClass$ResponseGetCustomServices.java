package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonCustomItems;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$ResponseGetCustomServices extends GeneratedMessageLite implements U64 {
    public static final int CUSTOM_ITEMS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetCustomServices DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private GarsonStruct$GarsonCustomItems customItems_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetCustomServices.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetCustomServices garsonOuterClass$ResponseGetCustomServices = new GarsonOuterClass$ResponseGetCustomServices();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetCustomServices;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetCustomServices.class, garsonOuterClass$ResponseGetCustomServices);
    }

    private GarsonOuterClass$ResponseGetCustomServices() {
    }

    private void clearCustomItems() {
        this.customItems_ = null;
        this.bitField0_ &= -2;
    }

    public static GarsonOuterClass$ResponseGetCustomServices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCustomItems(GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems) {
        garsonStruct$GarsonCustomItems.getClass();
        GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems2 = this.customItems_;
        if (garsonStruct$GarsonCustomItems2 == null || garsonStruct$GarsonCustomItems2 == GarsonStruct$GarsonCustomItems.getDefaultInstance()) {
            this.customItems_ = garsonStruct$GarsonCustomItems;
        } else {
            this.customItems_ = (GarsonStruct$GarsonCustomItems) ((GarsonStruct$GarsonCustomItems.a) GarsonStruct$GarsonCustomItems.newBuilder(this.customItems_).v(garsonStruct$GarsonCustomItems)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCustomItems(GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems) {
        garsonStruct$GarsonCustomItems.getClass();
        this.customItems_ = garsonStruct$GarsonCustomItems;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetCustomServices();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "customItems_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetCustomServices.class) {
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

    public GarsonStruct$GarsonCustomItems getCustomItems() {
        GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems = this.customItems_;
        return garsonStruct$GarsonCustomItems == null ? GarsonStruct$GarsonCustomItems.getDefaultInstance() : garsonStruct$GarsonCustomItems;
    }

    public boolean hasCustomItems() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetCustomServices garsonOuterClass$ResponseGetCustomServices) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetCustomServices);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetCustomServices parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetCustomServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
