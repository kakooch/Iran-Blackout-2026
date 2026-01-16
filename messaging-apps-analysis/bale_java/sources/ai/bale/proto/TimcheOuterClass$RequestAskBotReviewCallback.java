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
public final class TimcheOuterClass$RequestAskBotReviewCallback extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final TimcheOuterClass$RequestAskBotReviewCallback DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private int botId_;
    private String payload_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((TimcheOuterClass$RequestAskBotReviewCallback) this.b).setBotId(i);
            return this;
        }

        public a B(String str) {
            q();
            ((TimcheOuterClass$RequestAskBotReviewCallback) this.b).setPayload(str);
            return this;
        }

        private a() {
            super(TimcheOuterClass$RequestAskBotReviewCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$RequestAskBotReviewCallback timcheOuterClass$RequestAskBotReviewCallback = new TimcheOuterClass$RequestAskBotReviewCallback();
        DEFAULT_INSTANCE = timcheOuterClass$RequestAskBotReviewCallback;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$RequestAskBotReviewCallback.class, timcheOuterClass$RequestAskBotReviewCallback);
    }

    private TimcheOuterClass$RequestAskBotReviewCallback() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotId(int i) {
        this.botId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayload(String str) {
        str.getClass();
        this.payload_ = str;
    }

    private void setPayloadBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.payload_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$RequestAskBotReviewCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"botId_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$RequestAskBotReviewCallback.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public String getPayload() {
        return this.payload_;
    }

    public AbstractC2383g getPayloadBytes() {
        return AbstractC2383g.N(this.payload_);
    }

    public static a newBuilder(TimcheOuterClass$RequestAskBotReviewCallback timcheOuterClass$RequestAskBotReviewCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$RequestAskBotReviewCallback);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(byte[] bArr) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$RequestAskBotReviewCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$RequestAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
