package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseLoadPinnedMessages extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseLoadPinnedMessages DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PINNED_MESSAGES_FIELD_NUMBER = 1;
    private B.j pinnedMessages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseLoadPinnedMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseLoadPinnedMessages messagingOuterClass$ResponseLoadPinnedMessages = new MessagingOuterClass$ResponseLoadPinnedMessages();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseLoadPinnedMessages;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseLoadPinnedMessages.class, messagingOuterClass$ResponseLoadPinnedMessages);
    }

    private MessagingOuterClass$ResponseLoadPinnedMessages() {
    }

    private void addAllPinnedMessages(Iterable<? extends MessagingStruct$MessageContainer> iterable) {
        ensurePinnedMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pinnedMessages_);
    }

    private void addPinnedMessages(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinnedMessagesIsMutable();
        this.pinnedMessages_.add(messagingStruct$MessageContainer);
    }

    private void clearPinnedMessages() {
        this.pinnedMessages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePinnedMessagesIsMutable() {
        B.j jVar = this.pinnedMessages_;
        if (jVar.u()) {
            return;
        }
        this.pinnedMessages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePinnedMessages(int i) {
        ensurePinnedMessagesIsMutable();
        this.pinnedMessages_.remove(i);
    }

    private void setPinnedMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinnedMessagesIsMutable();
        this.pinnedMessages_.set(i, messagingStruct$MessageContainer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseLoadPinnedMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pinnedMessages_", MessagingStruct$MessageContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseLoadPinnedMessages.class) {
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

    public MessagingStruct$MessageContainer getPinnedMessages(int i) {
        return (MessagingStruct$MessageContainer) this.pinnedMessages_.get(i);
    }

    public int getPinnedMessagesCount() {
        return this.pinnedMessages_.size();
    }

    public List<MessagingStruct$MessageContainer> getPinnedMessagesList() {
        return this.pinnedMessages_;
    }

    public InterfaceC11027cc4 getPinnedMessagesOrBuilder(int i) {
        return (InterfaceC11027cc4) this.pinnedMessages_.get(i);
    }

    public List<? extends InterfaceC11027cc4> getPinnedMessagesOrBuilderList() {
        return this.pinnedMessages_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseLoadPinnedMessages messagingOuterClass$ResponseLoadPinnedMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseLoadPinnedMessages);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPinnedMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensurePinnedMessagesIsMutable();
        this.pinnedMessages_.add(i, messagingStruct$MessageContainer);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseLoadPinnedMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPinnedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
