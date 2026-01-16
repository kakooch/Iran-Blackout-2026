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
public final class MessagingStruct$WebAppInfo extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$WebAppInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$WebAppInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$WebAppInfo messagingStruct$WebAppInfo = new MessagingStruct$WebAppInfo();
        DEFAULT_INSTANCE = messagingStruct$WebAppInfo;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$WebAppInfo.class, messagingStruct$WebAppInfo);
    }

    private MessagingStruct$WebAppInfo() {
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static MessagingStruct$WebAppInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$WebAppInfo parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$WebAppInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
                return new MessagingStruct$WebAppInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$WebAppInfo.class) {
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

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(MessagingStruct$WebAppInfo messagingStruct$WebAppInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$WebAppInfo);
    }

    public static MessagingStruct$WebAppInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$WebAppInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$WebAppInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$WebAppInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$WebAppInfo parseFrom(InputStream inputStream) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$WebAppInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$WebAppInfo parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$WebAppInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$WebAppInfo parseFrom(byte[] bArr) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$WebAppInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$WebAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
