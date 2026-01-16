package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestGetWssURL extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestGetWssURL DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long callId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestGetWssURL) this.b).setCallId(j);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestGetWssURL.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestGetWssURL meetOuterClass$RequestGetWssURL = new MeetOuterClass$RequestGetWssURL();
        DEFAULT_INSTANCE = meetOuterClass$RequestGetWssURL;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestGetWssURL.class, meetOuterClass$RequestGetWssURL);
    }

    private MeetOuterClass$RequestGetWssURL() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    public static MeetOuterClass$RequestGetWssURL getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestGetWssURL parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestGetWssURL();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"callId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestGetWssURL.class) {
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

    public long getCallId() {
        return this.callId_;
    }

    public static a newBuilder(MeetOuterClass$RequestGetWssURL meetOuterClass$RequestGetWssURL) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestGetWssURL);
    }

    public static MeetOuterClass$RequestGetWssURL parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestGetWssURL parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestGetWssURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
