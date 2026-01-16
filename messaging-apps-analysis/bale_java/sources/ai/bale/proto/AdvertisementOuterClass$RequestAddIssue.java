package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$CRMIssueData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestAddIssue extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestAddIssue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$CRMIssueData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestAddIssue.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestAddIssue advertisementOuterClass$RequestAddIssue = new AdvertisementOuterClass$RequestAddIssue();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestAddIssue;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestAddIssue.class, advertisementOuterClass$RequestAddIssue);
    }

    private AdvertisementOuterClass$RequestAddIssue() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestAddIssue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData) {
        advertisementStruct$CRMIssueData.getClass();
        AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData2 = this.data_;
        if (advertisementStruct$CRMIssueData2 == null || advertisementStruct$CRMIssueData2 == AdvertisementStruct$CRMIssueData.getDefaultInstance()) {
            this.data_ = advertisementStruct$CRMIssueData;
        } else {
            this.data_ = (AdvertisementStruct$CRMIssueData) ((AdvertisementStruct$CRMIssueData.a) AdvertisementStruct$CRMIssueData.newBuilder(this.data_).v(advertisementStruct$CRMIssueData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestAddIssue parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData) {
        advertisementStruct$CRMIssueData.getClass();
        this.data_ = advertisementStruct$CRMIssueData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestAddIssue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestAddIssue.class) {
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

    public AdvertisementStruct$CRMIssueData getData() {
        AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData = this.data_;
        return advertisementStruct$CRMIssueData == null ? AdvertisementStruct$CRMIssueData.getDefaultInstance() : advertisementStruct$CRMIssueData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestAddIssue advertisementOuterClass$RequestAddIssue) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestAddIssue);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestAddIssue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddIssue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
