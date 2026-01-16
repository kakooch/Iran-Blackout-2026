package ai.bale.proto;

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
public final class PfmOuterClass$ResponseGetTransactionTags extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$ResponseGetTransactionTags DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAGS_FIELD_NUMBER = 1;
    private B.j tags_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseGetTransactionTags.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseGetTransactionTags pfmOuterClass$ResponseGetTransactionTags = new PfmOuterClass$ResponseGetTransactionTags();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseGetTransactionTags;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseGetTransactionTags.class, pfmOuterClass$ResponseGetTransactionTags);
    }

    private PfmOuterClass$ResponseGetTransactionTags() {
    }

    private void addAllTags(Iterable<? extends PfmStruct$PfmTransactionTag> iterable) {
        ensureTagsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tags_);
    }

    private void addTags(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(pfmStruct$PfmTransactionTag);
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

    public static PfmOuterClass$ResponseGetTransactionTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTags(int i) {
        ensureTagsIsMutable();
        this.tags_.remove(i);
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
                return new PfmOuterClass$ResponseGetTransactionTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"tags_", PfmStruct$PfmTransactionTag.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseGetTransactionTags.class) {
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

    public static a newBuilder(PfmOuterClass$ResponseGetTransactionTags pfmOuterClass$ResponseGetTransactionTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseGetTransactionTags);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTags(int i, PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(i, pfmStruct$PfmTransactionTag);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseGetTransactionTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetTransactionTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
