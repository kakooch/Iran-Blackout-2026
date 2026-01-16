package ir.nasim;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R2\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lir/nasim/zT0;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/AT0;", "binding", "Lir/nasim/rB7;", "R8", "(Lir/nasim/AT0;)V", "Lcom/google/android/material/button/MaterialButton;", "button", "U8", "(Lcom/google/android/material/button/MaterialButton;)V", "T8", "S8", "Landroid/view/View;", "v", "", "isTopItem", "W8", "(Landroid/view/View;Z)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lir/nasim/zm6;", "n1", "Lir/nasim/zm6;", "getCurrentDevice", "()Lir/nasim/zm6;", "X8", "(Lir/nasim/zm6;)V", "currentDevice", "Lkotlin/Function1;", "o1", "Lir/nasim/UA2;", "getOnAudioDeviceChangeCallBack", "()Lir/nasim/UA2;", "Y8", "(Lir/nasim/UA2;)V", "onAudioDeviceChangeCallBack", "Landroid/view/View$OnClickListener;", "p1", "Landroid/view/View$OnClickListener;", "onClickListener", "q1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.zT0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24939zT0 extends com.google.android.material.bottomsheet.b {
    public static final int r1 = 8;

    /* renamed from: n1, reason: from kotlin metadata */
    private EnumC25128zm6 currentDevice;

    /* renamed from: o1, reason: from kotlin metadata */
    private UA2 onAudioDeviceChangeCallBack;

    /* renamed from: p1, reason: from kotlin metadata */
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.nasim.yT0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C24939zT0.V8(this.a, view);
        }
    };

    private final void R8(AT0 binding) {
        MaterialButton materialButton = binding.b;
        AbstractC13042fc3.h(materialButton, "chooseSpeakerBsBackSpeaker");
        U8(materialButton);
        MaterialButton materialButton2 = binding.d;
        AbstractC13042fc3.h(materialButton2, "chooseSpeakerBsEarSpeaker");
        T8(materialButton2);
        MaterialButton materialButton3 = binding.c;
        AbstractC13042fc3.h(materialButton3, "chooseSpeakerBsBluetoothSpeaker");
        S8(materialButton3);
    }

    private final void S8(MaterialButton button) {
        button.setOnClickListener(this.onClickListener);
        button.setEnabled(this.currentDevice != EnumC25128zm6.d);
        W8(button, false);
        button.setBackgroundTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(button.getContext(), TA5.itemBackgroundSecondary)));
    }

    private final void T8(MaterialButton button) {
        button.setOnClickListener(this.onClickListener);
        button.setEnabled(this.currentDevice != EnumC25128zm6.c);
    }

    private final void U8(MaterialButton button) {
        button.setOnClickListener(this.onClickListener);
        button.setEnabled(this.currentDevice != EnumC25128zm6.b);
        W8(button, true);
        button.setBackgroundTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(button.getContext(), TA5.itemBackgroundSecondary)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V8(C24939zT0 c24939zT0, View view) {
        EnumC25128zm6 enumC25128zm6;
        AbstractC13042fc3.i(c24939zT0, "this$0");
        UA2 ua2 = c24939zT0.onAudioDeviceChangeCallBack;
        if (ua2 != null) {
            c24939zT0.u8();
            int id = view.getId();
            if (id == BC5.choose_speaker_bs_back_speaker) {
                enumC25128zm6 = EnumC25128zm6.b;
            } else if (id == BC5.choose_speaker_bs_ear_speaker) {
                enumC25128zm6 = EnumC25128zm6.c;
            } else {
                if (id != BC5.choose_speaker_bs_bluetooth_speaker) {
                    throw new IllegalArgumentException();
                }
                enumC25128zm6 = EnumC25128zm6.d;
            }
            ua2.invoke(enumC25128zm6);
        }
    }

    private final void W8(View v, boolean isTopItem) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(isTopItem ? new float[]{32.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f, 0.0f} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 32.0f, 32.0f, 32.0f, 32.0f});
        v.setBackground(gradientDrawable);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        AT0 at0C = AT0.c(LayoutInflater.from(G5()));
        aVar.setContentView(at0C.getRoot());
        AbstractC13042fc3.f(at0C);
        R8(at0C);
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        I8(0, AbstractC23035wE5.PlayListBottomSheetDialogTheme);
    }

    public final void X8(EnumC25128zm6 enumC25128zm6) {
        this.currentDevice = enumC25128zm6;
    }

    public final void Y8(UA2 ua2) {
        this.onAudioDeviceChangeCallBack = ua2;
    }
}
