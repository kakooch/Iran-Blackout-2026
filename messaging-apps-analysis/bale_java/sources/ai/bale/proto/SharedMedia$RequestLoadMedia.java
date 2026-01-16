package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11822dc4;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SharedMedia$RequestLoadMedia extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final SharedMedia$RequestLoadMedia DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    public static final int LOAD_MODE_FIELD_NUMBER = 4;
    public static final int MINIMUM_RESULTS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int contentType_;
    private CollectionsStruct$Int64Value date_;
    private PeersStruct$ExPeer exPeer_;
    private int loadMode_;
    private int minimumResults_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC11822dc4 enumC11822dc4) {
            q();
            ((SharedMedia$RequestLoadMedia) this.b).setContentType(enumC11822dc4);
            return this;
        }

        public a B(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((SharedMedia$RequestLoadMedia) this.b).setDate(collectionsStruct$Int64Value);
            return this;
        }

        public a C(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((SharedMedia$RequestLoadMedia) this.b).setExPeer(peersStruct$ExPeer);
            return this;
        }

        public a D(EnumC6845Pf4 enumC6845Pf4) {
            q();
            ((SharedMedia$RequestLoadMedia) this.b).setLoadMode(enumC6845Pf4);
            return this;
        }

        public a E(int i) {
            q();
            ((SharedMedia$RequestLoadMedia) this.b).setMinimumResults(i);
            return this;
        }

        private a() {
            super(SharedMedia$RequestLoadMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SharedMedia$RequestLoadMedia sharedMedia$RequestLoadMedia = new SharedMedia$RequestLoadMedia();
        DEFAULT_INSTANCE = sharedMedia$RequestLoadMedia;
        GeneratedMessageLite.registerDefaultInstance(SharedMedia$RequestLoadMedia.class, sharedMedia$RequestLoadMedia);
    }

    private SharedMedia$RequestLoadMedia() {
    }

    private void clearContentType() {
        this.contentType_ = 0;
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearMinimumResults() {
        this.minimumResults_ = 0;
    }

    public static SharedMedia$RequestLoadMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
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

    public static SharedMedia$RequestLoadMedia parseDelimitedFrom(InputStream inputStream) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(ByteBuffer byteBuffer) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentType(EnumC11822dc4 enumC11822dc4) {
        this.contentType_ = enumC11822dc4.getNumber();
    }

    private void setContentTypeValue(int i) {
        this.contentType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinimumResults(int i) {
        this.minimumResults_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z1.a[gVar.ordinal()]) {
            case 1:
                return new SharedMedia$RequestLoadMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f\u0004\f\u0005\u0004", new Object[]{"bitField0_", "exPeer_", "date_", "contentType_", "loadMode_", "minimumResults_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SharedMedia$RequestLoadMedia.class) {
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

    public EnumC11822dc4 getContentType() {
        EnumC11822dc4 enumC11822dc4J = EnumC11822dc4.j(this.contentType_);
        return enumC11822dc4J == null ? EnumC11822dc4.UNRECOGNIZED : enumC11822dc4J;
    }

    public int getContentTypeValue() {
        return this.contentType_;
    }

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
    }

    public int getMinimumResults() {
        return this.minimumResults_;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SharedMedia$RequestLoadMedia sharedMedia$RequestLoadMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(sharedMedia$RequestLoadMedia);
    }

    public static SharedMedia$RequestLoadMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(byte[] bArr) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(InputStream inputStream) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SharedMedia$RequestLoadMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SharedMedia$RequestLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
