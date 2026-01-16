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
public final class ConfigsOuterClass$RequestEditParameter extends GeneratedMessageLite implements U64 {
    private static final ConfigsOuterClass$RequestEditParameter DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String key_ = "";
    private StringValue value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((ConfigsOuterClass$RequestEditParameter) this.b).setKey(str);
            return this;
        }

        public a B(StringValue.b bVar) {
            q();
            ((ConfigsOuterClass$RequestEditParameter) this.b).setValue((StringValue) bVar.a());
            return this;
        }

        private a() {
            super(ConfigsOuterClass$RequestEditParameter.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsOuterClass$RequestEditParameter configsOuterClass$RequestEditParameter = new ConfigsOuterClass$RequestEditParameter();
        DEFAULT_INSTANCE = configsOuterClass$RequestEditParameter;
        GeneratedMessageLite.registerDefaultInstance(ConfigsOuterClass$RequestEditParameter.class, configsOuterClass$RequestEditParameter);
    }

    private ConfigsOuterClass$RequestEditParameter() {
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static ConfigsOuterClass$RequestEditParameter getDefaultInstance() {
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

    public static ConfigsOuterClass$RequestEditParameter parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    private void setKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.key_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(StringValue stringValue) {
        stringValue.getClass();
        this.value_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsOuterClass$RequestEditParameter();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsOuterClass$RequestEditParameter.class) {
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

    public static a newBuilder(ConfigsOuterClass$RequestEditParameter configsOuterClass$RequestEditParameter) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsOuterClass$RequestEditParameter);
    }

    public static ConfigsOuterClass$RequestEditParameter parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(byte[] bArr) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(InputStream inputStream) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsOuterClass$RequestEditParameter parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsOuterClass$RequestEditParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
