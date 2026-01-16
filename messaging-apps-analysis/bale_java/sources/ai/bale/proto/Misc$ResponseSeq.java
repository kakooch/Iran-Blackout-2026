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
public final class Misc$ResponseSeq extends GeneratedMessageLite implements U64 {
    private static final Misc$ResponseSeq DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    private int seq_;
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Misc$ResponseSeq.DEFAULT_INSTANCE);
        }
    }

    static {
        Misc$ResponseSeq misc$ResponseSeq = new Misc$ResponseSeq();
        DEFAULT_INSTANCE = misc$ResponseSeq;
        GeneratedMessageLite.registerDefaultInstance(Misc$ResponseSeq.class, misc$ResponseSeq);
    }

    private Misc$ResponseSeq() {
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    public static Misc$ResponseSeq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Misc$ResponseSeq parseDelimitedFrom(InputStream inputStream) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseSeq parseFrom(ByteBuffer byteBuffer) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N0.a[gVar.ordinal()]) {
            case 1:
                return new Misc$ResponseSeq();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\n", new Object[]{"seq_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Misc$ResponseSeq.class) {
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

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public static a newBuilder(Misc$ResponseSeq misc$ResponseSeq) {
        return (a) DEFAULT_INSTANCE.createBuilder(misc$ResponseSeq);
    }

    public static Misc$ResponseSeq parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseSeq parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Misc$ResponseSeq parseFrom(AbstractC2383g abstractC2383g) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Misc$ResponseSeq parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Misc$ResponseSeq parseFrom(byte[] bArr) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Misc$ResponseSeq parseFrom(byte[] bArr, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Misc$ResponseSeq parseFrom(InputStream inputStream) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseSeq parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseSeq parseFrom(AbstractC2384h abstractC2384h) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Misc$ResponseSeq parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Misc$ResponseSeq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
