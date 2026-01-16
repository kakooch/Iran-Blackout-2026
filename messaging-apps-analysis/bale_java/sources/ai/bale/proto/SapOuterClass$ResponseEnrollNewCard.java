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
public final class SapOuterClass$ResponseEnrollNewCard extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$ResponseEnrollNewCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_ID_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private String transactionId_ = "";
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseEnrollNewCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard = new SapOuterClass$ResponseEnrollNewCard();
        DEFAULT_INSTANCE = sapOuterClass$ResponseEnrollNewCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseEnrollNewCard.class, sapOuterClass$ResponseEnrollNewCard);
    }

    private SapOuterClass$ResponseEnrollNewCard() {
    }

    private void clearTransactionId() {
        this.transactionId_ = getDefaultInstance().getTransactionId();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static SapOuterClass$ResponseEnrollNewCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseEnrollNewCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTransactionId(String str) {
        str.getClass();
        this.transactionId_ = str;
    }

    private void setTransactionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionId_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseEnrollNewCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"transactionId_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseEnrollNewCard.class) {
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

    public String getTransactionId() {
        return this.transactionId_;
    }

    public AbstractC2383g getTransactionIdBytes() {
        return AbstractC2383g.N(this.transactionId_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseEnrollNewCard);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseEnrollNewCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
