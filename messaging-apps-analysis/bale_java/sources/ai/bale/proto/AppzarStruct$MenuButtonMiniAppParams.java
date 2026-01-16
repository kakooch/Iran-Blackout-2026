package ai.bale.proto;

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
public final class AppzarStruct$MenuButtonMiniAppParams extends GeneratedMessageLite implements U64 {
    private static final AppzarStruct$MenuButtonMiniAppParams DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue url_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((AppzarStruct$MenuButtonMiniAppParams) this.b).setUrl(stringValue);
            return this;
        }

        private a() {
            super(AppzarStruct$MenuButtonMiniAppParams.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarStruct$MenuButtonMiniAppParams appzarStruct$MenuButtonMiniAppParams = new AppzarStruct$MenuButtonMiniAppParams();
        DEFAULT_INSTANCE = appzarStruct$MenuButtonMiniAppParams;
        GeneratedMessageLite.registerDefaultInstance(AppzarStruct$MenuButtonMiniAppParams.class, appzarStruct$MenuButtonMiniAppParams);
    }

    private AppzarStruct$MenuButtonMiniAppParams() {
    }

    private void clearUrl() {
        this.url_ = null;
        this.bitField0_ &= -2;
    }

    public static AppzarStruct$MenuButtonMiniAppParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.url_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.url_ = stringValue;
        } else {
            this.url_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.url_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseDelimitedFrom(InputStream inputStream) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(ByteBuffer byteBuffer) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(StringValue stringValue) {
        stringValue.getClass();
        this.url_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1858h.a[gVar.ordinal()]) {
            case 1:
                return new AppzarStruct$MenuButtonMiniAppParams();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarStruct$MenuButtonMiniAppParams.class) {
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

    public StringValue getUrl() {
        StringValue stringValue = this.url_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AppzarStruct$MenuButtonMiniAppParams appzarStruct$MenuButtonMiniAppParams) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarStruct$MenuButtonMiniAppParams);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(byte[] bArr) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(InputStream inputStream) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarStruct$MenuButtonMiniAppParams parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarStruct$MenuButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
