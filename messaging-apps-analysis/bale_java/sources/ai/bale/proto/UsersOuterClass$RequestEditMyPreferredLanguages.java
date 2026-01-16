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
public final class UsersOuterClass$RequestEditMyPreferredLanguages extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestEditMyPreferredLanguages DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREFERRED_LANGUAGES_FIELD_NUMBER = 1;
    private B.j preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestEditMyPreferredLanguages.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditMyPreferredLanguages usersOuterClass$RequestEditMyPreferredLanguages = new UsersOuterClass$RequestEditMyPreferredLanguages();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditMyPreferredLanguages;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditMyPreferredLanguages.class, usersOuterClass$RequestEditMyPreferredLanguages);
    }

    private UsersOuterClass$RequestEditMyPreferredLanguages() {
    }

    private void addAllPreferredLanguages(Iterable<String> iterable) {
        ensurePreferredLanguagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.preferredLanguages_);
    }

    private void addPreferredLanguages(String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(str);
    }

    private void addPreferredLanguagesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(abstractC2383g.f0());
    }

    private void clearPreferredLanguages() {
        this.preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePreferredLanguagesIsMutable() {
        B.j jVar = this.preferredLanguages_;
        if (jVar.u()) {
            return;
        }
        this.preferredLanguages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPreferredLanguages(int i, String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditMyPreferredLanguages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"preferredLanguages_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditMyPreferredLanguages.class) {
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

    public String getPreferredLanguages(int i) {
        return (String) this.preferredLanguages_.get(i);
    }

    public AbstractC2383g getPreferredLanguagesBytes(int i) {
        return AbstractC2383g.N((String) this.preferredLanguages_.get(i));
    }

    public int getPreferredLanguagesCount() {
        return this.preferredLanguages_.size();
    }

    public List<String> getPreferredLanguagesList() {
        return this.preferredLanguages_;
    }

    public static a newBuilder(UsersOuterClass$RequestEditMyPreferredLanguages usersOuterClass$RequestEditMyPreferredLanguages) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditMyPreferredLanguages);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditMyPreferredLanguages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditMyPreferredLanguages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
