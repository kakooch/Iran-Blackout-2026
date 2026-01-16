package ai.bale.proto;

import ai.bale.proto.FilesStruct$Color;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ParagraphStyle extends GeneratedMessageLite implements U64 {
    public static final int BG_COLOR_FIELD_NUMBER = 3;
    private static final MessagingStruct$ParagraphStyle DEFAULT_INSTANCE;
    public static final int PARAGRAPH_COLOR_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_PARAGRAPH_FIELD_NUMBER = 1;
    private FilesStruct$Color bgColor_;
    private int bitField0_;
    private FilesStruct$Color paragraphColor_;
    private BoolValue showParagraph_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ParagraphStyle.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle = new MessagingStruct$ParagraphStyle();
        DEFAULT_INSTANCE = messagingStruct$ParagraphStyle;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ParagraphStyle.class, messagingStruct$ParagraphStyle);
    }

    private MessagingStruct$ParagraphStyle() {
    }

    private void clearBgColor() {
        this.bgColor_ = null;
        this.bitField0_ &= -5;
    }

    private void clearParagraphColor() {
        this.paragraphColor_ = null;
        this.bitField0_ &= -3;
    }

    private void clearShowParagraph() {
        this.showParagraph_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ParagraphStyle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBgColor(FilesStruct$Color filesStruct$Color) {
        filesStruct$Color.getClass();
        FilesStruct$Color filesStruct$Color2 = this.bgColor_;
        if (filesStruct$Color2 == null || filesStruct$Color2 == FilesStruct$Color.getDefaultInstance()) {
            this.bgColor_ = filesStruct$Color;
        } else {
            this.bgColor_ = (FilesStruct$Color) ((FilesStruct$Color.a) FilesStruct$Color.newBuilder(this.bgColor_).v(filesStruct$Color)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeParagraphColor(FilesStruct$Color filesStruct$Color) {
        filesStruct$Color.getClass();
        FilesStruct$Color filesStruct$Color2 = this.paragraphColor_;
        if (filesStruct$Color2 == null || filesStruct$Color2 == FilesStruct$Color.getDefaultInstance()) {
            this.paragraphColor_ = filesStruct$Color;
        } else {
            this.paragraphColor_ = (FilesStruct$Color) ((FilesStruct$Color.a) FilesStruct$Color.newBuilder(this.paragraphColor_).v(filesStruct$Color)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeShowParagraph(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.showParagraph_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.showParagraph_ = boolValue;
        } else {
            this.showParagraph_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.showParagraph_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ParagraphStyle parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBgColor(FilesStruct$Color filesStruct$Color) {
        filesStruct$Color.getClass();
        this.bgColor_ = filesStruct$Color;
        this.bitField0_ |= 4;
    }

    private void setParagraphColor(FilesStruct$Color filesStruct$Color) {
        filesStruct$Color.getClass();
        this.paragraphColor_ = filesStruct$Color;
        this.bitField0_ |= 2;
    }

    private void setShowParagraph(BoolValue boolValue) {
        boolValue.getClass();
        this.showParagraph_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ParagraphStyle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "showParagraph_", "paragraphColor_", "bgColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ParagraphStyle.class) {
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

    public FilesStruct$Color getBgColor() {
        FilesStruct$Color filesStruct$Color = this.bgColor_;
        return filesStruct$Color == null ? FilesStruct$Color.getDefaultInstance() : filesStruct$Color;
    }

    public FilesStruct$Color getParagraphColor() {
        FilesStruct$Color filesStruct$Color = this.paragraphColor_;
        return filesStruct$Color == null ? FilesStruct$Color.getDefaultInstance() : filesStruct$Color;
    }

    public BoolValue getShowParagraph() {
        BoolValue boolValue = this.showParagraph_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasBgColor() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasParagraphColor() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasShowParagraph() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ParagraphStyle messagingStruct$ParagraphStyle) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ParagraphStyle);
    }

    public static MessagingStruct$ParagraphStyle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(byte[] bArr) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(InputStream inputStream) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ParagraphStyle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ParagraphStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
