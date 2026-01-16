package ai.bale.proto;

import ai.bale.proto.AdvertisementOuterClass$RequestGetAllIssues;
import ai.bale.proto.AdvertisementOuterClass$RequestGetUserIssue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetCRMIssues extends GeneratedMessageLite implements U64 {
    public static final int ALL_ISSUE_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$RequestGetCRMIssues DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ISSUE_FIELD_NUMBER = 1;
    private int requestCase_ = 0;
    private Object request_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetCRMIssues.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        USER_ISSUE(1),
        ALL_ISSUE(2),
        REQUEST_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return REQUEST_NOT_SET;
            }
            if (i == 1) {
                return USER_ISSUE;
            }
            if (i != 2) {
                return null;
            }
            return ALL_ISSUE;
        }
    }

    static {
        AdvertisementOuterClass$RequestGetCRMIssues advertisementOuterClass$RequestGetCRMIssues = new AdvertisementOuterClass$RequestGetCRMIssues();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetCRMIssues;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetCRMIssues.class, advertisementOuterClass$RequestGetCRMIssues);
    }

    private AdvertisementOuterClass$RequestGetCRMIssues() {
    }

    private void clearAllIssue() {
        if (this.requestCase_ == 2) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    private void clearUserIssue() {
        if (this.requestCase_ == 1) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAllIssue(AdvertisementOuterClass$RequestGetAllIssues advertisementOuterClass$RequestGetAllIssues) {
        advertisementOuterClass$RequestGetAllIssues.getClass();
        if (this.requestCase_ != 2 || this.request_ == AdvertisementOuterClass$RequestGetAllIssues.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestGetAllIssues;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestGetAllIssues.a) AdvertisementOuterClass$RequestGetAllIssues.newBuilder((AdvertisementOuterClass$RequestGetAllIssues) this.request_).v(advertisementOuterClass$RequestGetAllIssues)).j();
        }
        this.requestCase_ = 2;
    }

    private void mergeUserIssue(AdvertisementOuterClass$RequestGetUserIssue advertisementOuterClass$RequestGetUserIssue) {
        advertisementOuterClass$RequestGetUserIssue.getClass();
        if (this.requestCase_ != 1 || this.request_ == AdvertisementOuterClass$RequestGetUserIssue.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestGetUserIssue;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestGetUserIssue.a) AdvertisementOuterClass$RequestGetUserIssue.newBuilder((AdvertisementOuterClass$RequestGetUserIssue) this.request_).v(advertisementOuterClass$RequestGetUserIssue)).j();
        }
        this.requestCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAllIssue(AdvertisementOuterClass$RequestGetAllIssues advertisementOuterClass$RequestGetAllIssues) {
        advertisementOuterClass$RequestGetAllIssues.getClass();
        this.request_ = advertisementOuterClass$RequestGetAllIssues;
        this.requestCase_ = 2;
    }

    private void setUserIssue(AdvertisementOuterClass$RequestGetUserIssue advertisementOuterClass$RequestGetUserIssue) {
        advertisementOuterClass$RequestGetUserIssue.getClass();
        this.request_ = advertisementOuterClass$RequestGetUserIssue;
        this.requestCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetCRMIssues();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"request_", "requestCase_", AdvertisementOuterClass$RequestGetUserIssue.class, AdvertisementOuterClass$RequestGetAllIssues.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetCRMIssues.class) {
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

    public AdvertisementOuterClass$RequestGetAllIssues getAllIssue() {
        return this.requestCase_ == 2 ? (AdvertisementOuterClass$RequestGetAllIssues) this.request_ : AdvertisementOuterClass$RequestGetAllIssues.getDefaultInstance();
    }

    public b getRequestCase() {
        return b.j(this.requestCase_);
    }

    public AdvertisementOuterClass$RequestGetUserIssue getUserIssue() {
        return this.requestCase_ == 1 ? (AdvertisementOuterClass$RequestGetUserIssue) this.request_ : AdvertisementOuterClass$RequestGetUserIssue.getDefaultInstance();
    }

    public boolean hasAllIssue() {
        return this.requestCase_ == 2;
    }

    public boolean hasUserIssue() {
        return this.requestCase_ == 1;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetCRMIssues advertisementOuterClass$RequestGetCRMIssues) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetCRMIssues);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetCRMIssues parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCRMIssues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
