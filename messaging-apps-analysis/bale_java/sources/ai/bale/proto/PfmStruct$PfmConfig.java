package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmConfig extends GeneratedMessageLite implements U64 {
    private static final PfmStruct$PfmConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int64Value startDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmStruct$PfmConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmConfig pfmStruct$PfmConfig = new PfmStruct$PfmConfig();
        DEFAULT_INSTANCE = pfmStruct$PfmConfig;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmConfig.class, pfmStruct$PfmConfig);
    }

    private PfmStruct$PfmConfig() {
    }

    private void clearStartDate() {
        this.startDate_ = null;
        this.bitField0_ &= -2;
    }

    public static PfmStruct$PfmConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.startDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.startDate_ = collectionsStruct$Int64Value;
        } else {
            this.startDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.startDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmConfig parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmConfig parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStartDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.startDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "startDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmConfig.class) {
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

    public CollectionsStruct$Int64Value getStartDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.startDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasStartDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmStruct$PfmConfig pfmStruct$PfmConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmConfig);
    }

    public static PfmStruct$PfmConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmConfig parseFrom(byte[] bArr) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmConfig parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
