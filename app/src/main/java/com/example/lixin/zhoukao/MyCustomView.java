package com.example.lixin.zhoukao;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hua on 2017/9/2.
 */

public class MyCustomView extends LinearLayout {


    private Button left_btn;
    private TextView center_text;
    private Button right_btn;
    private int left_btn_text_color;
    private String left_btn_text;
    private float left_btn_size;
    private int left_btn_bg;
    private String center_text1;
    private int center_text_color;
    private float center_text_size;
    private int center_bg;
    private String right_btn_text;
    private int right_btn_text_color;
    private float right_btn_size;
    private int right_btn_bg;

    public MyCustomView(Context context) {
        super(context);
        initView(context,null);
    }



    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }
    private void initView(Context context,@Nullable AttributeSet attrs) {

        View inflate = inflate(context, R.layout.custom_view, this);
        left_btn = inflate.findViewById(R.id.left_btn);
        center_text = inflate.findViewById(R.id.center_text);
        right_btn = inflate.findViewById(R.id.right_btn);

        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener!=null){
                    mOnClickListener.leftonClickListener(view);
                }
            }
        });

        right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener!=null){
                    mOnClickListener.RightClickListener(view);
                }
            }
        });



        if (attrs==null){
            return;
        }

        initAttrs(context,attrs);
        setViewContext();
    }
    private void initAttrs(Context context,@Nullable AttributeSet attrs) {

        if (attrs==null){
            return;
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);

        left_btn_text = typedArray.getString(R.styleable.MyCustomView_left_btn_text);
        left_btn_text_color = typedArray.getColor(R.styleable.MyCustomView_left_btn_text_color, 0xff0000);
        left_btn_size = typedArray.getDimension(R.styleable.MyCustomView_left_btn_text_size, 18);
        left_btn_bg = typedArray.getColor(R.styleable.MyCustomView_left_btn_bg, 0x00ff00);

        center_text1 = typedArray.getString(R.styleable.MyCustomView_center_text);
        center_text_color = typedArray.getColor(R.styleable.MyCustomView_center_text_color,0xff0000);
        center_text_size = typedArray.getDimension(R.styleable.MyCustomView_center_text_size,18);
        center_bg = typedArray.getColor(R.styleable.MyCustomView_center_text_bg,0x00ff00);

        right_btn_text = typedArray.getString(R.styleable.MyCustomView_right_btn_text);
        right_btn_text_color = typedArray.getColor(R.styleable.MyCustomView_right_btn_text_color,0xff0000);
        right_btn_size = typedArray.getDimension(R.styleable.MyCustomView_right_btn_text_size,18);
        right_btn_bg = typedArray.getColor(R.styleable.MyCustomView_right_btn_bg,0x00ff00);

    }
    private void setViewContext() {
        left_btn.setText(left_btn_text);
        left_btn.setTextColor(left_btn_text_color);
//        left_btn.setBackgroundColor(left_btn_bg);
        left_btn.setTextSize(left_btn_size);


        center_text.setText(center_text1);
        center_text.setTextColor(center_text_color);
        center_text.setBackgroundColor(center_bg);
        center_text.setTextSize(center_text_size);


        right_btn.setText(right_btn_text);
        right_btn.setTextColor(right_btn_text_color);
//        right_btn.setBackgroundColor(right_btn_bg);
        right_btn.setTextSize(right_btn_size);

    }

    public interface OnClickListener{
        void leftonClickListener(View left_btn);
        void RightClickListener(View right_btn);
    }
    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }




}

