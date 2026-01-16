package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestEditNickName extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestEditNickName DEFAULT_INSTANCE;
    public static final int NICKNAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue nickname_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((UsersOuterClass$RequestEditNickName) this.b).setNickname(stringValue);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestEditNickName.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditNickName usersOuterClass$RequestEditNickName = new UsersOuterClass$RequestEditNickName();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditNickName;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditNickName.class, usersOuterClass$RequestEditNickName);
    }

    private UsersOuterClass$RequestEditNickName() {
    }

    private void clearNickname() {
        this.nickname_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$RequestEditNickName getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNickname(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nickname_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nickname_ = stringValue;
        } else {
            this.nickname_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nickname_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditNickName parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNickname(StringValue stringValue) {
        stringValue.getClass();
        this.nickname_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditNickName();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "nickname_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditNickName.class) {
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

    public StringValue getNickname() {
        StringValue stringValue = this.nickname_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasNickname() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$RequestEditNickName usersOuterClass$RequestEditNickName) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditNickName);
    }

    public static UsersOuterClass$RequestEditNickName parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditNickName parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditNickName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
