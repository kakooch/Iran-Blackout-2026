package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.CG;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarOuterClass$ResponseGetMiniAppUrl extends GeneratedMessageLite implements U64 {
    private static final AppzarOuterClass$ResponseGetMiniAppUrl DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_ID_FIELD_NUMBER = 3;
    public static final int SCREEN_MODE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue queryId_;
    private int screenMode_;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AppzarOuterClass$ResponseGetMiniAppUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarOuterClass$ResponseGetMiniAppUrl appzarOuterClass$ResponseGetMiniAppUrl = new AppzarOuterClass$ResponseGetMiniAppUrl();
        DEFAULT_INSTANCE = appzarOuterClass$ResponseGetMiniAppUrl;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$ResponseGetMiniAppUrl.class, appzarOuterClass$ResponseGetMiniAppUrl);
    }

    private AppzarOuterClass$ResponseGetMiniAppUrl() {
    }

    private void clearQueryId() {
        this.queryId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearScreenMode() {
        this.screenMode_ = 0;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeQueryId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.queryId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.queryId_ = stringValue;
        } else {
            this.queryId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.queryId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setQueryId(StringValue stringValue) {
        stringValue.getClass();
        this.queryId_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setScreenMode(CG cg) {
        this.screenMode_ = cg.getNumber();
    }

    private void setScreenModeValue(int i) {
        this.screenMode_ = i;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$ResponseGetMiniAppUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "url_", "screenMode_", "queryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$ResponseGetMiniAppUrl.class) {
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

    public StringValue getQueryId() {
        StringValue stringValue = this.queryId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public CG getScreenMode() {
        CG cgJ = CG.j(this.screenMode_);
        return cgJ == null ? CG.UNRECOGNIZED : cgJ;
    }

    public int getScreenModeValue() {
        return this.screenMode_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasQueryId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AppzarOuterClass$ResponseGetMiniAppUrl appzarOuterClass$ResponseGetMiniAppUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$ResponseGetMiniAppUrl);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(byte[] bArr) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$ResponseGetMiniAppUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
