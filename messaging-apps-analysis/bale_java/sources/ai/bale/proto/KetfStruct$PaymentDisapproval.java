package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8335Vn3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$PaymentDisapproval extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$PaymentDisapproval DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private int reason_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$PaymentDisapproval.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$PaymentDisapproval ketfStruct$PaymentDisapproval = new KetfStruct$PaymentDisapproval();
        DEFAULT_INSTANCE = ketfStruct$PaymentDisapproval;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$PaymentDisapproval.class, ketfStruct$PaymentDisapproval);
    }

    private KetfStruct$PaymentDisapproval() {
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    public static KetfStruct$PaymentDisapproval getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$PaymentDisapproval parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReason(EnumC8335Vn3 enumC8335Vn3) {
        this.reason_ = enumC8335Vn3.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$PaymentDisapproval();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$PaymentDisapproval.class) {
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

    public EnumC8335Vn3 getReason() {
        EnumC8335Vn3 enumC8335Vn3J = EnumC8335Vn3.j(this.reason_);
        return enumC8335Vn3J == null ? EnumC8335Vn3.UNRECOGNIZED : enumC8335Vn3J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public static a newBuilder(KetfStruct$PaymentDisapproval ketfStruct$PaymentDisapproval) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$PaymentDisapproval);
    }

    public static KetfStruct$PaymentDisapproval parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(byte[] bArr) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(InputStream inputStream) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$PaymentDisapproval parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$PaymentDisapproval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
