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
public final class MessagingOuterClass$UpdateChatGroupsChanged extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateChatGroupsChanged DEFAULT_INSTANCE;
    public static final int DIALOGS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j dialogs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateChatGroupsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateChatGroupsChanged messagingOuterClass$UpdateChatGroupsChanged = new MessagingOuterClass$UpdateChatGroupsChanged();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateChatGroupsChanged;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateChatGroupsChanged.class, messagingOuterClass$UpdateChatGroupsChanged);
    }

    private MessagingOuterClass$UpdateChatGroupsChanged() {
    }

    private void addAllDialogs(Iterable<? extends MessagingStruct$DialogGroup> iterable) {
        ensureDialogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogs_);
    }

    private void addDialogs(MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(messagingStruct$DialogGroup);
    }

    private void clearDialogs() {
        this.dialogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDialogsIsMutable() {
        B.j jVar = this.dialogs_;
        if (jVar.u()) {
            return;
        }
        this.dialogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogs(int i) {
        ensureDialogsIsMutable();
        this.dialogs_.remove(i);
    }

    private void setDialogs(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.set(i, messagingStruct$DialogGroup);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateChatGroupsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"dialogs_", MessagingStruct$DialogGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateChatGroupsChanged.class) {
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

    public MessagingStruct$DialogGroup getDialogs(int i) {
        return (MessagingStruct$DialogGroup) this.dialogs_.get(i);
    }

    public int getDialogsCount() {
        return this.dialogs_.size();
    }

    public List<MessagingStruct$DialogGroup> getDialogsList() {
        return this.dialogs_;
    }

    public InterfaceC17806nb4 getDialogsOrBuilder(int i) {
        return (InterfaceC17806nb4) this.dialogs_.get(i);
    }

    public List<? extends InterfaceC17806nb4> getDialogsOrBuilderList() {
        return this.dialogs_;
    }

    public static a newBuilder(MessagingOuterClass$UpdateChatGroupsChanged messagingOuterClass$UpdateChatGroupsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateChatGroupsChanged);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogs(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(i, messagingStruct$DialogGroup);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateChatGroupsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateChatGroupsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
