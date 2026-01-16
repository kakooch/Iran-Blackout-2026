package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22708vh6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$ContentSearchResult extends GeneratedMessageLite implements InterfaceC22708vh6 {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final SearchStruct$ContentSearchResult DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$Message content_;
    private MessagingStruct$HistoryMessageIdentifier messageId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22708vh6 {
        private a() {
            super(SearchStruct$ContentSearchResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$ContentSearchResult searchStruct$ContentSearchResult = new SearchStruct$ContentSearchResult();
        DEFAULT_INSTANCE = searchStruct$ContentSearchResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$ContentSearchResult.class, searchStruct$ContentSearchResult);
    }

    private SearchStruct$ContentSearchResult() {
    }

    private void clearContent() {
        this.content_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchStruct$ContentSearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.content_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.content_ = messagingStruct$Message;
        } else {
            this.content_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.content_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.messageId_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.messageId_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.messageId_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$ContentSearchResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$ContentSearchResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.content_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$ContentSearchResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "messageId_", "content_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$ContentSearchResult.class) {
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

    public MessagingStruct$Message getContent() {
        MessagingStruct$Message messagingStruct$Message = this.content_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public MessagingStruct$HistoryMessageIdentifier getMessageId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasContent() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$ContentSearchResult searchStruct$ContentSearchResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$ContentSearchResult);
    }

    public static SearchStruct$ContentSearchResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$ContentSearchResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$ContentSearchResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$ContentSearchResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$ContentSearchResult parseFrom(byte[] bArr) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$ContentSearchResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$ContentSearchResult parseFrom(InputStream inputStream) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$ContentSearchResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$ContentSearchResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$ContentSearchResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$ContentSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
