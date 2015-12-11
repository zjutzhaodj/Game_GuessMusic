package com.example.administrator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.administrator.musicgame.R;
import java.util.ArrayList;
import Model.WorldButton;
import Util.Util;
import mUI.MyGridView;


public class MainActivity extends Activity implements View.OnClickListener {

    //disk的动画
    private Animation mPanAnim;
    private LinearInterpolator mpanLin;

    //指针的in动画
    private Animation mBarInAnim;
    private LinearInterpolator mBarInLin;
    //指针的out动画
    private Animation mBarOutAnim;
    private LinearInterpolator mBarOutLin;

    private ImageView iv_start_bt;
    private ImageView mPan;
    private ImageView mBar;

    //判断disk是否在转
    private boolean mIsrunning;
    //所有待选文字
    private ArrayList<WorldButton> mAllWords;
    //已选文字
    private ArrayList<WorldButton> mBtnSelect;
    private MyGridView mMyGridView;
    //存放已选文字的容器
    private LinearLayout Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_start_bt= (ImageView) findViewById(R.id.id_start_bt);
        mPan= (ImageView) findViewById(R.id.id_pan);
        mBar= (ImageView) findViewById(R.id.id_bar);
        mMyGridView= (MyGridView) findViewById(R.id.id_gridview);
        Container= (LinearLayout) findViewById(R.id.id_container);
        initAnim();
        iv_start_bt.setOnClickListener(this);
        initCurrentData();

    }

    /**
     * 初始化待选文字和已选文字
     */
    private void initCurrentData(){
        mBtnSelect=initWordSelect();
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(140,140);
        for(int i=0;i<mBtnSelect.size();i++){
            Container.addView(mBtnSelect.get(i).getmViewButton(),params);
        }
        mAllWords=initAllWord();
        mMyGridView.updateData(mAllWords);

    }

    /**
     * 获得已选文字
     * @return
     */
    private ArrayList<WorldButton> initWordSelect(){
        ArrayList<WorldButton> data=new ArrayList<WorldButton>();
        for(int i=0;i<4;i++){
            View view=Util.getView(MainActivity.this,R.layout.gridview_item);
            WorldButton holder=new WorldButton();
            holder.setmViewButton((Button) view.findViewById(R.id.item_btn));
            holder.getmViewButton().setTextColor(Color.WHITE);
            holder.getmViewButton().setText("");
            holder.setIsVisible(false);
            holder.getmViewButton().setBackgroundResource(R.drawable.game_wordblank);
            data.add(holder);
        }
        return data;

    }

    /**
     * 获得待选的文字
     * @return
     */
    private ArrayList<WorldButton> initAllWord(){
        ArrayList<WorldButton> data=new ArrayList<WorldButton>();
        for(int i=0;i<24;i++){
            WorldButton button=new WorldButton();
            button.setmString("奥");
            data.add(button);
        }
        return data;
    }

    /**
     * 初始化所有的动画
     */
    private void initAnim() {
        mPanAnim= AnimationUtils.loadAnimation(this, R.anim.rotate);
        mpanLin=new LinearInterpolator();
        mPanAnim.setInterpolator(mpanLin);
        mPanAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mBar.startAnimation(mBarOutAnim);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mBarInAnim= AnimationUtils.loadAnimation(this,R.anim.rotate_45_in);
        mBarInLin=new LinearInterpolator();
        mBarInAnim.setFillAfter(true);
        mBarInAnim.setInterpolator(mBarInLin);
        mBarInAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mPan.startAnimation(mPanAnim);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mBarOutAnim= AnimationUtils.loadAnimation(this,R.anim.rotate_45_out);
        mBarOutLin=new LinearInterpolator();
        mBarOutAnim.setInterpolator(mBarOutLin);
        mBarOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIsrunning=false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /**
     * disk的点击事件
     */
    private void handlePlayButton(){
        if(!mIsrunning){
            mBar.startAnimation(mBarInAnim);
            mIsrunning=true;
        }

    }

    /**
     * 动画与activity生命周期联动
     */
    @Override
    protected void onPause() {
        mPan.clearAnimation();
        mBar.clearAnimation();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_start_bt:
                handlePlayButton();
                break;
        }
    }
}
