package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.O04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestStartRecording extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestStartRecording DEFAULT_INSTANCE;
    public static final int LAYOUT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int QUALITY_FIELD_NUMBER = 3;
    private long callId_;
    private String layout_ = "";
    private int quality_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MeetOuterClass$RequestStartRecording) this.b).setCallId(j);
            return this;
        }

        public a B(O04 o04) {
            q();
            ((MeetOuterClass$RequestStartRecording) this.b).setQuality(o04);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestStartRecording.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestStartRecording meetOuterClass$RequestStartRecording = new MeetOuterClass$RequestStartRecording();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartRecording;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartRecording.class, meetOuterClass$RequestStartRecording);
    }

    private MeetOuterClass$RequestStartRecording() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearLayout() {
        this.layout_ = getDefaultInstance().getLayout();
    }

    private void clearQuality() {
        this.quality_ = 0;
    }

    public static MeetOuterClass$RequestStartRecording getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestStartRecording parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(long j) {
        this.callId_ = j;
    }

    private void setLayout(String str) {
        str.getClass();
        this.layout_ = str;
    }

    private void setLayoutBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.layout_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuality(O04 o04) {
        this.quality_ = o04.getNumber();
    }

    private void setQualityValue(int i) {
        this.quality_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartRecording();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\f", new Object[]{"callId_", "layout_", "quality_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartRecording.class) {
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

    public String getLayout() {
        return this.layout_;
    }

    public AbstractC2383g getLayoutBytes() {
        return AbstractC2383g.N(this.layout_);
    }

    public O04 getQuality() {
        O04 o04J = O04.j(this.quality_);
        return o04J == null ? O04.UNRECOGNIZED : o04J;
    }

    public int getQualityValue() {
        return this.quality_;
    }

    public static a newBuilder(MeetOuterClass$RequestStartRecording meetOuterClass$RequestStartRecording) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartRecording);
    }

    public static MeetOuterClass$RequestStartRecording parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartRecording parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartRecording) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
