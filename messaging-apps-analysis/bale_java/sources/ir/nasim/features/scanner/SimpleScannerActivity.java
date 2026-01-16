package ir.nasim.features.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C19406qI3;
import ir.nasim.InterfaceC17461n03;
import ir.nasim.X06;
import ir.nasim.X5;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.base.activity.BaseActivity;
import java.io.IOException;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* loaded from: classes6.dex */
public class SimpleScannerActivity extends BaseActivity implements ZXingScannerView.b {
    protected ZXingScannerView K0;
    private boolean L0;
    private LinearLayout M0;

    class a extends ZXingScannerView {
        a(Context context) {
            super(context);
        }

        @Override // me.dm7.barcodescanner.core.BarcodeScannerView
        protected InterfaceC17461n03 a(Context context) {
            return new CustomViewFinderView(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2() throws IOException {
        this.K0.o(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2() {
        this.K0.setAutoFocus(true);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("exitFromSimpleActivity", true);
        setResult(-1, intent);
        super.onBackPressed();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        this.M0 = linearLayout;
        linearLayout.setOrientation(1);
        this.M0.setLayoutParams(C14433hu3.d(-1, -1));
        setContentView(this.M0);
        BaleToolbar baleToolbarM0 = BaleToolbar.m0(this, getString(AbstractC12217eE5.barcode_scanner_title));
        AppBarLayout appBarLayoutK0 = BaleToolbar.k0(this);
        appBarLayoutK0.addView(baleToolbarM0);
        this.M0.addView(appBarLayoutK0);
        a aVar = new a(this);
        this.K0 = aVar;
        aVar.setAutoFocus(true);
        this.K0.setAspectTolerance(0.5f);
        this.M0.addView(this.K0, C14433hu3.a(-1, -1.0f));
        if (AbstractC4043Dl1.a(this, "android.permission.CAMERA") != 0) {
            X5.w(this, new String[]{"android.permission.CAMERA"}, 13782);
        } else {
            this.L0 = true;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.L0) {
            this.K0.h();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 13782) {
            if (iArr[0] != 0) {
                finish();
                return;
            }
            this.K0.setResultHandler(this);
            this.K0.f();
            this.L0 = true;
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.L0) {
            this.K0.setResultHandler(this);
            this.K0.f();
        }
    }

    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.b
    public void p(X06 x06) throws NumberFormatException {
        long j;
        long j2;
        String strF = x06.f();
        if (strF.length() == 26) {
            try {
                j2 = Long.parseLong(strF.substring(0, 13));
                j = Long.parseLong(strF.substring(13, 26));
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
                j = -1;
                j2 = -1;
            }
            if (j2 == -1 || j == -1) {
                Intent intent = new Intent();
                intent.putExtra("scanResult", strF);
                setResult(-1, intent);
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("catchIdExtra", j2);
                intent2.putExtra("payIdExtra", j);
                setResult(-1, intent2);
                finish();
            }
        } else {
            Intent intent3 = new Intent();
            intent3.putExtra("scanResult", strF);
            setResult(-1, intent3);
            finish();
        }
        AbstractC7426Rr.Q(new Runnable() { // from class: ir.nasim.UC6
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.l2();
            }
        }, 2000L);
        AbstractC7426Rr.Q(new Runnable() { // from class: ir.nasim.VC6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n2();
            }
        }, 2000L);
    }
}
