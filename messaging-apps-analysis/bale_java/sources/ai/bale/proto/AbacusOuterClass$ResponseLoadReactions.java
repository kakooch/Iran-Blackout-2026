package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5384Jc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$ResponseLoadReactions extends GeneratedMessageLite implements U64 {
    public static final int CONTAINERS_FIELD_NUMBER = 1;
    private static final AbacusOuterClass$ResponseLoadReactions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j containers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$ResponseLoadReactions.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$ResponseLoadReactions abacusOuterClass$ResponseLoadReactions = new AbacusOuterClass$ResponseLoadReactions();
        DEFAULT_INSTANCE = abacusOuterClass$ResponseLoadReactions;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$ResponseLoadReactions.class, abacusOuterClass$ResponseLoadReactions);
    }

    private AbacusOuterClass$ResponseLoadReactions() {
    }

    private void addAllContainers(Iterable<? extends MessagingStruct$ReactionContainer> iterable) {
        ensureContainersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.containers_);
    }

    private void addContainers(MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        messagingStruct$ReactionContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.add(messagingStruct$ReactionContainer);
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

    public static AbacusOuterClass$ResponseLoadReactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$ResponseLoadReactions parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContainers(int i) {
        ensureContainersIsMutable();
        this.containers_.remove(i);
    }

    private void setContainers(int i, MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        messagingStruct$ReactionContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.set(i, messagingStruct$ReactionContainer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$ResponseLoadReactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"containers_", MessagingStruct$ReactionContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$ResponseLoadReactions.class) {
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

    public MessagingStruct$ReactionContainer getContainers(int i) {
        return (MessagingStruct$ReactionContainer) this.containers_.get(i);
    }

    public int getContainersCount() {
        return this.containers_.size();
    }

    public List<MessagingStruct$ReactionContainer> getContainersList() {
        return this.containers_;
    }

    public InterfaceC5384Jc4 getContainersOrBuilder(int i) {
        return (InterfaceC5384Jc4) this.containers_.get(i);
    }

    public List<? extends InterfaceC5384Jc4> getContainersOrBuilderList() {
        return this.containers_;
    }

    public static a newBuilder(AbacusOuterClass$ResponseLoadReactions abacusOuterClass$ResponseLoadReactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$ResponseLoadReactions);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContainers(int i, MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        messagingStruct$ReactionContainer.getClass();
        ensureContainersIsMutable();
        this.containers_.add(i, messagingStruct$ReactionContainer);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(byte[] bArr) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$ResponseLoadReactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$ResponseLoadReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
