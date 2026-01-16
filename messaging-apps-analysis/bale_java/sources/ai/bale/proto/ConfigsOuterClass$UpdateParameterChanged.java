package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ConfigsOuterClass$UpdateParameterChanged extends GeneratedMessageLite implements U64 {
    private static final ConfigsOuterClass$UpdateParameterChanged DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String key_ = "";
    private StringValue value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ConfigsOuterClass$UpdateParameterChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsOuterClass$UpdateParameterChanged configsOuterClass$UpdateParameterChanged = new ConfigsOuterClass$UpdateParameterChanged();
        DEFAULT_INSTANCE = configsOuterClass$UpdateParameterChanged;
        GeneratedMessageLite.registerDefaultInstance(ConfigsOuterClass$UpdateParameterChanged.class, configsOuterClass$UpdateParameterChanged);
    }

    private ConfigsOuterClass$UpdateParameterChanged() {
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static ConfigsOuterClass$UpdateParameterChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeValue(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.value_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.value_ = stringValue;
        } else {
            this.value_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.value_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setValue(StringValue stringValue) {
        stringValue.getClass();
        this.value_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsOuterClass$UpdateParameterChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsOuterClass$UpdateParameterChanged.class) {
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

    public StringValue getValue() {
        StringValue stringValue = this.value_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ConfigsOuterClass$UpdateParameterChanged configsOuterClass$UpdateParameterChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsOuterClass$UpdateParameterChanged);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(byte[] bArr) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(InputStream inputStream) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsOuterClass$UpdateParameterChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateParameterChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
