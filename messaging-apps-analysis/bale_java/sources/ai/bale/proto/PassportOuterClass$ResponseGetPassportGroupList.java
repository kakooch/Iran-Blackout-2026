package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.ZZ4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PassportOuterClass$ResponseGetPassportGroupList extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$ResponseGetPassportGroupList DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportOuterClass$ResponseGetPassportGroupList.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$ResponseGetPassportGroupList passportOuterClass$ResponseGetPassportGroupList = new PassportOuterClass$ResponseGetPassportGroupList();
        DEFAULT_INSTANCE = passportOuterClass$ResponseGetPassportGroupList;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$ResponseGetPassportGroupList.class, passportOuterClass$ResponseGetPassportGroupList);
    }

    private PassportOuterClass$ResponseGetPassportGroupList() {
    }

    private void addAllGroups(Iterable<? extends PassportStruct$PassportFieldGroupHeader> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(PassportStruct$PassportFieldGroupHeader passportStruct$PassportFieldGroupHeader) {
        passportStruct$PassportFieldGroupHeader.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(passportStruct$PassportFieldGroupHeader);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, PassportStruct$PassportFieldGroupHeader passportStruct$PassportFieldGroupHeader) {
        passportStruct$PassportFieldGroupHeader.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, passportStruct$PassportFieldGroupHeader);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$ResponseGetPassportGroupList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"groups_", PassportStruct$PassportFieldGroupHeader.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$ResponseGetPassportGroupList.class) {
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

    public PassportStruct$PassportFieldGroupHeader getGroups(int i) {
        return (PassportStruct$PassportFieldGroupHeader) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<PassportStruct$PassportFieldGroupHeader> getGroupsList() {
        return this.groups_;
    }

    public ZZ4 getGroupsOrBuilder(int i) {
        return (ZZ4) this.groups_.get(i);
    }

    public List<? extends ZZ4> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public static a newBuilder(PassportOuterClass$ResponseGetPassportGroupList passportOuterClass$ResponseGetPassportGroupList) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$ResponseGetPassportGroupList);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, PassportStruct$PassportFieldGroupHeader passportStruct$PassportFieldGroupHeader) {
        passportStruct$PassportFieldGroupHeader.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, passportStruct$PassportFieldGroupHeader);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(byte[] bArr) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(InputStream inputStream) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$ResponseGetPassportGroupList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$ResponseGetPassportGroupList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
