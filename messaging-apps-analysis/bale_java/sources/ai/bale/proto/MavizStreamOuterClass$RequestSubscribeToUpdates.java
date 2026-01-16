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
public final class MavizStreamOuterClass$RequestSubscribeToUpdates extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$RequestSubscribeToUpdates DEFAULT_INSTANCE;
    public static final int IS_MT_PROTO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isMtProto_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$RequestSubscribeToUpdates.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$RequestSubscribeToUpdates mavizStreamOuterClass$RequestSubscribeToUpdates = new MavizStreamOuterClass$RequestSubscribeToUpdates();
        DEFAULT_INSTANCE = mavizStreamOuterClass$RequestSubscribeToUpdates;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$RequestSubscribeToUpdates.class, mavizStreamOuterClass$RequestSubscribeToUpdates);
    }

    private MavizStreamOuterClass$RequestSubscribeToUpdates() {
    }

    private void clearIsMtProto() {
        this.isMtProto_ = false;
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsMtProto(boolean z) {
        this.isMtProto_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$RequestSubscribeToUpdates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"isMtProto_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$RequestSubscribeToUpdates.class) {
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

    public boolean getIsMtProto() {
        return this.isMtProto_;
    }

    public static a newBuilder(MavizStreamOuterClass$RequestSubscribeToUpdates mavizStreamOuterClass$RequestSubscribeToUpdates) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$RequestSubscribeToUpdates);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$RequestSubscribeToUpdates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestSubscribeToUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
