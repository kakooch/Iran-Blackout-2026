package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$Encryption extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$Encryption DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$Encryption.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        NONE(0),
        GCM(1),
        CUSTOM(2),
        UNRECOGNIZED(-1);

        private static final B.d f = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return NONE;
            }
            if (i == 1) {
                return GCM;
            }
            if (i != 2) {
                return null;
            }
            return CUSTOM;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitModels$Encryption livekitModels$Encryption = new LivekitModels$Encryption();
        DEFAULT_INSTANCE = livekitModels$Encryption;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$Encryption.class, livekitModels$Encryption);
    }

    private LivekitModels$Encryption() {
    }

    public static LivekitModels$Encryption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$Encryption parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Encryption parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$Encryption();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$Encryption.class) {
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

    public static a newBuilder(LivekitModels$Encryption livekitModels$Encryption) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$Encryption);
    }

    public static LivekitModels$Encryption parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Encryption parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$Encryption parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$Encryption parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$Encryption parseFrom(byte[] bArr) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$Encryption parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$Encryption parseFrom(InputStream inputStream) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Encryption parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Encryption parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$Encryption parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$Encryption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
