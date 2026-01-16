package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$ResponseGetOngoingCalls extends GeneratedMessageLite implements U64 {
    public static final int CALL_LOGS_FIELD_NUMBER = 1;
    private static final MeetOuterClass$ResponseGetOngoingCalls DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j callLogs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$ResponseGetOngoingCalls.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$ResponseGetOngoingCalls meetOuterClass$ResponseGetOngoingCalls = new MeetOuterClass$ResponseGetOngoingCalls();
        DEFAULT_INSTANCE = meetOuterClass$ResponseGetOngoingCalls;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$ResponseGetOngoingCalls.class, meetOuterClass$ResponseGetOngoingCalls);
    }

    private MeetOuterClass$ResponseGetOngoingCalls() {
    }

    private void addAllCallLogs(Iterable<? extends MeetStruct$CallLog> iterable) {
        ensureCallLogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.callLogs_);
    }

    private void addCallLogs(MeetStruct$CallLog meetStruct$CallLog) {
        meetStruct$CallLog.getClass();
        ensureCallLogsIsMutable();
        this.callLogs_.add(meetStruct$CallLog);
    }

    private void clearCallLogs() {
        this.callLogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCallLogsIsMutable() {
        B.j jVar = this.callLogs_;
        if (jVar.u()) {
            return;
        }
        this.callLogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCallLogs(int i) {
        ensureCallLogsIsMutable();
        this.callLogs_.remove(i);
    }

    private void setCallLogs(int i, MeetStruct$CallLog meetStruct$CallLog) {
        meetStruct$CallLog.getClass();
        ensureCallLogsIsMutable();
        this.callLogs_.set(i, meetStruct$CallLog);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$ResponseGetOngoingCalls();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"callLogs_", MeetStruct$CallLog.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$ResponseGetOngoingCalls.class) {
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

    public MeetStruct$CallLog getCallLogs(int i) {
        return (MeetStruct$CallLog) this.callLogs_.get(i);
    }

    public int getCallLogsCount() {
        return this.callLogs_.size();
    }

    public List<MeetStruct$CallLog> getCallLogsList() {
        return this.callLogs_;
    }

    public H0 getCallLogsOrBuilder(int i) {
        return (H0) this.callLogs_.get(i);
    }

    public List<? extends H0> getCallLogsOrBuilderList() {
        return this.callLogs_;
    }

    public static a newBuilder(MeetOuterClass$ResponseGetOngoingCalls meetOuterClass$ResponseGetOngoingCalls) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$ResponseGetOngoingCalls);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCallLogs(int i, MeetStruct$CallLog meetStruct$CallLog) {
        meetStruct$CallLog.getClass();
        ensureCallLogsIsMutable();
        this.callLogs_.add(i, meetStruct$CallLog);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(byte[] bArr) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$ResponseGetOngoingCalls parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$ResponseGetOngoingCalls) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
