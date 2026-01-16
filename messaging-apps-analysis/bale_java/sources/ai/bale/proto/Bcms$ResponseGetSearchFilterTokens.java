package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13677ge0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Bcms$ResponseGetSearchFilterTokens extends GeneratedMessageLite implements U64 {
    private static final Bcms$ResponseGetSearchFilterTokens DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKENS_FIELD_NUMBER = 1;
    private B.j tokens_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Bcms$ResponseGetSearchFilterTokens.DEFAULT_INSTANCE);
        }
    }

    static {
        Bcms$ResponseGetSearchFilterTokens bcms$ResponseGetSearchFilterTokens = new Bcms$ResponseGetSearchFilterTokens();
        DEFAULT_INSTANCE = bcms$ResponseGetSearchFilterTokens;
        GeneratedMessageLite.registerDefaultInstance(Bcms$ResponseGetSearchFilterTokens.class, bcms$ResponseGetSearchFilterTokens);
    }

    private Bcms$ResponseGetSearchFilterTokens() {
    }

    private void addAllTokens(Iterable<? extends BcmsStruct$SearchFilterToken> iterable) {
        ensureTokensIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tokens_);
    }

    private void addTokens(BcmsStruct$SearchFilterToken bcmsStruct$SearchFilterToken) {
        bcmsStruct$SearchFilterToken.getClass();
        ensureTokensIsMutable();
        this.tokens_.add(bcmsStruct$SearchFilterToken);
    }

    private void clearTokens() {
        this.tokens_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTokensIsMutable() {
        B.j jVar = this.tokens_;
        if (jVar.u()) {
            return;
        }
        this.tokens_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Bcms$ResponseGetSearchFilterTokens getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Bcms$ResponseGetSearchFilterTokens parseDelimitedFrom(InputStream inputStream) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(ByteBuffer byteBuffer) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTokens(int i) {
        ensureTokensIsMutable();
        this.tokens_.remove(i);
    }

    private void setTokens(int i, BcmsStruct$SearchFilterToken bcmsStruct$SearchFilterToken) {
        bcmsStruct$SearchFilterToken.getClass();
        ensureTokensIsMutable();
        this.tokens_.set(i, bcmsStruct$SearchFilterToken);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1882p.a[gVar.ordinal()]) {
            case 1:
                return new Bcms$ResponseGetSearchFilterTokens();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"tokens_", BcmsStruct$SearchFilterToken.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Bcms$ResponseGetSearchFilterTokens.class) {
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

    public BcmsStruct$SearchFilterToken getTokens(int i) {
        return (BcmsStruct$SearchFilterToken) this.tokens_.get(i);
    }

    public int getTokensCount() {
        return this.tokens_.size();
    }

    public List<BcmsStruct$SearchFilterToken> getTokensList() {
        return this.tokens_;
    }

    public InterfaceC13677ge0 getTokensOrBuilder(int i) {
        return (InterfaceC13677ge0) this.tokens_.get(i);
    }

    public List<? extends InterfaceC13677ge0> getTokensOrBuilderList() {
        return this.tokens_;
    }

    public static a newBuilder(Bcms$ResponseGetSearchFilterTokens bcms$ResponseGetSearchFilterTokens) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcms$ResponseGetSearchFilterTokens);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(AbstractC2383g abstractC2383g) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTokens(int i, BcmsStruct$SearchFilterToken bcmsStruct$SearchFilterToken) {
        bcmsStruct$SearchFilterToken.getClass();
        ensureTokensIsMutable();
        this.tokens_.add(i, bcmsStruct$SearchFilterToken);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(byte[] bArr) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(byte[] bArr, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(InputStream inputStream) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(AbstractC2384h abstractC2384h) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Bcms$ResponseGetSearchFilterTokens parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Bcms$ResponseGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
