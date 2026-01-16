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
public final class AppzarStruct$KeyboardButtonMiniAppParams extends GeneratedMessageLite implements U64 {
    private static final AppzarStruct$KeyboardButtonMiniAppParams DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AppzarStruct$KeyboardButtonMiniAppParams) this.b).setUrl(str);
            return this;
        }

        private a() {
            super(AppzarStruct$KeyboardButtonMiniAppParams.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarStruct$KeyboardButtonMiniAppParams appzarStruct$KeyboardButtonMiniAppParams = new AppzarStruct$KeyboardButtonMiniAppParams();
        DEFAULT_INSTANCE = appzarStruct$KeyboardButtonMiniAppParams;
        GeneratedMessageLite.registerDefaultInstance(AppzarStruct$KeyboardButtonMiniAppParams.class, appzarStruct$KeyboardButtonMiniAppParams);
    }

    private AppzarStruct$KeyboardButtonMiniAppParams() {
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseDelimitedFrom(InputStream inputStream) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(ByteBuffer byteBuffer) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1858h.a[gVar.ordinal()]) {
            case 1:
                return new AppzarStruct$KeyboardButtonMiniAppParams();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarStruct$KeyboardButtonMiniAppParams.class) {
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

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(AppzarStruct$KeyboardButtonMiniAppParams appzarStruct$KeyboardButtonMiniAppParams) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarStruct$KeyboardButtonMiniAppParams);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(byte[] bArr) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(InputStream inputStream) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarStruct$KeyboardButtonMiniAppParams parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarStruct$KeyboardButtonMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
