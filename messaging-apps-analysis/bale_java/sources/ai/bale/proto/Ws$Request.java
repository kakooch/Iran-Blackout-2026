package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ws$Request extends GeneratedMessageLite implements U64 {
    private static final Ws$Request DEFAULT_INSTANCE;
    public static final int INDEX_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 4;
    public static final int METHOD_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 3;
    public static final int SERVICE_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private long index_;
    private CollectionsStruct$MapValue metadata_;
    private String serviceName_ = "";
    private String method_ = "";
    private AbstractC2383g payload_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$Request.DEFAULT_INSTANCE);
        }
    }

    static {
        Ws$Request ws$Request = new Ws$Request();
        DEFAULT_INSTANCE = ws$Request;
        GeneratedMessageLite.registerDefaultInstance(Ws$Request.class, ws$Request);
    }

    private Ws$Request() {
    }

    private void clearIndex() {
        this.index_ = 0L;
    }

    private void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMethod() {
        this.method_ = getDefaultInstance().getMethod();
    }

    private void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    private void clearServiceName() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    public static Ws$Request getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMetadata(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.metadata_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.metadata_ = collectionsStruct$MapValue;
        } else {
            this.metadata_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.metadata_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$Request parseDelimitedFrom(InputStream inputStream) {
        return (Ws$Request) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Request parseFrom(ByteBuffer byteBuffer) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIndex(long j) {
        this.index_ = j;
    }

    private void setMetadata(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.metadata_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    private void setMethod(String str) {
        str.getClass();
        this.method_ = str;
    }

    private void setMethodBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.method_ = abstractC2383g.f0();
    }

    private void setPayload(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.payload_ = abstractC2383g;
    }

    private void setServiceName(String str) {
        str.getClass();
        this.serviceName_ = str;
    }

    private void setServiceNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$Request();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\n\u0004ဉ\u0000\u0005\u0002", new Object[]{"bitField0_", "serviceName_", "method_", "payload_", "metadata_", "index_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$Request.class) {
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

    public long getIndex() {
        return this.index_;
    }

    public CollectionsStruct$MapValue getMetadata() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.metadata_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public String getMethod() {
        return this.method_;
    }

    public AbstractC2383g getMethodBytes() {
        return AbstractC2383g.N(this.method_);
    }

    public AbstractC2383g getPayload() {
        return this.payload_;
    }

    public String getServiceName() {
        return this.serviceName_;
    }

    public AbstractC2383g getServiceNameBytes() {
        return AbstractC2383g.N(this.serviceName_);
    }

    public boolean hasMetadata() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Ws$Request ws$Request) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$Request);
    }

    public static Ws$Request parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Request parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$Request parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$Request parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$Request parseFrom(byte[] bArr) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$Request parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$Request parseFrom(InputStream inputStream) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Request parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Request parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$Request parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
