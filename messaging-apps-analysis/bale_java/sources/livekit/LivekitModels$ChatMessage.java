package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$ChatMessage extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$ChatMessage DEFAULT_INSTANCE;
    public static final int DELETED_FIELD_NUMBER = 5;
    public static final int EDIT_TIMESTAMP_FIELD_NUMBER = 3;
    public static final int GENERATED_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean deleted_;
    private long editTimestamp_;
    private boolean generated_;
    private String id_ = "";
    private String message_ = "";
    private long timestamp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$ChatMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$ChatMessage livekitModels$ChatMessage = new LivekitModels$ChatMessage();
        DEFAULT_INSTANCE = livekitModels$ChatMessage;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ChatMessage.class, livekitModels$ChatMessage);
    }

    private LivekitModels$ChatMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleted() {
        this.deleted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEditTimestamp() {
        this.bitField0_ &= -2;
        this.editTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGenerated() {
        this.generated_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static LivekitModels$ChatMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ChatMessage parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ChatMessage parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleted(boolean z) {
        this.deleted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditTimestamp(long j) {
        this.bitField0_ |= 1;
        this.editTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGenerated(boolean z) {
        this.generated_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ChatMessage();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဂ\u0000\u0004Ȉ\u0005\u0007\u0006\u0007", new Object[]{"bitField0_", "id_", "timestamp_", "editTimestamp_", "message_", "deleted_", "generated_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ChatMessage.class) {
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

    public boolean getDeleted() {
        return this.deleted_;
    }

    public long getEditTimestamp() {
        return this.editTimestamp_;
    }

    public boolean getGenerated() {
        return this.generated_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public boolean hasEditTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitModels$ChatMessage livekitModels$ChatMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ChatMessage);
    }

    public static LivekitModels$ChatMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ChatMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ChatMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ChatMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ChatMessage parseFrom(byte[] bArr) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ChatMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ChatMessage parseFrom(InputStream inputStream) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ChatMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ChatMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ChatMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ChatMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
