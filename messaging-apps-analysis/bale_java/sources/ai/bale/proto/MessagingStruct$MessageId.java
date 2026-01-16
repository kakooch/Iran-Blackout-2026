package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$MessageId extends GeneratedMessageLite implements InterfaceC13043fc4 {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final MessagingStruct$MessageId DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SEQ_FIELD_NUMBER = 3;
    private long date_;
    private long rid_;
    private long seq_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13043fc4 {
        public a A(long j) {
            q();
            ((MessagingStruct$MessageId) this.b).setDate(j);
            return this;
        }

        public a B(long j) {
            q();
            ((MessagingStruct$MessageId) this.b).setRid(j);
            return this;
        }

        public a C(long j) {
            q();
            ((MessagingStruct$MessageId) this.b).setSeq(j);
            return this;
        }

        private a() {
            super(MessagingStruct$MessageId.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MessageId messagingStruct$MessageId = new MessagingStruct$MessageId();
        DEFAULT_INSTANCE = messagingStruct$MessageId;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MessageId.class, messagingStruct$MessageId);
    }

    private MessagingStruct$MessageId() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSeq() {
        this.seq_ = 0L;
    }

    public static MessagingStruct$MessageId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MessageId parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageId parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeq(long j) {
        this.seq_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MessageId();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002", new Object[]{"date_", "rid_", "seq_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MessageId.class) {
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

    public long getRid() {
        return this.rid_;
    }

    public long getSeq() {
        return this.seq_;
    }

    public static a newBuilder(MessagingStruct$MessageId messagingStruct$MessageId) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MessageId);
    }

    public static MessagingStruct$MessageId parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageId parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MessageId parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$MessageId parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MessageId parseFrom(byte[] bArr) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MessageId parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MessageId parseFrom(InputStream inputStream) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageId parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageId parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MessageId parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MessageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
