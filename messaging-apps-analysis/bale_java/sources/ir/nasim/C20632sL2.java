package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupAvatar;
import ai.bale.proto.GroupsOuterClass$RequestRemoveGroupAvatar;
import ai.bale.proto.GroupsOuterClass$ResponseEditGroupAvatar;
import ai.bale.proto.Misc$ResponseSeqDate;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC10839cH7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.HashMap;

/* renamed from: ir.nasim.sL2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20632sL2 extends AbstractC6360Ng4 {
    private C9057Yh4 m;
    private HashMap n;
    private HashMap o;

    /* renamed from: ir.nasim.sL2$a */
    public static class a {
        private int a;
        private String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public String a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.sL2$b */
    public static class b implements InterfaceC15283jK {
        private int a;
        private long b;

        b(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public long a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    public C20632sL2(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = new HashMap();
        this.o = new HashMap();
        this.m = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 l0(int i, long j, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return this.m.V().S(misc$ResponseSeqDate.getSeq(), misc$ResponseSeqDate.getState().a0(), new KD7(i, j, this.m.i0(), null, misc$ResponseSeqDate.getDate()), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i, long j, C14505i18 c14505i18) {
        j0(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(long j, int i, Exception exc) {
        if (this.o.containsKey(Long.valueOf(j))) {
            Integer num = (Integer) this.o.get(Long.valueOf(j));
            num.intValue();
            if (((Long) this.n.get(Integer.valueOf(i))).longValue() != j) {
                return;
            }
            this.n.remove(num);
            this.o.remove(Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 o0(int i, long j, GroupsOuterClass$ResponseEditGroupAvatar groupsOuterClass$ResponseEditGroupAvatar) {
        return this.m.V().S(groupsOuterClass$ResponseEditGroupAvatar.getSeq(), groupsOuterClass$ResponseEditGroupAvatar.getState().a0(), new KD7(i, j, this.m.i0(), C18732p92.R(groupsOuterClass$ResponseEditGroupAvatar.getAvatar()), groupsOuterClass$ResponseEditGroupAvatar.getDate()), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(int i, long j, C14505i18 c14505i18) {
        j0(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(long j, Exception exc) {
        if (this.o.containsKey(Long.valueOf(j))) {
            Integer num = (Integer) this.o.get(Long.valueOf(j));
            num.intValue();
            if (((Long) this.n.get(num)).longValue() != j) {
                return;
            }
            this.n.remove(num);
            this.o.remove(Long.valueOf(j));
        }
    }

    private C6517Nv5 r0(final int i, long j) {
        if (this.n.containsKey(Integer.valueOf(i))) {
            this.m.D().S(((Long) this.n.get(Integer.valueOf(i))).longValue());
            this.n.remove(Integer.valueOf(i));
        }
        final long jA = AbstractC19981rG5.a();
        this.n.put(Integer.valueOf(i), Long.valueOf(jA));
        this.o.put(Long.valueOf(jA), Integer.valueOf(i));
        return L(new C22871vx5("/bale.groups.v1.Groups/RemoveGroupAvatar", GroupsOuterClass$RequestRemoveGroupAvatar.newBuilder().C((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i).A(((C14697iL2) this.m.E().X1().d(i)).getAccessHash()).a()).B((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(j).a()).A(PC.b).D(jA).a(), Misc$ResponseSeqDate.getDefaultInstance())).H(new InterfaceC17569nB2() { // from class: ir.nasim.pL2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.l0(i, jA, (Misc$ResponseSeqDate) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qL2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.m0(i, jA, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.rL2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.n0(jA, i, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (!(obj instanceof b)) {
            return super.G(obj);
        }
        b bVar = (b) obj;
        return r0(bVar.b(), bVar.a());
    }

    public void j0(int i, long j) {
        if (this.n.containsKey(Integer.valueOf(i)) && ((Long) this.n.get(Integer.valueOf(i))).longValue() == j) {
            this.n.remove(Integer.valueOf(i));
        }
    }

    public void k0(int i, String str) {
        if (this.n.containsKey(Integer.valueOf(i))) {
            this.m.D().S(((Long) this.n.get(Integer.valueOf(i))).longValue());
            this.n.remove(Integer.valueOf(i));
        }
        long jA = AbstractC19981rG5.a();
        this.n.put(Integer.valueOf(i), Long.valueOf(jA));
        this.o.put(Long.valueOf(jA), Integer.valueOf(i));
        this.m.D().X(jA, C11458d25.w(i, W25.b), new ExPeer(ExPeerType.GROUP, i), str, "avatar.jpg", "Avatar", r(), null, EnumC4543Fo6.b, InterfaceC10839cH7.b.a);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof a) {
            a aVar = (a) obj;
            k0(aVar.b(), aVar.a());
        } else if (obj instanceof VG7) {
            VG7 vg7 = (VG7) obj;
            s0(vg7.c(), vg7.a());
        } else if (obj instanceof C9629aH7) {
            t0(((C9629aH7) obj).a());
        } else {
            super.m(obj);
        }
    }

    public void s0(final long j, FileReference fileReference) {
        if (this.o.containsKey(Long.valueOf(j))) {
            Integer num = (Integer) this.o.get(Long.valueOf(j));
            final int iIntValue = num.intValue();
            long accessHash = ((C14697iL2) this.m.E().X1().d(iIntValue)).getAccessHash();
            if (((Long) this.n.get(num)).longValue() != j) {
                return;
            }
            L(new C22871vx5("/bale.groups.v1.Groups/EditGroupAvatar", GroupsOuterClass$RequestEditGroupAvatar.newBuilder().C((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(iIntValue).A(accessHash).a()).B((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(fileReference.getFileId()).A(fileReference.getAccessHash()).C(fileReference.getFileStorageVersion() != null ? (Int32Value) Int32Value.newBuilder().A(fileReference.getFileStorageVersion().intValue()).a() : Int32Value.getDefaultInstance()).a()).A(PC.b).a(), GroupsOuterClass$ResponseEditGroupAvatar.getDefaultInstance())).H(new InterfaceC17569nB2() { // from class: ir.nasim.mL2
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.o0(iIntValue, j, (GroupsOuterClass$ResponseEditGroupAvatar) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nL2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.p0(iIntValue, j, (C14505i18) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.oL2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.q0(j, (Exception) obj);
                }
            });
        }
    }

    public void t0(long j) {
        if (this.o.containsKey(Long.valueOf(j))) {
            Integer num = (Integer) this.o.get(Long.valueOf(j));
            num.intValue();
            if (((Long) this.n.get(num)).longValue() != j) {
                return;
            }
            this.n.remove(num);
            this.o.remove(Long.valueOf(j));
        }
    }
}
