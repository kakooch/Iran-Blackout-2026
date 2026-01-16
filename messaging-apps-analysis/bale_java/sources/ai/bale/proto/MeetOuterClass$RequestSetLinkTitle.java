package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestSetLinkTitle extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 2;
    private static final MeetOuterClass$RequestSetLinkTitle DEFAULT_INSTANCE;
    public static final int LINK_URL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int64Value callId_;
    private CollectionsStruct$StringValue linkUrl_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((MeetOuterClass$RequestSetLinkTitle) this.b).setCallId(collectionsStruct$Int64Value);
            return this;
        }

        public a B(String str) {
            q();
            ((MeetOuterClass$RequestSetLinkTitle) this.b).setTitle(str);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestSetLinkTitle.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestSetLinkTitle meetOuterClass$RequestSetLinkTitle = new MeetOuterClass$RequestSetLinkTitle();
        DEFAULT_INSTANCE = meetOuterClass$RequestSetLinkTitle;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestSetLinkTitle.class, meetOuterClass$RequestSetLinkTitle);
    }

    private MeetOuterClass$RequestSetLinkTitle() {
    }

    private void clearCallId() {
        this.callId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLinkUrl() {
        this.linkUrl_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static MeetOuterClass$RequestSetLinkTitle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.callId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.callId_ = collectionsStruct$Int64Value;
        } else {
            this.callId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.callId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLinkUrl(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.linkUrl_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.linkUrl_ = collectionsStruct$StringValue;
        } else {
            this.linkUrl_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.linkUrl_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestSetLinkTitle parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.callId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setLinkUrl(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.linkUrl_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestSetLinkTitle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "title_", "callId_", "linkUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestSetLinkTitle.class) {
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

    public CollectionsStruct$Int64Value getCallId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.callId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$StringValue getLinkUrl() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.linkUrl_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasCallId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLinkUrl() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestSetLinkTitle meetOuterClass$RequestSetLinkTitle) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestSetLinkTitle);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestSetLinkTitle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestSetLinkTitle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
