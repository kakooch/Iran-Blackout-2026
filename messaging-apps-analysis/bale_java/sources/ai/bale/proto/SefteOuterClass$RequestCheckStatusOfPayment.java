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

/* loaded from: classes.dex */
public final class SefteOuterClass$RequestCheckStatusOfPayment extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$RequestCheckStatusOfPayment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQ_ID_FIELD_NUMBER = 1;
    private String reqId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestCheckStatusOfPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestCheckStatusOfPayment sefteOuterClass$RequestCheckStatusOfPayment = new SefteOuterClass$RequestCheckStatusOfPayment();
        DEFAULT_INSTANCE = sefteOuterClass$RequestCheckStatusOfPayment;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestCheckStatusOfPayment.class, sefteOuterClass$RequestCheckStatusOfPayment);
    }

    private SefteOuterClass$RequestCheckStatusOfPayment() {
    }

    private void clearReqId() {
        this.reqId_ = getDefaultInstance().getReqId();
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReqId(String str) {
        str.getClass();
        this.reqId_ = str;
    }

    private void setReqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reqId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestCheckStatusOfPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"reqId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestCheckStatusOfPayment.class) {
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

    public String getReqId() {
        return this.reqId_;
    }

    public AbstractC2383g getReqIdBytes() {
        return AbstractC2383g.N(this.reqId_);
    }

    public static a newBuilder(SefteOuterClass$RequestCheckStatusOfPayment sefteOuterClass$RequestCheckStatusOfPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestCheckStatusOfPayment);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestCheckStatusOfPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestCheckStatusOfPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
