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
public final class MessagingStruct$ServiceExAnonymousContact extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExAnonymousContact DEFAULT_INSTANCE;
    public static final int DESC_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue desc_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExAnonymousContact.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExAnonymousContact messagingStruct$ServiceExAnonymousContact = new MessagingStruct$ServiceExAnonymousContact();
        DEFAULT_INSTANCE = messagingStruct$ServiceExAnonymousContact;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExAnonymousContact.class, messagingStruct$ServiceExAnonymousContact);
    }

    private MessagingStruct$ServiceExAnonymousContact() {
    }

    private void clearDesc() {
        this.desc_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ServiceExAnonymousContact getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDesc(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.desc_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.desc_ = stringValue;
        } else {
            this.desc_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.desc_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExAnonymousContact parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDesc(StringValue stringValue) {
        stringValue.getClass();
        this.desc_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExAnonymousContact();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "desc_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExAnonymousContact.class) {
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

    public StringValue getDesc() {
        StringValue stringValue = this.desc_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasDesc() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceExAnonymousContact messagingStruct$ServiceExAnonymousContact) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExAnonymousContact);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExAnonymousContact parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
