package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.MessagingStruct$ParagraphStyle;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC5393Jd4;
import ir.nasim.InterfaceC5861Ld4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextModernAttach extends GeneratedMessageLite implements InterfaceC5393Jd4 {
    private static final MessagingStruct$TextModernAttach DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int STYLE_FIELD_NUMBER = 5;
    public static final int TEXT_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TITLE_ICON_FIELD_NUMBER = 3;
    public static final int TITLE_URL_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j fields_ = GeneratedMessageLite.emptyProtobufList();
    private MessagingStruct$ParagraphStyle style_;
    private StringValue text_;
    private FilesStruct$ImageLocation titleIcon_;
    private StringValue titleUrl_;
    private StringValue title_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5393Jd4 {
        private a() {
            super(MessagingStruct$TextModernAttach.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextModernAttach messagingStruct$TextModernAttach = new MessagingStruct$TextModernAttach();
        DEFAULT_INSTANCE = messagingStruct$TextModernAttach;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextModernAttach.class, messagingStruct$TextModernAttach);
    }

    private MessagingStruct$TextModernAttach() {
    }

    private void addAllFields(Iterable<? extends MessagingStruct$TextModernField> iterable) {
        ensureFieldsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fields_);
    }

    private void addFields(MessagingStruct$TextModernField messagingStruct$TextModernField) {
        messagingStruct$TextModernField.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(messagingStruct$TextModernField);
    }

    private void clearFields() {
        this.fields_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearStyle() {
        this.style_ = null;
        this.bitField0_ &= -17;
    }

    private void clearText() {
        this.text_ = null;
        this.bitField0_ &= -9;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitleIcon() {
        this.titleIcon_ = null;
        this.bitField0_ &= -5;
    }

    private void clearTitleUrl() {
        this.titleUrl_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureFieldsIsMutable() {
        B.j jVar = this.fields_;
        if (jVar.u()) {
            return;
        }
        this.fields_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$TextModernAttach getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStyle(MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle) {
        messagingStruct$ParagraphStyle.getClass();
        MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle2 = this.style_;
        if (messagingStruct$ParagraphStyle2 == null || messagingStruct$ParagraphStyle2 == MessagingStruct$ParagraphStyle.getDefaultInstance()) {
            this.style_ = messagingStruct$ParagraphStyle;
        } else {
            this.style_ = (MessagingStruct$ParagraphStyle) ((MessagingStruct$ParagraphStyle.a) MessagingStruct$ParagraphStyle.newBuilder(this.style_).v(messagingStruct$ParagraphStyle)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.text_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.text_ = stringValue;
        } else {
            this.text_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.text_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.title_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.title_ = stringValue;
        } else {
            this.title_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.title_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTitleIcon(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.titleIcon_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.titleIcon_ = filesStruct$ImageLocation;
        } else {
            this.titleIcon_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.titleIcon_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeTitleUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.titleUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.titleUrl_ = stringValue;
        } else {
            this.titleUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.titleUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextModernAttach parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernAttach parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFields(int i) {
        ensureFieldsIsMutable();
        this.fields_.remove(i);
    }

    private void setFields(int i, MessagingStruct$TextModernField messagingStruct$TextModernField) {
        messagingStruct$TextModernField.getClass();
        ensureFieldsIsMutable();
        this.fields_.set(i, messagingStruct$TextModernField);
    }

    private void setStyle(MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle) {
        messagingStruct$ParagraphStyle.getClass();
        this.style_ = messagingStruct$ParagraphStyle;
        this.bitField0_ |= 16;
    }

    private void setText(StringValue stringValue) {
        stringValue.getClass();
        this.text_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setTitle(StringValue stringValue) {
        stringValue.getClass();
        this.title_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setTitleIcon(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.titleIcon_ = filesStruct$ImageLocation;
        this.bitField0_ |= 4;
    }

    private void setTitleUrl(StringValue stringValue) {
        stringValue.getClass();
        this.titleUrl_ = stringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextModernAttach();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001b", new Object[]{"bitField0_", "title_", "titleUrl_", "titleIcon_", "text_", "style_", "fields_", MessagingStruct$TextModernField.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextModernAttach.class) {
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

    public MessagingStruct$TextModernField getFields(int i) {
        return (MessagingStruct$TextModernField) this.fields_.get(i);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List<MessagingStruct$TextModernField> getFieldsList() {
        return this.fields_;
    }

    public InterfaceC5861Ld4 getFieldsOrBuilder(int i) {
        return (InterfaceC5861Ld4) this.fields_.get(i);
    }

    public List<? extends InterfaceC5861Ld4> getFieldsOrBuilderList() {
        return this.fields_;
    }

    public MessagingStruct$ParagraphStyle getStyle() {
        MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle = this.style_;
        return messagingStruct$ParagraphStyle == null ? MessagingStruct$ParagraphStyle.getDefaultInstance() : messagingStruct$ParagraphStyle;
    }

    public StringValue getText() {
        StringValue stringValue = this.text_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getTitle() {
        StringValue stringValue = this.title_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$ImageLocation getTitleIcon() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.titleIcon_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public StringValue getTitleUrl() {
        StringValue stringValue = this.titleUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasText() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTitleIcon() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTitleUrl() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingStruct$TextModernAttach messagingStruct$TextModernAttach) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextModernAttach);
    }

    public static MessagingStruct$TextModernAttach parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernAttach parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextModernAttach parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFields(int i, MessagingStruct$TextModernField messagingStruct$TextModernField) {
        messagingStruct$TextModernField.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(i, messagingStruct$TextModernField);
    }

    public static MessagingStruct$TextModernAttach parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextModernAttach parseFrom(byte[] bArr) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextModernAttach parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextModernAttach parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernAttach parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernAttach parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextModernAttach parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextModernAttach) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
