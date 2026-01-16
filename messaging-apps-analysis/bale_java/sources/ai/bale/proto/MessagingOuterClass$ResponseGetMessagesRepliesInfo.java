package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6579Oc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseGetMessagesRepliesInfo extends GeneratedMessageLite implements U64 {
    public static final int CONTAINERS_FIELD_NUMBER = 1;
    private static final MessagingOuterClass$ResponseGetMessagesRepliesInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j containers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseGetMessagesRepliesInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseGetMessagesRepliesInfo messagingOuterClass$ResponseGetMessagesRepliesInfo = new MessagingOuterClass$ResponseGetMessagesRepliesInfo();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseGetMessagesRepliesInfo;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseGetMessagesRepliesInfo.class, messagingOuterClass$ResponseGetMessagesRepliesInfo);
    }

    private MessagingOuterClass$ResponseGetMessagesRepliesInfo() {
    }

    private void addAllContainers(Iterable<? extends MessagingStruct$RepliesContainer> iterable) {
        ensureContainersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.containers_);
    }

    private void addContainers(MessagingStruct$RepliesContainer messagingStruct$RepliesContainer) {
        messagingStruct$RepliesContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.add(messagingStruct$RepliesContainer);
    }

    private void clearContainers() {
        this.containers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureContainersIsMutable() {
        B.j jVar = this.containers_;
        if (jVar.u()) {
            return;
        }
        this.containers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContainers(int i) {
        ensureContainersIsMutable();
        this.containers_.remove(i);
    }

    private void setContainers(int i, MessagingStruct$RepliesContainer messagingStruct$RepliesContainer) {
        messagingStruct$RepliesContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.set(i, messagingStruct$RepliesContainer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseGetMessagesRepliesInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"containers_", MessagingStruct$RepliesContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseGetMessagesRepliesInfo.class) {
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

    public MessagingStruct$RepliesContainer getContainers(int i) {
        return (MessagingStruct$RepliesContainer) this.containers_.get(i);
    }

    public int getContainersCount() {
        return this.containers_.size();
    }

    public List<MessagingStruct$RepliesContainer> getContainersList() {
        return this.containers_;
    }

    public InterfaceC6579Oc4 getContainersOrBuilder(int i) {
        return (InterfaceC6579Oc4) this.containers_.get(i);
    }

    public List<? extends InterfaceC6579Oc4> getContainersOrBuilderList() {
        return this.containers_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseGetMessagesRepliesInfo messagingOuterClass$ResponseGetMessagesRepliesInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseGetMessagesRepliesInfo);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContainers(int i, MessagingStruct$RepliesContainer messagingStruct$RepliesContainer) {
        messagingStruct$RepliesContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.add(i, messagingStruct$RepliesContainer);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseGetMessagesRepliesInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseGetMessagesRepliesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
