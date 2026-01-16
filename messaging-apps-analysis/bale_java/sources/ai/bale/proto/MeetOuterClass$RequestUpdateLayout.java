package ai.bale.proto;

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
public final class MeetOuterClass$RequestUpdateLayout extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestUpdateLayout DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTED_LAYOUT_FIELD_NUMBER = 2;
    private long callId_;
    private String requestedLayout_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$RequestUpdateLayout.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestUpdateLayout meetOuterClass$RequestUpdateLayout = new MeetOuterClass$RequestUpdateLayout();
        DEFAULT_INSTANCE = meetOuterClass$RequestUpdateLayout;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestUpdateLayout.class, meetOuterClass$RequestUpdateLayout);
    }

    private MeetOuterClass$RequestUpdateLayout() {
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearRequestedLayout() {
        this.requestedLayout_ = getDefaultInstance().getRequestedLayout();
    }

    public static MeetOuterClass$RequestUpdateLayout getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestUpdateLayout parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setRequestedLayout(String str) {
        str.getClass();
        this.requestedLayout_ = str;
    }

    private void setRequestedLayoutBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requestedLayout_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestUpdateLayout();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"callId_", "requestedLayout_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestUpdateLayout.class) {
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

    public String getRequestedLayout() {
        return this.requestedLayout_;
    }

    public AbstractC2383g getRequestedLayoutBytes() {
        return AbstractC2383g.N(this.requestedLayout_);
    }

    public static a newBuilder(MeetOuterClass$RequestUpdateLayout meetOuterClass$RequestUpdateLayout) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestUpdateLayout);
    }

    public static MeetOuterClass$RequestUpdateLayout parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestUpdateLayout parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestUpdateLayout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
