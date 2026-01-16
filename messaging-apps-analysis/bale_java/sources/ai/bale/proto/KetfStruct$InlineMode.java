package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$InlineMode extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$InlineMode DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PLACEHOLDER_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean enabled_;
    private CollectionsStruct$StringValue placeholder_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$InlineMode.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$InlineMode ketfStruct$InlineMode = new KetfStruct$InlineMode();
        DEFAULT_INSTANCE = ketfStruct$InlineMode;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$InlineMode.class, ketfStruct$InlineMode);
    }

    private KetfStruct$InlineMode() {
    }

    private void clearEnabled() {
        this.enabled_ = false;
    }

    private void clearPlaceholder() {
        this.placeholder_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfStruct$InlineMode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePlaceholder(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.placeholder_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.placeholder_ = collectionsStruct$StringValue;
        } else {
            this.placeholder_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.placeholder_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$InlineMode parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$InlineMode parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    private void setPlaceholder(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.placeholder_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$InlineMode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000", new Object[]{"bitField0_", "enabled_", "placeholder_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$InlineMode.class) {
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

    public boolean getEnabled() {
        return this.enabled_;
    }

    public CollectionsStruct$StringValue getPlaceholder() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.placeholder_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasPlaceholder() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfStruct$InlineMode ketfStruct$InlineMode) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$InlineMode);
    }

    public static KetfStruct$InlineMode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$InlineMode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$InlineMode parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$InlineMode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$InlineMode parseFrom(byte[] bArr) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$InlineMode parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$InlineMode parseFrom(InputStream inputStream) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$InlineMode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$InlineMode parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$InlineMode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$InlineMode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
