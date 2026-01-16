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
public final class SafirOuterClass$RequestGetSafirs extends GeneratedMessageLite implements U64 {
    private static final SafirOuterClass$RequestGetSafirs DEFAULT_INSTANCE;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int organizationId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$RequestGetSafirs.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$RequestGetSafirs safirOuterClass$RequestGetSafirs = new SafirOuterClass$RequestGetSafirs();
        DEFAULT_INSTANCE = safirOuterClass$RequestGetSafirs;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$RequestGetSafirs.class, safirOuterClass$RequestGetSafirs);
    }

    private SafirOuterClass$RequestGetSafirs() {
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    public static SafirOuterClass$RequestGetSafirs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$RequestGetSafirs parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$RequestGetSafirs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"organizationId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$RequestGetSafirs.class) {
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

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public static a newBuilder(SafirOuterClass$RequestGetSafirs safirOuterClass$RequestGetSafirs) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$RequestGetSafirs);
    }

    public static SafirOuterClass$RequestGetSafirs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(byte[] bArr) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$RequestGetSafirs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$RequestGetSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
