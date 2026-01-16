package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16260ky3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetPredictionsByMatchIdResponse extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetPredictionsByMatchIdResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREDICTIONS_FIELD_NUMBER = 1;
    private B.j predictions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetPredictionsByMatchIdResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetPredictionsByMatchIdResponse leagueOuterClass$GetPredictionsByMatchIdResponse = new LeagueOuterClass$GetPredictionsByMatchIdResponse();
        DEFAULT_INSTANCE = leagueOuterClass$GetPredictionsByMatchIdResponse;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetPredictionsByMatchIdResponse.class, leagueOuterClass$GetPredictionsByMatchIdResponse);
    }

    private LeagueOuterClass$GetPredictionsByMatchIdResponse() {
    }

    private void addAllPredictions(Iterable<? extends LeagueOuterClass$Prediction> iterable) {
        ensurePredictionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.predictions_);
    }

    private void addPredictions(LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        leagueOuterClass$Prediction.getClass();
        ensurePredictionsIsMutable();
        this.predictions_.add(leagueOuterClass$Prediction);
    }

    private void clearPredictions() {
        this.predictions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePredictionsIsMutable() {
        B.j jVar = this.predictions_;
        if (jVar.u()) {
            return;
        }
        this.predictions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePredictions(int i) {
        ensurePredictionsIsMutable();
        this.predictions_.remove(i);
    }

    private void setPredictions(int i, LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        leagueOuterClass$Prediction.getClass();
        ensurePredictionsIsMutable();
        this.predictions_.set(i, leagueOuterClass$Prediction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetPredictionsByMatchIdResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"predictions_", LeagueOuterClass$Prediction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetPredictionsByMatchIdResponse.class) {
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

    public LeagueOuterClass$Prediction getPredictions(int i) {
        return (LeagueOuterClass$Prediction) this.predictions_.get(i);
    }

    public int getPredictionsCount() {
        return this.predictions_.size();
    }

    public List<LeagueOuterClass$Prediction> getPredictionsList() {
        return this.predictions_;
    }

    public InterfaceC16260ky3 getPredictionsOrBuilder(int i) {
        return (InterfaceC16260ky3) this.predictions_.get(i);
    }

    public List<? extends InterfaceC16260ky3> getPredictionsOrBuilderList() {
        return this.predictions_;
    }

    public static a newBuilder(LeagueOuterClass$GetPredictionsByMatchIdResponse leagueOuterClass$GetPredictionsByMatchIdResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetPredictionsByMatchIdResponse);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPredictions(int i, LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        leagueOuterClass$Prediction.getClass();
        ensurePredictionsIsMutable();
        this.predictions_.add(i, leagueOuterClass$Prediction);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
