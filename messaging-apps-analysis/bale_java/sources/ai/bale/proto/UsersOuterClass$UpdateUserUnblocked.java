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
public final class UsersOuterClass$UpdateUserUnblocked extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateUserUnblocked DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserUnblocked.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserUnblocked usersOuterClass$UpdateUserUnblocked = new UsersOuterClass$UpdateUserUnblocked();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserUnblocked;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserUnblocked.class, usersOuterClass$UpdateUserUnblocked);
    }

    private UsersOuterClass$UpdateUserUnblocked() {
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$UpdateUserUnblocked getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserUnblocked parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserUnblocked();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"uid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserUnblocked.class) {
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

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserUnblocked usersOuterClass$UpdateUserUnblocked) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserUnblocked);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserUnblocked parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserUnblocked) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
