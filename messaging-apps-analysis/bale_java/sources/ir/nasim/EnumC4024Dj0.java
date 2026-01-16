package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Build;
import android.os.VibrationEffect;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.Dj0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public enum EnumC4024Dj0 {
    IMPACT_LIGHT(new long[]{7}, new int[]{65}, new long[]{60}),
    IMPACT_MEDIUM(new long[]{7}, new int[]{SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER}, new long[]{70}),
    IMPACT_HEAVY(new long[]{7}, new int[]{255}, new long[]{80}),
    IMPACT_RIGID(new long[]{3}, new int[]{225}, new long[]{50}),
    IMPACT_SOFT(new long[]{10}, new int[]{175}, new long[]{55}),
    NOTIFICATION_ERROR(new long[]{14, 48, 14, 48, 14, 48, 20}, new int[]{200, 0, 200, 0, 255, 0, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER}, new long[]{40, 60, 40, 60, 65, 60, 40}),
    NOTIFICATION_SUCCESS(new long[]{14, 65, 14}, new int[]{175, 0, 255}, new long[]{50, 60, 65}),
    NOTIFICATION_WARNING(new long[]{14, 64, 14}, new int[]{225, 0, 175}, new long[]{65, 60, 40}),
    SELECTION_CHANGE(new long[]{1}, new int[]{65}, new long[]{30}),
    APP_ERROR(new long[]{30, 10, 150, 10}, new int[]{0, 100, 0, 100}, new long[]{40, 60, 40, 60, 65, 60, 40});

    public final long[] a;
    public final int[] b;
    public final long[] c;
    private Object d;

    EnumC4024Dj0(long[] jArr, int[] iArr, long[] jArr2) {
        this.a = jArr;
        this.b = iArr;
        this.c = jArr2;
    }

    public VibrationEffect j() {
        if (this.d == null) {
            if (AbstractC21455b.r0().hasAmplitudeControl()) {
                this.d = VibrationEffect.createWaveform(this.a, this.b, -1);
            } else {
                this.d = VibrationEffect.createWaveform(this.c, -1);
            }
        }
        return AbstractC3790Cj0.a(this.d);
    }

    public void p() {
        if (Build.VERSION.SDK_INT >= 26) {
            AbstractC21455b.r0().vibrate(j());
        } else {
            AbstractC21455b.r0().vibrate(this.c, -1);
        }
    }
}
