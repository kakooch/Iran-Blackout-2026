package ir.nasim;

import android.media.AudioAttributes;

/* loaded from: classes3.dex */
public final class MN implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public MN(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static AudioAttributes a(AbstractC24902zP abstractC24902zP) {
        return (AudioAttributes) AbstractC4746Gj5.d(KN.a.c(abstractC24902zP));
    }

    public static MN b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new MN(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AudioAttributes get() {
        return a((AbstractC24902zP) this.a.get());
    }
}
