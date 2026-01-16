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
public final class MessagingStruct$LoginUrl extends GeneratedMessageLite implements U64 {
    public static final int BOT_USERNAME_FIELD_NUMBER = 3;
    private static final MessagingStruct$LoginUrl DEFAULT_INSTANCE;
    public static final int FORWARD_TEXT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_WRITE_ACCESS_FIELD_NUMBER = 4;
    public static final int URL_FIELD_NUMBER = 1;
    private boolean requestWriteAccess_;
    private String url_ = "";
    private String forwardText_ = "";
    private String botUsername_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$LoginUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$LoginUrl messagingStruct$LoginUrl = new MessagingStruct$LoginUrl();
        DEFAULT_INSTANCE = messagingStruct$LoginUrl;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$LoginUrl.class, messagingStruct$LoginUrl);
    }

    private MessagingStruct$LoginUrl() {
    }

    private void clearBotUsername() {
        this.botUsername_ = getDefaultInstance().getBotUsername();
    }

    private void clearForwardText() {
        this.forwardText_ = getDefaultInstance().getForwardText();
    }

    private void clearRequestWriteAccess() {
        this.requestWriteAccess_ = false;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static MessagingStruct$LoginUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$LoginUrl parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$LoginUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUsername(String str) {
        str.getClass();
        this.botUsername_ = str;
    }

    private void setBotUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botUsername_ = abstractC2383g.f0();
    }

    private void setForwardText(String str) {
        str.getClass();
        this.forwardText_ = str;
    }

    private void setForwardTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.forwardText_ = abstractC2383g.f0();
    }

    private void setRequestWriteAccess(boolean z) {
        this.requestWriteAccess_ = z;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$LoginUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007", new Object[]{"url_", "forwardText_", "botUsername_", "requestWriteAccess_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$LoginUrl.class) {
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

    public String getBotUsername() {
        return this.botUsername_;
    }

    public AbstractC2383g getBotUsernameBytes() {
        return AbstractC2383g.N(this.botUsername_);
    }

    public String getForwardText() {
        return this.forwardText_;
    }

    public AbstractC2383g getForwardTextBytes() {
        return AbstractC2383g.N(this.forwardText_);
    }

    public boolean getRequestWriteAccess() {
        return this.requestWriteAccess_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(MessagingStruct$LoginUrl messagingStruct$LoginUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$LoginUrl);
    }

    public static MessagingStruct$LoginUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$LoginUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$LoginUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$LoginUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$LoginUrl parseFrom(InputStream inputStream) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$LoginUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$LoginUrl parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$LoginUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$LoginUrl parseFrom(byte[] bArr) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$LoginUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$LoginUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
