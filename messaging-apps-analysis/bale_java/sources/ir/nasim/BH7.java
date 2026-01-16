package ir.nasim;

import ir.nasim.InterfaceC24244yH7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes7.dex */
public final class BH7 implements InterfaceC19401qH7 {
    private final C24963zV6 a;
    private final C14970in2 b;
    private final SettingsModule c;
    private final InterfaceC8327Vm4 d;
    private final InterfaceC10040ay6 e;

    public BH7(C24963zV6 c24963zV6, C14970in2 c14970in2, SettingsModule settingsModule) {
        AbstractC13042fc3.i(c24963zV6, "storyUploadApi");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = c24963zV6;
        this.b = c14970in2;
        this.c = settingsModule;
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(2, 2, EnumC6162Ml0.DROP_OLDEST);
        this.d = interfaceC8327Vm4A;
        this.e = interfaceC8327Vm4A;
    }

    @Override // ir.nasim.InterfaceC19401qH7
    public void a(long j, FileReference fileReference, Long l) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        this.d.c(new InterfaceC24244yH7.a(j, fileReference));
    }

    @Override // ir.nasim.InterfaceC19401qH7
    public void c(long j) {
        this.d.c(new InterfaceC24244yH7.b(j));
    }

    public final void d() {
        this.c.J7(false);
    }

    public final Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.c(interfaceC20295rm1);
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.b(interfaceC20295rm1);
    }

    public final boolean g() {
        return this.c.k4();
    }

    public final String h() {
        return this.c.j4();
    }

    public final boolean i() {
        return this.c.O5();
    }

    public final InterfaceC10040ay6 j() {
        return this.e;
    }

    public final void k() {
        this.c.H7(true);
    }

    public final void l(long j) {
        this.b.R(j);
    }

    public final void m(long j, ExPeer exPeer, String str, String str2, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "fileAddress");
        AbstractC13042fc3.i(str2, "mimeType");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        this.b.b0(j, exPeer, str, "story" + str2, "Story", this, enumC4543Fo6, h);
    }

    @Override // ir.nasim.InterfaceC19401qH7
    public void b(long j) {
    }
}
