package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonShortcutsSection extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonShortcutsSection DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHORTCUTS_FIELD_NUMBER = 1;
    private B.j shortcuts_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonShortcutsSection.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonShortcutsSection garsonStruct$GarsonShortcutsSection = new GarsonStruct$GarsonShortcutsSection();
        DEFAULT_INSTANCE = garsonStruct$GarsonShortcutsSection;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonShortcutsSection.class, garsonStruct$GarsonShortcutsSection);
    }

    private GarsonStruct$GarsonShortcutsSection() {
    }

    private void addAllShortcuts(Iterable<? extends GarsonStruct$GarsonShortcut> iterable) {
        ensureShortcutsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.shortcuts_);
    }

    private void addShortcuts(GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut) {
        garsonStruct$GarsonShortcut.getClass();
        ensureShortcutsIsMutable();
        this.shortcuts_.add(garsonStruct$GarsonShortcut);
    }

    private void clearShortcuts() {
        this.shortcuts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureShortcutsIsMutable() {
        B.j jVar = this.shortcuts_;
        if (jVar.u()) {
            return;
        }
        this.shortcuts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonStruct$GarsonShortcutsSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonShortcutsSection parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeShortcuts(int i) {
        ensureShortcutsIsMutable();
        this.shortcuts_.remove(i);
    }

    private void setShortcuts(int i, GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut) {
        garsonStruct$GarsonShortcut.getClass();
        ensureShortcutsIsMutable();
        this.shortcuts_.set(i, garsonStruct$GarsonShortcut);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonShortcutsSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"shortcuts_", GarsonStruct$GarsonShortcut.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonShortcutsSection.class) {
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

    public GarsonStruct$GarsonShortcut getShortcuts(int i) {
        return (GarsonStruct$GarsonShortcut) this.shortcuts_.get(i);
    }

    public int getShortcutsCount() {
        return this.shortcuts_.size();
    }

    public List<GarsonStruct$GarsonShortcut> getShortcutsList() {
        return this.shortcuts_;
    }

    public DE2 getShortcutsOrBuilder(int i) {
        return (DE2) this.shortcuts_.get(i);
    }

    public List<? extends DE2> getShortcutsOrBuilderList() {
        return this.shortcuts_;
    }

    public static a newBuilder(GarsonStruct$GarsonShortcutsSection garsonStruct$GarsonShortcutsSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonShortcutsSection);
    }

    public static GarsonStruct$GarsonShortcutsSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addShortcuts(int i, GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut) {
        garsonStruct$GarsonShortcut.getClass();
        ensureShortcutsIsMutable();
        this.shortcuts_.add(i, garsonStruct$GarsonShortcut);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonShortcutsSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcutsSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
