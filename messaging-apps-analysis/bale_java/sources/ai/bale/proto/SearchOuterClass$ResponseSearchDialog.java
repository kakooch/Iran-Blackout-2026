package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23894xh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchDialog extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$ResponseSearchDialog DEFAULT_INSTANCE;
    public static final int DIALOG_RESULTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j dialogResults_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchDialog.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchDialog searchOuterClass$ResponseSearchDialog = new SearchOuterClass$ResponseSearchDialog();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchDialog;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchDialog.class, searchOuterClass$ResponseSearchDialog);
    }

    private SearchOuterClass$ResponseSearchDialog() {
    }

    private void addAllDialogResults(Iterable<? extends SearchStruct$DialogSearchResult> iterable) {
        ensureDialogResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogResults_);
    }

    private void addDialogResults(SearchStruct$DialogSearchResult searchStruct$DialogSearchResult) {
        searchStruct$DialogSearchResult.getClass();
        ensureDialogResultsIsMutable();
        this.dialogResults_.add(searchStruct$DialogSearchResult);
    }

    private void clearDialogResults() {
        this.dialogResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDialogResultsIsMutable() {
        B.j jVar = this.dialogResults_;
        if (jVar.u()) {
            return;
        }
        this.dialogResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchDialog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$ResponseSearchDialog parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogResults(int i) {
        ensureDialogResultsIsMutable();
        this.dialogResults_.remove(i);
    }

    private void setDialogResults(int i, SearchStruct$DialogSearchResult searchStruct$DialogSearchResult) {
        searchStruct$DialogSearchResult.getClass();
        ensureDialogResultsIsMutable();
        this.dialogResults_.set(i, searchStruct$DialogSearchResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchDialog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"dialogResults_", SearchStruct$DialogSearchResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchDialog.class) {
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

    public SearchStruct$DialogSearchResult getDialogResults(int i) {
        return (SearchStruct$DialogSearchResult) this.dialogResults_.get(i);
    }

    public int getDialogResultsCount() {
        return this.dialogResults_.size();
    }

    public List<SearchStruct$DialogSearchResult> getDialogResultsList() {
        return this.dialogResults_;
    }

    public InterfaceC23894xh6 getDialogResultsOrBuilder(int i) {
        return (InterfaceC23894xh6) this.dialogResults_.get(i);
    }

    public List<? extends InterfaceC23894xh6> getDialogResultsOrBuilderList() {
        return this.dialogResults_;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchDialog searchOuterClass$ResponseSearchDialog) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchDialog);
    }

    public static SearchOuterClass$ResponseSearchDialog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogResults(int i, SearchStruct$DialogSearchResult searchStruct$DialogSearchResult) {
        searchStruct$DialogSearchResult.getClass();
        ensureDialogResultsIsMutable();
        this.dialogResults_.add(i, searchStruct$DialogSearchResult);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchDialog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
