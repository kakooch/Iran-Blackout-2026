package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
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
public final class MessagingStruct$PsProxyOrderMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$PsProxyOrderMessage DEFAULT_INSTANCE;
    public static final int PARAMETERS_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PRODUCT_TYPE_FIELD_NUMBER = 2;
    public static final int PRODUCT_VERSION_FIELD_NUMBER = 3;
    public static final int PSP_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$MapValue parameters_;
    private int productVersion_;
    private String psp_ = "";
    private String productType_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$PsProxyOrderMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$PsProxyOrderMessage messagingStruct$PsProxyOrderMessage = new MessagingStruct$PsProxyOrderMessage();
        DEFAULT_INSTANCE = messagingStruct$PsProxyOrderMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$PsProxyOrderMessage.class, messagingStruct$PsProxyOrderMessage);
    }

    private MessagingStruct$PsProxyOrderMessage() {
    }

    private void clearParameters() {
        this.parameters_ = null;
        this.bitField0_ &= -2;
    }

    private void clearProductType() {
        this.productType_ = getDefaultInstance().getProductType();
    }

    private void clearProductVersion() {
        this.productVersion_ = 0;
    }

    private void clearPsp() {
        this.psp_ = getDefaultInstance().getPsp();
    }

    public static MessagingStruct$PsProxyOrderMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeParameters(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.parameters_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.parameters_ = collectionsStruct$MapValue;
        } else {
            this.parameters_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.parameters_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$PsProxyOrderMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setParameters(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.parameters_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    private void setProductType(String str) {
        str.getClass();
        this.productType_ = str;
    }

    private void setProductTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.productType_ = abstractC2383g.f0();
    }

    private void setProductVersion(int i) {
        this.productVersion_ = i;
    }

    private void setPsp(String str) {
        str.getClass();
        this.psp_ = str;
    }

    private void setPspBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.psp_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$PsProxyOrderMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004ဉ\u0000", new Object[]{"bitField0_", "psp_", "productType_", "productVersion_", "parameters_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$PsProxyOrderMessage.class) {
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

    public CollectionsStruct$MapValue getParameters() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.parameters_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public String getProductType() {
        return this.productType_;
    }

    public AbstractC2383g getProductTypeBytes() {
        return AbstractC2383g.N(this.productType_);
    }

    public int getProductVersion() {
        return this.productVersion_;
    }

    public String getPsp() {
        return this.psp_;
    }

    public AbstractC2383g getPspBytes() {
        return AbstractC2383g.N(this.psp_);
    }

    public boolean hasParameters() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$PsProxyOrderMessage messagingStruct$PsProxyOrderMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$PsProxyOrderMessage);
    }

    public static MessagingStruct$PsProxyOrderMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$PsProxyOrderMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$PsProxyOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
