package ai.bale.proto;

import ai.bale.proto.UsersStruct$FullUser;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseGetFullUser extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseGetFullUser DEFAULT_INSTANCE;
    public static final int FULL_USER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private UsersStruct$FullUser fullUser_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseGetFullUser.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseGetFullUser usersOuterClass$ResponseGetFullUser = new UsersOuterClass$ResponseGetFullUser();
        DEFAULT_INSTANCE = usersOuterClass$ResponseGetFullUser;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseGetFullUser.class, usersOuterClass$ResponseGetFullUser);
    }

    private UsersOuterClass$ResponseGetFullUser() {
    }

    private void clearFullUser() {
        this.fullUser_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$ResponseGetFullUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFullUser(UsersStruct$FullUser usersStruct$FullUser) {
        usersStruct$FullUser.getClass();
        UsersStruct$FullUser usersStruct$FullUser2 = this.fullUser_;
        if (usersStruct$FullUser2 == null || usersStruct$FullUser2 == UsersStruct$FullUser.getDefaultInstance()) {
            this.fullUser_ = usersStruct$FullUser;
        } else {
            this.fullUser_ = (UsersStruct$FullUser) ((UsersStruct$FullUser.a) UsersStruct$FullUser.newBuilder(this.fullUser_).v(usersStruct$FullUser)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseGetFullUser parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFullUser(UsersStruct$FullUser usersStruct$FullUser) {
        usersStruct$FullUser.getClass();
        this.fullUser_ = usersStruct$FullUser;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseGetFullUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "fullUser_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseGetFullUser.class) {
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

    public UsersStruct$FullUser getFullUser() {
        UsersStruct$FullUser usersStruct$FullUser = this.fullUser_;
        return usersStruct$FullUser == null ? UsersStruct$FullUser.getDefaultInstance() : usersStruct$FullUser;
    }

    public boolean hasFullUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$ResponseGetFullUser usersOuterClass$ResponseGetFullUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseGetFullUser);
    }

    public static UsersOuterClass$ResponseGetFullUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseGetFullUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetFullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
