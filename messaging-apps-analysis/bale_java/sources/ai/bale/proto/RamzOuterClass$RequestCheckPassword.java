package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC14053hG5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RamzOuterClass$RequestCheckPassword extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$RequestCheckPassword DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 1;
    public static final int SERVICES_TYPE_FIELD_NUMBER = 2;
    private String password_ = "";
    private int servicesType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((RamzOuterClass$RequestCheckPassword) this.b).setPassword(str);
            return this;
        }

        public a B(EnumC14053hG5 enumC14053hG5) {
            q();
            ((RamzOuterClass$RequestCheckPassword) this.b).setServicesType(enumC14053hG5);
            return this;
        }

        private a() {
            super(RamzOuterClass$RequestCheckPassword.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$RequestCheckPassword ramzOuterClass$RequestCheckPassword = new RamzOuterClass$RequestCheckPassword();
        DEFAULT_INSTANCE = ramzOuterClass$RequestCheckPassword;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$RequestCheckPassword.class, ramzOuterClass$RequestCheckPassword);
    }

    private RamzOuterClass$RequestCheckPassword() {
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    private void clearServicesType() {
        this.servicesType_ = 0;
    }

    public static RamzOuterClass$RequestCheckPassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$RequestCheckPassword parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setServicesType(EnumC14053hG5 enumC14053hG5) {
        this.servicesType_ = enumC14053hG5.getNumber();
    }

    private void setServicesTypeValue(int i) {
        this.servicesType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$RequestCheckPassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"password_", "servicesType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$RequestCheckPassword.class) {
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

    public EnumC14053hG5 getServicesType() {
        EnumC14053hG5 enumC14053hG5J = EnumC14053hG5.j(this.servicesType_);
        return enumC14053hG5J == null ? EnumC14053hG5.UNRECOGNIZED : enumC14053hG5J;
    }

    public int getServicesTypeValue() {
        return this.servicesType_;
    }

    public static a newBuilder(RamzOuterClass$RequestCheckPassword ramzOuterClass$RequestCheckPassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$RequestCheckPassword);
    }

    public static RamzOuterClass$RequestCheckPassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(byte[] bArr) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$RequestCheckPassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$RequestCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
