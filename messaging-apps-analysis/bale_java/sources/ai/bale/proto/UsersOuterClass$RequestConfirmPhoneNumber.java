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
public final class UsersOuterClass$RequestConfirmPhoneNumber extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final UsersOuterClass$RequestConfirmPhoneNumber DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String code_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((UsersOuterClass$RequestConfirmPhoneNumber) this.b).setCode(str);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestConfirmPhoneNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestConfirmPhoneNumber usersOuterClass$RequestConfirmPhoneNumber = new UsersOuterClass$RequestConfirmPhoneNumber();
        DEFAULT_INSTANCE = usersOuterClass$RequestConfirmPhoneNumber;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestConfirmPhoneNumber.class, usersOuterClass$RequestConfirmPhoneNumber);
    }

    private UsersOuterClass$RequestConfirmPhoneNumber() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestConfirmPhoneNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestConfirmPhoneNumber.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public static a newBuilder(UsersOuterClass$RequestConfirmPhoneNumber usersOuterClass$RequestConfirmPhoneNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestConfirmPhoneNumber);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestConfirmPhoneNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestConfirmPhoneNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
