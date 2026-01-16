package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8050Uh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$SearchPeerTypeCondition extends GeneratedMessageLite implements U64 {
    private static final SearchStruct$SearchPeerTypeCondition DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_TYPE_FIELD_NUMBER = 1;
    private int peerType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC8050Uh6 enumC8050Uh6) {
            q();
            ((SearchStruct$SearchPeerTypeCondition) this.b).setPeerType(enumC8050Uh6);
            return this;
        }

        private a() {
            super(SearchStruct$SearchPeerTypeCondition.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchPeerTypeCondition searchStruct$SearchPeerTypeCondition = new SearchStruct$SearchPeerTypeCondition();
        DEFAULT_INSTANCE = searchStruct$SearchPeerTypeCondition;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchPeerTypeCondition.class, searchStruct$SearchPeerTypeCondition);
    }

    private SearchStruct$SearchPeerTypeCondition() {
    }

    private void clearPeerType() {
        this.peerType_ = 0;
    }

    public static SearchStruct$SearchPeerTypeCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchPeerTypeCondition parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeerType(EnumC8050Uh6 enumC8050Uh6) {
        this.peerType_ = enumC8050Uh6.getNumber();
    }

    private void setPeerTypeValue(int i) {
        this.peerType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchPeerTypeCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"peerType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchPeerTypeCondition.class) {
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

    public EnumC8050Uh6 getPeerType() {
        EnumC8050Uh6 enumC8050Uh6J = EnumC8050Uh6.j(this.peerType_);
        return enumC8050Uh6J == null ? EnumC8050Uh6.UNRECOGNIZED : enumC8050Uh6J;
    }

    public int getPeerTypeValue() {
        return this.peerType_;
    }

    public static a newBuilder(SearchStruct$SearchPeerTypeCondition searchStruct$SearchPeerTypeCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchPeerTypeCondition);
    }

    public static SearchStruct$SearchPeerTypeCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(byte[] bArr) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchPeerTypeCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchPeerTypeCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
