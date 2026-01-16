package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PresenceOuterClass$RequestGetContactsPresences extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestGetContactsPresences DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private Int32Value limit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$RequestGetContactsPresences.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestGetContactsPresences presenceOuterClass$RequestGetContactsPresences = new PresenceOuterClass$RequestGetContactsPresences();
        DEFAULT_INSTANCE = presenceOuterClass$RequestGetContactsPresences;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestGetContactsPresences.class, presenceOuterClass$RequestGetContactsPresences);
    }

    private PresenceOuterClass$RequestGetContactsPresences() {
    }

    private void clearLimit() {
        this.limit_ = null;
        this.bitField0_ &= -2;
    }

    public static PresenceOuterClass$RequestGetContactsPresences getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLimit(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.limit_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.limit_ = int32Value;
        } else {
            this.limit_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.limit_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLimit(Int32Value int32Value) {
        int32Value.getClass();
        this.limit_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestGetContactsPresences();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestGetContactsPresences.class) {
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

    public Int32Value getLimit() {
        Int32Value int32Value = this.limit_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasLimit() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PresenceOuterClass$RequestGetContactsPresences presenceOuterClass$RequestGetContactsPresences) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestGetContactsPresences);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestGetContactsPresences parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetContactsPresences) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
