package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.SK0;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Charnet$ResponseGetInternetBundleList extends GeneratedMessageLite implements U64 {
    public static final int BUNDLE_LISTS_FIELD_NUMBER = 1;
    private static final Charnet$ResponseGetInternetBundleList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j bundleLists_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseGetInternetBundleList.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseGetInternetBundleList charnet$ResponseGetInternetBundleList = new Charnet$ResponseGetInternetBundleList();
        DEFAULT_INSTANCE = charnet$ResponseGetInternetBundleList;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseGetInternetBundleList.class, charnet$ResponseGetInternetBundleList);
    }

    private Charnet$ResponseGetInternetBundleList() {
    }

    private void addAllBundleLists(Iterable<? extends CharnetStruct$InternetBundleList> iterable) {
        ensureBundleListsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bundleLists_);
    }

    private void addBundleLists(CharnetStruct$InternetBundleList charnetStruct$InternetBundleList) {
        charnetStruct$InternetBundleList.getClass();
        ensureBundleListsIsMutable();
        this.bundleLists_.add(charnetStruct$InternetBundleList);
    }

    private void clearBundleLists() {
        this.bundleLists_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBundleListsIsMutable() {
        B.j jVar = this.bundleLists_;
        if (jVar.u()) {
            return;
        }
        this.bundleLists_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Charnet$ResponseGetInternetBundleList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseGetInternetBundleList parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBundleLists(int i) {
        ensureBundleListsIsMutable();
        this.bundleLists_.remove(i);
    }

    private void setBundleLists(int i, CharnetStruct$InternetBundleList charnetStruct$InternetBundleList) {
        charnetStruct$InternetBundleList.getClass();
        ensureBundleListsIsMutable();
        this.bundleLists_.set(i, charnetStruct$InternetBundleList);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseGetInternetBundleList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"bundleLists_", CharnetStruct$InternetBundleList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseGetInternetBundleList.class) {
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

    public CharnetStruct$InternetBundleList getBundleLists(int i) {
        return (CharnetStruct$InternetBundleList) this.bundleLists_.get(i);
    }

    public int getBundleListsCount() {
        return this.bundleLists_.size();
    }

    public List<CharnetStruct$InternetBundleList> getBundleListsList() {
        return this.bundleLists_;
    }

    public SK0 getBundleListsOrBuilder(int i) {
        return (SK0) this.bundleLists_.get(i);
    }

    public List<? extends SK0> getBundleListsOrBuilderList() {
        return this.bundleLists_;
    }

    public static a newBuilder(Charnet$ResponseGetInternetBundleList charnet$ResponseGetInternetBundleList) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseGetInternetBundleList);
    }

    public static Charnet$ResponseGetInternetBundleList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBundleLists(int i, CharnetStruct$InternetBundleList charnetStruct$InternetBundleList) {
        charnetStruct$InternetBundleList.getClass();
        ensureBundleListsIsMutable();
        this.bundleLists_.add(i, charnetStruct$InternetBundleList);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(byte[] bArr) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(InputStream inputStream) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseGetInternetBundleList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
