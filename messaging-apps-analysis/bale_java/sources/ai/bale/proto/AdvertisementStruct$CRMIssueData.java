package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20824sg;
import ir.nasim.InterfaceC19033pg;
import ir.nasim.InterfaceC20231rg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$CRMIssueData extends GeneratedMessageLite implements InterfaceC20231rg {
    public static final int COMMENTS_FIELD_NUMBER = 4;
    private static final AdvertisementStruct$CRMIssueData DEFAULT_INSTANCE;
    public static final int IS_RESOLVED_FIELD_NUMBER = 6;
    public static final int LAST_UPDATE_DATE_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private boolean isResolved_;
    private long lastUpdateDate_;
    private int type_;
    private int userId_;
    private String name_ = "";
    private String phone_ = "";
    private B.j comments_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20231rg {
        private a() {
            super(AdvertisementStruct$CRMIssueData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData = new AdvertisementStruct$CRMIssueData();
        DEFAULT_INSTANCE = advertisementStruct$CRMIssueData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CRMIssueData.class, advertisementStruct$CRMIssueData);
    }

    private AdvertisementStruct$CRMIssueData() {
    }

    private void addAllComments(Iterable<? extends AdvertisementStruct$CRMIssueComment> iterable) {
        ensureCommentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.comments_);
    }

    private void addComments(AdvertisementStruct$CRMIssueComment advertisementStruct$CRMIssueComment) {
        advertisementStruct$CRMIssueComment.getClass();
        ensureCommentsIsMutable();
        this.comments_.add(advertisementStruct$CRMIssueComment);
    }

    private void clearComments() {
        this.comments_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIsResolved() {
        this.isResolved_ = false;
    }

    private void clearLastUpdateDate() {
        this.lastUpdateDate_ = 0L;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPhone() {
        this.phone_ = getDefaultInstance().getPhone();
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void ensureCommentsIsMutable() {
        B.j jVar = this.comments_;
        if (jVar.u()) {
            return;
        }
        this.comments_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementStruct$CRMIssueData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CRMIssueData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeComments(int i) {
        ensureCommentsIsMutable();
        this.comments_.remove(i);
    }

    private void setComments(int i, AdvertisementStruct$CRMIssueComment advertisementStruct$CRMIssueComment) {
        advertisementStruct$CRMIssueComment.getClass();
        ensureCommentsIsMutable();
        this.comments_.set(i, advertisementStruct$CRMIssueComment);
    }

    private void setIsResolved(boolean z) {
        this.isResolved_ = z;
    }

    private void setLastUpdateDate(long j) {
        this.lastUpdateDate_ = j;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setPhone(String str) {
        str.getClass();
        this.phone_ = str;
    }

    private void setPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phone_ = abstractC2383g.f0();
    }

    private void setType(EnumC20824sg enumC20824sg) {
        this.type_ = enumC20824sg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CRMIssueData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005\f\u0006\u0007\u0007\u0002", new Object[]{"userId_", "name_", "phone_", "comments_", AdvertisementStruct$CRMIssueComment.class, "type_", "isResolved_", "lastUpdateDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CRMIssueData.class) {
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

    public AdvertisementStruct$CRMIssueComment getComments(int i) {
        return (AdvertisementStruct$CRMIssueComment) this.comments_.get(i);
    }

    public int getCommentsCount() {
        return this.comments_.size();
    }

    public List<AdvertisementStruct$CRMIssueComment> getCommentsList() {
        return this.comments_;
    }

    public InterfaceC19033pg getCommentsOrBuilder(int i) {
        return (InterfaceC19033pg) this.comments_.get(i);
    }

    public List<? extends InterfaceC19033pg> getCommentsOrBuilderList() {
        return this.comments_;
    }

    public boolean getIsResolved() {
        return this.isResolved_;
    }

    public long getLastUpdateDate() {
        return this.lastUpdateDate_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getPhone() {
        return this.phone_;
    }

    public AbstractC2383g getPhoneBytes() {
        return AbstractC2383g.N(this.phone_);
    }

    public EnumC20824sg getType() {
        EnumC20824sg enumC20824sgJ = EnumC20824sg.j(this.type_);
        return enumC20824sgJ == null ? EnumC20824sg.UNRECOGNIZED : enumC20824sgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AdvertisementStruct$CRMIssueData advertisementStruct$CRMIssueData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CRMIssueData);
    }

    public static AdvertisementStruct$CRMIssueData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addComments(int i, AdvertisementStruct$CRMIssueComment advertisementStruct$CRMIssueComment) {
        advertisementStruct$CRMIssueComment.getClass();
        ensureCommentsIsMutable();
        this.comments_.add(i, advertisementStruct$CRMIssueComment);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CRMIssueData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
