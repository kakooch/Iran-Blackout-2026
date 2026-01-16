package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Replies;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6579Oc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$RepliesContainer extends GeneratedMessageLite implements InterfaceC6579Oc4 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final MessagingStruct$RepliesContainer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLIES_INFO_FIELD_NUMBER = 3;
    public static final int RID_FIELD_NUMBER = 1;
    private int bitField0_;
    private long date_;
    private MessagingStruct$Replies repliesInfo_;
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6579Oc4 {
        private a() {
            super(MessagingStruct$RepliesContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$RepliesContainer messagingStruct$RepliesContainer = new MessagingStruct$RepliesContainer();
        DEFAULT_INSTANCE = messagingStruct$RepliesContainer;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$RepliesContainer.class, messagingStruct$RepliesContainer);
    }

    private MessagingStruct$RepliesContainer() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearRepliesInfo() {
        this.repliesInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static MessagingStruct$RepliesContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRepliesInfo(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        MessagingStruct$Replies messagingStruct$Replies2 = this.repliesInfo_;
        if (messagingStruct$Replies2 == null || messagingStruct$Replies2 == MessagingStruct$Replies.getDefaultInstance()) {
            this.repliesInfo_ = messagingStruct$Replies;
        } else {
            this.repliesInfo_ = (MessagingStruct$Replies) ((MessagingStruct$Replies.a) MessagingStruct$Replies.newBuilder(this.repliesInfo_).v(messagingStruct$Replies)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$RepliesContainer parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$RepliesContainer parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setRepliesInfo(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        this.repliesInfo_ = messagingStruct$Replies;
        this.bitField0_ |= 1;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$RepliesContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003ဉ\u0000", new Object[]{"bitField0_", "rid_", "date_", "repliesInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$RepliesContainer.class) {
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

    public long getDate() {
        return this.date_;
    }

    public MessagingStruct$Replies getRepliesInfo() {
        MessagingStruct$Replies messagingStruct$Replies = this.repliesInfo_;
        return messagingStruct$Replies == null ? MessagingStruct$Replies.getDefaultInstance() : messagingStruct$Replies;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean hasRepliesInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$RepliesContainer messagingStruct$RepliesContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$RepliesContainer);
    }

    public static MessagingStruct$RepliesContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$RepliesContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$RepliesContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$RepliesContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$RepliesContainer parseFrom(byte[] bArr) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$RepliesContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$RepliesContainer parseFrom(InputStream inputStream) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$RepliesContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$RepliesContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$RepliesContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$RepliesContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
