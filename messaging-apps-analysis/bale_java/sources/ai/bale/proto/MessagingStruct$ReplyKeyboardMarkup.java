package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8462Wb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$ReplyKeyboardMarkup extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ReplyKeyboardMarkup DEFAULT_INSTANCE;
    public static final int LIST_OF_KEYBOARD_LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j listOfKeyboardList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ReplyKeyboardMarkup.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup = new MessagingStruct$ReplyKeyboardMarkup();
        DEFAULT_INSTANCE = messagingStruct$ReplyKeyboardMarkup;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ReplyKeyboardMarkup.class, messagingStruct$ReplyKeyboardMarkup);
    }

    private MessagingStruct$ReplyKeyboardMarkup() {
    }

    private void addAllListOfKeyboardList(Iterable<? extends MessagingStruct$ListOfKeyboardButton> iterable) {
        ensureListOfKeyboardListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.listOfKeyboardList_);
    }

    private void addListOfKeyboardList(MessagingStruct$ListOfKeyboardButton messagingStruct$ListOfKeyboardButton) {
        messagingStruct$ListOfKeyboardButton.getClass();
        ensureListOfKeyboardListIsMutable();
        this.listOfKeyboardList_.add(messagingStruct$ListOfKeyboardButton);
    }

    private void clearListOfKeyboardList() {
        this.listOfKeyboardList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureListOfKeyboardListIsMutable() {
        B.j jVar = this.listOfKeyboardList_;
        if (jVar.u()) {
            return;
        }
        this.listOfKeyboardList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$ReplyKeyboardMarkup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeListOfKeyboardList(int i) {
        ensureListOfKeyboardListIsMutable();
        this.listOfKeyboardList_.remove(i);
    }

    private void setListOfKeyboardList(int i, MessagingStruct$ListOfKeyboardButton messagingStruct$ListOfKeyboardButton) {
        messagingStruct$ListOfKeyboardButton.getClass();
        ensureListOfKeyboardListIsMutable();
        this.listOfKeyboardList_.set(i, messagingStruct$ListOfKeyboardButton);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ReplyKeyboardMarkup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"listOfKeyboardList_", MessagingStruct$ListOfKeyboardButton.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ReplyKeyboardMarkup.class) {
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

    public MessagingStruct$ListOfKeyboardButton getListOfKeyboardList(int i) {
        return (MessagingStruct$ListOfKeyboardButton) this.listOfKeyboardList_.get(i);
    }

    public int getListOfKeyboardListCount() {
        return this.listOfKeyboardList_.size();
    }

    public List<MessagingStruct$ListOfKeyboardButton> getListOfKeyboardListList() {
        return this.listOfKeyboardList_;
    }

    public InterfaceC8462Wb4 getListOfKeyboardListOrBuilder(int i) {
        return (InterfaceC8462Wb4) this.listOfKeyboardList_.get(i);
    }

    public List<? extends InterfaceC8462Wb4> getListOfKeyboardListOrBuilderList() {
        return this.listOfKeyboardList_;
    }

    public static a newBuilder(MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ReplyKeyboardMarkup);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addListOfKeyboardList(int i, MessagingStruct$ListOfKeyboardButton messagingStruct$ListOfKeyboardButton) {
        messagingStruct$ListOfKeyboardButton.getClass();
        ensureListOfKeyboardListIsMutable();
        this.listOfKeyboardList_.add(i, messagingStruct$ListOfKeyboardButton);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(byte[] bArr) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(InputStream inputStream) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ReplyKeyboardMarkup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardMarkup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
