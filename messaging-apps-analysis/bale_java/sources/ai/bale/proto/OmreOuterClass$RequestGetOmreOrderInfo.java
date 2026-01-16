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
public final class OmreOuterClass$RequestGetOmreOrderInfo extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$RequestGetOmreOrderInfo DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$RequestGetOmreOrderInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestGetOmreOrderInfo omreOuterClass$RequestGetOmreOrderInfo = new OmreOuterClass$RequestGetOmreOrderInfo();
        DEFAULT_INSTANCE = omreOuterClass$RequestGetOmreOrderInfo;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestGetOmreOrderInfo.class, omreOuterClass$RequestGetOmreOrderInfo);
    }

    private OmreOuterClass$RequestGetOmreOrderInfo() {
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestGetOmreOrderInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestGetOmreOrderInfo.class) {
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

    public int getOrderId() {
        return this.orderId_;
    }

    public static a newBuilder(OmreOuterClass$RequestGetOmreOrderInfo omreOuterClass$RequestGetOmreOrderInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestGetOmreOrderInfo);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestGetOmreOrderInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmreOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
