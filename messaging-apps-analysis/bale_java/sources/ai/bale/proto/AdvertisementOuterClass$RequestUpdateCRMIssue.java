package ai.bale.proto;

import ai.bale.proto.AdvertisementOuterClass$RequestAddComment;
import ai.bale.proto.AdvertisementOuterClass$RequestAddIssue;
import ai.bale.proto.AdvertisementOuterClass$RequestIgnoreUserIssue;
import ai.bale.proto.AdvertisementOuterClass$RequestResolveIssue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestUpdateCRMIssue extends GeneratedMessageLite implements U64 {
    public static final int ADD_COMMENT_FIELD_NUMBER = 2;
    public static final int ADD_ISSUE_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestUpdateCRMIssue DEFAULT_INSTANCE;
    public static final int IGNORE_USER_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int RESOLVE_ISSUE_FIELD_NUMBER = 3;
    private int requestCase_ = 0;
    private Object request_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestUpdateCRMIssue.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        ADD_ISSUE(1),
        ADD_COMMENT(2),
        RESOLVE_ISSUE(3),
        IGNORE_USER(4),
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
                return ADD_ISSUE;
            }
            if (i == 2) {
                return ADD_COMMENT;
            }
            if (i == 3) {
                return RESOLVE_ISSUE;
            }
            if (i != 4) {
                return null;
            }
            return IGNORE_USER;
        }
    }

    static {
        AdvertisementOuterClass$RequestUpdateCRMIssue advertisementOuterClass$RequestUpdateCRMIssue = new AdvertisementOuterClass$RequestUpdateCRMIssue();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestUpdateCRMIssue;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestUpdateCRMIssue.class, advertisementOuterClass$RequestUpdateCRMIssue);
    }

    private AdvertisementOuterClass$RequestUpdateCRMIssue() {
    }

    private void clearAddComment() {
        if (this.requestCase_ == 2) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearAddIssue() {
        if (this.requestCase_ == 1) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearIgnoreUser() {
        if (this.requestCase_ == 4) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    private void clearResolveIssue() {
        if (this.requestCase_ == 3) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAddComment(AdvertisementOuterClass$RequestAddComment advertisementOuterClass$RequestAddComment) {
        advertisementOuterClass$RequestAddComment.getClass();
        if (this.requestCase_ != 2 || this.request_ == AdvertisementOuterClass$RequestAddComment.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestAddComment;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestAddComment.a) AdvertisementOuterClass$RequestAddComment.newBuilder((AdvertisementOuterClass$RequestAddComment) this.request_).v(advertisementOuterClass$RequestAddComment)).j();
        }
        this.requestCase_ = 2;
    }

    private void mergeAddIssue(AdvertisementOuterClass$RequestAddIssue advertisementOuterClass$RequestAddIssue) {
        advertisementOuterClass$RequestAddIssue.getClass();
        if (this.requestCase_ != 1 || this.request_ == AdvertisementOuterClass$RequestAddIssue.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestAddIssue;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestAddIssue.a) AdvertisementOuterClass$RequestAddIssue.newBuilder((AdvertisementOuterClass$RequestAddIssue) this.request_).v(advertisementOuterClass$RequestAddIssue)).j();
        }
        this.requestCase_ = 1;
    }

    private void mergeIgnoreUser(AdvertisementOuterClass$RequestIgnoreUserIssue advertisementOuterClass$RequestIgnoreUserIssue) {
        advertisementOuterClass$RequestIgnoreUserIssue.getClass();
        if (this.requestCase_ != 4 || this.request_ == AdvertisementOuterClass$RequestIgnoreUserIssue.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestIgnoreUserIssue;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestIgnoreUserIssue.a) AdvertisementOuterClass$RequestIgnoreUserIssue.newBuilder((AdvertisementOuterClass$RequestIgnoreUserIssue) this.request_).v(advertisementOuterClass$RequestIgnoreUserIssue)).j();
        }
        this.requestCase_ = 4;
    }

    private void mergeResolveIssue(AdvertisementOuterClass$RequestResolveIssue advertisementOuterClass$RequestResolveIssue) {
        advertisementOuterClass$RequestResolveIssue.getClass();
        if (this.requestCase_ != 3 || this.request_ == AdvertisementOuterClass$RequestResolveIssue.getDefaultInstance()) {
            this.request_ = advertisementOuterClass$RequestResolveIssue;
        } else {
            this.request_ = ((AdvertisementOuterClass$RequestResolveIssue.a) AdvertisementOuterClass$RequestResolveIssue.newBuilder((AdvertisementOuterClass$RequestResolveIssue) this.request_).v(advertisementOuterClass$RequestResolveIssue)).j();
        }
        this.requestCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddComment(AdvertisementOuterClass$RequestAddComment advertisementOuterClass$RequestAddComment) {
        advertisementOuterClass$RequestAddComment.getClass();
        this.request_ = advertisementOuterClass$RequestAddComment;
        this.requestCase_ = 2;
    }

    private void setAddIssue(AdvertisementOuterClass$RequestAddIssue advertisementOuterClass$RequestAddIssue) {
        advertisementOuterClass$RequestAddIssue.getClass();
        this.request_ = advertisementOuterClass$RequestAddIssue;
        this.requestCase_ = 1;
    }

    private void setIgnoreUser(AdvertisementOuterClass$RequestIgnoreUserIssue advertisementOuterClass$RequestIgnoreUserIssue) {
        advertisementOuterClass$RequestIgnoreUserIssue.getClass();
        this.request_ = advertisementOuterClass$RequestIgnoreUserIssue;
        this.requestCase_ = 4;
    }

    private void setResolveIssue(AdvertisementOuterClass$RequestResolveIssue advertisementOuterClass$RequestResolveIssue) {
        advertisementOuterClass$RequestResolveIssue.getClass();
        this.request_ = advertisementOuterClass$RequestResolveIssue;
        this.requestCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestUpdateCRMIssue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"request_", "requestCase_", AdvertisementOuterClass$RequestAddIssue.class, AdvertisementOuterClass$RequestAddComment.class, AdvertisementOuterClass$RequestResolveIssue.class, AdvertisementOuterClass$RequestIgnoreUserIssue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestUpdateCRMIssue.class) {
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

    public AdvertisementOuterClass$RequestAddComment getAddComment() {
        return this.requestCase_ == 2 ? (AdvertisementOuterClass$RequestAddComment) this.request_ : AdvertisementOuterClass$RequestAddComment.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestAddIssue getAddIssue() {
        return this.requestCase_ == 1 ? (AdvertisementOuterClass$RequestAddIssue) this.request_ : AdvertisementOuterClass$RequestAddIssue.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestIgnoreUserIssue getIgnoreUser() {
        return this.requestCase_ == 4 ? (AdvertisementOuterClass$RequestIgnoreUserIssue) this.request_ : AdvertisementOuterClass$RequestIgnoreUserIssue.getDefaultInstance();
    }

    public b getRequestCase() {
        return b.j(this.requestCase_);
    }

    public AdvertisementOuterClass$RequestResolveIssue getResolveIssue() {
        return this.requestCase_ == 3 ? (AdvertisementOuterClass$RequestResolveIssue) this.request_ : AdvertisementOuterClass$RequestResolveIssue.getDefaultInstance();
    }

    public boolean hasAddComment() {
        return this.requestCase_ == 2;
    }

    public boolean hasAddIssue() {
        return this.requestCase_ == 1;
    }

    public boolean hasIgnoreUser() {
        return this.requestCase_ == 4;
    }

    public boolean hasResolveIssue() {
        return this.requestCase_ == 3;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestUpdateCRMIssue advertisementOuterClass$RequestUpdateCRMIssue) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestUpdateCRMIssue);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestUpdateCRMIssue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateCRMIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
