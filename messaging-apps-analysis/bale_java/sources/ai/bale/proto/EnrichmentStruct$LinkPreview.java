package ai.bale.proto;

import ai.bale.proto.EnrichmentStruct$OpenGraphObject;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11525d92;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EnrichmentStruct$LinkPreview extends GeneratedMessageLite implements U64 {
    private static final EnrichmentStruct$LinkPreview DEFAULT_INSTANCE;
    public static final int LINK_PREVIEW_TYPE_FIELD_NUMBER = 1;
    public static final int OPEN_GRAPH_OBJECT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int linkPreviewType_;
    private EnrichmentStruct$OpenGraphObject openGraphObject_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EnrichmentStruct$LinkPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview = new EnrichmentStruct$LinkPreview();
        DEFAULT_INSTANCE = enrichmentStruct$LinkPreview;
        GeneratedMessageLite.registerDefaultInstance(EnrichmentStruct$LinkPreview.class, enrichmentStruct$LinkPreview);
    }

    private EnrichmentStruct$LinkPreview() {
    }

    private void clearLinkPreviewType() {
        this.linkPreviewType_ = 0;
    }

    private void clearOpenGraphObject() {
        this.openGraphObject_ = null;
        this.bitField0_ &= -2;
    }

    public static EnrichmentStruct$LinkPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOpenGraphObject(EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject) {
        enrichmentStruct$OpenGraphObject.getClass();
        EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject2 = this.openGraphObject_;
        if (enrichmentStruct$OpenGraphObject2 == null || enrichmentStruct$OpenGraphObject2 == EnrichmentStruct$OpenGraphObject.getDefaultInstance()) {
            this.openGraphObject_ = enrichmentStruct$OpenGraphObject;
        } else {
            this.openGraphObject_ = (EnrichmentStruct$OpenGraphObject) ((EnrichmentStruct$OpenGraphObject.a) EnrichmentStruct$OpenGraphObject.newBuilder(this.openGraphObject_).v(enrichmentStruct$OpenGraphObject)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EnrichmentStruct$LinkPreview parseDelimitedFrom(InputStream inputStream) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(ByteBuffer byteBuffer) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLinkPreviewType(EnumC11525d92 enumC11525d92) {
        this.linkPreviewType_ = enumC11525d92.getNumber();
    }

    private void setLinkPreviewTypeValue(int i) {
        this.linkPreviewType_ = i;
    }

    private void setOpenGraphObject(EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject) {
        enrichmentStruct$OpenGraphObject.getClass();
        this.openGraphObject_ = enrichmentStruct$OpenGraphObject;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P.a[gVar.ordinal()]) {
            case 1:
                return new EnrichmentStruct$LinkPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "linkPreviewType_", "openGraphObject_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EnrichmentStruct$LinkPreview.class) {
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

    public EnumC11525d92 getLinkPreviewType() {
        EnumC11525d92 enumC11525d92J = EnumC11525d92.j(this.linkPreviewType_);
        return enumC11525d92J == null ? EnumC11525d92.UNRECOGNIZED : enumC11525d92J;
    }

    public int getLinkPreviewTypeValue() {
        return this.linkPreviewType_;
    }

    public EnrichmentStruct$OpenGraphObject getOpenGraphObject() {
        EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject = this.openGraphObject_;
        return enrichmentStruct$OpenGraphObject == null ? EnrichmentStruct$OpenGraphObject.getDefaultInstance() : enrichmentStruct$OpenGraphObject;
    }

    public boolean hasOpenGraphObject() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EnrichmentStruct$LinkPreview enrichmentStruct$LinkPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(enrichmentStruct$LinkPreview);
    }

    public static EnrichmentStruct$LinkPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(byte[] bArr) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(InputStream inputStream) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EnrichmentStruct$LinkPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EnrichmentStruct$LinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
