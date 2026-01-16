package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9110Yn3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KetfStruct$PaymentSession extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$PaymentSession DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_OPTIONS_FIELD_NUMBER = 2;
    public static final int PAYMENT_SESSION_ID_FIELD_NUMBER = 1;
    private String paymentSessionId_ = "";
    private B.j paymentOptions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$PaymentSession.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$PaymentSession ketfStruct$PaymentSession = new KetfStruct$PaymentSession();
        DEFAULT_INSTANCE = ketfStruct$PaymentSession;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$PaymentSession.class, ketfStruct$PaymentSession);
    }

    private KetfStruct$PaymentSession() {
    }

    private void addAllPaymentOptions(Iterable<? extends KetfStruct$PaymentOption> iterable) {
        ensurePaymentOptionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.paymentOptions_);
    }

    private void addPaymentOptions(KetfStruct$PaymentOption ketfStruct$PaymentOption) {
        ketfStruct$PaymentOption.getClass();
        ensurePaymentOptionsIsMutable();
        this.paymentOptions_.add(ketfStruct$PaymentOption);
    }

    private void clearPaymentOptions() {
        this.paymentOptions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPaymentSessionId() {
        this.paymentSessionId_ = getDefaultInstance().getPaymentSessionId();
    }

    private void ensurePaymentOptionsIsMutable() {
        B.j jVar = this.paymentOptions_;
        if (jVar.u()) {
            return;
        }
        this.paymentOptions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KetfStruct$PaymentSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$PaymentSession parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentSession parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePaymentOptions(int i) {
        ensurePaymentOptionsIsMutable();
        this.paymentOptions_.remove(i);
    }

    private void setPaymentOptions(int i, KetfStruct$PaymentOption ketfStruct$PaymentOption) {
        ketfStruct$PaymentOption.getClass();
        ensurePaymentOptionsIsMutable();
        this.paymentOptions_.set(i, ketfStruct$PaymentOption);
    }

    private void setPaymentSessionId(String str) {
        str.getClass();
        this.paymentSessionId_ = str;
    }

    private void setPaymentSessionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentSessionId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$PaymentSession();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"paymentSessionId_", "paymentOptions_", KetfStruct$PaymentOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$PaymentSession.class) {
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

    public KetfStruct$PaymentOption getPaymentOptions(int i) {
        return (KetfStruct$PaymentOption) this.paymentOptions_.get(i);
    }

    public int getPaymentOptionsCount() {
        return this.paymentOptions_.size();
    }

    public List<KetfStruct$PaymentOption> getPaymentOptionsList() {
        return this.paymentOptions_;
    }

    public InterfaceC9110Yn3 getPaymentOptionsOrBuilder(int i) {
        return (InterfaceC9110Yn3) this.paymentOptions_.get(i);
    }

    public List<? extends InterfaceC9110Yn3> getPaymentOptionsOrBuilderList() {
        return this.paymentOptions_;
    }

    public String getPaymentSessionId() {
        return this.paymentSessionId_;
    }

    public AbstractC2383g getPaymentSessionIdBytes() {
        return AbstractC2383g.N(this.paymentSessionId_);
    }

    public static a newBuilder(KetfStruct$PaymentSession ketfStruct$PaymentSession) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$PaymentSession);
    }

    public static KetfStruct$PaymentSession parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentSession parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$PaymentSession parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPaymentOptions(int i, KetfStruct$PaymentOption ketfStruct$PaymentOption) {
        ketfStruct$PaymentOption.getClass();
        ensurePaymentOptionsIsMutable();
        this.paymentOptions_.add(i, ketfStruct$PaymentOption);
    }

    public static KetfStruct$PaymentSession parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$PaymentSession parseFrom(byte[] bArr) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$PaymentSession parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$PaymentSession parseFrom(InputStream inputStream) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentSession parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentSession parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$PaymentSession parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$PaymentSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
