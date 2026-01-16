package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$SearchDocumentName extends GeneratedMessageLite implements U64 {
    private static final SearchStruct$SearchDocumentName DEFAULT_INSTANCE;
    public static final int DOCUMENT_NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String documentName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((SearchStruct$SearchDocumentName) this.b).setDocumentName(str);
            return this;
        }

        private a() {
            super(SearchStruct$SearchDocumentName.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchDocumentName searchStruct$SearchDocumentName = new SearchStruct$SearchDocumentName();
        DEFAULT_INSTANCE = searchStruct$SearchDocumentName;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchDocumentName.class, searchStruct$SearchDocumentName);
    }

    private SearchStruct$SearchDocumentName() {
    }

    private void clearDocumentName() {
        this.documentName_ = getDefaultInstance().getDocumentName();
    }

    public static SearchStruct$SearchDocumentName getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchDocumentName parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchDocumentName parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentName(String str) {
        str.getClass();
        this.documentName_ = str;
    }

    private void setDocumentNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.documentName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchDocumentName();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"documentName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchDocumentName.class) {
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

    public String getDocumentName() {
        return this.documentName_;
    }

    public AbstractC2383g getDocumentNameBytes() {
        return AbstractC2383g.N(this.documentName_);
    }

    public static a newBuilder(SearchStruct$SearchDocumentName searchStruct$SearchDocumentName) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchDocumentName);
    }

    public static SearchStruct$SearchDocumentName parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchDocumentName parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchDocumentName parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchDocumentName parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchDocumentName parseFrom(byte[] bArr) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchDocumentName parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchDocumentName parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchDocumentName parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchDocumentName parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchDocumentName parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchDocumentName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
