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
public final class LivekitRoom$DeleteRoomResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$DeleteRoomResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$DeleteRoomResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$DeleteRoomResponse livekitRoom$DeleteRoomResponse = new LivekitRoom$DeleteRoomResponse();
        DEFAULT_INSTANCE = livekitRoom$DeleteRoomResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$DeleteRoomResponse.class, livekitRoom$DeleteRoomResponse);
    }

    private LivekitRoom$DeleteRoomResponse() {
    }

    public static LivekitRoom$DeleteRoomResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$DeleteRoomResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$DeleteRoomResponse();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$DeleteRoomResponse.class) {
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

    public static a newBuilder(LivekitRoom$DeleteRoomResponse livekitRoom$DeleteRoomResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$DeleteRoomResponse);
    }

    public static LivekitRoom$DeleteRoomResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(byte[] bArr) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(InputStream inputStream) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$DeleteRoomResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$DeleteRoomResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
