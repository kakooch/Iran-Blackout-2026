package ai.bale.proto;

import ai.bale.proto.MiscStruct$Config;
import ai.bale.proto.UsersStruct$User;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseAuth extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 3;
    private static final AuthOuterClass$ResponseAuth DEFAULT_INSTANCE;
    public static final int JWT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int USER_FIELD_NUMBER = 2;
    private int bitField0_;
    private MiscStruct$Config config_;
    private StringValue jwt_;
    private UsersStruct$User user_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseAuth.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseAuth authOuterClass$ResponseAuth = new AuthOuterClass$ResponseAuth();
        DEFAULT_INSTANCE = authOuterClass$ResponseAuth;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseAuth.class, authOuterClass$ResponseAuth);
    }

    private AuthOuterClass$ResponseAuth() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -3;
    }

    private void clearJwt() {
        this.jwt_ = null;
        this.bitField0_ &= -5;
    }

    private void clearUser() {
        this.user_ = null;
        this.bitField0_ &= -2;
    }

    public static AuthOuterClass$ResponseAuth getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(MiscStruct$Config miscStruct$Config) {
        miscStruct$Config.getClass();
        MiscStruct$Config miscStruct$Config2 = this.config_;
        if (miscStruct$Config2 == null || miscStruct$Config2 == MiscStruct$Config.getDefaultInstance()) {
            this.config_ = miscStruct$Config;
        } else {
            this.config_ = (MiscStruct$Config) ((MiscStruct$Config.a) MiscStruct$Config.newBuilder(this.config_).v(miscStruct$Config)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeJwt(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.jwt_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.jwt_ = stringValue;
        } else {
            this.jwt_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.jwt_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeUser(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        UsersStruct$User usersStruct$User2 = this.user_;
        if (usersStruct$User2 == null || usersStruct$User2 == UsersStruct$User.getDefaultInstance()) {
            this.user_ = usersStruct$User;
        } else {
            this.user_ = (UsersStruct$User) ((UsersStruct$User.a) UsersStruct$User.newBuilder(this.user_).v(usersStruct$User)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseAuth parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfig(MiscStruct$Config miscStruct$Config) {
        miscStruct$Config.getClass();
        this.config_ = miscStruct$Config;
        this.bitField0_ |= 2;
    }

    private void setJwt(StringValue stringValue) {
        stringValue.getClass();
        this.jwt_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setUser(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        this.user_ = usersStruct$User;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseAuth();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0000\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "user_", "config_", "jwt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseAuth.class) {
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

    public MiscStruct$Config getConfig() {
        MiscStruct$Config miscStruct$Config = this.config_;
        return miscStruct$Config == null ? MiscStruct$Config.getDefaultInstance() : miscStruct$Config;
    }

    public StringValue getJwt() {
        StringValue stringValue = this.jwt_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public UsersStruct$User getUser() {
        UsersStruct$User usersStruct$User = this.user_;
        return usersStruct$User == null ? UsersStruct$User.getDefaultInstance() : usersStruct$User;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasJwt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AuthOuterClass$ResponseAuth authOuterClass$ResponseAuth) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseAuth);
    }

    public static AuthOuterClass$ResponseAuth parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseAuth parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
