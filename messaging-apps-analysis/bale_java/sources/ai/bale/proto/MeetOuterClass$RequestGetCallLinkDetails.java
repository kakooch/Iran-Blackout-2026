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
public final class MeetOuterClass$RequestGetCallLinkDetails extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestGetCallLinkDetails DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SESSION_FIELD_NUMBER = 1;
    private String session_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((MeetOuterClass$RequestGetCallLinkDetails) this.b).setSession(str);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestGetCallLinkDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestGetCallLinkDetails meetOuterClass$RequestGetCallLinkDetails = new MeetOuterClass$RequestGetCallLinkDetails();
        DEFAULT_INSTANCE = meetOuterClass$RequestGetCallLinkDetails;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestGetCallLinkDetails.class, meetOuterClass$RequestGetCallLinkDetails);
    }

    private MeetOuterClass$RequestGetCallLinkDetails() {
    }

    private void clearSession() {
        this.session_ = getDefaultInstance().getSession();
    }

    public static MeetOuterClass$RequestGetCallLinkDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSession(String str) {
        str.getClass();
        this.session_ = str;
    }

    private void setSessionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.session_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestGetCallLinkDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"session_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestGetCallLinkDetails.class) {
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

    public String getSession() {
        return this.session_;
    }

    public AbstractC2383g getSessionBytes() {
        return AbstractC2383g.N(this.session_);
    }

    public static a newBuilder(MeetOuterClass$RequestGetCallLinkDetails meetOuterClass$RequestGetCallLinkDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestGetCallLinkDetails);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestGetCallLinkDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestGetCallLinkDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
