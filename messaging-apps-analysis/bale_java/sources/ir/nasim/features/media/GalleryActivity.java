package ir.nasim.features.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C17481n23;
import ir.nasim.C19406qI3;
import ir.nasim.C21753u45;
import ir.nasim.C6011Lu2;
import ir.nasim.C6906Pm2;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.media.Actionbar.ActionBarLayout;
import ir.nasim.features.media.Actionbar.DrawerLayoutContainer;
import ir.nasim.features.media.a;
import ir.nasim.features.media.components.PhotoViewerAbs;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GalleryActivity extends BaseActivity implements ActionBarLayout.j {
    protected DrawerLayoutContainer K0;
    private ActionBarLayout M0;
    private ir.nasim.features.media.a N0;
    private ArrayList L0 = new ArrayList();
    private final a.f O0 = new a();

    class a implements a.f {
        a() {
        }

        @Override // ir.nasim.features.media.a.f
        public void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            Intent intent = new Intent();
            intent.putExtra("PHOTOS", arrayList);
            intent.putExtra("CAPTIONS", arrayList2);
            intent.putExtra("MEDIA_TYPES", arrayList3);
            GalleryActivity.this.setResult(-1, intent);
        }

        @Override // ir.nasim.features.media.a.f
        public boolean b(String str, String str2) {
            Intent intent = new Intent();
            intent.putExtra("VIDEOS", str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            intent.putExtra("CAPTIONS", arrayList);
            GalleryActivity.this.setResult(-1, intent);
            return true;
        }

        @Override // ir.nasim.features.media.a.f
        public void c() {
            try {
                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.putExtra("android.intent.extra.sizeLimit", 1610612736L);
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                Intent intentCreateChooser = Intent.createChooser(intent2, null);
                intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent});
                GalleryActivity.this.startActivityForResult(intentCreateChooser, 0);
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
        }
    }

    private void j2() {
        GalleryConfig galleryConfig = (GalleryConfig) getIntent().getParcelableExtra("gallery_config");
        ir.nasim.features.media.a aVar = new ir.nasim.features.media.a(galleryConfig.b(), galleryConfig.c(), galleryConfig.e(), galleryConfig.a(), galleryConfig.d());
        this.N0 = aVar;
        aVar.d0(this.O0);
        this.M0.M(this.N0, false, true, true);
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarLayout.j
    public boolean H() {
        if (!PhotoViewerAbs.getInstance().isVisible()) {
            return false;
        }
        PhotoViewerAbs.getInstance().closePhoto(true, false);
        return true;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarLayout.j
    public boolean j(ActionBarLayout actionBarLayout) {
        if (actionBarLayout.z.size() > 1) {
            return true;
        }
        finish();
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || i != 0 || intent == null || intent.getData() == null) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("VIDEOS", C6906Pm2.q(intent.getData()));
        setResult(-1, intent2);
        finish();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().closePhoto(true, false);
        } else {
            this.M0.E();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C6011Lu2.m(this);
        super.onCreate(bundle);
        DrawerLayoutContainer drawerLayoutContainer = new DrawerLayoutContainer(this);
        this.K0 = drawerLayoutContainer;
        setContentView(drawerLayoutContainer, new ViewGroup.LayoutParams(-1, -1));
        ActionBarLayout actionBarLayout = new ActionBarLayout(this);
        this.M0 = actionBarLayout;
        actionBarLayout.C(this.L0);
        this.M0.setDelegate(this);
        this.K0.addView(this.M0, new ViewGroup.LayoutParams(-1, -1));
        this.K0.setParentActionBarLayout(this.M0);
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.a.L0(this, 1, C21753u45.d.j, C21753u45.d.m);
        } else {
            j2();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C17481n23.T().F();
        this.N0.r();
        this.M0.z();
        this.L0.clear();
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.M0.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.M0.H();
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().onPause();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        j2();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.M0.I();
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().onResume();
        }
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarLayout.j
    public boolean r() {
        return true;
    }
}
