package org.rbmain.ui.Components;

import android.graphics.Paint;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class FireworksEffect {
    private ArrayList<Particle> freeParticles;
    private Paint particlePaint;

    private class Particle {
        private Particle(FireworksEffect fireworksEffect) {
        }
    }

    public FireworksEffect() {
        new ArrayList();
        this.freeParticles = new ArrayList<>();
        Paint paint = new Paint(1);
        this.particlePaint = paint;
        paint.setStrokeWidth(AndroidUtilities.dp(1.5f));
        this.particlePaint.setColor(Theme.getColor(Theme.key_actionBarDefaultTitle) & (-1644826));
        this.particlePaint.setStrokeCap(Paint.Cap.ROUND);
        this.particlePaint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 20; i++) {
            this.freeParticles.add(new Particle());
        }
    }
}
