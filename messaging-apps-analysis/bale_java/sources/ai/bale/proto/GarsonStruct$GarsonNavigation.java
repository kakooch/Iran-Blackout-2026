package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC21172tE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonNavigation extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonNavigation DEFAULT_INSTANCE;
    public static final int DESTINATION_URL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_CATEGORY_ID_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue destinationUrl_;
    private int serviceCategoryId_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonNavigation.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation = new GarsonStruct$GarsonNavigation();
        DEFAULT_INSTANCE = garsonStruct$GarsonNavigation;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonNavigation.class, garsonStruct$GarsonNavigation);
    }

    private GarsonStruct$GarsonNavigation() {
    }

    private void clearDestinationUrl() {
        this.destinationUrl_ = null;
        this.bitField0_ &= -2;
    }

    private void clearServiceCategoryId() {
        this.serviceCategoryId_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static GarsonStruct$GarsonNavigation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDestinationUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.destinationUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.destinationUrl_ = stringValue;
        } else {
            this.destinationUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.destinationUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonNavigation parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDestinationUrl(StringValue stringValue) {
        stringValue.getClass();
        this.destinationUrl_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setServiceCategoryId(int i) {
        this.serviceCategoryId_ = i;
    }

    private void setType(EnumC21172tE2 enumC21172tE2) {
        this.type_ = enumC21172tE2.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonNavigation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003ဉ\u0000", new Object[]{"bitField0_", "type_", "serviceCategoryId_", "destinationUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonNavigation.class) {
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

    public StringValue getDestinationUrl() {
        StringValue stringValue = this.destinationUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getServiceCategoryId() {
        return this.serviceCategoryId_;
    }

    public EnumC21172tE2 getType() {
        EnumC21172tE2 enumC21172tE2J = EnumC21172tE2.j(this.type_);
        return enumC21172tE2J == null ? EnumC21172tE2.UNRECOGNIZED : enumC21172tE2J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasDestinationUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonNavigation);
    }

    public static GarsonStruct$GarsonNavigation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonNavigation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonNavigation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
