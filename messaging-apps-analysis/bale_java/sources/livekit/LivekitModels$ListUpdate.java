package livekit;

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
public final class LivekitModels$ListUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$ListUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SET_FIELD_NUMBER = 1;
    private B.j set_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$ListUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$ListUpdate livekitModels$ListUpdate = new LivekitModels$ListUpdate();
        DEFAULT_INSTANCE = livekitModels$ListUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ListUpdate.class, livekitModels$ListUpdate);
    }

    private LivekitModels$ListUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSet(Iterable<String> iterable) {
        ensureSetIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.set_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSet(String str) {
        str.getClass();
        ensureSetIsMutable();
        this.set_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSetBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureSetIsMutable();
        this.set_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSet() {
        this.set_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSetIsMutable() {
        B.j jVar = this.set_;
        if (jVar.u()) {
            return;
        }
        this.set_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$ListUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ListUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ListUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSet(int i, String str) {
        str.getClass();
        ensureSetIsMutable();
        this.set_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ListUpdate();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"set_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ListUpdate.class) {
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

    public String getSet(int i) {
        return (String) this.set_.get(i);
    }

    public AbstractC2383g getSetBytes(int i) {
        return AbstractC2383g.N((String) this.set_.get(i));
    }

    public int getSetCount() {
        return this.set_.size();
    }

    public List<String> getSetList() {
        return this.set_;
    }

    public static a newBuilder(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ListUpdate);
    }

    public static LivekitModels$ListUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ListUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ListUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ListUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ListUpdate parseFrom(byte[] bArr) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ListUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ListUpdate parseFrom(InputStream inputStream) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ListUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ListUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ListUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ListUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
