package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestGetUserPrivacyStatus extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestGetUserPrivacyStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int type_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestGetUserPrivacyStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestGetUserPrivacyStatus usersOuterClass$RequestGetUserPrivacyStatus = new UsersOuterClass$RequestGetUserPrivacyStatus();
        DEFAULT_INSTANCE = usersOuterClass$RequestGetUserPrivacyStatus;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestGetUserPrivacyStatus.class, usersOuterClass$RequestGetUserPrivacyStatus);
    }

    private UsersOuterClass$RequestGetUserPrivacyStatus() {
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setType(EM7 em7) {
        this.type_ = em7.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestGetUserPrivacyStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\f", new Object[]{"userId_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestGetUserPrivacyStatus.class) {
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

    public EM7 getType() {
        EM7 em7J = EM7.j(this.type_);
        return em7J == null ? EM7.UNRECOGNIZED : em7J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(UsersOuterClass$RequestGetUserPrivacyStatus usersOuterClass$RequestGetUserPrivacyStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestGetUserPrivacyStatus);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestGetUserPrivacyStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
