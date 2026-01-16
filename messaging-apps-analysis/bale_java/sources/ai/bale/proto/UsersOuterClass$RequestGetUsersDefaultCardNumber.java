package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestGetUsersDefaultCardNumber extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestGetUsersDefaultCardNumber DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userIdMemoizedSerializedSize = -1;
    private B.g userId_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((UsersOuterClass$RequestGetUsersDefaultCardNumber) this.b).addAllUserId(iterable);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestGetUsersDefaultCardNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestGetUsersDefaultCardNumber usersOuterClass$RequestGetUsersDefaultCardNumber = new UsersOuterClass$RequestGetUsersDefaultCardNumber();
        DEFAULT_INSTANCE = usersOuterClass$RequestGetUsersDefaultCardNumber;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestGetUsersDefaultCardNumber.class, usersOuterClass$RequestGetUsersDefaultCardNumber);
    }

    private UsersOuterClass$RequestGetUsersDefaultCardNumber() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUserId(Iterable<? extends Integer> iterable) {
        ensureUserIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userId_);
    }

    private void addUserId(int i) {
        ensureUserIdIsMutable();
        this.userId_.b1(i);
    }

    private void clearUserId() {
        this.userId_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureUserIdIsMutable() {
        B.g gVar = this.userId_;
        if (gVar.u()) {
            return;
        }
        this.userId_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i, int i2) {
        ensureUserIdIsMutable();
        this.userId_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestGetUsersDefaultCardNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestGetUsersDefaultCardNumber.class) {
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

    public int getUserId(int i) {
        return this.userId_.getInt(i);
    }

    public int getUserIdCount() {
        return this.userId_.size();
    }

    public List<Integer> getUserIdList() {
        return this.userId_;
    }

    public static a newBuilder(UsersOuterClass$RequestGetUsersDefaultCardNumber usersOuterClass$RequestGetUsersDefaultCardNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestGetUsersDefaultCardNumber);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestGetUsersDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
