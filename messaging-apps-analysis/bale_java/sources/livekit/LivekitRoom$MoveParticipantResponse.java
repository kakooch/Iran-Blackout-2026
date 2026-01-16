package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRoom$MoveParticipantResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$MoveParticipantResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$MoveParticipantResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$MoveParticipantResponse livekitRoom$MoveParticipantResponse = new LivekitRoom$MoveParticipantResponse();
        DEFAULT_INSTANCE = livekitRoom$MoveParticipantResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$MoveParticipantResponse.class, livekitRoom$MoveParticipantResponse);
    }

    private LivekitRoom$MoveParticipantResponse() {
    }

    public static LivekitRoom$MoveParticipantResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$MoveParticipantResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$MoveParticipantResponse();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$MoveParticipantResponse.class) {
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

    public static a newBuilder(LivekitRoom$MoveParticipantResponse livekitRoom$MoveParticipantResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$MoveParticipantResponse);
    }

    public static LivekitRoom$MoveParticipantResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(byte[] bArr) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(InputStream inputStream) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$MoveParticipantResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$MoveParticipantResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
