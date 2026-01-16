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
public final class Arbainexchange$RequestLoadArbaeenHistory extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestLoadArbaeenHistory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestLoadArbaeenHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestLoadArbaeenHistory arbainexchange$RequestLoadArbaeenHistory = new Arbainexchange$RequestLoadArbaeenHistory();
        DEFAULT_INSTANCE = arbainexchange$RequestLoadArbaeenHistory;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestLoadArbaeenHistory.class, arbainexchange$RequestLoadArbaeenHistory);
    }

    private Arbainexchange$RequestLoadArbaeenHistory() {
    }

    public static Arbainexchange$RequestLoadArbaeenHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestLoadArbaeenHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestLoadArbaeenHistory.class) {
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

    public static a newBuilder(Arbainexchange$RequestLoadArbaeenHistory arbainexchange$RequestLoadArbaeenHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestLoadArbaeenHistory);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestLoadArbaeenHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
