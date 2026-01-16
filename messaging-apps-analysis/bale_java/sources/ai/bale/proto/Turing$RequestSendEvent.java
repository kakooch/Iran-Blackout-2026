package ai.bale.proto;

import ai.bale.proto.TuringStruct$TranscriptReactionEvent;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Turing$RequestSendEvent extends GeneratedMessageLite implements U64 {
    private static final Turing$RequestSendEvent DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSCRIPTREACTIONEVENT_FIELD_NUMBER = 1;
    private int eventCase_ = 0;
    private Object event_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(TuringStruct$TranscriptReactionEvent turingStruct$TranscriptReactionEvent) {
            q();
            ((Turing$RequestSendEvent) this.b).setTranscriptReactionEvent(turingStruct$TranscriptReactionEvent);
            return this;
        }

        private a() {
            super(Turing$RequestSendEvent.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        TRANSCRIPTREACTIONEVENT(1),
        EVENT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return EVENT_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return TRANSCRIPTREACTIONEVENT;
        }
    }

    static {
        Turing$RequestSendEvent turing$RequestSendEvent = new Turing$RequestSendEvent();
        DEFAULT_INSTANCE = turing$RequestSendEvent;
        GeneratedMessageLite.registerDefaultInstance(Turing$RequestSendEvent.class, turing$RequestSendEvent);
    }

    private Turing$RequestSendEvent() {
    }

    private void clearEvent() {
        this.eventCase_ = 0;
        this.event_ = null;
    }

    private void clearTranscriptReactionEvent() {
        if (this.eventCase_ == 1) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    public static Turing$RequestSendEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTranscriptReactionEvent(TuringStruct$TranscriptReactionEvent turingStruct$TranscriptReactionEvent) {
        turingStruct$TranscriptReactionEvent.getClass();
        if (this.eventCase_ != 1 || this.event_ == TuringStruct$TranscriptReactionEvent.getDefaultInstance()) {
            this.event_ = turingStruct$TranscriptReactionEvent;
        } else {
            this.event_ = ((TuringStruct$TranscriptReactionEvent.a) TuringStruct$TranscriptReactionEvent.newBuilder((TuringStruct$TranscriptReactionEvent) this.event_).v(turingStruct$TranscriptReactionEvent)).j();
        }
        this.eventCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Turing$RequestSendEvent parseDelimitedFrom(InputStream inputStream) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$RequestSendEvent parseFrom(ByteBuffer byteBuffer) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranscriptReactionEvent(TuringStruct$TranscriptReactionEvent turingStruct$TranscriptReactionEvent) {
        turingStruct$TranscriptReactionEvent.getClass();
        this.event_ = turingStruct$TranscriptReactionEvent;
        this.eventCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (m2.a[gVar.ordinal()]) {
            case 1:
                return new Turing$RequestSendEvent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"event_", "eventCase_", TuringStruct$TranscriptReactionEvent.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Turing$RequestSendEvent.class) {
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

    public b getEventCase() {
        return b.j(this.eventCase_);
    }

    public TuringStruct$TranscriptReactionEvent getTranscriptReactionEvent() {
        return this.eventCase_ == 1 ? (TuringStruct$TranscriptReactionEvent) this.event_ : TuringStruct$TranscriptReactionEvent.getDefaultInstance();
    }

    public boolean hasTranscriptReactionEvent() {
        return this.eventCase_ == 1;
    }

    public static a newBuilder(Turing$RequestSendEvent turing$RequestSendEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(turing$RequestSendEvent);
    }

    public static Turing$RequestSendEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$RequestSendEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Turing$RequestSendEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Turing$RequestSendEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Turing$RequestSendEvent parseFrom(byte[] bArr) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Turing$RequestSendEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Turing$RequestSendEvent parseFrom(InputStream inputStream) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$RequestSendEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$RequestSendEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Turing$RequestSendEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Turing$RequestSendEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
