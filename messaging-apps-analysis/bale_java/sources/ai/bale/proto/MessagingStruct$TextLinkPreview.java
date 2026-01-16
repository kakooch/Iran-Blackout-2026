package ai.bale.proto;

import ai.bale.proto.EnrichmentStruct$LinkPreview;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextLinkPreview extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$TextLinkPreview DEFAULT_INSTANCE;
    public static final int LINK_PREVIEW_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private EnrichmentStruct$LinkPreview linkPreview_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TextLinkPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextLinkPreview messagingStruct$TextLinkPreview = new MessagingStruct$TextLinkPreview();
        DEFAULT_INSTANCE = messagingStruct$TextLinkPreview;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextLinkPreview.class, messagingStruct$TextLinkPreview);
    }

    private MessagingStruct$TextLinkPreview() {
    }

    private void clearLinkPreview() {
        this.linkPreview_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$TextLinkPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLinkPreview(EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview) {
        enrichmentStruct$LinkPreview.getClass();
        EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview2 = this.linkPreview_;
        if (enrichmentStruct$LinkPreview2 == null || enrichmentStruct$LinkPreview2 == EnrichmentStruct$LinkPreview.getDefaultInstance()) {
            this.linkPreview_ = enrichmentStruct$LinkPreview;
        } else {
            this.linkPreview_ = (EnrichmentStruct$LinkPreview) ((EnrichmentStruct$LinkPreview.a) EnrichmentStruct$LinkPreview.newBuilder(this.linkPreview_).v(enrichmentStruct$LinkPreview)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextLinkPreview parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLinkPreview(EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview) {
        enrichmentStruct$LinkPreview.getClass();
        this.linkPreview_ = enrichmentStruct$LinkPreview;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextLinkPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "linkPreview_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextLinkPreview.class) {
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

    public EnrichmentStruct$LinkPreview getLinkPreview() {
        EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview = this.linkPreview_;
        return enrichmentStruct$LinkPreview == null ? EnrichmentStruct$LinkPreview.getDefaultInstance() : enrichmentStruct$LinkPreview;
    }

    public boolean hasLinkPreview() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$TextLinkPreview messagingStruct$TextLinkPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextLinkPreview);
    }

    public static MessagingStruct$TextLinkPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(byte[] bArr) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextLinkPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
