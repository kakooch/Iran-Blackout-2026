package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9519a60;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$RequestInvoiceGetToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$RequestInvoiceGetToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 1;
    private int service_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestInvoiceGetToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestInvoiceGetToken bankOuterClass$RequestInvoiceGetToken = new BankOuterClass$RequestInvoiceGetToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestInvoiceGetToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestInvoiceGetToken.class, bankOuterClass$RequestInvoiceGetToken);
    }

    private BankOuterClass$RequestInvoiceGetToken() {
    }

    private void clearService() {
        this.service_ = 0;
    }

    public static BankOuterClass$RequestInvoiceGetToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestInvoiceGetToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setService(EnumC9519a60 enumC9519a60) {
        this.service_ = enumC9519a60.getNumber();
    }

    private void setServiceValue(int i) {
        this.service_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestInvoiceGetToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"service_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestInvoiceGetToken.class) {
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

    public EnumC9519a60 getService() {
        EnumC9519a60 enumC9519a60J = EnumC9519a60.j(this.service_);
        return enumC9519a60J == null ? EnumC9519a60.UNRECOGNIZED : enumC9519a60J;
    }

    public int getServiceValue() {
        return this.service_;
    }

    public static a newBuilder(BankOuterClass$RequestInvoiceGetToken bankOuterClass$RequestInvoiceGetToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestInvoiceGetToken);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestInvoiceGetToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
