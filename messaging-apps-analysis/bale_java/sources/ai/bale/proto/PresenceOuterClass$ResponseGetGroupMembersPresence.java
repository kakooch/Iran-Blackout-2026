package ai.bale.proto;

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

/* loaded from: classes9.dex */
public final class PresenceOuterClass$ResponseGetGroupMembersPresence extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$ResponseGetGroupMembersPresence DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PRESENCES_FIELD_NUMBER = 1;
    private B.j presences_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$ResponseGetGroupMembersPresence.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$ResponseGetGroupMembersPresence presenceOuterClass$ResponseGetGroupMembersPresence = new PresenceOuterClass$ResponseGetGroupMembersPresence();
        DEFAULT_INSTANCE = presenceOuterClass$ResponseGetGroupMembersPresence;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$ResponseGetGroupMembersPresence.class, presenceOuterClass$ResponseGetGroupMembersPresence);
    }

    private PresenceOuterClass$ResponseGetGroupMembersPresence() {
    }

    private void addAllPresences(Iterable<? extends PresenceStruct$UserPresence> iterable) {
        ensurePresencesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.presences_);
    }

    private void addPresences(PresenceStruct$UserPresence presenceStruct$UserPresence) {
        presenceStruct$UserPresence.getClass();
        ensurePresencesIsMutable();
        this.presences_.add(presenceStruct$UserPresence);
    }

    private void clearPresences() {
        this.presences_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePresencesIsMutable() {
        B.j jVar = this.presences_;
        if (jVar.u()) {
            return;
        }
        this.presences_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePresences(int i) {
        ensurePresencesIsMutable();
        this.presences_.remove(i);
    }

    private void setPresences(int i, PresenceStruct$UserPresence presenceStruct$UserPresence) {
        presenceStruct$UserPresence.getClass();
        ensurePresencesIsMutable();
        this.presences_.set(i, presenceStruct$UserPresence);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$ResponseGetGroupMembersPresence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"presences_", PresenceStruct$UserPresence.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$ResponseGetGroupMembersPresence.class) {
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

    public PresenceStruct$UserPresence getPresences(int i) {
        return (PresenceStruct$UserPresence) this.presences_.get(i);
    }

    public int getPresencesCount() {
        return this.presences_.size();
    }

    public List<PresenceStruct$UserPresence> getPresencesList() {
        return this.presences_;
    }

    public InterfaceC1872l1 getPresencesOrBuilder(int i) {
        return (InterfaceC1872l1) this.presences_.get(i);
    }

    public List<? extends InterfaceC1872l1> getPresencesOrBuilderList() {
        return this.presences_;
    }

    public static a newBuilder(PresenceOuterClass$ResponseGetGroupMembersPresence presenceOuterClass$ResponseGetGroupMembersPresence) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$ResponseGetGroupMembersPresence);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPresences(int i, PresenceStruct$UserPresence presenceStruct$UserPresence) {
        presenceStruct$UserPresence.getClass();
        ensurePresencesIsMutable();
        this.presences_.add(i, presenceStruct$UserPresence);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(byte[] bArr) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$ResponseGetGroupMembersPresence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupMembersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
