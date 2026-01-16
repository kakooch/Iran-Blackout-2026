package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC8123Up7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheOuterClass$RequestSubmitReview extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    public static final int COMMENT_FIELD_NUMBER = 3;
    private static final TimcheOuterClass$RequestSubmitReview DEFAULT_INSTANCE;
    public static final int ORIGIN_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 4;
    public static final int RATING_FIELD_NUMBER = 2;
    private int bitField0_;
    private int botId_;
    private StringValue comment_;
    private int origin_;
    private StringValue payload_;
    private Int32Value rating_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((TimcheOuterClass$RequestSubmitReview) this.b).setBotId(i);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((TimcheOuterClass$RequestSubmitReview) this.b).setComment(stringValue);
            return this;
        }

        public a C(Int32Value int32Value) {
            q();
            ((TimcheOuterClass$RequestSubmitReview) this.b).setRating(int32Value);
            return this;
        }

        private a() {
            super(TimcheOuterClass$RequestSubmitReview.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$RequestSubmitReview timcheOuterClass$RequestSubmitReview = new TimcheOuterClass$RequestSubmitReview();
        DEFAULT_INSTANCE = timcheOuterClass$RequestSubmitReview;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$RequestSubmitReview.class, timcheOuterClass$RequestSubmitReview);
    }

    private TimcheOuterClass$RequestSubmitReview() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearComment() {
        this.comment_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOrigin() {
        this.origin_ = 0;
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -5;
    }

    private void clearRating() {
        this.rating_ = null;
        this.bitField0_ &= -2;
    }

    public static TimcheOuterClass$RequestSubmitReview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeComment(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.comment_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.comment_ = stringValue;
        } else {
            this.comment_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.comment_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePayload(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.payload_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.payload_ = stringValue;
        } else {
            this.payload_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.payload_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeRating(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.rating_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.rating_ = int32Value;
        } else {
            this.rating_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.rating_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$RequestSubmitReview parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotId(int i) {
        this.botId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComment(StringValue stringValue) {
        stringValue.getClass();
        this.comment_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setOrigin(EnumC8123Up7 enumC8123Up7) {
        this.origin_ = enumC8123Up7.getNumber();
    }

    private void setOriginValue(int i) {
        this.origin_ = i;
    }

    private void setPayload(StringValue stringValue) {
        stringValue.getClass();
        this.payload_ = stringValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRating(Int32Value int32Value) {
        int32Value.getClass();
        this.rating_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$RequestSubmitReview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\f", new Object[]{"bitField0_", "botId_", "rating_", "comment_", "payload_", "origin_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$RequestSubmitReview.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public StringValue getComment() {
        StringValue stringValue = this.comment_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC8123Up7 getOrigin() {
        EnumC8123Up7 enumC8123Up7J = EnumC8123Up7.j(this.origin_);
        return enumC8123Up7J == null ? EnumC8123Up7.UNRECOGNIZED : enumC8123Up7J;
    }

    public int getOriginValue() {
        return this.origin_;
    }

    public StringValue getPayload() {
        StringValue stringValue = this.payload_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public Int32Value getRating() {
        Int32Value int32Value = this.rating_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasComment() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRating() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TimcheOuterClass$RequestSubmitReview timcheOuterClass$RequestSubmitReview) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$RequestSubmitReview);
    }

    public static TimcheOuterClass$RequestSubmitReview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(byte[] bArr) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$RequestSubmitReview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$RequestSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
