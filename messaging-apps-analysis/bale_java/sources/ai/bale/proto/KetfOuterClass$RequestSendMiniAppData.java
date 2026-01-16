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
public final class KetfOuterClass$RequestSendMiniAppData extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    public static final int BUTTON_TEXT_FIELD_NUMBER = 4;
    public static final int DATA_FIELD_NUMBER = 3;
    private static final KetfOuterClass$RequestSendMiniAppData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private int botUserId_;
    private StringValue buttonText_;
    private StringValue data_;
    private StringValue queryId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((KetfOuterClass$RequestSendMiniAppData) this.b).setBotUserId(i);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((KetfOuterClass$RequestSendMiniAppData) this.b).setData(stringValue);
            return this;
        }

        public a C(StringValue stringValue) {
            q();
            ((KetfOuterClass$RequestSendMiniAppData) this.b).setQueryId(stringValue);
            return this;
        }

        private a() {
            super(KetfOuterClass$RequestSendMiniAppData.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestSendMiniAppData ketfOuterClass$RequestSendMiniAppData = new KetfOuterClass$RequestSendMiniAppData();
        DEFAULT_INSTANCE = ketfOuterClass$RequestSendMiniAppData;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestSendMiniAppData.class, ketfOuterClass$RequestSendMiniAppData);
    }

    private KetfOuterClass$RequestSendMiniAppData() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearButtonText() {
        this.buttonText_ = null;
        this.bitField0_ &= -5;
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -3;
    }

    private void clearQueryId() {
        this.queryId_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$RequestSendMiniAppData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeButtonText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.buttonText_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.buttonText_ = stringValue;
        } else {
            this.buttonText_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.buttonText_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeData(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.data_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.data_ = stringValue;
        } else {
            this.data_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.data_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
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

    public static KetfOuterClass$RequestSendMiniAppData parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    private void setButtonText(StringValue stringValue) {
        stringValue.getClass();
        this.buttonText_ = stringValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(StringValue stringValue) {
        stringValue.getClass();
        this.data_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueryId(StringValue stringValue) {
        stringValue.getClass();
        this.queryId_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestSendMiniAppData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "botUserId_", "queryId_", "data_", "buttonText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestSendMiniAppData.class) {
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

    public StringValue getButtonText() {
        StringValue stringValue = this.buttonText_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getData() {
        StringValue stringValue = this.data_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getQueryId() {
        StringValue stringValue = this.queryId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasButtonText() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasData() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasQueryId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestSendMiniAppData ketfOuterClass$RequestSendMiniAppData) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestSendMiniAppData);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestSendMiniAppData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestSendMiniAppData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
