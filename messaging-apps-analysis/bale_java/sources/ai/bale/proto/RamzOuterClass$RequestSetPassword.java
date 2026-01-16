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

/* loaded from: classes9.dex */
public final class RamzOuterClass$RequestSetPassword extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$RequestSetPassword DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 1;
    private String password_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((RamzOuterClass$RequestSetPassword) this.b).setPassword(str);
            return this;
        }

        private a() {
            super(RamzOuterClass$RequestSetPassword.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$RequestSetPassword ramzOuterClass$RequestSetPassword = new RamzOuterClass$RequestSetPassword();
        DEFAULT_INSTANCE = ramzOuterClass$RequestSetPassword;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$RequestSetPassword.class, ramzOuterClass$RequestSetPassword);
    }

    private RamzOuterClass$RequestSetPassword() {
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    public static RamzOuterClass$RequestSetPassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$RequestSetPassword parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassword(String str) {
        str.getClass();
        this.password_ = str;
    }

    private void setPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.password_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$RequestSetPassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"password_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$RequestSetPassword.class) {
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

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public static a newBuilder(RamzOuterClass$RequestSetPassword ramzOuterClass$RequestSetPassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$RequestSetPassword);
    }

    public static RamzOuterClass$RequestSetPassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(byte[] bArr) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$RequestSetPassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$RequestSetPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
