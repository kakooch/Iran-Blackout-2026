package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Utilities;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TimerParticles {
    private long lastAnimationTime;
    private ArrayList<Particle> particles = new ArrayList<>();
    private ArrayList<Particle> freeParticles = new ArrayList<>();

    private static class Particle {
        float alpha;
        float currentTime;
        float lifeTime;
        float velocity;
        float vx;
        float vy;
        float x;
        float y;

        private Particle() {
        }
    }

    public TimerParticles() {
        for (int i = 0; i < 40; i++) {
            this.freeParticles.add(new Particle());
        }
    }

    private void updateParticles(long dt) {
        int size = this.particles.size();
        int i = 0;
        while (i < size) {
            Particle particle = this.particles.get(i);
            float f = particle.currentTime;
            float f2 = particle.lifeTime;
            if (f >= f2) {
                if (this.freeParticles.size() < 40) {
                    this.freeParticles.add(particle);
                }
                this.particles.remove(i);
                i--;
                size--;
            } else {
                particle.alpha = 1.0f - AndroidUtilities.decelerateInterpolator.getInterpolation(f / f2);
                float f3 = particle.x;
                float f4 = particle.vx;
                float f5 = particle.velocity;
                float f6 = dt;
                particle.x = f3 + (((f4 * f5) * f6) / 500.0f);
                particle.y += ((particle.vy * f5) * f6) / 500.0f;
                particle.currentTime += f6;
            }
            i++;
        }
    }

    public void draw(Canvas canvas, Paint particlePaint, RectF rect, float radProgress, float alpha) {
        Particle particle;
        int size = this.particles.size();
        for (int i = 0; i < size; i++) {
            Particle particle2 = this.particles.get(i);
            particlePaint.setAlpha((int) (particle2.alpha * 255.0f * alpha));
            canvas.drawPoint(particle2.x, particle2.y, particlePaint);
        }
        double d = radProgress - 90.0f;
        Double.isNaN(d);
        double d2 = d * 0.017453292519943295d;
        double dSin = Math.sin(d2);
        double d3 = -Math.cos(d2);
        double dWidth = rect.width() / 2.0f;
        Double.isNaN(dWidth);
        double dCenterX = rect.centerX();
        Double.isNaN(dCenterX);
        float f = (float) (((-d3) * dWidth) + dCenterX);
        Double.isNaN(dWidth);
        double dCenterY = rect.centerY();
        Double.isNaN(dCenterY);
        float f2 = (float) ((dWidth * dSin) + dCenterY);
        for (int i2 = 0; i2 < 1; i2++) {
            if (!this.freeParticles.isEmpty()) {
                particle = this.freeParticles.get(0);
                this.freeParticles.remove(0);
            } else {
                particle = new Particle();
            }
            particle.x = f;
            particle.y = f2;
            double dNextInt = Utilities.random.nextInt(140) - 70;
            Double.isNaN(dNextInt);
            double d4 = dNextInt * 0.017453292519943295d;
            if (d4 < 0.0d) {
                d4 += 6.283185307179586d;
            }
            particle.vx = (float) ((Math.cos(d4) * dSin) - (Math.sin(d4) * d3));
            particle.vy = (float) ((Math.sin(d4) * dSin) + (Math.cos(d4) * d3));
            particle.alpha = 1.0f;
            particle.currentTime = 0.0f;
            particle.lifeTime = Utilities.random.nextInt(100) + 400;
            particle.velocity = (Utilities.random.nextFloat() * 4.0f) + 20.0f;
            this.particles.add(particle);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        updateParticles(Math.min(20L, jElapsedRealtime - this.lastAnimationTime));
        this.lastAnimationTime = jElapsedRealtime;
    }
}
