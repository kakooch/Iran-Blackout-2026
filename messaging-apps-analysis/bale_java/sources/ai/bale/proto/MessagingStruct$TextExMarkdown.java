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
public final class MessagingStruct$TextExMarkdown extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$TextExMarkdown DEFAULT_INSTANCE;
    public static final int MARKDOWN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String markdown_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TextExMarkdown.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextExMarkdown messagingStruct$TextExMarkdown = new MessagingStruct$TextExMarkdown();
        DEFAULT_INSTANCE = messagingStruct$TextExMarkdown;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextExMarkdown.class, messagingStruct$TextExMarkdown);
    }

    private MessagingStruct$TextExMarkdown() {
    }

    private void clearMarkdown() {
        this.markdown_ = getDefaultInstance().getMarkdown();
    }

    public static MessagingStruct$TextExMarkdown getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextExMarkdown parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMarkdown(String str) {
        str.getClass();
        this.markdown_ = str;
    }

    private void setMarkdownBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.markdown_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextExMarkdown();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"markdown_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextExMarkdown.class) {
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

    public String getMarkdown() {
        return this.markdown_;
    }

    public AbstractC2383g getMarkdownBytes() {
        return AbstractC2383g.N(this.markdown_);
    }

    public static a newBuilder(MessagingStruct$TextExMarkdown messagingStruct$TextExMarkdown) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextExMarkdown);
    }

    public static MessagingStruct$TextExMarkdown parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(byte[] bArr) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextExMarkdown parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextExMarkdown) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
