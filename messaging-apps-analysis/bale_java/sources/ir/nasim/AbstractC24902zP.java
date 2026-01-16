package ir.nasim;

import android.media.AudioAttributes;

/* renamed from: ir.nasim.zP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24902zP {
    private final int a;
    private final AudioAttributes b;
    private final int c;

    /* renamed from: ir.nasim.zP$a */
    public static final class a extends AbstractC24902zP {
        /* JADX WARN: Illegal instructions before constructor call */
        public a() {
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(2).setContentType(1).build();
            AbstractC13042fc3.h(audioAttributesBuild, "build(...)");
            super(3, audioAttributesBuild, 0, null);
        }
    }

    public /* synthetic */ AbstractC24902zP(int i, AudioAttributes audioAttributes, int i2, ED1 ed1) {
        this(i, audioAttributes, i2);
    }

    public final AudioAttributes a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    private AbstractC24902zP(int i, AudioAttributes audioAttributes, int i2) {
        this.a = i;
        this.b = audioAttributes;
        this.c = i2;
    }
}
