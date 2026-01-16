package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6132Mh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestUpdateSearchContentClick extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestUpdateSearchContentClick DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SEARCH_TAB_FIELD_NUMBER = 2;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier messageId_;
    private int searchTab_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((SearchOuterClass$RequestUpdateSearchContentClick) this.b).setMessageId(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        public a B(EnumC6132Mh6 enumC6132Mh6) {
            q();
            ((SearchOuterClass$RequestUpdateSearchContentClick) this.b).setSearchTab(enumC6132Mh6);
            return this;
        }

        private a() {
            super(SearchOuterClass$RequestUpdateSearchContentClick.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestUpdateSearchContentClick searchOuterClass$RequestUpdateSearchContentClick = new SearchOuterClass$RequestUpdateSearchContentClick();
        DEFAULT_INSTANCE = searchOuterClass$RequestUpdateSearchContentClick;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestUpdateSearchContentClick.class, searchOuterClass$RequestUpdateSearchContentClick);
    }

    private SearchOuterClass$RequestUpdateSearchContentClick() {
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSearchTab() {
        this.searchTab_ = 0;
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static SearchOuterClass$RequestUpdateSearchContentClick parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchTab(EnumC6132Mh6 enumC6132Mh6) {
        this.searchTab_ = enumC6132Mh6.getNumber();
    }

    private void setSearchTabValue(int i) {
        this.searchTab_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestUpdateSearchContentClick();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "messageId_", "searchTab_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestUpdateSearchContentClick.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMessageId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public EnumC6132Mh6 getSearchTab() {
        EnumC6132Mh6 enumC6132Mh6J = EnumC6132Mh6.j(this.searchTab_);
        return enumC6132Mh6J == null ? EnumC6132Mh6.UNRECOGNIZED : enumC6132Mh6J;
    }

    public int getSearchTabValue() {
        return this.searchTab_;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$RequestUpdateSearchContentClick searchOuterClass$RequestUpdateSearchContentClick) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestUpdateSearchContentClick);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestUpdateSearchContentClick parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestUpdateSearchContentClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
