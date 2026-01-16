package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.NJ5;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RecommenderOuterClass$RequestGetGroupsRecommendation extends GeneratedMessageLite implements U64 {
    private static final RecommenderOuterClass$RequestGetGroupsRecommendation DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SOURCE_FIELD_NUMBER = 1;
    private int source_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(NJ5 nj5) {
            q();
            ((RecommenderOuterClass$RequestGetGroupsRecommendation) this.b).setSource(nj5);
            return this;
        }

        private a() {
            super(RecommenderOuterClass$RequestGetGroupsRecommendation.DEFAULT_INSTANCE);
        }
    }

    static {
        RecommenderOuterClass$RequestGetGroupsRecommendation recommenderOuterClass$RequestGetGroupsRecommendation = new RecommenderOuterClass$RequestGetGroupsRecommendation();
        DEFAULT_INSTANCE = recommenderOuterClass$RequestGetGroupsRecommendation;
        GeneratedMessageLite.registerDefaultInstance(RecommenderOuterClass$RequestGetGroupsRecommendation.class, recommenderOuterClass$RequestGetGroupsRecommendation);
    }

    private RecommenderOuterClass$RequestGetGroupsRecommendation() {
    }

    private void clearSource() {
        this.source_ = 0;
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseDelimitedFrom(InputStream inputStream) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(ByteBuffer byteBuffer) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(NJ5 nj5) {
        this.source_ = nj5.getNumber();
    }

    private void setSourceValue(int i) {
        this.source_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1895t1.a[gVar.ordinal()]) {
            case 1:
                return new RecommenderOuterClass$RequestGetGroupsRecommendation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"source_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RecommenderOuterClass$RequestGetGroupsRecommendation.class) {
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

    public NJ5 getSource() {
        NJ5 nj5J = NJ5.j(this.source_);
        return nj5J == null ? NJ5.UNRECOGNIZED : nj5J;
    }

    public int getSourceValue() {
        return this.source_;
    }

    public static a newBuilder(RecommenderOuterClass$RequestGetGroupsRecommendation recommenderOuterClass$RequestGetGroupsRecommendation) {
        return (a) DEFAULT_INSTANCE.createBuilder(recommenderOuterClass$RequestGetGroupsRecommendation);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(AbstractC2383g abstractC2383g) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(byte[] bArr) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(byte[] bArr, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(InputStream inputStream) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(AbstractC2384h abstractC2384h) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RecommenderOuterClass$RequestGetGroupsRecommendation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetGroupsRecommendation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
