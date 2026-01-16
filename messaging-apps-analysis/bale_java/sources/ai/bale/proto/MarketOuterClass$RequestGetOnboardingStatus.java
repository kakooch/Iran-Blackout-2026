package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestGetOnboardingStatus extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestGetOnboardingStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetOnboardingStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetOnboardingStatus marketOuterClass$RequestGetOnboardingStatus = new MarketOuterClass$RequestGetOnboardingStatus();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetOnboardingStatus;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetOnboardingStatus.class, marketOuterClass$RequestGetOnboardingStatus);
    }

    private MarketOuterClass$RequestGetOnboardingStatus() {
    }

    public static MarketOuterClass$RequestGetOnboardingStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetOnboardingStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetOnboardingStatus.class) {
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

    public static a newBuilder(MarketOuterClass$RequestGetOnboardingStatus marketOuterClass$RequestGetOnboardingStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetOnboardingStatus);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetOnboardingStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetOnboardingStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
