package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$MessageAttributes extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$MessageAttributes DEFAULT_INSTANCE;
    public static final int IS_HIGHLIGHTED_FIELD_NUMBER = 2;
    public static final int IS_MENTIONED_FIELD_NUMBER = 1;
    public static final int IS_NOTIFIED_FIELD_NUMBER = 3;
    public static final int IS_ONLY_FOR_YOU_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BoolValue isHighlighted_;
    private BoolValue isMentioned_;
    private BoolValue isNotified_;
    private BoolValue isOnlyForYou_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$MessageAttributes.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes = new MessagingStruct$MessageAttributes();
        DEFAULT_INSTANCE = messagingStruct$MessageAttributes;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MessageAttributes.class, messagingStruct$MessageAttributes);
    }

    private MessagingStruct$MessageAttributes() {
    }

    private void clearIsHighlighted() {
        this.isHighlighted_ = null;
        this.bitField0_ &= -3;
    }

    private void clearIsMentioned() {
        this.isMentioned_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsNotified() {
        this.isNotified_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsOnlyForYou() {
        this.isOnlyForYou_ = null;
        this.bitField0_ &= -9;
    }

    public static MessagingStruct$MessageAttributes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsHighlighted(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isHighlighted_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isHighlighted_ = boolValue;
        } else {
            this.isHighlighted_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isHighlighted_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIsMentioned(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isMentioned_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isMentioned_ = boolValue;
        } else {
            this.isMentioned_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isMentioned_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeIsNotified(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isNotified_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isNotified_ = boolValue;
        } else {
            this.isNotified_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isNotified_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeIsOnlyForYou(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isOnlyForYou_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isOnlyForYou_ = boolValue;
        } else {
            this.isOnlyForYou_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isOnlyForYou_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MessageAttributes parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageAttributes parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsHighlighted(BoolValue boolValue) {
        boolValue.getClass();
        this.isHighlighted_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setIsMentioned(BoolValue boolValue) {
        boolValue.getClass();
        this.isMentioned_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setIsNotified(BoolValue boolValue) {
        boolValue.getClass();
        this.isNotified_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setIsOnlyForYou(BoolValue boolValue) {
        boolValue.getClass();
        this.isOnlyForYou_ = boolValue;
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MessageAttributes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"bitField0_", "isMentioned_", "isHighlighted_", "isNotified_", "isOnlyForYou_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MessageAttributes.class) {
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

    public BoolValue getIsHighlighted() {
        BoolValue boolValue = this.isHighlighted_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsMentioned() {
        BoolValue boolValue = this.isMentioned_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsNotified() {
        BoolValue boolValue = this.isNotified_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsOnlyForYou() {
        BoolValue boolValue = this.isOnlyForYou_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasIsHighlighted() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsMentioned() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsNotified() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsOnlyForYou() {
        return (this.bitField0_ & 8) != 0;
    }

    public static a newBuilder(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MessageAttributes);
    }

    public static MessagingStruct$MessageAttributes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageAttributes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MessageAttributes parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$MessageAttributes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MessageAttributes parseFrom(byte[] bArr) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MessageAttributes parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MessageAttributes parseFrom(InputStream inputStream) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageAttributes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageAttributes parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MessageAttributes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MessageAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
