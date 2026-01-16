package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7287Rb4;
import ir.nasim.InterfaceC8462Wb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$ListOfKeyboardButton extends GeneratedMessageLite implements InterfaceC8462Wb4 {
    private static final MessagingStruct$ListOfKeyboardButton DEFAULT_INSTANCE;
    public static final int KEYBOARD_LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j keyboardList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8462Wb4 {
        private a() {
            super(MessagingStruct$ListOfKeyboardButton.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ListOfKeyboardButton messagingStruct$ListOfKeyboardButton = new MessagingStruct$ListOfKeyboardButton();
        DEFAULT_INSTANCE = messagingStruct$ListOfKeyboardButton;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ListOfKeyboardButton.class, messagingStruct$ListOfKeyboardButton);
    }

    private MessagingStruct$ListOfKeyboardButton() {
    }

    private void addAllKeyboardList(Iterable<? extends MessagingStruct$KeyboardButton> iterable) {
        ensureKeyboardListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.keyboardList_);
    }

    private void addKeyboardList(MessagingStruct$KeyboardButton messagingStruct$KeyboardButton) {
        messagingStruct$KeyboardButton.getClass();
        ensureKeyboardListIsMutable();
        this.keyboardList_.add(messagingStruct$KeyboardButton);
    }

    private void clearKeyboardList() {
        this.keyboardList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureKeyboardListIsMutable() {
        B.j jVar = this.keyboardList_;
        if (jVar.u()) {
            return;
        }
        this.keyboardList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$ListOfKeyboardButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ListOfKeyboardButton parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeKeyboardList(int i) {
        ensureKeyboardListIsMutable();
        this.keyboardList_.remove(i);
    }

    private void setKeyboardList(int i, MessagingStruct$KeyboardButton messagingStruct$KeyboardButton) {
        messagingStruct$KeyboardButton.getClass();
        ensureKeyboardListIsMutable();
        this.keyboardList_.set(i, messagingStruct$KeyboardButton);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ListOfKeyboardButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"keyboardList_", MessagingStruct$KeyboardButton.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ListOfKeyboardButton.class) {
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

    public MessagingStruct$KeyboardButton getKeyboardList(int i) {
        return (MessagingStruct$KeyboardButton) this.keyboardList_.get(i);
    }

    public int getKeyboardListCount() {
        return this.keyboardList_.size();
    }

    public List<MessagingStruct$KeyboardButton> getKeyboardListList() {
        return this.keyboardList_;
    }

    public InterfaceC7287Rb4 getKeyboardListOrBuilder(int i) {
        return (InterfaceC7287Rb4) this.keyboardList_.get(i);
    }

    public List<? extends InterfaceC7287Rb4> getKeyboardListOrBuilderList() {
        return this.keyboardList_;
    }

    public static a newBuilder(MessagingStruct$ListOfKeyboardButton messagingStruct$ListOfKeyboardButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ListOfKeyboardButton);
    }

    public static MessagingStruct$ListOfKeyboardButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addKeyboardList(int i, MessagingStruct$KeyboardButton messagingStruct$KeyboardButton) {
        messagingStruct$KeyboardButton.getClass();
        ensureKeyboardListIsMutable();
        this.keyboardList_.add(i, messagingStruct$KeyboardButton);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(byte[] bArr) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(InputStream inputStream) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ListOfKeyboardButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ListOfKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
