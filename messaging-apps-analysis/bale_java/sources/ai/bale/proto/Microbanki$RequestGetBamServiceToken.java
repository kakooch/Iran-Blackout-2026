package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.O60;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Microbanki$RequestGetBamServiceToken extends GeneratedMessageLite implements U64 {
    private static final Microbanki$RequestGetBamServiceToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 1;
    private int service_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(O60 o60) {
            q();
            ((Microbanki$RequestGetBamServiceToken) this.b).setService(o60);
            return this;
        }

        private a() {
            super(Microbanki$RequestGetBamServiceToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Microbanki$RequestGetBamServiceToken microbanki$RequestGetBamServiceToken = new Microbanki$RequestGetBamServiceToken();
        DEFAULT_INSTANCE = microbanki$RequestGetBamServiceToken;
        GeneratedMessageLite.registerDefaultInstance(Microbanki$RequestGetBamServiceToken.class, microbanki$RequestGetBamServiceToken);
    }

    private Microbanki$RequestGetBamServiceToken() {
    }

    private void clearService() {
        this.service_ = 0;
    }

    public static Microbanki$RequestGetBamServiceToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Microbanki$RequestGetBamServiceToken parseDelimitedFrom(InputStream inputStream) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(ByteBuffer byteBuffer) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setService(O60 o60) {
        this.service_ = o60.getNumber();
    }

    private void setServiceValue(int i) {
        this.service_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M0.a[gVar.ordinal()]) {
            case 1:
                return new Microbanki$RequestGetBamServiceToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"service_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Microbanki$RequestGetBamServiceToken.class) {
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

    public O60 getService() {
        O60 o60J = O60.j(this.service_);
        return o60J == null ? O60.UNRECOGNIZED : o60J;
    }

    public int getServiceValue() {
        return this.service_;
    }

    public static a newBuilder(Microbanki$RequestGetBamServiceToken microbanki$RequestGetBamServiceToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(microbanki$RequestGetBamServiceToken);
    }

    public static Microbanki$RequestGetBamServiceToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(byte[] bArr) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(InputStream inputStream) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Microbanki$RequestGetBamServiceToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Microbanki$RequestGetBamServiceToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
