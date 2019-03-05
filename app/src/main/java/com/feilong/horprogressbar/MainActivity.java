package com.feilong.horprogressbar;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feilong.horizontalporgressbar.HorProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final HorProgressView horProcessView = (HorProgressView) findViewById(R.id.horProcessView);
        final HorProgressView horProcessView1 = (HorProgressView) findViewById(R.id.horProcessView1);
        final HorProgressView horProcessView2 = (HorProgressView) findViewById(R.id.horProcessView2);
        horProcessView.setMaxValue(1000);
        horProcessView1.setMaxValue(1000);
        horProcessView2.setMaxValue(1000);

        ValueAnimator animator = ValueAnimator.ofFloat(0, 800);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float v = (float) valueAnimator.getAnimatedValue();
                horProcessView.setCurrentValue((int) v);
                horProcessView1.setCurrentValue((int) v);
                horProcessView2.setCurrentValue((int) v);
            }
        });
        animator.setDuration(2000);
        animator.start();
    }
}
