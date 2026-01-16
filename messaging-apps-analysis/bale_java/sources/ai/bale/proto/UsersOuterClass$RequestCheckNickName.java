package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestCheckNickName extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestCheckNickName DEFAULT_INSTANCE;
    public static final int NICKNAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String nickname_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((UsersOuterClass$RequestCheckNickName) this.b).setNickname(str);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestCheckNickName.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestCheckNickName usersOuterClass$RequestCheckNickName = new UsersOuterClass$RequestCheckNickName();
        DEFAULT_INSTANCE = usersOuterClass$RequestCheckNickName;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestCheckNickName.class, usersOuterClass$RequestCheckNickName);
    }

    private UsersOuterClass$RequestCheckNickName() {
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    public static UsersOuterClass$RequestCheckNickName getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestCheckNickName parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestCheckNickName();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"nickname_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestCheckNickName.class) {
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

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public static a newBuilder(UsersOuterClass$RequestCheckNickName usersOuterClass$RequestCheckNickName) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestCheckNickName);
    }

    public static UsersOuterClass$RequestCheckNickName parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestCheckNickName parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestCheckNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
