package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class Feedback$RequestSendFeedBack extends GeneratedMessageLite implements U64 {
    private static final Feedback$RequestSendFeedBack DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DETAILS_FIELD_NUMBER = 4;
    public static final int MT_DETAILS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int RATE_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$MapValue mtDetails_;
    private int rate_;
    private com.google.protobuf.J details_ = com.google.protobuf.J.e();
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((Feedback$RequestSendFeedBack) this.b).setDescription(str);
            return this;
        }

        public a B(CollectionsStruct$MapValue collectionsStruct$MapValue) {
            q();
            ((Feedback$RequestSendFeedBack) this.b).setMtDetails(collectionsStruct$MapValue);
            return this;
        }

        public a C(int i) {
            q();
            ((Feedback$RequestSendFeedBack) this.b).setRate(i);
            return this;
        }

        public a D(String str) {
            q();
            ((Feedback$RequestSendFeedBack) this.b).setTitle(str);
            return this;
        }

        private a() {
            super(Feedback$RequestSendFeedBack.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    static {
        Feedback$RequestSendFeedBack feedback$RequestSendFeedBack = new Feedback$RequestSendFeedBack();
        DEFAULT_INSTANCE = feedback$RequestSendFeedBack;
        GeneratedMessageLite.registerDefaultInstance(Feedback$RequestSendFeedBack.class, feedback$RequestSendFeedBack);
    }

    private Feedback$RequestSendFeedBack() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearMtDetails() {
        this.mtDetails_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRate() {
        this.rate_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static Feedback$RequestSendFeedBack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableDetailsMap() {
        return internalGetMutableDetails();
    }

    private com.google.protobuf.J internalGetDetails() {
        return this.details_;
    }

    private com.google.protobuf.J internalGetMutableDetails() {
        if (!this.details_.n()) {
            this.details_ = this.details_.s();
        }
        return this.details_;
    }

    private void mergeMtDetails(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.mtDetails_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.mtDetails_ = collectionsStruct$MapValue;
        } else {
            this.mtDetails_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.mtDetails_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Feedback$RequestSendFeedBack parseDelimitedFrom(InputStream inputStream) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Feedback$RequestSendFeedBack parseFrom(ByteBuffer byteBuffer) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMtDetails(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.mtDetails_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRate(int i) {
        this.rate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    public boolean containsDetails(String str) {
        str.getClass();
        return internalGetDetails().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1838a0.a[gVar.ordinal()]) {
            case 1:
                return new Feedback$RequestSendFeedBack();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0001\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u00042\u0005ဉ\u0000", new Object[]{"bitField0_", "rate_", "title_", "description_", "details_", b.a, "mtDetails_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Feedback$RequestSendFeedBack.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    @Deprecated
    public Map<String, String> getDetails() {
        return getDetailsMap();
    }

    public int getDetailsCount() {
        return internalGetDetails().size();
    }

    public Map<String, String> getDetailsMap() {
        return Collections.unmodifiableMap(internalGetDetails());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getDetailsOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetDetails = internalGetDetails();
        return jInternalGetDetails.containsKey(str) ? (String) jInternalGetDetails.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getDetailsOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetDetails = internalGetDetails();
        if (jInternalGetDetails.containsKey(str)) {
            return (String) jInternalGetDetails.get(str);
        }
        throw new IllegalArgumentException();
    }

    public CollectionsStruct$MapValue getMtDetails() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.mtDetails_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public int getRate() {
        return this.rate_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasMtDetails() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Feedback$RequestSendFeedBack feedback$RequestSendFeedBack) {
        return (a) DEFAULT_INSTANCE.createBuilder(feedback$RequestSendFeedBack);
    }

    public static Feedback$RequestSendFeedBack parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Feedback$RequestSendFeedBack parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Feedback$RequestSendFeedBack parseFrom(AbstractC2383g abstractC2383g) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Feedback$RequestSendFeedBack parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Feedback$RequestSendFeedBack parseFrom(byte[] bArr) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Feedback$RequestSendFeedBack parseFrom(byte[] bArr, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Feedback$RequestSendFeedBack parseFrom(InputStream inputStream) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Feedback$RequestSendFeedBack parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Feedback$RequestSendFeedBack parseFrom(AbstractC2384h abstractC2384h) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Feedback$RequestSendFeedBack parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Feedback$RequestSendFeedBack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
