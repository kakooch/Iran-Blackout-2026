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
public final class BusinessOuterClass$RequestLogout extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestLogout DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestLogout.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestLogout businessOuterClass$RequestLogout = new BusinessOuterClass$RequestLogout();
        DEFAULT_INSTANCE = businessOuterClass$RequestLogout;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestLogout.class, businessOuterClass$RequestLogout);
    }

    private BusinessOuterClass$RequestLogout() {
    }

    public static BusinessOuterClass$RequestLogout getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestLogout parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestLogout();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestLogout.class) {
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

    public static a newBuilder(BusinessOuterClass$RequestLogout businessOuterClass$RequestLogout) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestLogout);
    }

    public static BusinessOuterClass$RequestLogout parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestLogout parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestLogout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
