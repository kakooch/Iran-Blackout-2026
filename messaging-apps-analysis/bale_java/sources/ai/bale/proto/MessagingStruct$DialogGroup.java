package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17806nb4;
import ir.nasim.InterfaceC19579qb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$DialogGroup extends GeneratedMessageLite implements InterfaceC17806nb4 {
    private static final MessagingStruct$DialogGroup DEFAULT_INSTANCE;
    public static final int DIALOGS_FIELD_NUMBER = 3;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";
    private String key_ = "";
    private B.j dialogs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17806nb4 {
        private a() {
            super(MessagingStruct$DialogGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DialogGroup messagingStruct$DialogGroup = new MessagingStruct$DialogGroup();
        DEFAULT_INSTANCE = messagingStruct$DialogGroup;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DialogGroup.class, messagingStruct$DialogGroup);
    }

    private MessagingStruct$DialogGroup() {
    }

    private void addAllDialogs(Iterable<? extends MessagingStruct$DialogShort> iterable) {
        ensureDialogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogs_);
    }

    private void addDialogs(MessagingStruct$DialogShort messagingStruct$DialogShort) {
        messagingStruct$DialogShort.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(messagingStruct$DialogShort);
    }

    private void clearDialogs() {
        this.dialogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureDialogsIsMutable() {
        B.j jVar = this.dialogs_;
        if (jVar.u()) {
            return;
        }
        this.dialogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$DialogGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DialogGroup parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DialogGroup parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogs(int i) {
        ensureDialogsIsMutable();
        this.dialogs_.remove(i);
    }

    private void setDialogs(int i, MessagingStruct$DialogShort messagingStruct$DialogShort) {
        messagingStruct$DialogShort.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.set(i, messagingStruct$DialogShort);
    }

    private void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    private void setKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.key_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DialogGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"title_", "key_", "dialogs_", MessagingStruct$DialogShort.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DialogGroup.class) {
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

    public MessagingStruct$DialogShort getDialogs(int i) {
        return (MessagingStruct$DialogShort) this.dialogs_.get(i);
    }

    public int getDialogsCount() {
        return this.dialogs_.size();
    }

    public List<MessagingStruct$DialogShort> getDialogsList() {
        return this.dialogs_;
    }

    public InterfaceC19579qb4 getDialogsOrBuilder(int i) {
        return (InterfaceC19579qb4) this.dialogs_.get(i);
    }

    public List<? extends InterfaceC19579qb4> getDialogsOrBuilderList() {
        return this.dialogs_;
    }

    public String getKey() {
        return this.key_;
    }

    public AbstractC2383g getKeyBytes() {
        return AbstractC2383g.N(this.key_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DialogGroup);
    }

    public static MessagingStruct$DialogGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DialogGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DialogGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogs(int i, MessagingStruct$DialogShort messagingStruct$DialogShort) {
        messagingStruct$DialogShort.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(i, messagingStruct$DialogShort);
    }

    public static MessagingStruct$DialogGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DialogGroup parseFrom(byte[] bArr) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DialogGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DialogGroup parseFrom(InputStream inputStream) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DialogGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DialogGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DialogGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DialogGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
