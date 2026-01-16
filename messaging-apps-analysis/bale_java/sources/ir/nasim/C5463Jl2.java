package ir.nasim;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: ir.nasim.Jl2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5463Jl2 implements InterfaceC14123hO3 {
    public static final C5463Jl2 a = new C5463Jl2();

    private C5463Jl2() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FilesStruct$FileLocation a(C4995Hl2 c4995Hl2) {
        AbstractC13042fc3.i(c4995Hl2, "input");
        GeneratedMessageLite generatedMessageLiteA = FilesStruct$FileLocation.newBuilder().B(c4995Hl2.b()).A(c4995Hl2.a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (FilesStruct$FileLocation) generatedMessageLiteA;
    }
}
