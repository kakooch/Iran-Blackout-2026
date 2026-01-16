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
public final class KetfStruct$WalletPaymentParams extends GeneratedMessageLite implements U64 {
    public static final int CHARGE_AMOUNT_FIELD_NUMBER = 1;
    private static final KetfStruct$WalletPaymentParams DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long chargeAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$WalletPaymentParams.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$WalletPaymentParams ketfStruct$WalletPaymentParams = new KetfStruct$WalletPaymentParams();
        DEFAULT_INSTANCE = ketfStruct$WalletPaymentParams;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$WalletPaymentParams.class, ketfStruct$WalletPaymentParams);
    }

    private KetfStruct$WalletPaymentParams() {
    }

    private void clearChargeAmount() {
        this.chargeAmount_ = 0L;
    }

    public static KetfStruct$WalletPaymentParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$WalletPaymentParams parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChargeAmount(long j) {
        this.chargeAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$WalletPaymentParams();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"chargeAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$WalletPaymentParams.class) {
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

    public long getChargeAmount() {
        return this.chargeAmount_;
    }

    public static a newBuilder(KetfStruct$WalletPaymentParams ketfStruct$WalletPaymentParams) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$WalletPaymentParams);
    }

    public static KetfStruct$WalletPaymentParams parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(byte[] bArr) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(InputStream inputStream) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$WalletPaymentParams parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$WalletPaymentParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
