package ai.bale.proto;

import ai.bale.proto.RemoteConfigStruct$JSON;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RemoteConfigStruct$RemoteConfig extends GeneratedMessageLite implements InterfaceC1907x1 {
    public static final int BOOL_FIELD_NUMBER = 3;
    private static final RemoteConfigStruct$RemoteConfig DEFAULT_INSTANCE;
    public static final int INT64_FIELD_NUMBER = 4;
    public static final int JSON_FIELD_NUMBER = 5;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 2;
    private Object value_;
    private int valueCase_ = 0;
    private String key_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1907x1 {
        private a() {
            super(RemoteConfigStruct$RemoteConfig.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        STRING(2),
        BOOL(3),
        INT64(4),
        JSON(5),
        VALUE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VALUE_NOT_SET;
            }
            if (i == 2) {
                return STRING;
            }
            if (i == 3) {
                return BOOL;
            }
            if (i == 4) {
                return INT64;
            }
            if (i != 5) {
                return null;
            }
            return JSON;
        }
    }

    static {
        RemoteConfigStruct$RemoteConfig remoteConfigStruct$RemoteConfig = new RemoteConfigStruct$RemoteConfig();
        DEFAULT_INSTANCE = remoteConfigStruct$RemoteConfig;
        GeneratedMessageLite.registerDefaultInstance(RemoteConfigStruct$RemoteConfig.class, remoteConfigStruct$RemoteConfig);
    }

    private RemoteConfigStruct$RemoteConfig() {
    }

    private void clearBool() {
        if (this.valueCase_ == 3) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearInt64() {
        if (this.valueCase_ == 4) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearJson() {
        if (this.valueCase_ == 5) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearString() {
        if (this.valueCase_ == 2) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    private void clearValue() {
        this.valueCase_ = 0;
        this.value_ = null;
    }

    public static RemoteConfigStruct$RemoteConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeJson(RemoteConfigStruct$JSON remoteConfigStruct$JSON) {
        remoteConfigStruct$JSON.getClass();
        if (this.valueCase_ != 5 || this.value_ == RemoteConfigStruct$JSON.getDefaultInstance()) {
            this.value_ = remoteConfigStruct$JSON;
        } else {
            this.value_ = ((RemoteConfigStruct$JSON.a) RemoteConfigStruct$JSON.newBuilder((RemoteConfigStruct$JSON) this.value_).v(remoteConfigStruct$JSON)).j();
        }
        this.valueCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RemoteConfigStruct$RemoteConfig parseDelimitedFrom(InputStream inputStream) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(ByteBuffer byteBuffer) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBool(boolean z) {
        this.valueCase_ = 3;
        this.value_ = Boolean.valueOf(z);
    }

    private void setInt64(long j) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j);
    }

    private void setJson(RemoteConfigStruct$JSON remoteConfigStruct$JSON) {
        remoteConfigStruct$JSON.getClass();
        this.value_ = remoteConfigStruct$JSON;
        this.valueCase_ = 5;
    }

    private void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    private void setKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.key_ = abstractC2383g.f0();
    }

    private void setString(String str) {
        str.getClass();
        this.valueCase_ = 2;
        this.value_ = str;
    }

    private void setStringBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
        this.valueCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1904w1.a[gVar.ordinal()]) {
            case 1:
                return new RemoteConfigStruct$RemoteConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003:\u0000\u00045\u0000\u0005<\u0000", new Object[]{"value_", "valueCase_", "key_", RemoteConfigStruct$JSON.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RemoteConfigStruct$RemoteConfig.class) {
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

    public boolean getBool() {
        if (this.valueCase_ == 3) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public long getInt64() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public RemoteConfigStruct$JSON getJson() {
        return this.valueCase_ == 5 ? (RemoteConfigStruct$JSON) this.value_ : RemoteConfigStruct$JSON.getDefaultInstance();
    }

    public String getKey() {
        return this.key_;
    }

    public AbstractC2383g getKeyBytes() {
        return AbstractC2383g.N(this.key_);
    }

    public String getString() {
        return this.valueCase_ == 2 ? (String) this.value_ : "";
    }

    public AbstractC2383g getStringBytes() {
        return AbstractC2383g.N(this.valueCase_ == 2 ? (String) this.value_ : "");
    }

    public b getValueCase() {
        return b.j(this.valueCase_);
    }

    public boolean hasBool() {
        return this.valueCase_ == 3;
    }

    public boolean hasInt64() {
        return this.valueCase_ == 4;
    }

    public boolean hasJson() {
        return this.valueCase_ == 5;
    }

    public boolean hasString() {
        return this.valueCase_ == 2;
    }

    public static a newBuilder(RemoteConfigStruct$RemoteConfig remoteConfigStruct$RemoteConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(remoteConfigStruct$RemoteConfig);
    }

    public static RemoteConfigStruct$RemoteConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(byte[] bArr) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(InputStream inputStream) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RemoteConfigStruct$RemoteConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RemoteConfigStruct$RemoteConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
