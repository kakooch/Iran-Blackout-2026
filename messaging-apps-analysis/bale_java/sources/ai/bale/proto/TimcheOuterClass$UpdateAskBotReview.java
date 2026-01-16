package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheOuterClass$UpdateAskBotReview extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final TimcheOuterClass$UpdateAskBotReview DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 4;
    public static final int PREVIOUS_COMMENT_FIELD_NUMBER = 3;
    public static final int PREVIOUS_RATING_FIELD_NUMBER = 2;
    private int bitField0_;
    private int botId_;
    private StringValue payload_;
    private StringValue previousComment_;
    private Int32Value previousRating_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$UpdateAskBotReview.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview = new TimcheOuterClass$UpdateAskBotReview();
        DEFAULT_INSTANCE = timcheOuterClass$UpdateAskBotReview;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$UpdateAskBotReview.class, timcheOuterClass$UpdateAskBotReview);
    }

    private TimcheOuterClass$UpdateAskBotReview() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPreviousComment() {
        this.previousComment_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPreviousRating() {
        this.previousRating_ = null;
        this.bitField0_ &= -2;
    }

    public static TimcheOuterClass$UpdateAskBotReview getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergePreviousComment(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.previousComment_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.previousComment_ = stringValue;
        } else {
            this.previousComment_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.previousComment_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePreviousRating(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.previousRating_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.previousRating_ = int32Value;
        } else {
            this.previousRating_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.previousRating_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$UpdateAskBotReview parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setPayload(StringValue stringValue) {
        stringValue.getClass();
        this.payload_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setPreviousComment(StringValue stringValue) {
        stringValue.getClass();
        this.previousComment_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setPreviousRating(Int32Value int32Value) {
        int32Value.getClass();
        this.previousRating_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$UpdateAskBotReview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "botId_", "previousRating_", "previousComment_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$UpdateAskBotReview.class) {
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

    public StringValue getPayload() {
        StringValue stringValue = this.payload_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getPreviousComment() {
        StringValue stringValue = this.previousComment_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public Int32Value getPreviousRating() {
        Int32Value int32Value = this.previousRating_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPreviousComment() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPreviousRating() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$UpdateAskBotReview);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(byte[] bArr) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$UpdateAskBotReview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$UpdateAskBotReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
