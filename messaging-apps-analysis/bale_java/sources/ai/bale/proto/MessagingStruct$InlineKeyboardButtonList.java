package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6076Mb4;
import ir.nasim.InterfaceC6570Ob4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$InlineKeyboardButtonList extends GeneratedMessageLite implements InterfaceC6076Mb4 {
    private static final MessagingStruct$InlineKeyboardButtonList DEFAULT_INSTANCE;
    public static final int INLINE_LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j inlineList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6076Mb4 {
        private a() {
            super(MessagingStruct$InlineKeyboardButtonList.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$InlineKeyboardButtonList messagingStruct$InlineKeyboardButtonList = new MessagingStruct$InlineKeyboardButtonList();
        DEFAULT_INSTANCE = messagingStruct$InlineKeyboardButtonList;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$InlineKeyboardButtonList.class, messagingStruct$InlineKeyboardButtonList);
    }

    private MessagingStruct$InlineKeyboardButtonList() {
    }

    private void addAllInlineList(Iterable<? extends MessagingStruct$InlineKeyboardButton> iterable) {
        ensureInlineListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inlineList_);
    }

    private void addInlineList(MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton) {
        messagingStruct$InlineKeyboardButton.getClass();
        ensureInlineListIsMutable();
        this.inlineList_.add(messagingStruct$InlineKeyboardButton);
    }

    private void clearInlineList() {
        this.inlineList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInlineListIsMutable() {
        B.j jVar = this.inlineList_;
        if (jVar.u()) {
            return;
        }
        this.inlineList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$InlineKeyboardButtonList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$InlineKeyboardButtonList parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInlineList(int i) {
        ensureInlineListIsMutable();
        this.inlineList_.remove(i);
    }

    private void setInlineList(int i, MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton) {
        messagingStruct$InlineKeyboardButton.getClass();
        ensureInlineListIsMutable();
        this.inlineList_.set(i, messagingStruct$InlineKeyboardButton);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$InlineKeyboardButtonList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"inlineList_", MessagingStruct$InlineKeyboardButton.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$InlineKeyboardButtonList.class) {
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

    public MessagingStruct$InlineKeyboardButton getInlineList(int i) {
        return (MessagingStruct$InlineKeyboardButton) this.inlineList_.get(i);
    }

    public int getInlineListCount() {
        return this.inlineList_.size();
    }

    public List<MessagingStruct$InlineKeyboardButton> getInlineListList() {
        return this.inlineList_;
    }

    public InterfaceC6570Ob4 getInlineListOrBuilder(int i) {
        return (InterfaceC6570Ob4) this.inlineList_.get(i);
    }

    public List<? extends InterfaceC6570Ob4> getInlineListOrBuilderList() {
        return this.inlineList_;
    }

    public static a newBuilder(MessagingStruct$InlineKeyboardButtonList messagingStruct$InlineKeyboardButtonList) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$InlineKeyboardButtonList);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInlineList(int i, MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton) {
        messagingStruct$InlineKeyboardButton.getClass();
        ensureInlineListIsMutable();
        this.inlineList_.add(i, messagingStruct$InlineKeyboardButton);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(byte[] bArr) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$InlineKeyboardButtonList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
