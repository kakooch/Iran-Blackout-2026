package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseGetUserPrivacyStatus extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseGetUserPrivacyStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseGetUserPrivacyStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseGetUserPrivacyStatus usersOuterClass$ResponseGetUserPrivacyStatus = new UsersOuterClass$ResponseGetUserPrivacyStatus();
        DEFAULT_INSTANCE = usersOuterClass$ResponseGetUserPrivacyStatus;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseGetUserPrivacyStatus.class, usersOuterClass$ResponseGetUserPrivacyStatus);
    }

    private UsersOuterClass$ResponseGetUserPrivacyStatus() {
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStatus(DM7 dm7) {
        this.status_ = dm7.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseGetUserPrivacyStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseGetUserPrivacyStatus.class) {
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

    public DM7 getStatus() {
        DM7 dm7J = DM7.j(this.status_);
        return dm7J == null ? DM7.UNRECOGNIZED : dm7J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(UsersOuterClass$ResponseGetUserPrivacyStatus usersOuterClass$ResponseGetUserPrivacyStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseGetUserPrivacyStatus);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseGetUserPrivacyStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUserPrivacyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
