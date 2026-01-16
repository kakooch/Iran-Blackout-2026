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

/* loaded from: classes.dex */
public final class Sequence$UpdateForceClearCache extends GeneratedMessageLite implements U64 {
    public static final int BACKUP_OPTIONS_FIELD_NUMBER = 1;
    private static final Sequence$UpdateForceClearCache DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j backupOptions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$UpdateForceClearCache.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$UpdateForceClearCache sequence$UpdateForceClearCache = new Sequence$UpdateForceClearCache();
        DEFAULT_INSTANCE = sequence$UpdateForceClearCache;
        GeneratedMessageLite.registerDefaultInstance(Sequence$UpdateForceClearCache.class, sequence$UpdateForceClearCache);
    }

    private Sequence$UpdateForceClearCache() {
    }

    private void addAllBackupOptions(Iterable<String> iterable) {
        ensureBackupOptionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.backupOptions_);
    }

    private void addBackupOptions(String str) {
        str.getClass();
        ensureBackupOptionsIsMutable();
        this.backupOptions_.add(str);
    }

    private void addBackupOptionsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureBackupOptionsIsMutable();
        this.backupOptions_.add(abstractC2383g.f0());
    }

    private void clearBackupOptions() {
        this.backupOptions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBackupOptionsIsMutable() {
        B.j jVar = this.backupOptions_;
        if (jVar.u()) {
            return;
        }
        this.backupOptions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sequence$UpdateForceClearCache getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$UpdateForceClearCache parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateForceClearCache parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBackupOptions(int i, String str) {
        str.getClass();
        ensureBackupOptionsIsMutable();
        this.backupOptions_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$UpdateForceClearCache();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"backupOptions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$UpdateForceClearCache.class) {
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

    public String getBackupOptions(int i) {
        return (String) this.backupOptions_.get(i);
    }

    public AbstractC2383g getBackupOptionsBytes(int i) {
        return AbstractC2383g.N((String) this.backupOptions_.get(i));
    }

    public int getBackupOptionsCount() {
        return this.backupOptions_.size();
    }

    public List<String> getBackupOptionsList() {
        return this.backupOptions_;
    }

    public static a newBuilder(Sequence$UpdateForceClearCache sequence$UpdateForceClearCache) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$UpdateForceClearCache);
    }

    public static Sequence$UpdateForceClearCache parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateForceClearCache parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$UpdateForceClearCache parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Sequence$UpdateForceClearCache parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$UpdateForceClearCache parseFrom(byte[] bArr) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$UpdateForceClearCache parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$UpdateForceClearCache parseFrom(InputStream inputStream) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateForceClearCache parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateForceClearCache parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$UpdateForceClearCache parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$UpdateForceClearCache) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
