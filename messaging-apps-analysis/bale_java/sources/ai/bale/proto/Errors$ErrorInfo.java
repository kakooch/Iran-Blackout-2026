package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
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
public final class Errors$ErrorInfo extends GeneratedMessageLite implements U64 {
    private static final Errors$ErrorInfo DEFAULT_INSTANCE;
    public static final int DOMAIN_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private com.google.protobuf.J metadata_ = com.google.protobuf.J.e();
    private String reason_ = "";
    private String domain_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Errors$ErrorInfo.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    static {
        Errors$ErrorInfo errors$ErrorInfo = new Errors$ErrorInfo();
        DEFAULT_INSTANCE = errors$ErrorInfo;
        GeneratedMessageLite.registerDefaultInstance(Errors$ErrorInfo.class, errors$ErrorInfo);
    }

    private Errors$ErrorInfo() {
    }

    private void clearDomain() {
        this.domain_ = getDefaultInstance().getDomain();
    }

    private void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    public static Errors$ErrorInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private com.google.protobuf.J internalGetMetadata() {
        return this.metadata_;
    }

    private com.google.protobuf.J internalGetMutableMetadata() {
        if (!this.metadata_.n()) {
            this.metadata_ = this.metadata_.s();
        }
        return this.metadata_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Errors$ErrorInfo parseDelimitedFrom(InputStream inputStream) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Errors$ErrorInfo parseFrom(ByteBuffer byteBuffer) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDomain(String str) {
        str.getClass();
        this.domain_ = str;
    }

    private void setDomainBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.domain_ = abstractC2383g.f0();
    }

    private void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    private void setReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reason_ = abstractC2383g.f0();
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Q.a[gVar.ordinal()]) {
            case 1:
                return new Errors$ErrorInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"reason_", "domain_", "metadata_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Errors$ErrorInfo.class) {
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

    public String getDomain() {
        return this.domain_;
    }

    public AbstractC2383g getDomainBytes() {
        return AbstractC2383g.N(this.domain_);
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetMetadata = internalGetMetadata();
        return jInternalGetMetadata.containsKey(str) ? (String) jInternalGetMetadata.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getMetadataOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetMetadata = internalGetMetadata();
        if (jInternalGetMetadata.containsKey(str)) {
            return (String) jInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getReason() {
        return this.reason_;
    }

    public AbstractC2383g getReasonBytes() {
        return AbstractC2383g.N(this.reason_);
    }

    public static a newBuilder(Errors$ErrorInfo errors$ErrorInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(errors$ErrorInfo);
    }

    public static Errors$ErrorInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Errors$ErrorInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Errors$ErrorInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Errors$ErrorInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Errors$ErrorInfo parseFrom(byte[] bArr) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Errors$ErrorInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Errors$ErrorInfo parseFrom(InputStream inputStream) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Errors$ErrorInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Errors$ErrorInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Errors$ErrorInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Errors$ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
