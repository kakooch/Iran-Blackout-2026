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
public final class LivekitCloudAgent$ClientSettingsRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitCloudAgent$ClientSettingsRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$ClientSettingsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$ClientSettingsRequest livekitCloudAgent$ClientSettingsRequest = new LivekitCloudAgent$ClientSettingsRequest();
        DEFAULT_INSTANCE = livekitCloudAgent$ClientSettingsRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$ClientSettingsRequest.class, livekitCloudAgent$ClientSettingsRequest);
    }

    private LivekitCloudAgent$ClientSettingsRequest() {
    }

    public static LivekitCloudAgent$ClientSettingsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$ClientSettingsRequest();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$ClientSettingsRequest.class) {
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

    public static a newBuilder(LivekitCloudAgent$ClientSettingsRequest livekitCloudAgent$ClientSettingsRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$ClientSettingsRequest);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$ClientSettingsRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$ClientSettingsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
