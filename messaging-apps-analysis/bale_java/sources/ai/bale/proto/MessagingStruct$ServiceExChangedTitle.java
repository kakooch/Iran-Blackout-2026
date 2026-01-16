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
public final class MessagingStruct$ServiceExChangedTitle extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExChangedTitle DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExChangedTitle.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExChangedTitle messagingStruct$ServiceExChangedTitle = new MessagingStruct$ServiceExChangedTitle();
        DEFAULT_INSTANCE = messagingStruct$ServiceExChangedTitle;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExChangedTitle.class, messagingStruct$ServiceExChangedTitle);
    }

    private MessagingStruct$ServiceExChangedTitle() {
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static MessagingStruct$ServiceExChangedTitle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExChangedTitle parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
                return new MessagingStruct$ServiceExChangedTitle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExChangedTitle.class) {
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

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MessagingStruct$ServiceExChangedTitle messagingStruct$ServiceExChangedTitle) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExChangedTitle);
    }

    public static MessagingStruct$ServiceExChangedTitle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExChangedTitle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
