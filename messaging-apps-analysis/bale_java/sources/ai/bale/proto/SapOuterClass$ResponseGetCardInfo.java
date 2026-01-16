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
public final class SapOuterClass$ResponseGetCardInfo extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$ResponseGetCardInfo DEFAULT_INSTANCE;
    public static final int MASKED_PAN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String cardId_ = "";
    private String maskedPan_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseGetCardInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo = new SapOuterClass$ResponseGetCardInfo();
        DEFAULT_INSTANCE = sapOuterClass$ResponseGetCardInfo;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseGetCardInfo.class, sapOuterClass$ResponseGetCardInfo);
    }

    private SapOuterClass$ResponseGetCardInfo() {
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    private void clearMaskedPan() {
        this.maskedPan_ = getDefaultInstance().getMaskedPan();
    }

    public static SapOuterClass$ResponseGetCardInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseGetCardInfo parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardId(String str) {
        str.getClass();
        this.cardId_ = str;
    }

    private void setCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardId_ = abstractC2383g.f0();
    }

    private void setMaskedPan(String str) {
        str.getClass();
        this.maskedPan_ = str;
    }

    private void setMaskedPanBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.maskedPan_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseGetCardInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"cardId_", "maskedPan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseGetCardInfo.class) {
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

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public String getMaskedPan() {
        return this.maskedPan_;
    }

    public AbstractC2383g getMaskedPanBytes() {
        return AbstractC2383g.N(this.maskedPan_);
    }

    public static a newBuilder(SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseGetCardInfo);
    }

    public static SapOuterClass$ResponseGetCardInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseGetCardInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
