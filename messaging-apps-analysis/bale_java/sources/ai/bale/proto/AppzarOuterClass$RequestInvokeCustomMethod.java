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
public final class AppzarOuterClass$RequestInvokeCustomMethod extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final AppzarOuterClass$RequestInvokeCustomMethod DEFAULT_INSTANCE;
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int botUserId_;
    private String method_ = "";
    private String params_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((AppzarOuterClass$RequestInvokeCustomMethod) this.b).setBotUserId(i);
            return this;
        }

        public a B(String str) {
            q();
            ((AppzarOuterClass$RequestInvokeCustomMethod) this.b).setMethod(str);
            return this;
        }

        public a C(String str) {
            q();
            ((AppzarOuterClass$RequestInvokeCustomMethod) this.b).setParams(str);
            return this;
        }

        private a() {
            super(AppzarOuterClass$RequestInvokeCustomMethod.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarOuterClass$RequestInvokeCustomMethod appzarOuterClass$RequestInvokeCustomMethod = new AppzarOuterClass$RequestInvokeCustomMethod();
        DEFAULT_INSTANCE = appzarOuterClass$RequestInvokeCustomMethod;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$RequestInvokeCustomMethod.class, appzarOuterClass$RequestInvokeCustomMethod);
    }

    private AppzarOuterClass$RequestInvokeCustomMethod() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearMethod() {
        this.method_ = getDefaultInstance().getMethod();
    }

    private void clearParams() {
        this.params_ = getDefaultInstance().getParams();
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethod(String str) {
        str.getClass();
        this.method_ = str;
    }

    private void setMethodBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.method_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(String str) {
        str.getClass();
        this.params_ = str;
    }

    private void setParamsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.params_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$RequestInvokeCustomMethod();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ", new Object[]{"botUserId_", "method_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$RequestInvokeCustomMethod.class) {
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

    public int getBotUserId() {
        return this.botUserId_;
    }

    public String getMethod() {
        return this.method_;
    }

    public AbstractC2383g getMethodBytes() {
        return AbstractC2383g.N(this.method_);
    }

    public String getParams() {
        return this.params_;
    }

    public AbstractC2383g getParamsBytes() {
        return AbstractC2383g.N(this.params_);
    }

    public static a newBuilder(AppzarOuterClass$RequestInvokeCustomMethod appzarOuterClass$RequestInvokeCustomMethod) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$RequestInvokeCustomMethod);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(byte[] bArr) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$RequestInvokeCustomMethod parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$RequestInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
