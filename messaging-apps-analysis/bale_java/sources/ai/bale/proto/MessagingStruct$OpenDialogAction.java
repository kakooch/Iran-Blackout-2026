package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$OpenDialogAction extends GeneratedMessageLite implements U64 {
    public static final int AGREE_BUTTON_FIELD_NUMBER = 3;
    private static final MessagingStruct$OpenDialogAction DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISAGREE_BUTTON_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";
    private String description_ = "";
    private String agreeButton_ = "";
    private String disagreeButton_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$OpenDialogAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$OpenDialogAction messagingStruct$OpenDialogAction = new MessagingStruct$OpenDialogAction();
        DEFAULT_INSTANCE = messagingStruct$OpenDialogAction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$OpenDialogAction.class, messagingStruct$OpenDialogAction);
    }

    private MessagingStruct$OpenDialogAction() {
    }

    private void clearAgreeButton() {
        this.agreeButton_ = getDefaultInstance().getAgreeButton();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDisagreeButton() {
        this.disagreeButton_ = getDefaultInstance().getDisagreeButton();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static MessagingStruct$OpenDialogAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$OpenDialogAction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAgreeButton(String str) {
        str.getClass();
        this.agreeButton_ = str;
    }

    private void setAgreeButtonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agreeButton_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setDisagreeButton(String str) {
        str.getClass();
        this.disagreeButton_ = str;
    }

    private void setDisagreeButtonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.disagreeButton_ = abstractC2383g.f0();
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
                return new MessagingStruct$OpenDialogAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"title_", "description_", "agreeButton_", "disagreeButton_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$OpenDialogAction.class) {
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

    public String getAgreeButton() {
        return this.agreeButton_;
    }

    public AbstractC2383g getAgreeButtonBytes() {
        return AbstractC2383g.N(this.agreeButton_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getDisagreeButton() {
        return this.disagreeButton_;
    }

    public AbstractC2383g getDisagreeButtonBytes() {
        return AbstractC2383g.N(this.disagreeButton_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MessagingStruct$OpenDialogAction messagingStruct$OpenDialogAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$OpenDialogAction);
    }

    public static MessagingStruct$OpenDialogAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(InputStream inputStream) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(byte[] bArr) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$OpenDialogAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$OpenDialogAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
