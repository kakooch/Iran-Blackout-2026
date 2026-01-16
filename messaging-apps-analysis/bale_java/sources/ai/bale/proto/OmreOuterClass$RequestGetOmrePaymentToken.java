package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$RequestGetOmrePaymentToken extends GeneratedMessageLite implements U64 {
    public static final int CALL_BACK_FIELD_NUMBER = 10;
    private static final OmreOuterClass$RequestGetOmrePaymentToken DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER;
    private String callBack_ = "";
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$RequestGetOmrePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestGetOmrePaymentToken omreOuterClass$RequestGetOmrePaymentToken = new OmreOuterClass$RequestGetOmrePaymentToken();
        DEFAULT_INSTANCE = omreOuterClass$RequestGetOmrePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestGetOmrePaymentToken.class, omreOuterClass$RequestGetOmrePaymentToken);
    }

    private OmreOuterClass$RequestGetOmrePaymentToken() {
    }

    private void clearCallBack() {
        this.callBack_ = getDefaultInstance().getCallBack();
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallBack(String str) {
        str.getClass();
        this.callBack_ = str;
    }

    private void setCallBackBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callBack_ = abstractC2383g.f0();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestGetOmrePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\t\n\u0002\u0000\u0000\u0000\t\u0004\nȈ", new Object[]{"orderId_", "callBack_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestGetOmrePaymentToken.class) {
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

    public String getCallBack() {
        return this.callBack_;
    }

    public AbstractC2383g getCallBackBytes() {
        return AbstractC2383g.N(this.callBack_);
    }

    public int getOrderId() {
        return this.orderId_;
    }

    public static a newBuilder(OmreOuterClass$RequestGetOmrePaymentToken omreOuterClass$RequestGetOmrePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestGetOmrePaymentToken);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestGetOmrePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestGetOmrePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
