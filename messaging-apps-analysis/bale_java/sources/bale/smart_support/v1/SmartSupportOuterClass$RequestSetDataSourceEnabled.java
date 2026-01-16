package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestSetDataSourceEnabled extends GeneratedMessageLite implements U64 {
    public static final int DATASOURCE_ID_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$RequestSetDataSourceEnabled DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long datasourceId_;
    private boolean enabled_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestSetDataSourceEnabled.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestSetDataSourceEnabled smartSupportOuterClass$RequestSetDataSourceEnabled = new SmartSupportOuterClass$RequestSetDataSourceEnabled();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestSetDataSourceEnabled;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestSetDataSourceEnabled.class, smartSupportOuterClass$RequestSetDataSourceEnabled);
    }

    private SmartSupportOuterClass$RequestSetDataSourceEnabled() {
    }

    private void clearDatasourceId() {
        this.datasourceId_ = 0L;
    }

    private void clearEnabled() {
        this.enabled_ = false;
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDatasourceId(long j) {
        this.datasourceId_ = j;
    }

    private void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestSetDataSourceEnabled();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0007", new Object[]{"datasourceId_", "enabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestSetDataSourceEnabled.class) {
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

    public long getDatasourceId() {
        return this.datasourceId_;
    }

    public boolean getEnabled() {
        return this.enabled_;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestSetDataSourceEnabled smartSupportOuterClass$RequestSetDataSourceEnabled) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestSetDataSourceEnabled);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestSetDataSourceEnabled parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestSetDataSourceEnabled) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
