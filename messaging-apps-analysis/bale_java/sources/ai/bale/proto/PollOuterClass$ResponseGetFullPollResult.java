package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6630Oh5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PollOuterClass$ResponseGetFullPollResult extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$ResponseGetFullPollResult DEFAULT_INSTANCE;
    public static final int FULL_POLL_RESULT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j fullPollResult_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PollOuterClass$ResponseGetFullPollResult.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$ResponseGetFullPollResult pollOuterClass$ResponseGetFullPollResult = new PollOuterClass$ResponseGetFullPollResult();
        DEFAULT_INSTANCE = pollOuterClass$ResponseGetFullPollResult;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$ResponseGetFullPollResult.class, pollOuterClass$ResponseGetFullPollResult);
    }

    private PollOuterClass$ResponseGetFullPollResult() {
    }

    private void addAllFullPollResult(Iterable<? extends PollStruct$FullOptionResult> iterable) {
        ensureFullPollResultIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fullPollResult_);
    }

    private void addFullPollResult(PollStruct$FullOptionResult pollStruct$FullOptionResult) {
        pollStruct$FullOptionResult.getClass();
        ensureFullPollResultIsMutable();
        this.fullPollResult_.add(pollStruct$FullOptionResult);
    }

    private void clearFullPollResult() {
        this.fullPollResult_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFullPollResultIsMutable() {
        B.j jVar = this.fullPollResult_;
        if (jVar.u()) {
            return;
        }
        this.fullPollResult_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PollOuterClass$ResponseGetFullPollResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$ResponseGetFullPollResult parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFullPollResult(int i) {
        ensureFullPollResultIsMutable();
        this.fullPollResult_.remove(i);
    }

    private void setFullPollResult(int i, PollStruct$FullOptionResult pollStruct$FullOptionResult) {
        pollStruct$FullOptionResult.getClass();
        ensureFullPollResultIsMutable();
        this.fullPollResult_.set(i, pollStruct$FullOptionResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$ResponseGetFullPollResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"fullPollResult_", PollStruct$FullOptionResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$ResponseGetFullPollResult.class) {
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

    public PollStruct$FullOptionResult getFullPollResult(int i) {
        return (PollStruct$FullOptionResult) this.fullPollResult_.get(i);
    }

    public int getFullPollResultCount() {
        return this.fullPollResult_.size();
    }

    public List<PollStruct$FullOptionResult> getFullPollResultList() {
        return this.fullPollResult_;
    }

    public InterfaceC6630Oh5 getFullPollResultOrBuilder(int i) {
        return (InterfaceC6630Oh5) this.fullPollResult_.get(i);
    }

    public List<? extends InterfaceC6630Oh5> getFullPollResultOrBuilderList() {
        return this.fullPollResult_;
    }

    public static a newBuilder(PollOuterClass$ResponseGetFullPollResult pollOuterClass$ResponseGetFullPollResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$ResponseGetFullPollResult);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFullPollResult(int i, PollStruct$FullOptionResult pollStruct$FullOptionResult) {
        pollStruct$FullOptionResult.getClass();
        ensureFullPollResultIsMutable();
        this.fullPollResult_.add(i, pollStruct$FullOptionResult);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(byte[] bArr) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$ResponseGetFullPollResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$ResponseGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
