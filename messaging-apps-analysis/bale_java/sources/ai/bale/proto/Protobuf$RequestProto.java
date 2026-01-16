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

/* loaded from: classes9.dex */
public final class Protobuf$RequestProto extends GeneratedMessageLite implements U64 {
    private static final Protobuf$RequestProto DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 3;
    public static final int METHOD_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$MapValue metadata_;
    private String method_ = "";
    private AbstractC2383g payload_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Protobuf$RequestProto.DEFAULT_INSTANCE);
        }
    }

    static {
        Protobuf$RequestProto protobuf$RequestProto = new Protobuf$RequestProto();
        DEFAULT_INSTANCE = protobuf$RequestProto;
        GeneratedMessageLite.registerDefaultInstance(Protobuf$RequestProto.class, protobuf$RequestProto);
    }

    private Protobuf$RequestProto() {
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

    public static Protobuf$RequestProto getDefaultInstance() {
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

    public static Protobuf$RequestProto parseDelimitedFrom(InputStream inputStream) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Protobuf$RequestProto parseFrom(ByteBuffer byteBuffer) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1875m1.a[gVar.ordinal()]) {
            case 1:
                return new Protobuf$RequestProto();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003ဉ\u0000", new Object[]{"bitField0_", "method_", "payload_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Protobuf$RequestProto.class) {
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

    public boolean hasMetadata() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Protobuf$RequestProto protobuf$RequestProto) {
        return (a) DEFAULT_INSTANCE.createBuilder(protobuf$RequestProto);
    }

    public static Protobuf$RequestProto parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Protobuf$RequestProto parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Protobuf$RequestProto parseFrom(AbstractC2383g abstractC2383g) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Protobuf$RequestProto parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Protobuf$RequestProto parseFrom(byte[] bArr) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Protobuf$RequestProto parseFrom(byte[] bArr, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Protobuf$RequestProto parseFrom(InputStream inputStream) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Protobuf$RequestProto parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Protobuf$RequestProto parseFrom(AbstractC2384h abstractC2384h) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Protobuf$RequestProto parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Protobuf$RequestProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
