package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.SK0;
import ir.nasim.TK0;
import ir.nasim.UK0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class CharnetStruct$InternetBundleList extends GeneratedMessageLite implements SK0 {
    public static final int BUNDLES_FIELD_NUMBER = 2;
    private static final CharnetStruct$InternetBundleList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private B.j bundles_ = GeneratedMessageLite.emptyProtobufList();
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements SK0 {
        private a() {
            super(CharnetStruct$InternetBundleList.DEFAULT_INSTANCE);
        }
    }

    static {
        CharnetStruct$InternetBundleList charnetStruct$InternetBundleList = new CharnetStruct$InternetBundleList();
        DEFAULT_INSTANCE = charnetStruct$InternetBundleList;
        GeneratedMessageLite.registerDefaultInstance(CharnetStruct$InternetBundleList.class, charnetStruct$InternetBundleList);
    }

    private CharnetStruct$InternetBundleList() {
    }

    private void addAllBundles(Iterable<? extends CharnetStruct$InternetBundle> iterable) {
        ensureBundlesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bundles_);
    }

    private void addBundles(CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        charnetStruct$InternetBundle.getClass();
        ensureBundlesIsMutable();
        this.bundles_.add(charnetStruct$InternetBundle);
    }

    private void clearBundles() {
        this.bundles_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void ensureBundlesIsMutable() {
        B.j jVar = this.bundles_;
        if (jVar.u()) {
            return;
        }
        this.bundles_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static CharnetStruct$InternetBundleList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CharnetStruct$InternetBundleList parseDelimitedFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundleList parseFrom(ByteBuffer byteBuffer) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBundles(int i) {
        ensureBundlesIsMutable();
        this.bundles_.remove(i);
    }

    private void setBundles(int i, CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        charnetStruct$InternetBundle.getClass();
        ensureBundlesIsMutable();
        this.bundles_.set(i, charnetStruct$InternetBundle);
    }

    private void setType(TK0 tk0) {
        this.type_ = tk0.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A.a[gVar.ordinal()]) {
            case 1:
                return new CharnetStruct$InternetBundleList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"type_", "bundles_", CharnetStruct$InternetBundle.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CharnetStruct$InternetBundleList.class) {
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

    public CharnetStruct$InternetBundle getBundles(int i) {
        return (CharnetStruct$InternetBundle) this.bundles_.get(i);
    }

    public int getBundlesCount() {
        return this.bundles_.size();
    }

    public List<CharnetStruct$InternetBundle> getBundlesList() {
        return this.bundles_;
    }

    public UK0 getBundlesOrBuilder(int i) {
        return (UK0) this.bundles_.get(i);
    }

    public List<? extends UK0> getBundlesOrBuilderList() {
        return this.bundles_;
    }

    public TK0 getType() {
        TK0 tk0J = TK0.j(this.type_);
        return tk0J == null ? TK0.UNRECOGNIZED : tk0J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(CharnetStruct$InternetBundleList charnetStruct$InternetBundleList) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnetStruct$InternetBundleList);
    }

    public static CharnetStruct$InternetBundleList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundleList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CharnetStruct$InternetBundleList parseFrom(AbstractC2383g abstractC2383g) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBundles(int i, CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        charnetStruct$InternetBundle.getClass();
        ensureBundlesIsMutable();
        this.bundles_.add(i, charnetStruct$InternetBundle);
    }

    public static CharnetStruct$InternetBundleList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CharnetStruct$InternetBundleList parseFrom(byte[] bArr) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CharnetStruct$InternetBundleList parseFrom(byte[] bArr, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CharnetStruct$InternetBundleList parseFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundleList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundleList parseFrom(AbstractC2384h abstractC2384h) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CharnetStruct$InternetBundleList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CharnetStruct$InternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
