package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18816pI4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$ResponseGetOmreOrderInfo extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$ResponseGetOmreOrderInfo DEFAULT_INSTANCE;
    public static final int ORDER_STATUS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$ResponseGetOmreOrderInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$ResponseGetOmreOrderInfo omreOuterClass$ResponseGetOmreOrderInfo = new OmreOuterClass$ResponseGetOmreOrderInfo();
        DEFAULT_INSTANCE = omreOuterClass$ResponseGetOmreOrderInfo;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$ResponseGetOmreOrderInfo.class, omreOuterClass$ResponseGetOmreOrderInfo);
    }

    private OmreOuterClass$ResponseGetOmreOrderInfo() {
    }

    private void clearOrderStatus() {
        this.orderStatus_ = 0;
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderStatus(EnumC18816pI4 enumC18816pI4) {
        this.orderStatus_ = enumC18816pI4.getNumber();
    }

    private void setOrderStatusValue(int i) {
        this.orderStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$ResponseGetOmreOrderInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"orderStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$ResponseGetOmreOrderInfo.class) {
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

    public EnumC18816pI4 getOrderStatus() {
        EnumC18816pI4 enumC18816pI4J = EnumC18816pI4.j(this.orderStatus_);
        return enumC18816pI4J == null ? EnumC18816pI4.UNRECOGNIZED : enumC18816pI4J;
    }

    public int getOrderStatusValue() {
        return this.orderStatus_;
    }

    public static a newBuilder(OmreOuterClass$ResponseGetOmreOrderInfo omreOuterClass$ResponseGetOmreOrderInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$ResponseGetOmreOrderInfo);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(byte[] bArr) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$ResponseGetOmreOrderInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
