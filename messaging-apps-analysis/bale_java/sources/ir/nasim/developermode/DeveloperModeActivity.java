package ir.nasim.developermode;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.compose.foundation.layout.q;
import androidx.compose.foundation.layout.t;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC12582er2;
import ir.nasim.AbstractC12623ev3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16159ko0;
import ir.nasim.AbstractC17932no0;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC20271rj7;
import ir.nasim.AbstractC21071t37;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC7191Qq7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9105Ym7;
import ir.nasim.AbstractC9758aW1;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.C24254yJ;
import ir.nasim.C24381yX0;
import ir.nasim.C9784aZ0;
import ir.nasim.DG7;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.G41;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15069ix3;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC16782lr2;
import ir.nasim.InterfaceC16978mB2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24779zB6;
import ir.nasim.InterfaceC6988Pv3;
import ir.nasim.InterfaceC9049Yg5;
import ir.nasim.KV0;
import ir.nasim.M10;
import ir.nasim.R01;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XY0;
import ir.nasim.ZG4;
import ir.nasim.ZV1;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.entity.CallRemoteConfig;
import ir.nasim.developermode.DeveloperModeActivity;
import ir.nasim.util.preview.DesignSystemPreviewsActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lir/nasim/developermode/DeveloperModeActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "Lir/nasim/zB6;", "A", "Lir/nasim/zB6;", "C0", "()Lir/nasim/zB6;", "setShowkaseLauncher", "(Lir/nasim/zB6;)V", "showkaseLauncher", "Lir/nasim/core/modules/settings/SettingsModule;", "B", "Lir/nasim/core/modules/settings/SettingsModule;", "B0", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "developerMode_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class DeveloperModeActivity extends Hilt_DeveloperModeActivity {

    /* renamed from: A, reason: from kotlin metadata */
    public InterfaceC24779zB6 showkaseLauncher;

    /* renamed from: B, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ CallRemoteConfig b;
        final /* synthetic */ EnumC4196Ec1[] c;
        final /* synthetic */ ClipboardManager d;
        final /* synthetic */ EnumC4716Gg2[] e;

        /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a, reason: collision with other inner class name */
        static final class C1025a implements InterfaceC14603iB2 {
            final /* synthetic */ DeveloperModeActivity a;
            final /* synthetic */ CallRemoteConfig b;
            final /* synthetic */ EnumC4196Ec1[] c;
            final /* synthetic */ ClipboardManager d;
            final /* synthetic */ EnumC4716Gg2[] e;

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$a, reason: collision with other inner class name */
            static final class C1026a implements InterfaceC15796kB2 {
                final /* synthetic */ DeveloperModeActivity a;

                /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$a$a, reason: collision with other inner class name */
                static final class C1027a implements InterfaceC15796kB2 {
                    final /* synthetic */ DeveloperModeActivity a;

                    C1027a(DeveloperModeActivity developerModeActivity) {
                        this.a = developerModeActivity;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(DeveloperModeActivity developerModeActivity) {
                        AbstractC13042fc3.i(developerModeActivity, "this$0");
                        developerModeActivity.C0().a();
                        return C19938rB7.a;
                    }

                    public final void b(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
                        if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        interfaceC22053ub1.W(481615123);
                        boolean zD = interfaceC22053ub1.D(this.a);
                        final DeveloperModeActivity developerModeActivity = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.developermode.b
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return DeveloperModeActivity.a.C1025a.C1026a.C1027a.c(developerModeActivity);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC17932no0.O((SA2) objB, InterfaceC19114po0.b.a.a, "Showkase :-)", null, null, interfaceC22053ub1, (InterfaceC19114po0.b.a.b << 3) | 384, 24);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                C1026a(DeveloperModeActivity developerModeActivity) {
                    this.a = developerModeActivity;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarM = q.m(t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, C17784nZ1.q(16), 0.0f, 0.0f, 13, null);
                    C24254yJ c24254yJ = C24254yJ.a;
                    float f = 8;
                    AbstractC12582er2.b(eVarM, c24254yJ.o(C17784nZ1.q(f)), c24254yJ.o(C17784nZ1.q(f)), null, 0, 0, AbstractC19242q11.e(-1539025279, true, new C1027a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 1573302, 56);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ CallRemoteConfig a;

                b(CallRemoteConfig callRemoteConfig) {
                    this.a = callRemoteConfig;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC9105Ym7.b(String.valueOf(this.a), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                    }
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$c */
            static final class c implements PointerInputEventHandler {
                final /* synthetic */ ClipboardManager a;
                final /* synthetic */ EnumC4196Ec1 b;
                final /* synthetic */ DeveloperModeActivity c;

                /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$c$a, reason: collision with other inner class name */
                static final class C1028a implements UA2 {
                    final /* synthetic */ ClipboardManager a;
                    final /* synthetic */ EnumC4196Ec1 b;
                    final /* synthetic */ DeveloperModeActivity c;

                    C1028a(ClipboardManager clipboardManager, EnumC4196Ec1 enumC4196Ec1, DeveloperModeActivity developerModeActivity) {
                        this.a = clipboardManager;
                        this.b = enumC4196Ec1;
                        this.c = developerModeActivity;
                    }

                    public final void a(long j) {
                        this.a.setPrimaryClip(ClipData.newPlainText("flag", "app.android." + this.b.getValue()));
                        if (KV0.b()) {
                            Toast.makeText(this.c.getApplicationContext(), "flag copied", 1).show();
                        }
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(((ZG4) obj).t());
                        return C19938rB7.a;
                    }
                }

                c(ClipboardManager clipboardManager, EnumC4196Ec1 enumC4196Ec1, DeveloperModeActivity developerModeActivity) {
                    this.a = clipboardManager;
                    this.b = enumC4196Ec1;
                    this.c = developerModeActivity;
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new C1028a(this.a, this.b, this.c), null, null, interfaceC20295rm1, 13, null);
                    return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$d */
            static final class d implements PointerInputEventHandler {
                final /* synthetic */ ClipboardManager a;
                final /* synthetic */ EnumC4716Gg2 b;
                final /* synthetic */ DeveloperModeActivity c;

                /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$d$a, reason: collision with other inner class name */
                static final class C1029a implements UA2 {
                    final /* synthetic */ ClipboardManager a;
                    final /* synthetic */ EnumC4716Gg2 b;
                    final /* synthetic */ DeveloperModeActivity c;

                    C1029a(ClipboardManager clipboardManager, EnumC4716Gg2 enumC4716Gg2, DeveloperModeActivity developerModeActivity) {
                        this.a = clipboardManager;
                        this.b = enumC4716Gg2;
                        this.c = developerModeActivity;
                    }

                    public final void a(long j) {
                        this.a.setPrimaryClip(ClipData.newPlainText("flag", "app.android." + this.b.getValue()));
                        if (KV0.b()) {
                            Toast.makeText(this.c.getApplicationContext(), "flag copied", 1).show();
                        }
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(((ZG4) obj).t());
                        return C19938rB7.a;
                    }
                }

                d(ClipboardManager clipboardManager, EnumC4716Gg2 enumC4716Gg2, DeveloperModeActivity developerModeActivity) {
                    this.a = clipboardManager;
                    this.b = enumC4716Gg2;
                    this.c = developerModeActivity;
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new C1029a(this.a, this.b, this.c), null, null, interfaceC20295rm1, 13, null);
                    return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$e */
            static final class e implements InterfaceC15796kB2 {
                final /* synthetic */ DeveloperModeActivity a;

                e(DeveloperModeActivity developerModeActivity) {
                    this.a = developerModeActivity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(DeveloperModeActivity developerModeActivity) {
                    AbstractC13042fc3.i(developerModeActivity, "this$0");
                    developerModeActivity.startActivity(new Intent(developerModeActivity, (Class<?>) DesignSystemPreviewsActivity.class));
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(-1184980889);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final DeveloperModeActivity developerModeActivity = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.developermode.c
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return DeveloperModeActivity.a.C1025a.e.c(developerModeActivity);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC16159ko0.a((SA2) objB, null, false, null, null, null, null, null, null, G41.a.d(), interfaceC22053ub1, 805306368, 510);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$f */
            public static final class f extends AbstractC8614Ws3 implements UA2 {
                public static final f e = new f();

                public f() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$g */
            public static final class g extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ Object[] f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public g(UA2 ua2, Object[] objArr) {
                    super(1);
                    this.e = ua2;
                    this.f = objArr;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f[i]);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$h */
            public static final class h extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ Object[] e;
                final /* synthetic */ ClipboardManager f;
                final /* synthetic */ DeveloperModeActivity g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public h(Object[] objArr, ClipboardManager clipboardManager, DeveloperModeActivity developerModeActivity) {
                    super(4);
                    this.e = objArr;
                    this.f = clipboardManager;
                    this.g = developerModeActivity;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-1043393750, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:250)");
                    }
                    EnumC4196Ec1 enumC4196Ec1 = (EnumC4196Ec1) this.e[i];
                    interfaceC22053ub1.W(1915370472);
                    e.a aVar = androidx.compose.ui.e.a;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1185138314);
                    boolean zD = interfaceC22053ub1.D(this.f) | interfaceC22053ub1.V(enumC4196Ec1) | interfaceC22053ub1.D(this.g);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new c(this.f, enumC4196Ec1, this.g);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarC = AbstractC21071t37.c(aVar, c19938rB7, (PointerInputEventHandler) objB);
                    InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
                    InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar2.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    C9784aZ0 c9784aZ0 = C9784aZ0.a;
                    AbstractC9105Ym7.b(enumC4196Ec1.name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                    boolean zW0 = AbstractC5969Lp4.d().w0(enumC4196Ec1);
                    C24381yX0.a aVar3 = C24381yX0.b;
                    AbstractC9105Ym7.b("is Enabled ? " + zW0, androidx.compose.foundation.b.d(aVar, zW0 ? aVar3.d() : aVar3.g(), null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131068);
                    AbstractC9105Ym7.b("key : " + enumC4196Ec1.getValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                    AbstractC9758aW1.a(androidx.compose.foundation.b.d(t.i(t.h(aVar, 0.0f, 1, null), C17784nZ1.q((float) 1)), C24381yX0.b.a(), null, 2, null), 0L, 0.0f, 0.0f, interfaceC22053ub1, 6, 14);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$i */
            public static final class i extends AbstractC8614Ws3 implements UA2 {
                public static final i e = new i();

                public i() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$j */
            public static final class j extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ Object[] f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public j(UA2 ua2, Object[] objArr) {
                    super(1);
                    this.e = ua2;
                    this.f = objArr;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f[i]);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.developermode.DeveloperModeActivity$a$a$k */
            public static final class k extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ Object[] e;
                final /* synthetic */ ClipboardManager f;
                final /* synthetic */ DeveloperModeActivity g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public k(Object[] objArr, ClipboardManager clipboardManager, DeveloperModeActivity developerModeActivity) {
                    super(4);
                    this.e = objArr;
                    this.f = clipboardManager;
                    this.g = developerModeActivity;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-1043393750, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:250)");
                    }
                    EnumC4716Gg2 enumC4716Gg2 = (EnumC4716Gg2) this.e[i];
                    interfaceC22053ub1.W(1918144228);
                    e.a aVar = androidx.compose.ui.e.a;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1185048841);
                    boolean zD = interfaceC22053ub1.D(this.f) | interfaceC22053ub1.V(enumC4716Gg2) | interfaceC22053ub1.D(this.g);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new d(this.f, enumC4716Gg2, this.g);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarC = AbstractC21071t37.c(aVar, c19938rB7, (PointerInputEventHandler) objB);
                    InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
                    InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar2.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    C9784aZ0 c9784aZ0 = C9784aZ0.a;
                    AbstractC9105Ym7.b(enumC4716Gg2.name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                    boolean zW0 = AbstractC5969Lp4.d().w0(enumC4716Gg2);
                    C24381yX0.a aVar3 = C24381yX0.b;
                    AbstractC9105Ym7.b("is Enabled ? " + zW0, androidx.compose.foundation.b.d(aVar, zW0 ? aVar3.d() : aVar3.g(), null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131068);
                    AbstractC9105Ym7.b("key : " + enumC4716Gg2.getValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                    AbstractC9758aW1.a(androidx.compose.foundation.b.d(t.i(t.h(aVar, 0.0f, 1, null), C17784nZ1.q((float) 1)), C24381yX0.b.a(), null, 2, null), 0L, 0.0f, 0.0f, interfaceC22053ub1, 6, 14);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            C1025a(DeveloperModeActivity developerModeActivity, CallRemoteConfig callRemoteConfig, EnumC4196Ec1[] enumC4196Ec1Arr, ClipboardManager clipboardManager, EnumC4716Gg2[] enumC4716Gg2Arr) {
                this.a = developerModeActivity;
                this.b = callRemoteConfig;
                this.c = enumC4196Ec1Arr;
                this.d = clipboardManager;
                this.e = enumC4716Gg2Arr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(EnumC4196Ec1[] enumC4196Ec1Arr, EnumC4716Gg2[] enumC4716Gg2Arr, DeveloperModeActivity developerModeActivity, CallRemoteConfig callRemoteConfig, ClipboardManager clipboardManager, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(enumC4196Ec1Arr, "$configFlags");
                AbstractC13042fc3.i(enumC4716Gg2Arr, "$featureFlags");
                AbstractC13042fc3.i(developerModeActivity, "this$0");
                AbstractC13042fc3.i(clipboardManager, "$clipboard");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1860303942, true, new C1026a(developerModeActivity)), 3, null);
                G41 g41 = G41.a;
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, g41.a(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1034795506, true, new b(callRemoteConfig)), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, g41.b(), 3, null);
                interfaceC15069ix3.a(enumC4196Ec1Arr.length, null, new g(f.e, enumC4196Ec1Arr), AbstractC19242q11.c(-1043393750, true, new h(enumC4196Ec1Arr, clipboardManager, developerModeActivity)));
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, g41.c(), 3, null);
                interfaceC15069ix3.a(enumC4716Gg2Arr.length, null, new j(i.e, enumC4716Gg2Arr), AbstractC19242q11.c(-1043393750, true, new k(enumC4716Gg2Arr, clipboardManager, developerModeActivity)));
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1245607211, true, new e(developerModeActivity)), 3, null);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                if ((i2 & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final DeveloperModeActivity developerModeActivity = this.a;
                final CallRemoteConfig callRemoteConfig = this.b;
                final EnumC4196Ec1[] enumC4196Ec1Arr = this.c;
                final ClipboardManager clipboardManager = this.d;
                final EnumC4716Gg2[] enumC4716Gg2Arr = this.e;
                e.a aVar = androidx.compose.ui.e.a;
                C24254yJ.m mVarH = C24254yJ.a.h();
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                AbstractC7191Qq7.b(C9784aZ0.a.c(aVar, aVar2.g()), interfaceC22053ub1, 0);
                ZV1.b(null, C17784nZ1.q(5), 0L, interfaceC22053ub1, 48, 5);
                androidx.compose.ui.e eVarK = q.k(t.f(aVar, 0.0f, 1, null), C17784nZ1.q(4), 0.0f, 2, null);
                interfaceC22053ub1.W(-764971724);
                boolean zD = interfaceC22053ub1.D(developerModeActivity) | interfaceC22053ub1.D(callRemoteConfig) | interfaceC22053ub1.D(enumC4196Ec1Arr) | interfaceC22053ub1.D(clipboardManager) | interfaceC22053ub1.D(enumC4716Gg2Arr);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    Object obj = new UA2() { // from class: ir.nasim.developermode.a
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return DeveloperModeActivity.a.C1025a.c(enumC4196Ec1Arr, enumC4716Gg2Arr, developerModeActivity, callRemoteConfig, clipboardManager, (InterfaceC15069ix3) obj2);
                        }
                    };
                    interfaceC22053ub1.s(obj);
                    objB = obj;
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 6, 510);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(CallRemoteConfig callRemoteConfig, EnumC4196Ec1[] enumC4196Ec1Arr, ClipboardManager clipboardManager, EnumC4716Gg2[] enumC4716Gg2Arr) {
            this.b = callRemoteConfig;
            this.c = enumC4196Ec1Arr;
            this.d = clipboardManager;
            this.e = enumC4716Gg2Arr;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1614893711, true, new C1025a(DeveloperModeActivity.this, this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final SettingsModule B0() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    public final InterfaceC24779zB6 C0() {
        InterfaceC24779zB6 interfaceC24779zB6 = this.showkaseLauncher;
        if (interfaceC24779zB6 != null) {
            return interfaceC24779zB6;
        }
        AbstractC13042fc3.y("showkaseLauncher");
        return null;
    }

    @Override // ir.nasim.developermode.Hilt_DeveloperModeActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnumC4716Gg2[] enumC4716Gg2ArrValues = EnumC4716Gg2.values();
        EnumC4196Ec1[] enumC4196Ec1ArrValues = EnumC4196Ec1.values();
        CallRemoteConfig callRemoteConfigQ0 = B0().Q0();
        Object systemService = getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        R01.b(this, null, AbstractC19242q11.c(-240462516, true, new a(callRemoteConfigQ0, enumC4196Ec1ArrValues, (ClipboardManager) systemService, enumC4716Gg2ArrValues)), 1, null);
    }
}
