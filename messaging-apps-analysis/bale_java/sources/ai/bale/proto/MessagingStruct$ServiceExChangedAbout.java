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
public final class MessagingStruct$ServiceExChangedAbout extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 1;
    private static final MessagingStruct$ServiceExChangedAbout DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private StringValue about_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExChangedAbout.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExChangedAbout messagingStruct$ServiceExChangedAbout = new MessagingStruct$ServiceExChangedAbout();
        DEFAULT_INSTANCE = messagingStruct$ServiceExChangedAbout;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExChangedAbout.class, messagingStruct$ServiceExChangedAbout);
    }

    private MessagingStruct$ServiceExChangedAbout() {
    }

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ServiceExChangedAbout getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.about_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.about_ = stringValue;
        } else {
            this.about_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.about_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExChangedAbout parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExChangedAbout();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "about_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExChangedAbout.class) {
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

    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAbout() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceExChangedAbout messagingStruct$ServiceExChangedAbout) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExChangedAbout);
    }

    public static MessagingStruct$ServiceExChangedAbout parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExChangedAbout parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
