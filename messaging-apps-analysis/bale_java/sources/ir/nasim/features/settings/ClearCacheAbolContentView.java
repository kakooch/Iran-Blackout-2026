package ir.nasim.features.settings;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C18495ol2;
import ir.nasim.C24790zC4;
import ir.nasim.C5152Ic6;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C9248Zc6;
import ir.nasim.DD6;
import ir.nasim.EnumC11723dV1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC5620Kc6;
import ir.nasim.SZ;
import ir.nasim.features.settings.ClearCacheAbolContentView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ClearCacheAbolContentView extends RelativeLayout implements InterfaceC16866m0 {
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    private C14486i0 e;
    private a f;

    interface a {
        void E2();
    }

    public ClearCacheAbolContentView(Context context, a aVar) {
        super(context);
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        q(context);
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(final TextView textView, final TextView textView2, final TextView textView3, final TextView textView4) {
        final String strZ9 = ir.nasim.features.settings.a.Z9(Long.valueOf(ir.nasim.features.settings.a.W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Images"))));
        final String strZ92 = ir.nasim.features.settings.a.Z9(Long.valueOf(ir.nasim.features.settings.a.W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Audio"))));
        final String strZ93 = ir.nasim.features.settings.a.Z9(Long.valueOf(ir.nasim.features.settings.a.W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Video"))));
        final String strZ94 = ir.nasim.features.settings.a.Z9(Long.valueOf(ir.nasim.features.settings.a.W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Documents")) + ir.nasim.features.settings.a.W9(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "tmp"))));
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.ZU0
            @Override // java.lang.Runnable
            public final void run() {
                ClearCacheAbolContentView.z(textView, strZ9, textView2, strZ92, textView3, strZ93, textView4, strZ94);
            }
        });
    }

    private void n() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.i);
        ArrayList arrayList = new ArrayList();
        for (String str : interfaceC3570Bk5Q.getAll().keySet()) {
            if (str.startsWith(C18495ol2.E.a())) {
                arrayList.add(str);
            }
        }
        interfaceC3570Bk5Q.i(arrayList);
    }

    private void o(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                o(file2);
            }
        }
        file.delete();
    }

    private void p() {
        this.e.g();
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.XU0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r();
            }
        })).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.YU0
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                this.a.s((C24790zC4) obj);
            }
        }));
    }

    private void q(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return;
        }
        layoutInflater.inflate(AbstractC12208eD5.bottomsheet_clear_cache, this);
        findViewById(BC5.close_compose).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QU0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t(view);
            }
        });
        findViewById(BC5.clean_cache).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RU0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u(view);
            }
        });
        ((TextView) findViewById(BC5.compose_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.clean_cache_text)).setTypeface(C6011Lu2.i());
        ((CheckBox) findViewById(BC5.picture_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.SU0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.v(compoundButton, z);
            }
        });
        ((CheckBox) findViewById(BC5.video_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.TU0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.w(compoundButton, z);
            }
        });
        ((CheckBox) findViewById(BC5.audio_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.UU0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.x(compoundButton, z);
            }
        });
        ((CheckBox) findViewById(BC5.document_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.VU0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.y(compoundButton, z);
            }
        });
        ((TextView) findViewById(BC5.picture_title)).setText(AbstractC12217eE5.clear_cache_type_photo);
        ((TextView) findViewById(BC5.audio_title)).setText(AbstractC12217eE5.clear_cache_type_audio);
        ((TextView) findViewById(BC5.video_title)).setText(AbstractC12217eE5.clear_cache_type_video);
        ((TextView) findViewById(BC5.document_title)).setText(AbstractC12217eE5.clear_cache_type_document);
        final TextView textView = (TextView) findViewById(BC5.picture_size);
        final TextView textView2 = (TextView) findViewById(BC5.audio_size);
        final TextView textView3 = (TextView) findViewById(BC5.video_size);
        final TextView textView4 = (TextView) findViewById(BC5.document_size);
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.WU0
            @Override // java.lang.Runnable
            public final void run() {
                ClearCacheAbolContentView.A(textView, textView2, textView3, textView4);
            }
        })).h(EnumC11723dV1.IO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        ArrayList arrayList = new ArrayList();
        if (this.a) {
            File externalFilesDir = getContext().getExternalFilesDir(null);
            arrayList.add(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Images"));
            StringBuilder sb = new StringBuilder();
            sb.append(externalFilesDir.getAbsolutePath());
            sb.append(Separators.SLASH);
            sb.append("Bale");
            sb.append("/cache");
            arrayList.add(new File(sb.toString()));
            arrayList.add(new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale/files"));
        }
        if (this.b) {
            Iterator it = DD6.c().f().iterator();
            while (it.hasNext()) {
                DD6.c().k((String) it.next());
            }
            arrayList.add(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Video"));
        }
        if (this.c) {
            arrayList.add(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Audio"));
        }
        if (this.d) {
            arrayList.add(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "Bale Documents"));
            arrayList.add(new File(AbstractC7426Rr.D() + Separators.SLASH + "Bale" + Separators.SLASH + "tmp"));
            n();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            o((File) it2.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(C24790zC4 c24790zC4) {
        this.f.E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        this.e.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CompoundButton compoundButton, boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(CompoundButton compoundButton, boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(CompoundButton compoundButton, boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(CompoundButton compoundButton, boolean z) {
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(TextView textView, String str, TextView textView2, String str2, TextView textView3, String str3, TextView textView4, String str4) {
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
    }

    public void setAbolInstance(C14486i0 c14486i0) {
        this.e = c14486i0;
    }

    public ClearCacheAbolContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        q(context);
    }

    public ClearCacheAbolContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        q(context);
    }
}
