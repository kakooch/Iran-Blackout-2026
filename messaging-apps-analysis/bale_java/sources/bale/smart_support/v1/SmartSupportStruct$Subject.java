package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21859uF6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$Subject extends GeneratedMessageLite implements InterfaceC21859uF6 {
    public static final int AGENT_ID_FIELD_NUMBER = 4;
    public static final int BOT_ID_FIELD_NUMBER = 3;
    private static final SmartSupportStruct$Subject DEFAULT_INSTANCE;
    public static final int ENABLE_FIELD_NUMBER = 5;
    public static final int GROUP_ID_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int SUBJECT_ID_FIELD_NUMBER = 1;
    public static final int SUBJECT_NAME_FIELD_NUMBER = 2;
    public static final int SUB_SUBJECT_IDS_FIELD_NUMBER = 6;
    private int agentId_;
    private int botId_;
    private boolean enable_;
    private long groupId_;
    private int subjectId_;
    private int subSubjectIdsMemoizedSerializedSize = -1;
    private String subjectName_ = "";
    private B.g subSubjectIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21859uF6 {
        private a() {
            super(SmartSupportStruct$Subject.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$Subject smartSupportStruct$Subject = new SmartSupportStruct$Subject();
        DEFAULT_INSTANCE = smartSupportStruct$Subject;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$Subject.class, smartSupportStruct$Subject);
    }

    private SmartSupportStruct$Subject() {
    }

    private void addAllSubSubjectIds(Iterable<? extends Integer> iterable) {
        ensureSubSubjectIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.subSubjectIds_);
    }

    private void addSubSubjectIds(int i) {
        ensureSubSubjectIdsIsMutable();
        this.subSubjectIds_.b1(i);
    }

    private void clearAgentId() {
        this.agentId_ = 0;
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearEnable() {
        this.enable_ = false;
    }

    private void clearGroupId() {
        this.groupId_ = 0L;
    }

    private void clearSubSubjectIds() {
        this.subSubjectIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearSubjectId() {
        this.subjectId_ = 0;
    }

    private void clearSubjectName() {
        this.subjectName_ = getDefaultInstance().getSubjectName();
    }

    private void ensureSubSubjectIdsIsMutable() {
        B.g gVar = this.subSubjectIds_;
        if (gVar.u()) {
            return;
        }
        this.subSubjectIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static SmartSupportStruct$Subject getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$Subject parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Subject parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAgentId(int i) {
        this.agentId_ = i;
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setEnable(boolean z) {
        this.enable_ = z;
    }

    private void setGroupId(long j) {
        this.groupId_ = j;
    }

    private void setSubSubjectIds(int i, int i2) {
        ensureSubSubjectIdsIsMutable();
        this.subSubjectIds_.U(i, i2);
    }

    private void setSubjectId(int i) {
        this.subjectId_ = i;
    }

    private void setSubjectName(String str) {
        str.getClass();
        this.subjectName_ = str;
    }

    private void setSubjectNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.subjectName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$Subject();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004\u0004\u0005\u0007\u0006'\u0007\u0002", new Object[]{"subjectId_", "subjectName_", "botId_", "agentId_", "enable_", "subSubjectIds_", "groupId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$Subject.class) {
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

    public int getAgentId() {
        return this.agentId_;
    }

    public int getBotId() {
        return this.botId_;
    }

    public boolean getEnable() {
        return this.enable_;
    }

    public long getGroupId() {
        return this.groupId_;
    }

    public int getSubSubjectIds(int i) {
        return this.subSubjectIds_.getInt(i);
    }

    public int getSubSubjectIdsCount() {
        return this.subSubjectIds_.size();
    }

    public List<Integer> getSubSubjectIdsList() {
        return this.subSubjectIds_;
    }

    public int getSubjectId() {
        return this.subjectId_;
    }

    public String getSubjectName() {
        return this.subjectName_;
    }

    public AbstractC2383g getSubjectNameBytes() {
        return AbstractC2383g.N(this.subjectName_);
    }

    public static a newBuilder(SmartSupportStruct$Subject smartSupportStruct$Subject) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$Subject);
    }

    public static SmartSupportStruct$Subject parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Subject parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$Subject parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$Subject parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$Subject parseFrom(byte[] bArr) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$Subject parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$Subject parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Subject parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Subject parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$Subject parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$Subject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
