package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16415lE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$SettingsParam extends GeneratedMessageLite implements InterfaceC16415lE3 {
    private static final LivekitCloudAgent$SettingsParam DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String name_ = "";
    private String value_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16415lE3 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$SettingsParam.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$SettingsParam livekitCloudAgent$SettingsParam = new LivekitCloudAgent$SettingsParam();
        DEFAULT_INSTANCE = livekitCloudAgent$SettingsParam;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$SettingsParam.class, livekitCloudAgent$SettingsParam);
    }

    private LivekitCloudAgent$SettingsParam() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static LivekitCloudAgent$SettingsParam getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$SettingsParam parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$SettingsParam();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$SettingsParam.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public static a newBuilder(LivekitCloudAgent$SettingsParam livekitCloudAgent$SettingsParam) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$SettingsParam);
    }

    public static LivekitCloudAgent$SettingsParam parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$SettingsParam parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$SettingsParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
