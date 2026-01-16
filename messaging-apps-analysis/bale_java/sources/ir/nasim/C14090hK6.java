package ir.nasim;

import ir.nasim.C21753u45;
import ir.nasim.G35;
import ir.nasim.J35;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.hK6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14090hK6 extends VW7 {
    private final int b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;
    private Set e;

    /* renamed from: ir.nasim.hK6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C21753u45.d.values().length];
            try {
                iArr[C21753u45.d.s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C21753u45.d.u.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C21753u45.d.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C14090hK6(int i) {
        this.b = i;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C13499gK6(false, false, null, 7, null));
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.e = AbstractC4597Fu6.d();
    }

    private final void P0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new C13499gK6(true, false, null, 6, null)));
    }

    private final void U0() {
        Object value;
        Set set = this.e;
        boolean z = set == null || set.isEmpty();
        boolean z2 = this.b >= 31;
        C21753u45.d dVar = C21753u45.d.s;
        List listS = AbstractC10360bX0.s(dVar);
        if (z2) {
            listS.add(C21753u45.d.u);
        }
        List listM1 = AbstractC15401jX0.m1(listS);
        List listS2 = AbstractC10360bX0.s(dVar, C21753u45.d.f);
        if (z2) {
            Set set2 = this.e;
            C21753u45.d dVar2 = C21753u45.d.u;
            if (set2.contains(dVar2)) {
                listS2.add(dVar2);
            }
        }
        List listM12 = AbstractC15401jX0.m1(listS2);
        boolean z3 = this.e.containsAll(listM1) && this.e.size() == listM1.size();
        boolean z4 = this.e.containsAll(listM12) && this.e.size() == listM12.size();
        J35 j35D = ((C13499gK6) this.c.getValue()).d();
        J35 aVar = (z || !(j35D instanceof J35.a)) ? (z3 && j35D == null && z2) ? new J35.a(AbstractC15401jX0.m1(this.e), new G35.b(AbstractC12217eE5.call_phone_and_record_audio_desciption, KB5.ic_permission_voice)) : (z4 && j35D == null && z2) ? new J35.a(AbstractC15401jX0.m1(this.e), new G35.b(AbstractC12217eE5.call_phone_and_record_audio_video_desciption, KB5.ic_multi_permission_voice_camera)) : (z4 && j35D == null) ? new J35.a(AbstractC15401jX0.m1(this.e), new G35.b(AbstractC12217eE5.call_record_audio_video_desciption, KB5.ic_multi_permission_voice_camera)) : !z ? new J35.b((C21753u45.d) AbstractC15401jX0.p0(this.e)) : null : new J35.a(AbstractC15401jX0.m1(this.e), G35.a.a);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13499gK6.b((C13499gK6) value, false, z, aVar, 1, null)));
    }

    public final InterfaceC10258bL6 R0() {
        return this.d;
    }

    public final void S0(C21753u45.d dVar, boolean z) {
        AbstractC13042fc3.i(dVar, "permissionType");
        int i = a.a[dVar.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            C19406qI3.a("CallViewModel", "permission <" + dVar + "> not handled ", new Object[0]);
        } else if (!z) {
            P0();
            return;
        }
        this.e = AbstractC4846Gu6.k(AbstractC15401jX0.q1(this.e), dVar);
        U0();
    }

    public final void T0(Set set) {
        AbstractC13042fc3.i(set, "permissions");
        this.e = AbstractC4846Gu6.l(AbstractC15401jX0.q1(this.e), set);
        U0();
    }
}
