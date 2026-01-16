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
public final class Arbainexchange$ResponseCashPaymentCallback extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$ResponseCashPaymentCallback DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int LAST_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String firstName_ = "";
    private String lastName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseCashPaymentCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseCashPaymentCallback arbainexchange$ResponseCashPaymentCallback = new Arbainexchange$ResponseCashPaymentCallback();
        DEFAULT_INSTANCE = arbainexchange$ResponseCashPaymentCallback;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseCashPaymentCallback.class, arbainexchange$ResponseCashPaymentCallback);
    }

    private Arbainexchange$ResponseCashPaymentCallback() {
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    public static Arbainexchange$ResponseCashPaymentCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFirstName(String str) {
        str.getClass();
        this.firstName_ = str;
    }

    private void setFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.firstName_ = abstractC2383g.f0();
    }

    private void setLastName(String str) {
        str.getClass();
        this.lastName_ = str;
    }

    private void setLastNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.lastName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseCashPaymentCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"firstName_", "lastName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseCashPaymentCallback.class) {
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

    public String getFirstName() {
        return this.firstName_;
    }

    public AbstractC2383g getFirstNameBytes() {
        return AbstractC2383g.N(this.firstName_);
    }

    public String getLastName() {
        return this.lastName_;
    }

    public AbstractC2383g getLastNameBytes() {
        return AbstractC2383g.N(this.lastName_);
    }

    public static a newBuilder(Arbainexchange$ResponseCashPaymentCallback arbainexchange$ResponseCashPaymentCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseCashPaymentCallback);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseCashPaymentCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
