package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionId;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestGetTransactionTags extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestGetTransactionTags DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PfmStruct$PfmTransactionId id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$RequestGetTransactionTags.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestGetTransactionTags pfmOuterClass$RequestGetTransactionTags = new PfmOuterClass$RequestGetTransactionTags();
        DEFAULT_INSTANCE = pfmOuterClass$RequestGetTransactionTags;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestGetTransactionTags.class, pfmOuterClass$RequestGetTransactionTags);
    }

    private PfmOuterClass$RequestGetTransactionTags() {
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -2;
    }

    public static PfmOuterClass$RequestGetTransactionTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId2 = this.id_;
        if (pfmStruct$PfmTransactionId2 == null || pfmStruct$PfmTransactionId2 == PfmStruct$PfmTransactionId.getDefaultInstance()) {
            this.id_ = pfmStruct$PfmTransactionId;
        } else {
            this.id_ = (PfmStruct$PfmTransactionId) ((PfmStruct$PfmTransactionId.a) PfmStruct$PfmTransactionId.newBuilder(this.id_).v(pfmStruct$PfmTransactionId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestGetTransactionTags parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        this.id_ = pfmStruct$PfmTransactionId;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestGetTransactionTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestGetTransactionTags.class) {
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

    public PfmStruct$PfmTransactionId getId() {
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = this.id_;
        return pfmStruct$PfmTransactionId == null ? PfmStruct$PfmTransactionId.getDefaultInstance() : pfmStruct$PfmTransactionId;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$RequestGetTransactionTags pfmOuterClass$RequestGetTransactionTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestGetTransactionTags);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestGetTransactionTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
