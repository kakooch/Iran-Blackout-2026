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
public final class MessagingStruct$DocumentExVoice extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$DocumentExVoice DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TRANSCRIPT_FIELD_NUMBER = 2;
    private int bitField0_;
    private int duration_;
    private StringValue transcript_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MessagingStruct$DocumentExVoice) this.b).setDuration(i);
            return this;
        }

        private a() {
            super(MessagingStruct$DocumentExVoice.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DocumentExVoice messagingStruct$DocumentExVoice = new MessagingStruct$DocumentExVoice();
        DEFAULT_INSTANCE = messagingStruct$DocumentExVoice;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DocumentExVoice.class, messagingStruct$DocumentExVoice);
    }

    private MessagingStruct$DocumentExVoice() {
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearTranscript() {
        this.transcript_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$DocumentExVoice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTranscript(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.transcript_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.transcript_ = stringValue;
        } else {
            this.transcript_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.transcript_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DocumentExVoice parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(int i) {
        this.duration_ = i;
    }

    private void setTranscript(StringValue stringValue) {
        stringValue.getClass();
        this.transcript_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DocumentExVoice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "duration_", "transcript_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DocumentExVoice.class) {
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

    public int getDuration() {
        return this.duration_;
    }

    public StringValue getTranscript() {
        StringValue stringValue = this.transcript_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasTranscript() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$DocumentExVoice messagingStruct$DocumentExVoice) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DocumentExVoice);
    }

    public static MessagingStruct$DocumentExVoice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(byte[] bArr) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DocumentExVoice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DocumentExVoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
