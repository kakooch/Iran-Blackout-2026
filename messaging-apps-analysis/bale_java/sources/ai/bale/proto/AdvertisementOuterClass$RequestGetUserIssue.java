package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetUserIssue extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetUserIssue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetUserIssue.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetUserIssue advertisementOuterClass$RequestGetUserIssue = new AdvertisementOuterClass$RequestGetUserIssue();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetUserIssue;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetUserIssue.class, advertisementOuterClass$RequestGetUserIssue);
    }

    private AdvertisementOuterClass$RequestGetUserIssue() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetUserIssue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetUserIssue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetUserIssue.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetUserIssue advertisementOuterClass$RequestGetUserIssue) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetUserIssue);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetUserIssue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
