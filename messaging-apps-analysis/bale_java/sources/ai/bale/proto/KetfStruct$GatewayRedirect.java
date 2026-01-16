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
public final class KetfStruct$GatewayRedirect extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$GatewayRedirect DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    public static final int PAYMENT_URL_FIELD_NUMBER = 2;
    private String paymentToken_ = "";
    private String paymentUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$GatewayRedirect.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$GatewayRedirect ketfStruct$GatewayRedirect = new KetfStruct$GatewayRedirect();
        DEFAULT_INSTANCE = ketfStruct$GatewayRedirect;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$GatewayRedirect.class, ketfStruct$GatewayRedirect);
    }

    private KetfStruct$GatewayRedirect() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = getDefaultInstance().getPaymentToken();
    }

    private void clearPaymentUrl() {
        this.paymentUrl_ = getDefaultInstance().getPaymentUrl();
    }

    public static KetfStruct$GatewayRedirect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$GatewayRedirect parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$GatewayRedirect parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentToken(String str) {
        str.getClass();
        this.paymentToken_ = str;
    }

    private void setPaymentTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentToken_ = abstractC2383g.f0();
    }

    private void setPaymentUrl(String str) {
        str.getClass();
        this.paymentUrl_ = str;
    }

    private void setPaymentUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentUrl_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$GatewayRedirect();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"paymentToken_", "paymentUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$GatewayRedirect.class) {
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

    public String getPaymentToken() {
        return this.paymentToken_;
    }

    public AbstractC2383g getPaymentTokenBytes() {
        return AbstractC2383g.N(this.paymentToken_);
    }

    public String getPaymentUrl() {
        return this.paymentUrl_;
    }

    public AbstractC2383g getPaymentUrlBytes() {
        return AbstractC2383g.N(this.paymentUrl_);
    }

    public static a newBuilder(KetfStruct$GatewayRedirect ketfStruct$GatewayRedirect) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$GatewayRedirect);
    }

    public static KetfStruct$GatewayRedirect parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$GatewayRedirect parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$GatewayRedirect parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$GatewayRedirect parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$GatewayRedirect parseFrom(byte[] bArr) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$GatewayRedirect parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$GatewayRedirect parseFrom(InputStream inputStream) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$GatewayRedirect parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$GatewayRedirect parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$GatewayRedirect parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$GatewayRedirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
