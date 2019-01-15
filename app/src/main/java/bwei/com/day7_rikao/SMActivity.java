package bwei.com.day7_rikao;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class SMActivity extends AppCompatActivity {

    @BindView(R.id.bun_sao)
    Button bunSao;
    @BindView(R.id.bun_sheng)
    Button bunSheng;
    @BindView(R.id.edit_action)
    EditText editAction;
    @BindView(R.id.img_view_sheng)
    ImageView imgViewSheng;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm);
        unbinder = ButterKnife.bind(this);
        bunSao.setText("点击扫描");
        bunSheng.setText("点击生成二维码");


    }

    @OnClick({R.id.bun_sao, R.id.bun_sheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bun_sao:
                checkPermission();
                break;
            case R.id.bun_sheng:
                createQRCode();
                break;
        }
    }
    private void checkPermission() {
        //第一步，判断系统版本是否为6.0以上
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //第二步：checkSelfPermission判断有没有此权限
            //第一个参数：上下文
            //第二个参数：我们想要判断的权限，此处为相机权限
            //PackageManager.PERMISSION_GRANTED 条件，权限有没有被授予
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //如果没授予，则申请权限
                //第一个：上下文
                //第二个：要申请的权限数组，此处为相机权限
                //第三个：请求码，startActivityForResult一样
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},100);
            }
        }else{
            startActivity(new Intent(SMActivity.this, ScanActivity.class));
        }
    }
    /**
     * 接受权限请求结果
     * @param requestCode 请求码
     * @param permissions 我们请求的权限数组
     * @param grantResults 返回结果数组
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //如果requestCode匹配，切权限申请通过
        if(requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(SMActivity.this, ScanActivity.class));
        }
    }
    private void createQRCode() {
        QRTask qrTask = new QRTask(this, imgViewSheng, editAction);
        qrTask.execute(editAction.getText().toString());
    }
    static class QRTask extends AsyncTask<String, Void, Bitmap> {
        private WeakReference<Context> mContext;
        private WeakReference<ImageView> mImageView;

        public QRTask(Context context, ImageView image, EditText ed) {
            mContext = new WeakReference<>(context);
            mImageView = new WeakReference<>(image);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String str = params[0];
            if (TextUtils.isEmpty(str)) {
                return null;
            }
//            int size = mContext.get().getResources().getDimensionPixelOffset(R.dimen.qr_code_size);
            return QRCodeEncoder.syncEncodeQRCode(str, 200);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                mImageView.get().setImageBitmap(bitmap);
            } else {
                Toast.makeText(mContext.get(), "生成失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }
}
