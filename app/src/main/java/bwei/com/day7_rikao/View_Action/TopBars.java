package bwei.com.day7_rikao.View_Action;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bwei.com.day7_rikao.R;

public class TopBars  extends RelativeLayout {

    private Button rightButton;
    private  Button leftButton;
    private TextView titletext;

    private OnLeftAndRightClickListener listener;
    public void setOnLeftAndRightClickListener(OnLeftAndRightClickListener listener) {
        this.listener = listener;
    }
    public interface OnLeftAndRightClickListener {
        void OnLeftButtonClick();

        void OnRightButtonClick();
    }
    public TopBars(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_bar, this);

        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        titletext = findViewById(R.id.titleText);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.OnLeftButtonClick();

                }
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.OnRightButtonClick();

                }
            }
        });
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        int leftbut = typedArray.getResourceId(R.styleable.TopBar_leftBackground, 0);
        int rightbut = typedArray.getResourceId(R.styleable.TopBar_rightBackground, 0);
        String text = typedArray.getString(R.styleable.TopBar_titleText);
        float textsize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);
        int titlecolor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        typedArray.recycle();
        leftButton.setBackgroundResource(leftbut);
        rightButton.setBackgroundResource(rightbut);
        titletext.setText(text);
        titletext.setTextSize(textsize);
        titletext.setTextColor(titlecolor);
    }
}
