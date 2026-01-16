package ai.bale.proto;

import ai.bale.proto.UsersStruct$Privacy;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseGetUserFullPrivacy extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseGetUserFullPrivacy DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PRIVACY_FIELD_NUMBER = 1;
    private int bitField0_;
    private UsersStruct$Privacy privacy_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseGetUserFullPrivacy.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseGetUserFullPrivacy usersOuterClass$ResponseGetUserFullPrivacy = new UsersOuterClass$ResponseGetUserFullPrivacy();
        DEFAULT_INSTANCE = usersOuterClass$ResponseGetUserFullPrivacy;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseGetUserFullPrivacy.class, usersOuterClass$ResponseGetUserFullPrivacy);
    }

    private UsersOuterClass$ResponseGetUserFullPrivacy() {
    }

    private void clearPrivacy() {
        this.privacy_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePrivacy(UsersStruct$Privacy usersStruct$Privacy) {
        usersStruct$Privacy.getClass();
        UsersStruct$Privacy usersStruct$Privacy2 = this.privacy_;
        if (usersStruct$Privacy2 == null || usersStruct$Privacy2 == UsersStruct$Privacy.getDefaultInstance()) {
            this.privacy_ = usersStruct$Privacy;
        } else {
            this.privacy_ = (UsersStruct$Privacy) ((UsersStruct$Privacy.a) UsersStruct$Privacy.newBuilder(this.privacy_).v(usersStruct$Privacy)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPrivacy(UsersStruct$Privacy usersStruct$Privacy) {
        usersStruct$Privacy.getClass();
        this.privacy_ = usersStruct$Privacy;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseGetUserFullPrivacy();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "privacy_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseGetUserFullPrivacy.class) {
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

    public UsersStruct$Privacy getPrivacy() {
        UsersStruct$Privacy usersStruct$Privacy = this.privacy_;
        return usersStruct$Privacy == null ? UsersStruct$Privacy.getDefaultInstance() : usersStruct$Privacy;
    }

    public boolean hasPrivacy() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$ResponseGetUserFullPrivacy usersOuterClass$ResponseGetUserFullPrivacy) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseGetUserFullPrivacy);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseGetUserFullPrivacy parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserFullPrivacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
