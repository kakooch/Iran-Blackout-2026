package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.UsersOuterClass$RequestEditAvatar;
import ai.bale.proto.UsersOuterClass$RequestRemoveAvatar;
import ai.bale.proto.UsersOuterClass$ResponseEditAvatar;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC10839cH7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.qO4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19461qO4 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private long n;

    /* renamed from: ir.nasim.qO4$a */
    public static class a {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.qO4$b */
    public static class b {
        private final String a;

        public b(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.qO4$c */
    public static class c implements InterfaceC15283jK {
        private final long a;

        public c(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    public C19461qO4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = 0L;
        this.m = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(long j, Exception exc) {
        r0(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(long j, C14505i18 c14505i18) {
        r().d(new a(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(long j, C14505i18 c14505i18) {
        r().d(new a(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(final long j, UsersOuterClass$ResponseEditAvatar usersOuterClass$ResponseEditAvatar) {
        this.m.V().S(usersOuterClass$ResponseEditAvatar.getSeq(), usersOuterClass$ResponseEditAvatar.getState().a0(), new OF7(this.m.i0(), usersOuterClass$ResponseEditAvatar.getAvatar(), null), 0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.lO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.o0(j, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(long j, Exception exc) {
        if (j != this.n) {
            return;
        }
        this.n = 0L;
    }

    private void r0(long j) {
        if (j != this.n) {
            return;
        }
        this.n = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void l0(Misc$ResponseSeq misc$ResponseSeq, final long j) {
        this.m.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new OF7(this.m.i0(), null, null), 0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.kO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.n0(j, (C14505i18) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        return obj instanceof c ? s0(Long.valueOf(((c) obj).a())) : super.G(obj);
    }

    public void j0(long j) {
        if (j != this.n) {
            return;
        }
        this.n = 0L;
    }

    public void k0(String str) {
        if (this.n != 0) {
            this.m.D().S(this.n);
            this.n = 0L;
        }
        this.n = AbstractC19981rG5.a();
        C11458d25 c11458d25E = C11458d25.E(this.m.i0());
        this.m.D().X(this.n, c11458d25E.u(), new ExPeer(ExPeerType.PRIVATE, this.m.i0()), str, "avatar.jpg", "Avatar", r(), null, EnumC4543Fo6.b, InterfaceC10839cH7.b.a);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof b) {
            k0(((b) obj).a());
            return;
        }
        if (obj instanceof VG7) {
            VG7 vg7 = (VG7) obj;
            u0(vg7.c(), vg7.a());
        } else if (obj instanceof C9629aH7) {
            v0(((C9629aH7) obj).a());
        } else if (obj instanceof a) {
            j0(((a) obj).a());
        } else {
            super.m(obj);
        }
    }

    public C6517Nv5 s0(Long l) {
        if (this.n != 0) {
            this.m.D().S(this.n);
            this.n = 0L;
        }
        final long jA = AbstractC19981rG5.a();
        this.n = jA;
        UsersOuterClass$RequestRemoveAvatar.a aVarNewBuilder = UsersOuterClass$RequestRemoveAvatar.newBuilder();
        if (l != null) {
            aVarNewBuilder.A((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(l.longValue()).a());
        }
        return L(new C22871vx5("/bale.users.v1.Users/RemoveAvatar", aVarNewBuilder.a(), Misc$ResponseSeq.getDefaultInstance())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.oO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.l0(jA, (Misc$ResponseSeq) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.pO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.m0(jA, (Exception) obj);
            }
        });
    }

    public void u0(final long j, FileReference fileReference) {
        if (j != this.n) {
            return;
        }
        L(new C22871vx5("/bale.users.v1.Users/EditAvatar", UsersOuterClass$RequestEditAvatar.newBuilder().A(FilesStruct$FileLocation.newBuilder().B(fileReference.getFileId()).A(fileReference.getAccessHash()).C(fileReference.getFileStorageVersion() != null ? (Int32Value) Int32Value.newBuilder().A(fileReference.getFileStorageVersion().intValue()).a() : Int32Value.getDefaultInstance())).a(), UsersOuterClass$ResponseEditAvatar.getDefaultInstance())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.mO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.p0(j, (UsersOuterClass$ResponseEditAvatar) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.nO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.q0(j, (Exception) obj);
            }
        });
    }

    public void v0(long j) {
        if (j != this.n) {
            return;
        }
        this.n = 0L;
    }
}
