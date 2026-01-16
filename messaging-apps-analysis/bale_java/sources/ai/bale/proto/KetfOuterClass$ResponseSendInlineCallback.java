package ai.bale.proto;

import ai.bale.proto.KetfStruct$InlineCallbackAnswer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseSendInlineCallback extends GeneratedMessageLite implements U64 {
    public static final int ANSWER_FIELD_NUMBER = 1;
    private static final KetfOuterClass$ResponseSendInlineCallback DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private KetfStruct$InlineCallbackAnswer answer_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseSendInlineCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseSendInlineCallback ketfOuterClass$ResponseSendInlineCallback = new KetfOuterClass$ResponseSendInlineCallback();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseSendInlineCallback;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseSendInlineCallback.class, ketfOuterClass$ResponseSendInlineCallback);
    }

    private KetfOuterClass$ResponseSendInlineCallback() {
    }

    private void clearAnswer() {
        this.answer_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$ResponseSendInlineCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAnswer(KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer) {
        ketfStruct$InlineCallbackAnswer.getClass();
        KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer2 = this.answer_;
        if (ketfStruct$InlineCallbackAnswer2 == null || ketfStruct$InlineCallbackAnswer2 == KetfStruct$InlineCallbackAnswer.getDefaultInstance()) {
            this.answer_ = ketfStruct$InlineCallbackAnswer;
        } else {
            this.answer_ = (KetfStruct$InlineCallbackAnswer) ((KetfStruct$InlineCallbackAnswer.a) KetfStruct$InlineCallbackAnswer.newBuilder(this.answer_).v(ketfStruct$InlineCallbackAnswer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAnswer(KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer) {
        ketfStruct$InlineCallbackAnswer.getClass();
        this.answer_ = ketfStruct$InlineCallbackAnswer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseSendInlineCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "answer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseSendInlineCallback.class) {
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

    public KetfStruct$InlineCallbackAnswer getAnswer() {
        KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer = this.answer_;
        return ketfStruct$InlineCallbackAnswer == null ? KetfStruct$InlineCallbackAnswer.getDefaultInstance() : ketfStruct$InlineCallbackAnswer;
    }

    public boolean hasAnswer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$ResponseSendInlineCallback ketfOuterClass$ResponseSendInlineCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseSendInlineCallback);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseSendInlineCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
