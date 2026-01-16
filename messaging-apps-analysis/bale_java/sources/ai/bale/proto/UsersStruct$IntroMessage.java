package ai.bale.proto;

import ai.bale.proto.UsersStruct$IntroMedia;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$IntroMessage extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$IntroMessage DEFAULT_INSTANCE;
    public static final int MEDIA_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bitField0_;
    private UsersStruct$IntroMedia media_;
    private StringValue text_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$IntroMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$IntroMessage usersStruct$IntroMessage = new UsersStruct$IntroMessage();
        DEFAULT_INSTANCE = usersStruct$IntroMessage;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$IntroMessage.class, usersStruct$IntroMessage);
    }

    private UsersStruct$IntroMessage() {
    }

    private void clearMedia() {
        this.media_ = null;
        this.bitField0_ &= -3;
    }

    private void clearText() {
        this.text_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersStruct$IntroMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMedia(UsersStruct$IntroMedia usersStruct$IntroMedia) {
        usersStruct$IntroMedia.getClass();
        UsersStruct$IntroMedia usersStruct$IntroMedia2 = this.media_;
        if (usersStruct$IntroMedia2 == null || usersStruct$IntroMedia2 == UsersStruct$IntroMedia.getDefaultInstance()) {
            this.media_ = usersStruct$IntroMedia;
        } else {
            this.media_ = (UsersStruct$IntroMedia) ((UsersStruct$IntroMedia.a) UsersStruct$IntroMedia.newBuilder(this.media_).v(usersStruct$IntroMedia)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.text_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.text_ = stringValue;
        } else {
            this.text_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.text_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$IntroMessage parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroMessage parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMedia(UsersStruct$IntroMedia usersStruct$IntroMedia) {
        usersStruct$IntroMedia.getClass();
        this.media_ = usersStruct$IntroMedia;
        this.bitField0_ |= 2;
    }

    private void setText(StringValue stringValue) {
        stringValue.getClass();
        this.text_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$IntroMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "text_", "media_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$IntroMessage.class) {
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

    public UsersStruct$IntroMedia getMedia() {
        UsersStruct$IntroMedia usersStruct$IntroMedia = this.media_;
        return usersStruct$IntroMedia == null ? UsersStruct$IntroMedia.getDefaultInstance() : usersStruct$IntroMedia;
    }

    public StringValue getText() {
        StringValue stringValue = this.text_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasMedia() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasText() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$IntroMessage);
    }

    public static UsersStruct$IntroMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$IntroMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$IntroMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$IntroMessage parseFrom(byte[] bArr) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$IntroMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$IntroMessage parseFrom(InputStream inputStream) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$IntroMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$IntroMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$IntroMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$IntroMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
