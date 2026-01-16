package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TuringStruct$DownloadSource extends GeneratedMessageLite implements U64 {
    private static final TuringStruct$DownloadSource DEFAULT_INSTANCE;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$DocumentMessage documentMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TuringStruct$DownloadSource.DEFAULT_INSTANCE);
        }
    }

    static {
        TuringStruct$DownloadSource turingStruct$DownloadSource = new TuringStruct$DownloadSource();
        DEFAULT_INSTANCE = turingStruct$DownloadSource;
        GeneratedMessageLite.registerDefaultInstance(TuringStruct$DownloadSource.class, turingStruct$DownloadSource);
    }

    private TuringStruct$DownloadSource() {
    }

    private void clearDocumentMessage() {
        this.documentMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static TuringStruct$DownloadSource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.documentMessage_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.documentMessage_ = messagingStruct$DocumentMessage;
        } else {
            this.documentMessage_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.documentMessage_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TuringStruct$DownloadSource parseDelimitedFrom(InputStream inputStream) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$DownloadSource parseFrom(ByteBuffer byteBuffer) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.documentMessage_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (n2.a[gVar.ordinal()]) {
            case 1:
                return new TuringStruct$DownloadSource();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "documentMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TuringStruct$DownloadSource.class) {
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

    public MessagingStruct$DocumentMessage getDocumentMessage() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.documentMessage_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public boolean hasDocumentMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TuringStruct$DownloadSource turingStruct$DownloadSource) {
        return (a) DEFAULT_INSTANCE.createBuilder(turingStruct$DownloadSource);
    }

    public static TuringStruct$DownloadSource parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$DownloadSource parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TuringStruct$DownloadSource parseFrom(AbstractC2383g abstractC2383g) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TuringStruct$DownloadSource parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TuringStruct$DownloadSource parseFrom(byte[] bArr) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuringStruct$DownloadSource parseFrom(byte[] bArr, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TuringStruct$DownloadSource parseFrom(InputStream inputStream) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$DownloadSource parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$DownloadSource parseFrom(AbstractC2384h abstractC2384h) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TuringStruct$DownloadSource parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TuringStruct$DownloadSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
