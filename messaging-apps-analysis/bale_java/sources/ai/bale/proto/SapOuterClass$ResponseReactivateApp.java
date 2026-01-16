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

/* loaded from: classes.dex */
public final class SapOuterClass$ResponseReactivateApp extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$ResponseReactivateApp DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTIVATION_ADDRESS_FIELD_NUMBER = 2;
    public static final int TRANSACTION_ID_FIELD_NUMBER = 1;
    private String transactionId_ = "";
    private String reactivationAddress_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseReactivateApp.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseReactivateApp sapOuterClass$ResponseReactivateApp = new SapOuterClass$ResponseReactivateApp();
        DEFAULT_INSTANCE = sapOuterClass$ResponseReactivateApp;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseReactivateApp.class, sapOuterClass$ResponseReactivateApp);
    }

    private SapOuterClass$ResponseReactivateApp() {
    }

    private void clearReactivationAddress() {
        this.reactivationAddress_ = getDefaultInstance().getReactivationAddress();
    }

    private void clearTransactionId() {
        this.transactionId_ = getDefaultInstance().getTransactionId();
    }

    public static SapOuterClass$ResponseReactivateApp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseReactivateApp parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReactivationAddress(String str) {
        str.getClass();
        this.reactivationAddress_ = str;
    }

    private void setReactivationAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reactivationAddress_ = abstractC2383g.f0();
    }

    private void setTransactionId(String str) {
        str.getClass();
        this.transactionId_ = str;
    }

    private void setTransactionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseReactivateApp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"transactionId_", "reactivationAddress_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseReactivateApp.class) {
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

    public String getReactivationAddress() {
        return this.reactivationAddress_;
    }

    public AbstractC2383g getReactivationAddressBytes() {
        return AbstractC2383g.N(this.reactivationAddress_);
    }

    public String getTransactionId() {
        return this.transactionId_;
    }

    public AbstractC2383g getTransactionIdBytes() {
        return AbstractC2383g.N(this.transactionId_);
    }

    public static a newBuilder(SapOuterClass$ResponseReactivateApp sapOuterClass$ResponseReactivateApp) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseReactivateApp);
    }

    public static SapOuterClass$ResponseReactivateApp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseReactivateApp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
