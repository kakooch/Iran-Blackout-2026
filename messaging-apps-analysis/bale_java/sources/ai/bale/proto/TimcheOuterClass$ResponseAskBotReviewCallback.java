package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheOuterClass$ResponseAskBotReviewCallback extends GeneratedMessageLite implements U64 {
    private static final TimcheOuterClass$ResponseAskBotReviewCallback DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$ResponseAskBotReviewCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$ResponseAskBotReviewCallback timcheOuterClass$ResponseAskBotReviewCallback = new TimcheOuterClass$ResponseAskBotReviewCallback();
        DEFAULT_INSTANCE = timcheOuterClass$ResponseAskBotReviewCallback;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$ResponseAskBotReviewCallback.class, timcheOuterClass$ResponseAskBotReviewCallback);
    }

    private TimcheOuterClass$ResponseAskBotReviewCallback() {
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$ResponseAskBotReviewCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$ResponseAskBotReviewCallback.class) {
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

    public static a newBuilder(TimcheOuterClass$ResponseAskBotReviewCallback timcheOuterClass$ResponseAskBotReviewCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$ResponseAskBotReviewCallback);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(byte[] bArr) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$ResponseAskBotReviewCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$ResponseAskBotReviewCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
