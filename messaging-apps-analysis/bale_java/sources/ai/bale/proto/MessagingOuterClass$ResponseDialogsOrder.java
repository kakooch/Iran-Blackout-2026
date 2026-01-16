package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17806nb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseDialogsOrder extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseDialogsOrder DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    private int seq_;
    private AbstractC2383g state_ = AbstractC2383g.b;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseDialogsOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseDialogsOrder messagingOuterClass$ResponseDialogsOrder = new MessagingOuterClass$ResponseDialogsOrder();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseDialogsOrder;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseDialogsOrder.class, messagingOuterClass$ResponseDialogsOrder);
    }

    private MessagingOuterClass$ResponseDialogsOrder() {
    }

    private void addAllGroups(Iterable<? extends MessagingStruct$DialogGroup> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(messagingStruct$DialogGroup);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseDialogsOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, messagingStruct$DialogGroup);
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseDialogsOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002\n\u0003\u001b", new Object[]{"seq_", "state_", "groups_", MessagingStruct$DialogGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseDialogsOrder.class) {
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

    public MessagingStruct$DialogGroup getGroups(int i) {
        return (MessagingStruct$DialogGroup) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<MessagingStruct$DialogGroup> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC17806nb4 getGroupsOrBuilder(int i) {
        return (InterfaceC17806nb4) this.groups_.get(i);
    }

    public List<? extends InterfaceC17806nb4> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseDialogsOrder messagingOuterClass$ResponseDialogsOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseDialogsOrder);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, messagingStruct$DialogGroup);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseDialogsOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseDialogsOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
