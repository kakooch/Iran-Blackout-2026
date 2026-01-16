package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageTag;
import ai.bale.proto.MessagingStruct$TextMessageEx;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$TextMessage DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 3;
    public static final int MENTIONS_FIELD_NUMBER = 2;
    public static final int MESSAGE_TAG_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$TextMessageEx ext_;
    private MessagingStruct$MessageTag messageTag_;
    private int mentionsMemoizedSerializedSize = -1;
    private String text_ = "";
    private B.g mentions_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MessagingStruct$TextMessage) this.b).addAllMentions(iterable);
            return this;
        }

        public a B(String str) {
            q();
            ((MessagingStruct$TextMessage) this.b).setText(str);
            return this;
        }

        private a() {
            super(MessagingStruct$TextMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextMessage messagingStruct$TextMessage = new MessagingStruct$TextMessage();
        DEFAULT_INSTANCE = messagingStruct$TextMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextMessage.class, messagingStruct$TextMessage);
    }

    private MessagingStruct$TextMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMentions(Iterable<? extends Integer> iterable) {
        ensureMentionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.mentions_);
    }

    private void addMentions(int i) {
        ensureMentionsIsMutable();
        this.mentions_.b1(i);
    }

    private void clearExt() {
        this.ext_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMentions() {
        this.mentions_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearMessageTag() {
        this.messageTag_ = null;
        this.bitField0_ &= -3;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void ensureMentionsIsMutable() {
        B.g gVar = this.mentions_;
        if (gVar.u()) {
            return;
        }
        this.mentions_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingStruct$TextMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExt(MessagingStruct$TextMessageEx messagingStruct$TextMessageEx) {
        messagingStruct$TextMessageEx.getClass();
        MessagingStruct$TextMessageEx messagingStruct$TextMessageEx2 = this.ext_;
        if (messagingStruct$TextMessageEx2 == null || messagingStruct$TextMessageEx2 == MessagingStruct$TextMessageEx.getDefaultInstance()) {
            this.ext_ = messagingStruct$TextMessageEx;
        } else {
            this.ext_ = (MessagingStruct$TextMessageEx) ((MessagingStruct$TextMessageEx.a) MessagingStruct$TextMessageEx.newBuilder(this.ext_).v(messagingStruct$TextMessageEx)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMessageTag(MessagingStruct$MessageTag messagingStruct$MessageTag) {
        messagingStruct$MessageTag.getClass();
        MessagingStruct$MessageTag messagingStruct$MessageTag2 = this.messageTag_;
        if (messagingStruct$MessageTag2 == null || messagingStruct$MessageTag2 == MessagingStruct$MessageTag.getDefaultInstance()) {
            this.messageTag_ = messagingStruct$MessageTag;
        } else {
            this.messageTag_ = (MessagingStruct$MessageTag) ((MessagingStruct$MessageTag.a) MessagingStruct$MessageTag.newBuilder(this.messageTag_).v(messagingStruct$MessageTag)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExt(MessagingStruct$TextMessageEx messagingStruct$TextMessageEx) {
        messagingStruct$TextMessageEx.getClass();
        this.ext_ = messagingStruct$TextMessageEx;
        this.bitField0_ |= 1;
    }

    private void setMentions(int i, int i2) {
        ensureMentionsIsMutable();
        this.mentions_.U(i, i2);
    }

    private void setMessageTag(MessagingStruct$MessageTag messagingStruct$MessageTag) {
        messagingStruct$MessageTag.getClass();
        this.messageTag_ = messagingStruct$MessageTag;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002'\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "text_", "mentions_", "ext_", "messageTag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextMessage.class) {
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

    public MessagingStruct$TextMessageEx getExt() {
        MessagingStruct$TextMessageEx messagingStruct$TextMessageEx = this.ext_;
        return messagingStruct$TextMessageEx == null ? MessagingStruct$TextMessageEx.getDefaultInstance() : messagingStruct$TextMessageEx;
    }

    public int getMentions(int i) {
        return this.mentions_.getInt(i);
    }

    public int getMentionsCount() {
        return this.mentions_.size();
    }

    public List<Integer> getMentionsList() {
        return this.mentions_;
    }

    public MessagingStruct$MessageTag getMessageTag() {
        MessagingStruct$MessageTag messagingStruct$MessageTag = this.messageTag_;
        return messagingStruct$MessageTag == null ? MessagingStruct$MessageTag.getDefaultInstance() : messagingStruct$MessageTag;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public boolean hasExt() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMessageTag() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextMessage);
    }

    public static MessagingStruct$TextMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TextMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
