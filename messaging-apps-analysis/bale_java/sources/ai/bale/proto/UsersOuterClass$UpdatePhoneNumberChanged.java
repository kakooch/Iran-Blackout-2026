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
public final class UsersOuterClass$UpdatePhoneNumberChanged extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdatePhoneNumberChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long phoneNumber_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdatePhoneNumberChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdatePhoneNumberChanged usersOuterClass$UpdatePhoneNumberChanged = new UsersOuterClass$UpdatePhoneNumberChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdatePhoneNumberChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdatePhoneNumberChanged.class, usersOuterClass$UpdatePhoneNumberChanged);
    }

    private UsersOuterClass$UpdatePhoneNumberChanged() {
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPhoneNumber(long j) {
        this.phoneNumber_ = j;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdatePhoneNumberChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"userId_", "phoneNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdatePhoneNumberChanged.class) {
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

    public long getPhoneNumber() {
        return this.phoneNumber_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(UsersOuterClass$UpdatePhoneNumberChanged usersOuterClass$UpdatePhoneNumberChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdatePhoneNumberChanged);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdatePhoneNumberChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdatePhoneNumberChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
