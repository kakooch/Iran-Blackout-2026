package ai.bale.proto;

import ai.bale.proto.LeagueOuterClass$Prediction;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$AddPredictionRequest extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$AddPredictionRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREDICTION_FIELD_NUMBER = 1;
    private int bitField0_;
    private LeagueOuterClass$Prediction prediction_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$AddPredictionRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$AddPredictionRequest leagueOuterClass$AddPredictionRequest = new LeagueOuterClass$AddPredictionRequest();
        DEFAULT_INSTANCE = leagueOuterClass$AddPredictionRequest;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$AddPredictionRequest.class, leagueOuterClass$AddPredictionRequest);
    }

    private LeagueOuterClass$AddPredictionRequest() {
    }

    private void clearPrediction() {
        this.prediction_ = null;
        this.bitField0_ &= -2;
    }

    public static LeagueOuterClass$AddPredictionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePrediction(LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        leagueOuterClass$Prediction.getClass();
        LeagueOuterClass$Prediction leagueOuterClass$Prediction2 = this.prediction_;
        if (leagueOuterClass$Prediction2 == null || leagueOuterClass$Prediction2 == LeagueOuterClass$Prediction.getDefaultInstance()) {
            this.prediction_ = leagueOuterClass$Prediction;
        } else {
            this.prediction_ = (LeagueOuterClass$Prediction) ((LeagueOuterClass$Prediction.a) LeagueOuterClass$Prediction.newBuilder(this.prediction_).v(leagueOuterClass$Prediction)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$AddPredictionRequest parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPrediction(LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        leagueOuterClass$Prediction.getClass();
        this.prediction_ = leagueOuterClass$Prediction;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$AddPredictionRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "prediction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$AddPredictionRequest.class) {
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

    public LeagueOuterClass$Prediction getPrediction() {
        LeagueOuterClass$Prediction leagueOuterClass$Prediction = this.prediction_;
        return leagueOuterClass$Prediction == null ? LeagueOuterClass$Prediction.getDefaultInstance() : leagueOuterClass$Prediction;
    }

    public boolean hasPrediction() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LeagueOuterClass$AddPredictionRequest leagueOuterClass$AddPredictionRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$AddPredictionRequest);
    }

    public static LeagueOuterClass$AddPredictionRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(byte[] bArr) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$AddPredictionRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$AddPredictionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
