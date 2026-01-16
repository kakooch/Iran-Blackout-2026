package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$WelcomeMessageConfig extends GeneratedMessageLite implements U64 {
    private static final SmartSupportStruct$WelcomeMessageConfig DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private boolean enabled_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportStruct$WelcomeMessageConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig = new SmartSupportStruct$WelcomeMessageConfig();
        DEFAULT_INSTANCE = smartSupportStruct$WelcomeMessageConfig;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$WelcomeMessageConfig.class, smartSupportStruct$WelcomeMessageConfig);
    }

    private SmartSupportStruct$WelcomeMessageConfig() {
    }

    private void clearEnabled() {
        this.enabled_ = false;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static SmartSupportStruct$WelcomeMessageConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$WelcomeMessageConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"enabled_", "text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$WelcomeMessageConfig.class) {
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

    public boolean getEnabled() {
        return this.enabled_;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$WelcomeMessageConfig);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(byte[] bArr) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$WelcomeMessageConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$WelcomeMessageConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
