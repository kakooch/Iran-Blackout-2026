package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6076Mb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$InlineKeyboardButtonMarkup extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$InlineKeyboardButtonMarkup DEFAULT_INSTANCE;
    public static final int LIST_OF_INLINE_LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j listOfInlineList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$InlineKeyboardButtonMarkup.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup = new MessagingStruct$InlineKeyboardButtonMarkup();
        DEFAULT_INSTANCE = messagingStruct$InlineKeyboardButtonMarkup;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$InlineKeyboardButtonMarkup.class, messagingStruct$InlineKeyboardButtonMarkup);
    }

    private MessagingStruct$InlineKeyboardButtonMarkup() {
    }

    private void addAllListOfInlineList(Iterable<? extends MessagingStruct$InlineKeyboardButtonList> iterable) {
        ensureListOfInlineListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.listOfInlineList_);
    }

    private void addListOfInlineList(MessagingStruct$InlineKeyboardButtonList messagingStruct$InlineKeyboardButtonList) {
        messagingStruct$InlineKeyboardButtonList.getClass();
        ensureListOfInlineListIsMutable();
        this.listOfInlineList_.add(messagingStruct$InlineKeyboardButtonList);
    }

    private void clearListOfInlineList() {
        this.listOfInlineList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureListOfInlineListIsMutable() {
        B.j jVar = this.listOfInlineList_;
        if (jVar.u()) {
            return;
        }
        this.listOfInlineList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeListOfInlineList(int i) {
        ensureListOfInlineListIsMutable();
        this.listOfInlineList_.remove(i);
    }

    private void setListOfInlineList(int i, MessagingStruct$InlineKeyboardButtonList messagingStruct$InlineKeyboardButtonList) {
        messagingStruct$InlineKeyboardButtonList.getClass();
        ensureListOfInlineListIsMutable();
        this.listOfInlineList_.set(i, messagingStruct$InlineKeyboardButtonList);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$InlineKeyboardButtonMarkup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"listOfInlineList_", MessagingStruct$InlineKeyboardButtonList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$InlineKeyboardButtonMarkup.class) {
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

    public MessagingStruct$InlineKeyboardButtonList getListOfInlineList(int i) {
        return (MessagingStruct$InlineKeyboardButtonList) this.listOfInlineList_.get(i);
    }

    public int getListOfInlineListCount() {
        return this.listOfInlineList_.size();
    }

    public List<MessagingStruct$InlineKeyboardButtonList> getListOfInlineListList() {
        return this.listOfInlineList_;
    }

    public InterfaceC6076Mb4 getListOfInlineListOrBuilder(int i) {
        return (InterfaceC6076Mb4) this.listOfInlineList_.get(i);
    }

    public List<? extends InterfaceC6076Mb4> getListOfInlineListOrBuilderList() {
        return this.listOfInlineList_;
    }

    public static a newBuilder(MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$InlineKeyboardButtonMarkup);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addListOfInlineList(int i, MessagingStruct$InlineKeyboardButtonList messagingStruct$InlineKeyboardButtonList) {
        messagingStruct$InlineKeyboardButtonList.getClass();
        ensureListOfInlineListIsMutable();
        this.listOfInlineList_.add(i, messagingStruct$InlineKeyboardButtonList);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(byte[] bArr) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$InlineKeyboardButtonMarkup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButtonMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
