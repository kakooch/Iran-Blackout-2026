package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.SV3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$RouteSeq extends GeneratedMessageLite implements SV3 {
    private static final MavizStreamOuterClass$RouteSeq DEFAULT_INSTANCE;
    public static final int LAST_SEQUENCE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int ROUTE_ID_FIELD_NUMBER = 1;
    private int lastSequence_;
    private int routeId_;

    public static final class a extends GeneratedMessageLite.b implements SV3 {
        private a() {
            super(MavizStreamOuterClass$RouteSeq.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$RouteSeq mavizStreamOuterClass$RouteSeq = new MavizStreamOuterClass$RouteSeq();
        DEFAULT_INSTANCE = mavizStreamOuterClass$RouteSeq;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$RouteSeq.class, mavizStreamOuterClass$RouteSeq);
    }

    private MavizStreamOuterClass$RouteSeq() {
    }

    private void clearLastSequence() {
        this.lastSequence_ = 0;
    }

    private void clearRouteId() {
        this.routeId_ = 0;
    }

    public static MavizStreamOuterClass$RouteSeq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$RouteSeq parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastSequence(int i) {
        this.lastSequence_ = i;
    }

    private void setRouteId(int i) {
        this.routeId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$RouteSeq();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"routeId_", "lastSequence_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$RouteSeq.class) {
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

    public int getLastSequence() {
        return this.lastSequence_;
    }

    public int getRouteId() {
        return this.routeId_;
    }

    public static a newBuilder(MavizStreamOuterClass$RouteSeq mavizStreamOuterClass$RouteSeq) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$RouteSeq);
    }

    public static MavizStreamOuterClass$RouteSeq parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$RouteSeq parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$RouteSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
