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
public final class KetfOuterClass$ResponseGetBotGroupPermissions extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$ResponseGetBotGroupPermissions DEFAULT_INSTANCE;
    public static final int HAS_ACCESS_TO_MESSAGES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean hasAccessToMessages_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetBotGroupPermissions.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetBotGroupPermissions ketfOuterClass$ResponseGetBotGroupPermissions = new KetfOuterClass$ResponseGetBotGroupPermissions();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetBotGroupPermissions;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetBotGroupPermissions.class, ketfOuterClass$ResponseGetBotGroupPermissions);
    }

    private KetfOuterClass$ResponseGetBotGroupPermissions() {
    }

    private void clearHasAccessToMessages() {
        this.hasAccessToMessages_ = false;
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHasAccessToMessages(boolean z) {
        this.hasAccessToMessages_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetBotGroupPermissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"hasAccessToMessages_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetBotGroupPermissions.class) {
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

    public boolean getHasAccessToMessages() {
        return this.hasAccessToMessages_;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetBotGroupPermissions ketfOuterClass$ResponseGetBotGroupPermissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetBotGroupPermissions);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetBotGroupPermissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotGroupPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
