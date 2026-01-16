package ai.bale.proto;

import ai.bale.proto.SafirStruct$MessageOrder;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirPanelMessageOuterClass$RequestCreateMessageOrder extends GeneratedMessageLite implements U64 {
    private static final SafirPanelMessageOuterClass$RequestCreateMessageOrder DEFAULT_INSTANCE;
    public static final int MESSAGE_ORDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SHOULD_USE_CREDIT_FIELD_NUMBER = 2;
    private int bitField0_;
    private SafirStruct$MessageOrder messageOrder_;
    private boolean shouldUseCredit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$RequestCreateMessageOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$RequestCreateMessageOrder safirPanelMessageOuterClass$RequestCreateMessageOrder = new SafirPanelMessageOuterClass$RequestCreateMessageOrder();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$RequestCreateMessageOrder;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$RequestCreateMessageOrder.class, safirPanelMessageOuterClass$RequestCreateMessageOrder);
    }

    private SafirPanelMessageOuterClass$RequestCreateMessageOrder() {
    }

    private void clearMessageOrder() {
        this.messageOrder_ = null;
        this.bitField0_ &= -2;
    }

    private void clearShouldUseCredit() {
        this.shouldUseCredit_ = false;
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageOrder(SafirStruct$MessageOrder safirStruct$MessageOrder) {
        safirStruct$MessageOrder.getClass();
        SafirStruct$MessageOrder safirStruct$MessageOrder2 = this.messageOrder_;
        if (safirStruct$MessageOrder2 == null || safirStruct$MessageOrder2 == SafirStruct$MessageOrder.getDefaultInstance()) {
            this.messageOrder_ = safirStruct$MessageOrder;
        } else {
            this.messageOrder_ = (SafirStruct$MessageOrder) ((SafirStruct$MessageOrder.a) SafirStruct$MessageOrder.newBuilder(this.messageOrder_).v(safirStruct$MessageOrder)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessageOrder(SafirStruct$MessageOrder safirStruct$MessageOrder) {
        safirStruct$MessageOrder.getClass();
        this.messageOrder_ = safirStruct$MessageOrder;
        this.bitField0_ |= 1;
    }

    private void setShouldUseCredit(boolean z) {
        this.shouldUseCredit_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$RequestCreateMessageOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007", new Object[]{"bitField0_", "messageOrder_", "shouldUseCredit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$RequestCreateMessageOrder.class) {
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

    public SafirStruct$MessageOrder getMessageOrder() {
        SafirStruct$MessageOrder safirStruct$MessageOrder = this.messageOrder_;
        return safirStruct$MessageOrder == null ? SafirStruct$MessageOrder.getDefaultInstance() : safirStruct$MessageOrder;
    }

    public boolean getShouldUseCredit() {
        return this.shouldUseCredit_;
    }

    public boolean hasMessageOrder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$RequestCreateMessageOrder safirPanelMessageOuterClass$RequestCreateMessageOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$RequestCreateMessageOrder);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$RequestCreateMessageOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
