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
public final class SefteOuterClass$RequestGetCitiesOfState extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$RequestGetCitiesOfState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATE_CODE_FIELD_NUMBER = 1;
    private int stateCode_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestGetCitiesOfState.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestGetCitiesOfState sefteOuterClass$RequestGetCitiesOfState = new SefteOuterClass$RequestGetCitiesOfState();
        DEFAULT_INSTANCE = sefteOuterClass$RequestGetCitiesOfState;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestGetCitiesOfState.class, sefteOuterClass$RequestGetCitiesOfState);
    }

    private SefteOuterClass$RequestGetCitiesOfState() {
    }

    private void clearStateCode() {
        this.stateCode_ = 0;
    }

    public static SefteOuterClass$RequestGetCitiesOfState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStateCode(int i) {
        this.stateCode_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestGetCitiesOfState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"stateCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestGetCitiesOfState.class) {
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

    public int getStateCode() {
        return this.stateCode_;
    }

    public static a newBuilder(SefteOuterClass$RequestGetCitiesOfState sefteOuterClass$RequestGetCitiesOfState) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestGetCitiesOfState);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestGetCitiesOfState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
