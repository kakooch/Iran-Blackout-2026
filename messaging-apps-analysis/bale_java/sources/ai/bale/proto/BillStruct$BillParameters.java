package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class BillStruct$BillParameters extends GeneratedMessageLite implements U64 {
    private static final BillStruct$BillParameters DEFAULT_INSTANCE;
    public static final int PARAMETERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private com.google.protobuf.J parameters_ = com.google.protobuf.J.e();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillStruct$BillParameters.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        BillStruct$BillParameters billStruct$BillParameters = new BillStruct$BillParameters();
        DEFAULT_INSTANCE = billStruct$BillParameters;
        GeneratedMessageLite.registerDefaultInstance(BillStruct$BillParameters.class, billStruct$BillParameters);
    }

    private BillStruct$BillParameters() {
    }

    public static BillStruct$BillParameters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableParametersMap() {
        return internalGetMutableParameters();
    }

    private com.google.protobuf.J internalGetMutableParameters() {
        if (!this.parameters_.n()) {
            this.parameters_ = this.parameters_.s();
        }
        return this.parameters_;
    }

    private com.google.protobuf.J internalGetParameters() {
        return this.parameters_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillStruct$BillParameters parseDelimitedFrom(InputStream inputStream) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$BillParameters parseFrom(ByteBuffer byteBuffer) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public boolean containsParameters(String str) {
        str.getClass();
        return internalGetParameters().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1890s.a[gVar.ordinal()]) {
            case 1:
                return new BillStruct$BillParameters();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"parameters_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillStruct$BillParameters.class) {
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

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getParameters() {
        return getParametersMap();
    }

    public int getParametersCount() {
        return internalGetParameters().size();
    }

    public Map<String, CollectionsStruct$RawValue> getParametersMap() {
        return Collections.unmodifiableMap(internalGetParameters());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getParametersOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetParameters = internalGetParameters();
        return jInternalGetParameters.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetParameters.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getParametersOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetParameters = internalGetParameters();
        if (jInternalGetParameters.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetParameters.get(str);
        }
        throw new IllegalArgumentException();
    }

    public static a newBuilder(BillStruct$BillParameters billStruct$BillParameters) {
        return (a) DEFAULT_INSTANCE.createBuilder(billStruct$BillParameters);
    }

    public static BillStruct$BillParameters parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$BillParameters parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillStruct$BillParameters parseFrom(AbstractC2383g abstractC2383g) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillStruct$BillParameters parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillStruct$BillParameters parseFrom(byte[] bArr) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillStruct$BillParameters parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillStruct$BillParameters parseFrom(InputStream inputStream) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillStruct$BillParameters parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillStruct$BillParameters parseFrom(AbstractC2384h abstractC2384h) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillStruct$BillParameters parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillStruct$BillParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
