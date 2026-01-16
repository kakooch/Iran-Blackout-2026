package ai.bale.proto;

import ai.bale.proto.KetfStruct$KetfPagination;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestGetBots extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$RequestGetBots DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private KetfStruct$KetfPagination pagination_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetBots.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestGetBots ketfOuterClass$RequestGetBots = new KetfOuterClass$RequestGetBots();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetBots;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetBots.class, ketfOuterClass$RequestGetBots);
    }

    private KetfOuterClass$RequestGetBots() {
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$RequestGetBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagination(KetfStruct$KetfPagination ketfStruct$KetfPagination) {
        ketfStruct$KetfPagination.getClass();
        KetfStruct$KetfPagination ketfStruct$KetfPagination2 = this.pagination_;
        if (ketfStruct$KetfPagination2 == null || ketfStruct$KetfPagination2 == KetfStruct$KetfPagination.getDefaultInstance()) {
            this.pagination_ = ketfStruct$KetfPagination;
        } else {
            this.pagination_ = (KetfStruct$KetfPagination) ((KetfStruct$KetfPagination.a) KetfStruct$KetfPagination.newBuilder(this.pagination_).v(ketfStruct$KetfPagination)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestGetBots parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPagination(KetfStruct$KetfPagination ketfStruct$KetfPagination) {
        ketfStruct$KetfPagination.getClass();
        this.pagination_ = ketfStruct$KetfPagination;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestGetBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetBots.class) {
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

    public KetfStruct$KetfPagination getPagination() {
        KetfStruct$KetfPagination ketfStruct$KetfPagination = this.pagination_;
        return ketfStruct$KetfPagination == null ? KetfStruct$KetfPagination.getDefaultInstance() : ketfStruct$KetfPagination;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestGetBots ketfOuterClass$RequestGetBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetBots);
    }

    public static KetfOuterClass$RequestGetBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
