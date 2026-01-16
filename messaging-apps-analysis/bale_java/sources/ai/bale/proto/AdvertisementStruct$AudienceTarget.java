package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AudienceTarget extends GeneratedMessageLite implements U64 {
    public static final int AUDIENCE_IDS_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$AudienceTarget DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int audienceIdsMemoizedSerializedSize = -1;
    private B.g audienceIds_ = GeneratedMessageLite.emptyIntList();
    private long fileId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$AudienceTarget.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget = new AdvertisementStruct$AudienceTarget();
        DEFAULT_INSTANCE = advertisementStruct$AudienceTarget;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AudienceTarget.class, advertisementStruct$AudienceTarget);
    }

    private AdvertisementStruct$AudienceTarget() {
    }

    private void addAllAudienceIds(Iterable<? extends Integer> iterable) {
        ensureAudienceIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.audienceIds_);
    }

    private void addAudienceIds(int i) {
        ensureAudienceIdsIsMutable();
        this.audienceIds_.b1(i);
    }

    private void clearAudienceIds() {
        this.audienceIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void ensureAudienceIdsIsMutable() {
        B.g gVar = this.audienceIds_;
        if (gVar.u()) {
            return;
        }
        this.audienceIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$AudienceTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AudienceTarget parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAudienceIds(int i, int i2) {
        ensureAudienceIdsIsMutable();
        this.audienceIds_.U(i, i2);
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AudienceTarget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001'\u0002\u0002", new Object[]{"audienceIds_", "fileId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AudienceTarget.class) {
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

    public int getAudienceIds(int i) {
        return this.audienceIds_.getInt(i);
    }

    public int getAudienceIdsCount() {
        return this.audienceIds_.size();
    }

    public List<Integer> getAudienceIdsList() {
        return this.audienceIds_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public static a newBuilder(AdvertisementStruct$AudienceTarget advertisementStruct$AudienceTarget) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AudienceTarget);
    }

    public static AdvertisementStruct$AudienceTarget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AudienceTarget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AudienceTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
