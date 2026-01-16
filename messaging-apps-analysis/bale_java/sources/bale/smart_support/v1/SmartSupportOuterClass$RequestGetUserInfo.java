package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestGetUserInfo extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$RequestGetUserInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestGetUserInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestGetUserInfo smartSupportOuterClass$RequestGetUserInfo = new SmartSupportOuterClass$RequestGetUserInfo();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestGetUserInfo;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestGetUserInfo.class, smartSupportOuterClass$RequestGetUserInfo);
    }

    private SmartSupportOuterClass$RequestGetUserInfo() {
    }

    public static SmartSupportOuterClass$RequestGetUserInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestGetUserInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestGetUserInfo.class) {
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

    public static a newBuilder(SmartSupportOuterClass$RequestGetUserInfo smartSupportOuterClass$RequestGetUserInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestGetUserInfo);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestGetUserInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
