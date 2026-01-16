package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9711aR;
import ir.nasim.KW4;
import ir.nasim.WQ;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthStruct$ExInfoAddress extends GeneratedMessageLite implements InterfaceC9711aR {
    private static final AuthStruct$ExInfoAddress DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int key_;
    private String value_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9711aR {
        private a() {
            super(AuthStruct$ExInfoAddress.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthStruct$ExInfoAddress authStruct$ExInfoAddress = new AuthStruct$ExInfoAddress();
        DEFAULT_INSTANCE = authStruct$ExInfoAddress;
        GeneratedMessageLite.registerDefaultInstance(AuthStruct$ExInfoAddress.class, authStruct$ExInfoAddress);
    }

    private AuthStruct$ExInfoAddress() {
    }

    private void clearKey() {
        this.key_ = 0;
    }

    private void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static AuthStruct$ExInfoAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthStruct$ExInfoAddress parseDelimitedFrom(InputStream inputStream) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthStruct$ExInfoAddress parseFrom(ByteBuffer byteBuffer) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(WQ wq) {
        this.key_ = wq.getNumber();
    }

    private void setKeyValue(int i) {
        this.key_ = i;
    }

    private void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    private void setValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1870l.a[gVar.ordinal()]) {
            case 1:
                return new AuthStruct$ExInfoAddress();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthStruct$ExInfoAddress.class) {
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

    public WQ getKey() {
        WQ wqJ = WQ.j(this.key_);
        return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
    }

    public int getKeyValue() {
        return this.key_;
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public static a newBuilder(AuthStruct$ExInfoAddress authStruct$ExInfoAddress) {
        return (a) DEFAULT_INSTANCE.createBuilder(authStruct$ExInfoAddress);
    }

    public static AuthStruct$ExInfoAddress parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthStruct$ExInfoAddress parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthStruct$ExInfoAddress parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthStruct$ExInfoAddress parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthStruct$ExInfoAddress parseFrom(byte[] bArr) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthStruct$ExInfoAddress parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthStruct$ExInfoAddress parseFrom(InputStream inputStream) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthStruct$ExInfoAddress parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthStruct$ExInfoAddress parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthStruct$ExInfoAddress parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthStruct$ExInfoAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
