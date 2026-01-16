package ir.nasim.features.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C14505i18;
import ir.nasim.C22042ua0;
import ir.nasim.C5152Ic6;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.C9248Zc6;
import ir.nasim.EnumC11723dV1;
import ir.nasim.HV1;
import ir.nasim.InterfaceC5620Kc6;
import ir.nasim.InterfaceC7298Rc6;
import ir.nasim.KN6;
import ir.nasim.SZ;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.settings.ClearCacheAbolContentView;
import java.io.File;

/* loaded from: classes6.dex */
public class a extends C22042ua0 implements ClearCacheAbolContentView.a {
    TextView c1;
    TextView d1;
    TextView e1;
    TextView f1;
    TextView g1;
    private HV1 h1;

    public static long W9(File file) {
        File[] fileArrListFiles;
        long jW9 = 0;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                jW9 += file2.isDirectory() ? W9(file2) : file2.length();
            }
        }
        return jW9;
    }

    private void X9() {
        q9(new AlertDialog.a(G5()).i(h6(AbstractC12217eE5.clear_database_alert_title)).l(h6(AbstractC12217eE5.dialog_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.dV0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.ca(dialogInterface, i);
            }
        }).j(h6(AbstractC12217eE5.dialog_no), new DialogInterface.OnClickListener() { // from class: ir.nasim.eV0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ir.nasim.features.settings.a.da(dialogInterface, i);
            }
        }).a());
    }

    private void Y9() {
        HV1 hv1 = this.h1;
        if (hv1 != null) {
            hv1.dispose();
            this.h1 = null;
        }
    }

    public static String Z9(Long l) {
        float fLongValue = l.longValue() / 1024.0f;
        if (fLongValue < 1024.0f) {
            return String.format("%.0f", Float.valueOf(fLongValue)) + C5721Ko.b.getResources().getString(AbstractC12217eE5.file_size_kb);
        }
        float f = fLongValue / 1024.0f;
        if (f >= 1024.0f) {
            return String.format("%.1f", Float.valueOf(f / 1024.0f)) + C5721Ko.b.getResources().getString(AbstractC12217eE5.file_size_gb);
        }
        return String.format("%.1f", Float.valueOf(f)) + C5721Ko.b.getResources().getString(AbstractC12217eE5.file_size_mb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C14505i18 aa() {
        AbstractC5969Lp4.d().A();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(C14505i18 c14505i18) {
        R4();
        ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(DialogInterface dialogInterface, int i) {
        t2(AbstractC12217eE5.clear_database_progress);
        SZ.e(new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.gV0
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return ir.nasim.features.settings.a.aa();
            }
        }).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.hV0
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                this.a.ba((C14505i18) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void da(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(View view) {
        ja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fa(View view) {
        X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(long j, long j2) {
        Context contextG5 = G5();
        if (contextG5 == null) {
            return;
        }
        this.e1.setText(contextG5.getString(AbstractC12217eE5.clear_cache_label) + " (" + Z9(Long.valueOf(j)) + Separators.RPAREN);
        this.f1.setText(contextG5.getString(AbstractC12217eE5.clear_database_label) + " (" + Z9(Long.valueOf(j2)) + Separators.RPAREN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha() {
        final long jW9 = W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Images")) + W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Audio")) + W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Video")) + W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Documents")) + W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "tmp"));
        final long jE = KN6.s().e();
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.fV0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.ga(jW9, jE);
            }
        });
    }

    private void ia() {
        Y9();
        this.h1 = SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.cV0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.ha();
            }
        })).h(EnumC11723dV1.IO));
    }

    private void ja() {
        C14486i0 c14486i0F = C14486i0.f(Q7());
        ClearCacheAbolContentView clearCacheAbolContentView = new ClearCacheAbolContentView(G5(), this);
        clearCacheAbolContentView.setAbolInstance(c14486i0F);
        c14486i0F.o(clearCacheAbolContentView);
    }

    @Override // ir.nasim.features.settings.ClearCacheAbolContentView.a
    public void E2() {
        ia();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_clear_cache, viewGroup, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.o());
        ((BaleToolbar) viewInflate.findViewById(BC5.clear_cache_toolbar)).setHasBackButton(Q7(), true);
        View viewFindViewById = viewInflate.findViewById(BC5.clear_cache_layout);
        View viewFindViewById2 = viewInflate.findViewById(BC5.clear_database_layout);
        viewFindViewById.setBackground(AbstractC4310Eo7.d(0, c5495Jo7.O0()));
        viewFindViewById2.setBackgroundColor(c5495Jo7.O0());
        TextView textView = (TextView) viewInflate.findViewById(BC5.description_text_view);
        this.c1 = textView;
        textView.setText(AbstractC12217eE5.clear_cache_description);
        this.c1.setTypeface(C6011Lu2.k());
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.clear_cache_more_detail);
        this.d1 = textView2;
        textView2.setText(AbstractC12217eE5.clear_cache_more_detail);
        this.d1.setTypeface(C6011Lu2.k());
        this.e1 = (TextView) viewInflate.findViewById(BC5.clear_cache_label);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.aV0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ea(view);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bV0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.fa(view);
            }
        });
        this.f1 = (TextView) viewInflate.findViewById(BC5.clear_database_label);
        this.g1 = (TextView) viewInflate.findViewById(BC5.clear_database_description);
        ia();
        return viewInflate;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        Y9();
        super.T6();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        ia();
    }
}
