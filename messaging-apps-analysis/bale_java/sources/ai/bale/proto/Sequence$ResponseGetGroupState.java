package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8356Vp6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Sequence$ResponseGetGroupState extends GeneratedMessageLite implements U64 {
    private static final Sequence$ResponseGetGroupState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEQS_FIELD_NUMBER = 1;
    private B.j seqs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$ResponseGetGroupState.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$ResponseGetGroupState sequence$ResponseGetGroupState = new Sequence$ResponseGetGroupState();
        DEFAULT_INSTANCE = sequence$ResponseGetGroupState;
        GeneratedMessageLite.registerDefaultInstance(Sequence$ResponseGetGroupState.class, sequence$ResponseGetGroupState);
    }

    private Sequence$ResponseGetGroupState() {
    }

    private void addAllSeqs(Iterable<? extends SequenceStruct$SeqState> iterable) {
        ensureSeqsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.seqs_);
    }

    private void addSeqs(SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureSeqsIsMutable();
        this.seqs_.add(sequenceStruct$SeqState);
    }

    private void clearSeqs() {
        this.seqs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSeqsIsMutable() {
        B.j jVar = this.seqs_;
        if (jVar.u()) {
            return;
        }
        this.seqs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sequence$ResponseGetGroupState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$ResponseGetGroupState parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetGroupState parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSeqs(int i) {
        ensureSeqsIsMutable();
        this.seqs_.remove(i);
    }

    private void setSeqs(int i, SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureSeqsIsMutable();
        this.seqs_.set(i, sequenceStruct$SeqState);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$ResponseGetGroupState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"seqs_", SequenceStruct$SeqState.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$ResponseGetGroupState.class) {
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

    public SequenceStruct$SeqState getSeqs(int i) {
        return (SequenceStruct$SeqState) this.seqs_.get(i);
    }

    public int getSeqsCount() {
        return this.seqs_.size();
    }

    public List<SequenceStruct$SeqState> getSeqsList() {
        return this.seqs_;
    }

    public InterfaceC8356Vp6 getSeqsOrBuilder(int i) {
        return (InterfaceC8356Vp6) this.seqs_.get(i);
    }

    public List<? extends InterfaceC8356Vp6> getSeqsOrBuilderList() {
        return this.seqs_;
    }

    public static a newBuilder(Sequence$ResponseGetGroupState sequence$ResponseGetGroupState) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$ResponseGetGroupState);
    }

    public static Sequence$ResponseGetGroupState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetGroupState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$ResponseGetGroupState parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSeqs(int i, SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        ensureSeqsIsMutable();
        this.seqs_.add(i, sequenceStruct$SeqState);
    }

    public static Sequence$ResponseGetGroupState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$ResponseGetGroupState parseFrom(byte[] bArr) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$ResponseGetGroupState parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$ResponseGetGroupState parseFrom(InputStream inputStream) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetGroupState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetGroupState parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$ResponseGetGroupState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$ResponseGetGroupState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
