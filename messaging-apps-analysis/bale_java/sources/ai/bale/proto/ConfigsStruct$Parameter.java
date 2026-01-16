package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8234Vc1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ConfigsStruct$Parameter extends GeneratedMessageLite implements InterfaceC8234Vc1 {
    private static final ConfigsStruct$Parameter DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String key_ = "";
    private String value_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8234Vc1 {
        private a() {
            super(ConfigsStruct$Parameter.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsStruct$Parameter configsStruct$Parameter = new ConfigsStruct$Parameter();
        DEFAULT_INSTANCE = configsStruct$Parameter;
        GeneratedMessageLite.registerDefaultInstance(ConfigsStruct$Parameter.class, configsStruct$Parameter);
    }

    private ConfigsStruct$Parameter() {
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static ConfigsStruct$Parameter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsStruct$Parameter parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$Parameter parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    private void setKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.key_ = abstractC2383g.f0();
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
        switch (G.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsStruct$Parameter();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsStruct$Parameter.class) {
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

    public String getKey() {
        return this.key_;
    }

    public AbstractC2383g getKeyBytes() {
        return AbstractC2383g.N(this.key_);
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public static a newBuilder(ConfigsStruct$Parameter configsStruct$Parameter) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsStruct$Parameter);
    }

    public static ConfigsStruct$Parameter parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$Parameter parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsStruct$Parameter parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsStruct$Parameter parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsStruct$Parameter parseFrom(byte[] bArr) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsStruct$Parameter parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsStruct$Parameter parseFrom(InputStream inputStream) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$Parameter parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$Parameter parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsStruct$Parameter parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsStruct$Parameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
