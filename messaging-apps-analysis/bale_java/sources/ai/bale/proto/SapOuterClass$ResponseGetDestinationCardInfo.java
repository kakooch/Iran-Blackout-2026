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
public final class SapOuterClass$ResponseGetDestinationCardInfo extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_CODE_FIELD_NUMBER = 2;
    public static final int CARD_HOLDER_NAME_FIELD_NUMBER = 1;
    private static final SapOuterClass$ResponseGetDestinationCardInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String cardHolderName_ = "";
    private String approvalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseGetDestinationCardInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseGetDestinationCardInfo sapOuterClass$ResponseGetDestinationCardInfo = new SapOuterClass$ResponseGetDestinationCardInfo();
        DEFAULT_INSTANCE = sapOuterClass$ResponseGetDestinationCardInfo;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseGetDestinationCardInfo.class, sapOuterClass$ResponseGetDestinationCardInfo);
    }

    private SapOuterClass$ResponseGetDestinationCardInfo() {
    }

    private void clearApprovalCode() {
        this.approvalCode_ = getDefaultInstance().getApprovalCode();
    }

    private void clearCardHolderName() {
        this.cardHolderName_ = getDefaultInstance().getCardHolderName();
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApprovalCode(String str) {
        str.getClass();
        this.approvalCode_ = str;
    }

    private void setApprovalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.approvalCode_ = abstractC2383g.f0();
    }

    private void setCardHolderName(String str) {
        str.getClass();
        this.cardHolderName_ = str;
    }

    private void setCardHolderNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardHolderName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseGetDestinationCardInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"cardHolderName_", "approvalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseGetDestinationCardInfo.class) {
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

    public String getApprovalCode() {
        return this.approvalCode_;
    }

    public AbstractC2383g getApprovalCodeBytes() {
        return AbstractC2383g.N(this.approvalCode_);
    }

    public String getCardHolderName() {
        return this.cardHolderName_;
    }

    public AbstractC2383g getCardHolderNameBytes() {
        return AbstractC2383g.N(this.cardHolderName_);
    }

    public static a newBuilder(SapOuterClass$ResponseGetDestinationCardInfo sapOuterClass$ResponseGetDestinationCardInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseGetDestinationCardInfo);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseGetDestinationCardInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
