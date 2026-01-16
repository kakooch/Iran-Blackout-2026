package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5375Jb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineStruct$MagazineUpvotes extends GeneratedMessageLite implements U64 {
    private static final MagazineStruct$MagazineUpvotes DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int UPVOTES_LIMIT_FIELD_NUMBER = 2;
    private B.j messages_ = GeneratedMessageLite.emptyProtobufList();
    private int upvotesLimit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineStruct$MagazineUpvotes.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes = new MagazineStruct$MagazineUpvotes();
        DEFAULT_INSTANCE = magazineStruct$MagazineUpvotes;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$MagazineUpvotes.class, magazineStruct$MagazineUpvotes);
    }

    private MagazineStruct$MagazineUpvotes() {
    }

    private void addAllMessages(Iterable<? extends MessagingStruct$HistoryMessageIdentifier> iterable) {
        ensureMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messages_);
    }

    private void addMessages(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(messagingStruct$HistoryMessageIdentifier);
    }

    private void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUpvotesLimit() {
        this.upvotesLimit_ = 0;
    }

    private void ensureMessagesIsMutable() {
        B.j jVar = this.messages_;
        if (jVar.u()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MagazineStruct$MagazineUpvotes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$MagazineUpvotes parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    private void setMessages(int i, MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i, messagingStruct$HistoryMessageIdentifier);
    }

    private void setUpvotesLimit(int i) {
        this.upvotesLimit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$MagazineUpvotes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"messages_", MessagingStruct$HistoryMessageIdentifier.class, "upvotesLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$MagazineUpvotes.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMessages(int i) {
        return (MessagingStruct$HistoryMessageIdentifier) this.messages_.get(i);
    }

    public int getMessagesCount() {
        return this.messages_.size();
    }

    public List<MessagingStruct$HistoryMessageIdentifier> getMessagesList() {
        return this.messages_;
    }

    public InterfaceC5375Jb4 getMessagesOrBuilder(int i) {
        return (InterfaceC5375Jb4) this.messages_.get(i);
    }

    public List<? extends InterfaceC5375Jb4> getMessagesOrBuilderList() {
        return this.messages_;
    }

    public int getUpvotesLimit() {
        return this.upvotesLimit_;
    }

    public static a newBuilder(MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$MagazineUpvotes);
    }

    public static MagazineStruct$MagazineUpvotes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessages(int i, MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, messagingStruct$HistoryMessageIdentifier);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(byte[] bArr) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(InputStream inputStream) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$MagazineUpvotes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$MagazineUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
