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
public final class SentenceOuterClass$RequestGetMyAwardsSummary extends GeneratedMessageLite implements U64 {
    private static final SentenceOuterClass$RequestGetMyAwardsSummary DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$RequestGetMyAwardsSummary.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$RequestGetMyAwardsSummary sentenceOuterClass$RequestGetMyAwardsSummary = new SentenceOuterClass$RequestGetMyAwardsSummary();
        DEFAULT_INSTANCE = sentenceOuterClass$RequestGetMyAwardsSummary;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$RequestGetMyAwardsSummary.class, sentenceOuterClass$RequestGetMyAwardsSummary);
    }

    private SentenceOuterClass$RequestGetMyAwardsSummary() {
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$RequestGetMyAwardsSummary();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$RequestGetMyAwardsSummary.class) {
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

    public static a newBuilder(SentenceOuterClass$RequestGetMyAwardsSummary sentenceOuterClass$RequestGetMyAwardsSummary) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$RequestGetMyAwardsSummary);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(byte[] bArr) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$RequestGetMyAwardsSummary parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$RequestGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
