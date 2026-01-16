package ir.nasim;

import android.view.KeyEvent;
import ir.nasim.InterfaceC22036uZ3;
import ir.nasim.story.repository.StoryRepository;
import ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum;
import java.util.ArrayList;

/* renamed from: ir.nasim.Tg3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7802Tg3 implements InterfaceC7565Sg3 {
    public static final int b = StoryRepository.s;
    private final StoryRepository a;

    public C7802Tg3(StoryRepository storyRepository) {
        AbstractC13042fc3.i(storyRepository, "storyRepository");
        this.a = storyRepository;
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objH = this.a.H(interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 b() {
        return MW6.INSTANCE.a(645784619, new ArrayList(), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0);
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 d() {
        return TS6.INSTANCE.a();
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public void e(KeyEvent keyEvent) {
        AbstractC13042fc3.i(keyEvent, "event");
        if (keyEvent.getAction() == 0 && AbstractC10360bX0.p(24, 25).contains(Integer.valueOf(keyEvent.getKeyCode()))) {
            this.a.i0(InterfaceC22036uZ3.a.a);
        }
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 f(boolean z, boolean z2) {
        return C6614Og3.INSTANCE.a(z, z2);
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 g(int i, String str) {
        AbstractC13042fc3.i(str, "storyId");
        return MW6.INSTANCE.a(i, new ArrayList(), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : str, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0);
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 h(int i, ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "userIdList");
        return MW6.INSTANCE.a(i, arrayList, (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : WV6.b, (60 & 32) != 0 ? -1 : 0);
    }

    @Override // ir.nasim.InterfaceC7565Sg3
    public C22042ua0 i() {
        return C20672sP6.INSTANCE.a(StoryAdderSourceCallerEnum.e);
    }
}
