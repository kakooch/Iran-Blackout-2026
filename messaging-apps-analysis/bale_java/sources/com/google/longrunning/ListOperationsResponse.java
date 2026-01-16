package com.google.longrunning;

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

/* loaded from: classes3.dex */
public final class ListOperationsResponse extends GeneratedMessageLite implements U64 {
    private static final ListOperationsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j operations_ = GeneratedMessageLite.emptyProtobufList();
    private String nextPageToken_ = "";

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GeneratedMessageLite.g.values().length];
            a = iArr;
            try {
                iArr[GeneratedMessageLite.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.g.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.g.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.g.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.g.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.g.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.g.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            super(ListOperationsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        ListOperationsResponse listOperationsResponse = new ListOperationsResponse();
        DEFAULT_INSTANCE = listOperationsResponse;
        GeneratedMessageLite.registerDefaultInstance(ListOperationsResponse.class, listOperationsResponse);
    }

    private ListOperationsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOperations(Iterable<? extends Operation> iterable) {
        ensureOperationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.operations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.add(operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperations() {
        this.operations_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOperationsIsMutable() {
        B.j jVar = this.operations_;
        if (jVar.u()) {
            return;
        }
        this.operations_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ListOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream) {
        return (ListOperationsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOperations(int i) {
        ensureOperationsIsMutable();
        this.operations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageToken(String str) {
        str.getClass();
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nextPageToken_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperations(int i, Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.set(i, operation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.a[gVar.ordinal()]) {
            case 1:
                return new ListOperationsResponse();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"operations_", Operation.class, "nextPageToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ListOperationsResponse.class) {
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

    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    public AbstractC2383g getNextPageTokenBytes() {
        return AbstractC2383g.N(this.nextPageToken_);
    }

    public Operation getOperations(int i) {
        return (Operation) this.operations_.get(i);
    }

    public int getOperationsCount() {
        return this.operations_.size();
    }

    public List<Operation> getOperationsList() {
        return this.operations_;
    }

    public com.google.longrunning.a getOperationsOrBuilder(int i) {
        return (com.google.longrunning.a) this.operations_.get(i);
    }

    public List<? extends com.google.longrunning.a> getOperationsOrBuilderList() {
        return this.operations_;
    }

    public static b newBuilder(ListOperationsResponse listOperationsResponse) {
        return (b) DEFAULT_INSTANCE.createBuilder(listOperationsResponse);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ListOperationsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(int i, Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.add(i, operation);
    }

    public static ListOperationsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ListOperationsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ListOperationsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
