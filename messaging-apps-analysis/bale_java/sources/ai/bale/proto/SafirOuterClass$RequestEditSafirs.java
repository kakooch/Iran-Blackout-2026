package ai.bale.proto;

import ai.bale.proto.SafirStruct$SafirOrganization;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.W96;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SafirOuterClass$RequestEditSafirs extends GeneratedMessageLite implements U64 {
    public static final int BOTS_FIELD_NUMBER = 3;
    private static final SafirOuterClass$RequestEditSafirs DEFAULT_INSTANCE;
    public static final int NOTIFY_OWNER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SAFIR_INFO_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();
    private boolean notifyOwner_;
    private SafirStruct$SafirOrganization safirInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$RequestEditSafirs.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$RequestEditSafirs safirOuterClass$RequestEditSafirs = new SafirOuterClass$RequestEditSafirs();
        DEFAULT_INSTANCE = safirOuterClass$RequestEditSafirs;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$RequestEditSafirs.class, safirOuterClass$RequestEditSafirs);
    }

    private SafirOuterClass$RequestEditSafirs() {
    }

    private void addAllBots(Iterable<? extends SafirStruct$SafirBots> iterable) {
        ensureBotsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bots_);
    }

    private void addBots(SafirStruct$SafirBots safirStruct$SafirBots) {
        safirStruct$SafirBots.getClass();
        ensureBotsIsMutable();
        this.bots_.add(safirStruct$SafirBots);
    }

    private void clearBots() {
        this.bots_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearNotifyOwner() {
        this.notifyOwner_ = false;
    }

    private void clearSafirInfo() {
        this.safirInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SafirOuterClass$RequestEditSafirs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSafirInfo(SafirStruct$SafirOrganization safirStruct$SafirOrganization) {
        safirStruct$SafirOrganization.getClass();
        SafirStruct$SafirOrganization safirStruct$SafirOrganization2 = this.safirInfo_;
        if (safirStruct$SafirOrganization2 == null || safirStruct$SafirOrganization2 == SafirStruct$SafirOrganization.getDefaultInstance()) {
            this.safirInfo_ = safirStruct$SafirOrganization;
        } else {
            this.safirInfo_ = (SafirStruct$SafirOrganization) ((SafirStruct$SafirOrganization.a) SafirStruct$SafirOrganization.newBuilder(this.safirInfo_).v(safirStruct$SafirOrganization)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$RequestEditSafirs parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBots(int i) {
        ensureBotsIsMutable();
        this.bots_.remove(i);
    }

    private void setBots(int i, SafirStruct$SafirBots safirStruct$SafirBots) {
        safirStruct$SafirBots.getClass();
        ensureBotsIsMutable();
        this.bots_.set(i, safirStruct$SafirBots);
    }

    private void setNotifyOwner(boolean z) {
        this.notifyOwner_ = z;
    }

    private void setSafirInfo(SafirStruct$SafirOrganization safirStruct$SafirOrganization) {
        safirStruct$SafirOrganization.getClass();
        this.safirInfo_ = safirStruct$SafirOrganization;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$RequestEditSafirs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0007\u0002ဉ\u0000\u0003\u001b", new Object[]{"bitField0_", "notifyOwner_", "safirInfo_", "bots_", SafirStruct$SafirBots.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$RequestEditSafirs.class) {
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

    public SafirStruct$SafirBots getBots(int i) {
        return (SafirStruct$SafirBots) this.bots_.get(i);
    }

    public int getBotsCount() {
        return this.bots_.size();
    }

    public List<SafirStruct$SafirBots> getBotsList() {
        return this.bots_;
    }

    public W96 getBotsOrBuilder(int i) {
        return (W96) this.bots_.get(i);
    }

    public List<? extends W96> getBotsOrBuilderList() {
        return this.bots_;
    }

    public boolean getNotifyOwner() {
        return this.notifyOwner_;
    }

    public SafirStruct$SafirOrganization getSafirInfo() {
        SafirStruct$SafirOrganization safirStruct$SafirOrganization = this.safirInfo_;
        return safirStruct$SafirOrganization == null ? SafirStruct$SafirOrganization.getDefaultInstance() : safirStruct$SafirOrganization;
    }

    public boolean hasSafirInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SafirOuterClass$RequestEditSafirs safirOuterClass$RequestEditSafirs) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$RequestEditSafirs);
    }

    public static SafirOuterClass$RequestEditSafirs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, SafirStruct$SafirBots safirStruct$SafirBots) {
        safirStruct$SafirBots.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, safirStruct$SafirBots);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(byte[] bArr) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$RequestEditSafirs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$RequestEditSafirs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
