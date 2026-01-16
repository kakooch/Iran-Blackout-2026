package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.NM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseGetUsersDefaultCardNumber extends GeneratedMessageLite implements U64 {
    public static final int DEFAULT_CARD_NO_FIELD_NUMBER = 1;
    private static final UsersOuterClass$ResponseGetUsersDefaultCardNumber DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j defaultCardNo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseGetUsersDefaultCardNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseGetUsersDefaultCardNumber usersOuterClass$ResponseGetUsersDefaultCardNumber = new UsersOuterClass$ResponseGetUsersDefaultCardNumber();
        DEFAULT_INSTANCE = usersOuterClass$ResponseGetUsersDefaultCardNumber;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseGetUsersDefaultCardNumber.class, usersOuterClass$ResponseGetUsersDefaultCardNumber);
    }

    private UsersOuterClass$ResponseGetUsersDefaultCardNumber() {
    }

    private void addAllDefaultCardNo(Iterable<? extends UsersStruct$UserCardNo> iterable) {
        ensureDefaultCardNoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.defaultCardNo_);
    }

    private void addDefaultCardNo(UsersStruct$UserCardNo usersStruct$UserCardNo) {
        usersStruct$UserCardNo.getClass();
        ensureDefaultCardNoIsMutable();
        this.defaultCardNo_.add(usersStruct$UserCardNo);
    }

    private void clearDefaultCardNo() {
        this.defaultCardNo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDefaultCardNoIsMutable() {
        B.j jVar = this.defaultCardNo_;
        if (jVar.u()) {
            return;
        }
        this.defaultCardNo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDefaultCardNo(int i) {
        ensureDefaultCardNoIsMutable();
        this.defaultCardNo_.remove(i);
    }

    private void setDefaultCardNo(int i, UsersStruct$UserCardNo usersStruct$UserCardNo) {
        usersStruct$UserCardNo.getClass();
        ensureDefaultCardNoIsMutable();
        this.defaultCardNo_.set(i, usersStruct$UserCardNo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseGetUsersDefaultCardNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"defaultCardNo_", UsersStruct$UserCardNo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseGetUsersDefaultCardNumber.class) {
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

    public UsersStruct$UserCardNo getDefaultCardNo(int i) {
        return (UsersStruct$UserCardNo) this.defaultCardNo_.get(i);
    }

    public int getDefaultCardNoCount() {
        return this.defaultCardNo_.size();
    }

    public List<UsersStruct$UserCardNo> getDefaultCardNoList() {
        return this.defaultCardNo_;
    }

    public NM7 getDefaultCardNoOrBuilder(int i) {
        return (NM7) this.defaultCardNo_.get(i);
    }

    public List<? extends NM7> getDefaultCardNoOrBuilderList() {
        return this.defaultCardNo_;
    }

    public static a newBuilder(UsersOuterClass$ResponseGetUsersDefaultCardNumber usersOuterClass$ResponseGetUsersDefaultCardNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseGetUsersDefaultCardNumber);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDefaultCardNo(int i, UsersStruct$UserCardNo usersStruct$UserCardNo) {
        usersStruct$UserCardNo.getClass();
        ensureDefaultCardNoIsMutable();
        this.defaultCardNo_.add(i, usersStruct$UserCardNo);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseGetUsersDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseGetUsersDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
