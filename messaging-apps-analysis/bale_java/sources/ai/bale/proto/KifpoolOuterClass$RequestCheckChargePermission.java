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
public final class KifpoolOuterClass$RequestCheckChargePermission extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestCheckChargePermission DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private String paymentToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCheckChargePermission.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCheckChargePermission kifpoolOuterClass$RequestCheckChargePermission = new KifpoolOuterClass$RequestCheckChargePermission();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCheckChargePermission;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCheckChargePermission.class, kifpoolOuterClass$RequestCheckChargePermission);
    }

    private KifpoolOuterClass$RequestCheckChargePermission() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = getDefaultInstance().getPaymentToken();
    }

    public static KifpoolOuterClass$RequestCheckChargePermission getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCheckChargePermission();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"paymentToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCheckChargePermission.class) {
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

    public static a newBuilder(KifpoolOuterClass$RequestCheckChargePermission kifpoolOuterClass$RequestCheckChargePermission) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCheckChargePermission);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCheckChargePermission parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCheckChargePermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
