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

/* loaded from: classes.dex */
public final class TuringStruct$CustomOpenUrlAction extends GeneratedMessageLite implements U64 {
    public static final int BUTTON_TITLE_FIELD_NUMBER = 2;
    private static final TuringStruct$CustomOpenUrlAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHOULD_SEARCH_INTERNAL_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 1;
    private boolean shouldSearchInternal_;
    private String url_ = "";
    private String buttonTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TuringStruct$CustomOpenUrlAction.DEFAULT_INSTANCE);
        }
    }

    static {
        TuringStruct$CustomOpenUrlAction turingStruct$CustomOpenUrlAction = new TuringStruct$CustomOpenUrlAction();
        DEFAULT_INSTANCE = turingStruct$CustomOpenUrlAction;
        GeneratedMessageLite.registerDefaultInstance(TuringStruct$CustomOpenUrlAction.class, turingStruct$CustomOpenUrlAction);
    }

    private TuringStruct$CustomOpenUrlAction() {
    }

    private void clearButtonTitle() {
        this.buttonTitle_ = getDefaultInstance().getButtonTitle();
    }

    private void clearShouldSearchInternal() {
        this.shouldSearchInternal_ = false;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static TuringStruct$CustomOpenUrlAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TuringStruct$CustomOpenUrlAction parseDelimitedFrom(InputStream inputStream) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(ByteBuffer byteBuffer) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setButtonTitle(String str) {
        str.getClass();
        this.buttonTitle_ = str;
    }

    private void setButtonTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.buttonTitle_ = abstractC2383g.f0();
    }

    private void setShouldSearchInternal(boolean z) {
        this.shouldSearchInternal_ = z;
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
        switch (n2.a[gVar.ordinal()]) {
            case 1:
                return new TuringStruct$CustomOpenUrlAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"url_", "buttonTitle_", "shouldSearchInternal_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TuringStruct$CustomOpenUrlAction.class) {
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

    public String getButtonTitle() {
        return this.buttonTitle_;
    }

    public AbstractC2383g getButtonTitleBytes() {
        return AbstractC2383g.N(this.buttonTitle_);
    }

    public boolean getShouldSearchInternal() {
        return this.shouldSearchInternal_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(TuringStruct$CustomOpenUrlAction turingStruct$CustomOpenUrlAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(turingStruct$CustomOpenUrlAction);
    }

    public static TuringStruct$CustomOpenUrlAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(AbstractC2383g abstractC2383g) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(byte[] bArr) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(InputStream inputStream) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(AbstractC2384h abstractC2384h) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TuringStruct$CustomOpenUrlAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TuringStruct$CustomOpenUrlAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
