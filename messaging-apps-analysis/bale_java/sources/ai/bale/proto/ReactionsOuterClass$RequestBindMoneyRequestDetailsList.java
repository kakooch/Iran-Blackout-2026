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
public final class ReactionsOuterClass$RequestBindMoneyRequestDetailsList extends GeneratedMessageLite implements U64 {
    private static final ReactionsOuterClass$RequestBindMoneyRequestDetailsList DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j messages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReactionsOuterClass$RequestBindMoneyRequestDetailsList.DEFAULT_INSTANCE);
        }
    }

    static {
        ReactionsOuterClass$RequestBindMoneyRequestDetailsList reactionsOuterClass$RequestBindMoneyRequestDetailsList = new ReactionsOuterClass$RequestBindMoneyRequestDetailsList();
        DEFAULT_INSTANCE = reactionsOuterClass$RequestBindMoneyRequestDetailsList;
        GeneratedMessageLite.registerDefaultInstance(ReactionsOuterClass$RequestBindMoneyRequestDetailsList.class, reactionsOuterClass$RequestBindMoneyRequestDetailsList);
    }

    private ReactionsOuterClass$RequestBindMoneyRequestDetailsList() {
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

    private void ensureMessagesIsMutable() {
        B.j jVar = this.messages_;
        if (jVar.u()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseDelimitedFrom(InputStream inputStream) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(ByteBuffer byteBuffer) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1889r1.a[gVar.ordinal()]) {
            case 1:
                return new ReactionsOuterClass$RequestBindMoneyRequestDetailsList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"messages_", MessagingStruct$HistoryMessageIdentifier.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReactionsOuterClass$RequestBindMoneyRequestDetailsList.class) {
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

    public static a newBuilder(ReactionsOuterClass$RequestBindMoneyRequestDetailsList reactionsOuterClass$RequestBindMoneyRequestDetailsList) {
        return (a) DEFAULT_INSTANCE.createBuilder(reactionsOuterClass$RequestBindMoneyRequestDetailsList);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(AbstractC2383g abstractC2383g) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessages(int i, MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, messagingStruct$HistoryMessageIdentifier);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(byte[] bArr) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(InputStream inputStream) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(AbstractC2384h abstractC2384h) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReactionsOuterClass$RequestBindMoneyRequestDetailsList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
