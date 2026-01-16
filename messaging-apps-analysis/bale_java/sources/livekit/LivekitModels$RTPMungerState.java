package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$RTPMungerState extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$RTPMungerState DEFAULT_INSTANCE;
    public static final int EXT_LAST_SEQUENCE_NUMBER_FIELD_NUMBER = 1;
    public static final int EXT_LAST_TIMESTAMP_FIELD_NUMBER = 3;
    public static final int EXT_SECOND_LAST_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int EXT_SECOND_LAST_TIMESTAMP_FIELD_NUMBER = 4;
    public static final int LAST_MARKER_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SECOND_LAST_MARKER_FIELD_NUMBER = 6;
    private long extLastSequenceNumber_;
    private long extLastTimestamp_;
    private long extSecondLastSequenceNumber_;
    private long extSecondLastTimestamp_;
    private boolean lastMarker_;
    private boolean secondLastMarker_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RTPMungerState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RTPMungerState livekitModels$RTPMungerState = new LivekitModels$RTPMungerState();
        DEFAULT_INSTANCE = livekitModels$RTPMungerState;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RTPMungerState.class, livekitModels$RTPMungerState);
    }

    private LivekitModels$RTPMungerState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtLastSequenceNumber() {
        this.extLastSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtLastTimestamp() {
        this.extLastTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtSecondLastSequenceNumber() {
        this.extSecondLastSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtSecondLastTimestamp() {
        this.extSecondLastTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastMarker() {
        this.lastMarker_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSecondLastMarker() {
        this.secondLastMarker_ = false;
    }

    public static LivekitModels$RTPMungerState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RTPMungerState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPMungerState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtLastSequenceNumber(long j) {
        this.extLastSequenceNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtLastTimestamp(long j) {
        this.extLastTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtSecondLastSequenceNumber(long j) {
        this.extSecondLastSequenceNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtSecondLastTimestamp(long j) {
        this.extSecondLastTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastMarker(boolean z) {
        this.lastMarker_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecondLastMarker(boolean z) {
        this.secondLastMarker_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RTPMungerState();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0003\u0002\u0003\u0003\u0003\u0004\u0003\u0005\u0007\u0006\u0007", new Object[]{"extLastSequenceNumber_", "extSecondLastSequenceNumber_", "extLastTimestamp_", "extSecondLastTimestamp_", "lastMarker_", "secondLastMarker_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RTPMungerState.class) {
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

    public long getExtLastSequenceNumber() {
        return this.extLastSequenceNumber_;
    }

    public long getExtLastTimestamp() {
        return this.extLastTimestamp_;
    }

    public long getExtSecondLastSequenceNumber() {
        return this.extSecondLastSequenceNumber_;
    }

    public long getExtSecondLastTimestamp() {
        return this.extSecondLastTimestamp_;
    }

    public boolean getLastMarker() {
        return this.lastMarker_;
    }

    public boolean getSecondLastMarker() {
        return this.secondLastMarker_;
    }

    public static a newBuilder(LivekitModels$RTPMungerState livekitModels$RTPMungerState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RTPMungerState);
    }

    public static LivekitModels$RTPMungerState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPMungerState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RTPMungerState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RTPMungerState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RTPMungerState parseFrom(byte[] bArr) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RTPMungerState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RTPMungerState parseFrom(InputStream inputStream) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPMungerState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPMungerState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RTPMungerState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RTPMungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
