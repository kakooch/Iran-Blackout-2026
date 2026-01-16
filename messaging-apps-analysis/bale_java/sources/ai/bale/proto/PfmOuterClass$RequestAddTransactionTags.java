package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionId;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.B75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestAddTransactionTags extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestAddTransactionTags DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TAGS_FIELD_NUMBER = 2;
    private int bitField0_;
    private PfmStruct$PfmTransactionId id_;
    private B.j tags_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PfmOuterClass$RequestAddTransactionTags) this.b).addAllTags(iterable);
            return this;
        }

        public a B(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
            q();
            ((PfmOuterClass$RequestAddTransactionTags) this.b).setId(pfmStruct$PfmTransactionId);
            return this;
        }

        private a() {
            super(PfmOuterClass$RequestAddTransactionTags.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestAddTransactionTags pfmOuterClass$RequestAddTransactionTags = new PfmOuterClass$RequestAddTransactionTags();
        DEFAULT_INSTANCE = pfmOuterClass$RequestAddTransactionTags;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestAddTransactionTags.class, pfmOuterClass$RequestAddTransactionTags);
    }

    private PfmOuterClass$RequestAddTransactionTags() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTags(Iterable<? extends PfmStruct$PfmTransactionTag> iterable) {
        ensureTagsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tags_);
    }

    private void addTags(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(pfmStruct$PfmTransactionTag);
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTags() {
        this.tags_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTagsIsMutable() {
        B.j jVar = this.tags_;
        if (jVar.u()) {
            return;
        }
        this.tags_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$RequestAddTransactionTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId2 = this.id_;
        if (pfmStruct$PfmTransactionId2 == null || pfmStruct$PfmTransactionId2 == PfmStruct$PfmTransactionId.getDefaultInstance()) {
            this.id_ = pfmStruct$PfmTransactionId;
        } else {
            this.id_ = (PfmStruct$PfmTransactionId) ((PfmStruct$PfmTransactionId.a) PfmStruct$PfmTransactionId.newBuilder(this.id_).v(pfmStruct$PfmTransactionId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestAddTransactionTags parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTags(int i) {
        ensureTagsIsMutable();
        this.tags_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        this.id_ = pfmStruct$PfmTransactionId;
        this.bitField0_ |= 1;
    }

    private void setTags(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.set(i, pfmStruct$PfmTransactionTag);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestAddTransactionTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "id_", "tags_", PfmStruct$PfmTransactionTag.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestAddTransactionTags.class) {
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

    public PfmStruct$PfmTransactionId getId() {
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = this.id_;
        return pfmStruct$PfmTransactionId == null ? PfmStruct$PfmTransactionId.getDefaultInstance() : pfmStruct$PfmTransactionId;
    }

    public PfmStruct$PfmTransactionTag getTags(int i) {
        return (PfmStruct$PfmTransactionTag) this.tags_.get(i);
    }

    public int getTagsCount() {
        return this.tags_.size();
    }

    public List<PfmStruct$PfmTransactionTag> getTagsList() {
        return this.tags_;
    }

    public B75 getTagsOrBuilder(int i) {
        return (B75) this.tags_.get(i);
    }

    public List<? extends B75> getTagsOrBuilderList() {
        return this.tags_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$RequestAddTransactionTags pfmOuterClass$RequestAddTransactionTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestAddTransactionTags);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTags(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(i, pfmStruct$PfmTransactionTag);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestAddTransactionTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestAddTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
