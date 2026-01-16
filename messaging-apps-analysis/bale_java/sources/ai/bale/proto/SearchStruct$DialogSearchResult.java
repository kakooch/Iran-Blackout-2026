package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23894xh6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$DialogSearchResult extends GeneratedMessageLite implements InterfaceC23894xh6 {
    private static final SearchStruct$DialogSearchResult DEFAULT_INSTANCE;
    public static final int EXPEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23894xh6 {
        private a() {
            super(SearchStruct$DialogSearchResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$DialogSearchResult searchStruct$DialogSearchResult = new SearchStruct$DialogSearchResult();
        DEFAULT_INSTANCE = searchStruct$DialogSearchResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$DialogSearchResult.class, searchStruct$DialogSearchResult);
    }

    private SearchStruct$DialogSearchResult() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchStruct$DialogSearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$DialogSearchResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$DialogSearchResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$DialogSearchResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$DialogSearchResult.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$DialogSearchResult searchStruct$DialogSearchResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$DialogSearchResult);
    }

    public static SearchStruct$DialogSearchResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$DialogSearchResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$DialogSearchResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$DialogSearchResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$DialogSearchResult parseFrom(byte[] bArr) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$DialogSearchResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$DialogSearchResult parseFrom(InputStream inputStream) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$DialogSearchResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$DialogSearchResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$DialogSearchResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$DialogSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
