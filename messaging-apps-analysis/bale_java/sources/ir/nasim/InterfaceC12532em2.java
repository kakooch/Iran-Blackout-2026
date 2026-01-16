package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.em2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC12532em2 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.em2$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    static /* synthetic */ Object a(InterfaceC12532em2 interfaceC12532em2, FileReference fileReference, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDownload");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return interfaceC12532em2.j(fileReference, z, z2, interfaceC20295rm1);
    }

    static /* synthetic */ Object b(InterfaceC12532em2 interfaceC12532em2, long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadState");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return interfaceC12532em2.l(j, j2, z, interfaceC20295rm1);
    }

    static /* synthetic */ InterfaceC4557Fq2 i(InterfaceC12532em2 interfaceC12532em2, FileReference fileReference, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindDownloadState");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return interfaceC12532em2.g(fileReference, z);
    }

    Object c(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1);

    InterfaceC10258bL6 d();

    Object e(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1);

    Object f(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1);

    InterfaceC4557Fq2 g(FileReference fileReference, boolean z);

    Object h(int i, long j, long j2, String str, String str2, ExPeer exPeer, EnumC4543Fo6 enumC4543Fo6, InterfaceC20295rm1 interfaceC20295rm1);

    Object j(FileReference fileReference, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1);

    Object k(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1);

    Object l(long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1);
}
