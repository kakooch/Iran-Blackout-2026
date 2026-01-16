package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.MessagingStruct$ParagraphStyle;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC5393Jd4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextModernMessage extends GeneratedMessageLite implements U64 {
    public static final int ATTACHES_FIELD_NUMBER = 5;
    private static final MessagingStruct$TextModernMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SENDER_NAME_OVERRIDE_FIELD_NUMBER = 2;
    public static final int SENDER_PHOTO_OVERRIDE_FIELD_NUMBER = 3;
    public static final int STYLE_FIELD_NUMBER = 4;
    public static final int TEXT_FIELD_NUMBER = 1;
    private B.j attaches_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private StringValue senderNameOverride_;
    private FilesStruct$Avatar senderPhotoOverride_;
    private MessagingStruct$ParagraphStyle style_;
    private StringValue text_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TextModernMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextModernMessage messagingStruct$TextModernMessage = new MessagingStruct$TextModernMessage();
        DEFAULT_INSTANCE = messagingStruct$TextModernMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextModernMessage.class, messagingStruct$TextModernMessage);
    }

    private MessagingStruct$TextModernMessage() {
    }

    private void addAllAttaches(Iterable<? extends MessagingStruct$TextModernAttach> iterable) {
        ensureAttachesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.attaches_);
    }

    private void addAttaches(MessagingStruct$TextModernAttach messagingStruct$TextModernAttach) {
        messagingStruct$TextModernAttach.getClass();
        ensureAttachesIsMutable();
        this.attaches_.add(messagingStruct$TextModernAttach);
    }

    private void clearAttaches() {
        this.attaches_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSenderNameOverride() {
        this.senderNameOverride_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSenderPhotoOverride() {
        this.senderPhotoOverride_ = null;
        this.bitField0_ &= -5;
    }

    private void clearStyle() {
        this.style_ = null;
        this.bitField0_ &= -9;
    }

    private void clearText() {
        this.text_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureAttachesIsMutable() {
        B.j jVar = this.attaches_;
        if (jVar.u()) {
            return;
        }
        this.attaches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$TextModernMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSenderNameOverride(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.senderNameOverride_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.senderNameOverride_ = stringValue;
        } else {
            this.senderNameOverride_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.senderNameOverride_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSenderPhotoOverride(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.senderPhotoOverride_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.senderPhotoOverride_ = filesStruct$Avatar;
        } else {
            this.senderPhotoOverride_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.senderPhotoOverride_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeStyle(MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle) {
        messagingStruct$ParagraphStyle.getClass();
        MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle2 = this.style_;
        if (messagingStruct$ParagraphStyle2 == null || messagingStruct$ParagraphStyle2 == MessagingStruct$ParagraphStyle.getDefaultInstance()) {
            this.style_ = messagingStruct$ParagraphStyle;
        } else {
            this.style_ = (MessagingStruct$ParagraphStyle) ((MessagingStruct$ParagraphStyle.a) MessagingStruct$ParagraphStyle.newBuilder(this.style_).v(messagingStruct$ParagraphStyle)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.text_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.text_ = stringValue;
        } else {
            this.text_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.text_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextModernMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAttaches(int i) {
        ensureAttachesIsMutable();
        this.attaches_.remove(i);
    }

    private void setAttaches(int i, MessagingStruct$TextModernAttach messagingStruct$TextModernAttach) {
        messagingStruct$TextModernAttach.getClass();
        ensureAttachesIsMutable();
        this.attaches_.set(i, messagingStruct$TextModernAttach);
    }

    private void setSenderNameOverride(StringValue stringValue) {
        stringValue.getClass();
        this.senderNameOverride_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setSenderPhotoOverride(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.senderPhotoOverride_ = filesStruct$Avatar;
        this.bitField0_ |= 4;
    }

    private void setStyle(MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle) {
        messagingStruct$ParagraphStyle.getClass();
        this.style_ = messagingStruct$ParagraphStyle;
        this.bitField0_ |= 8;
    }

    private void setText(StringValue stringValue) {
        stringValue.getClass();
        this.text_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextModernMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b", new Object[]{"bitField0_", "text_", "senderNameOverride_", "senderPhotoOverride_", "style_", "attaches_", MessagingStruct$TextModernAttach.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextModernMessage.class) {
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

    public MessagingStruct$TextModernAttach getAttaches(int i) {
        return (MessagingStruct$TextModernAttach) this.attaches_.get(i);
    }

    public int getAttachesCount() {
        return this.attaches_.size();
    }

    public List<MessagingStruct$TextModernAttach> getAttachesList() {
        return this.attaches_;
    }

    public InterfaceC5393Jd4 getAttachesOrBuilder(int i) {
        return (InterfaceC5393Jd4) this.attaches_.get(i);
    }

    public List<? extends InterfaceC5393Jd4> getAttachesOrBuilderList() {
        return this.attaches_;
    }

    public StringValue getSenderNameOverride() {
        StringValue stringValue = this.senderNameOverride_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$Avatar getSenderPhotoOverride() {
        FilesStruct$Avatar filesStruct$Avatar = this.senderPhotoOverride_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public MessagingStruct$ParagraphStyle getStyle() {
        MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle = this.style_;
        return messagingStruct$ParagraphStyle == null ? MessagingStruct$ParagraphStyle.getDefaultInstance() : messagingStruct$ParagraphStyle;
    }

    public StringValue getText() {
        StringValue stringValue = this.text_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasSenderNameOverride() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSenderPhotoOverride() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasText() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$TextModernMessage messagingStruct$TextModernMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextModernMessage);
    }

    public static MessagingStruct$TextModernMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextModernMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAttaches(int i, MessagingStruct$TextModernAttach messagingStruct$TextModernAttach) {
        messagingStruct$TextModernAttach.getClass();
        ensureAttachesIsMutable();
        this.attaches_.add(i, messagingStruct$TextModernAttach);
    }

    public static MessagingStruct$TextModernMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextModernMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextModernMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextModernMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextModernMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextModernMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
